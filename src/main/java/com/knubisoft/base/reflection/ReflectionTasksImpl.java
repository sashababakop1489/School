package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.model.InheritedEntryModel;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        if (cls == null)
            throw new NoSuchElementException("Hello");
        Constructor constructor;
        Object myObject;
        try {
            constructor = cls.getConstructor(String.class);
            myObject = constructor.newInstance("");
        } catch (Exception e){
            throw new  RuntimeException("Bye!");
        }
       return myObject;
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        if (cls == null)
            throw new NoSuchElementException("HI!");
        Reflections scan = new Reflections("com.knubisoft.base.reflection.model");
        Set<Class <? extends T>> impls = scan.getSubTypesOf(cls);
        if (impls.isEmpty())
            throw new IllegalArgumentException("HI!");
        for (Class<? extends T> impl : impls)
            return impl;
        return null;
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if (cls == null)
            throw new NoSuchElementException("Hi!");
        Map<String, Object> ans = new HashMap<>();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            ans.put(field.getName(), cls);
        }
        return ans;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null)
            throw new NoSuchElementException("Hi");
        Method[] methods = cls.getDeclaredMethods();
        return (int) Arrays.stream(methods).filter(m -> m.toString().startsWith("private")).count();
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        Method method1;
        try{
            method1 = annotationUnderMethod.getMethod(method.getName());
        } catch (Exception e){
            return false;
        }
        Annotation[] annotations = method1.getDeclaredAnnotations();
        return annotations.length != 0;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        Method method;
        try{
            method = cls.getMethod(name);
        } catch (Exception e){
            return "lll";
        }
        return method.getParameterTypes();
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if (obj == null || name == null || args == null) {
            throw new IllegalArgumentException("Hello");
        }
        Object ans;
        Method method;
        Class<?>[] params = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            params[i] = args[i].getClass();
        }
        try{
            method = obj.getClass().getDeclaredMethod(name, params);
            ans = method.invoke(obj, args);
        } catch (Exception e){
            return "";
        }
        return ans;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        Class<?> clas = instance.getClass();
        try {
            Field field = clas.getField(name);
            field.set(instance, newValue);
        } catch (Exception e){
            return null;
        }
        return instance;
    }
}
