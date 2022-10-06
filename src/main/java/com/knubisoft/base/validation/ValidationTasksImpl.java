package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotation.MaxLength;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public void validate(Object instance) {
        Annotation[] annotations = instance.getClass().getDeclaredAnnotations();
        Map<Field, String> resultMap = new LinkedHashMap<>();
        for (Field f: instance.getClass().getDeclaredFields()) {
            resultMap.put(f,checkForAnnotation(f, annotations, instance));
        }
    }

    private String checkForAnnotation(Field f, Annotation[] annotations, Object instance) {
        for (Annotation annotation: annotations) {
            if(f.isAnnotationPresent(annotation.annotationType())) {
                return validateField(f, annotation.annotationType(),instance) ? "valid" : "not valid";
            }
        }
        return "No restrictions to field";
    }

    private boolean validateField(Field f, Class<? extends Annotation> annotationType, Object instance) {
        Map<Class<? extends Annotation>, Function<Field, Boolean>> validateFunction = new LinkedHashMap<>();
        validateFunction.put(MaxLength.class, field -> {
            int fieldLength = 0;
            try {
                fieldLength = getGetterMethod(field.getName(), instance).invoke(instance).toString().length();
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            int maxLength = f.getAnnotation(MaxLength.class).maxLength();
            return fieldLength <= maxLength;
        });
        return validateFunction.get(annotationType).apply(f);
    }

    @SneakyThrows
    private boolean checkMaxLength(Object instance) {
        List<Field> fieldList = getFieldNames(instance, MaxLength.class);
        for (Field f : fieldList) {
            int fieldLength = getGetterMethod(f.getName(), instance).invoke(instance).toString().length();
            int maxLength = f.getAnnotation(MaxLength.class).maxLength();
            if (fieldLength > maxLength) {
                System.out.println("Invalid length(" + fieldLength + ") for field " + f.getName() + ". Max length is " + maxLength);
                return false;
            }

        }
        return true;
    }

    @SneakyThrows
    private Method getGetterMethod(String name, Object instance) {
        return instance.getClass().getMethod("get" + StringUtils.capitalize(name));
    }


    private List<Field> getFieldNames(Object instance, Class<? extends Annotation> annotationClass) {
        Field[] fields = instance.getClass().getDeclaredFields();
        List<Field> fieldList = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotationClass)) {
                fieldList.add(f);
            }
        }
        return fieldList;
    }

    @Override
    public User buildUser() {
        User user = new User();
        user.setId(12345L);
        user.setName("Alex");
        user.setSurname("Hnidash");
        user.setMarried(false);
        user.setCountOfChildren(0);
        user.setCountOfPets(1);
        user.setFkUserGeneralDetails(54321L);
        return user;
    }

    @Override
    public UserGeneralDetails buildUserGeneralDetails() {
        return null;
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        return null;
    }
}
