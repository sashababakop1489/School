package com.knubisoft.tasks.algorithm.reflection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConstructorUtilsImplTest {

    private final ConstructorUtilsImpl instance = new ConstructorUtilsImpl();
    Object[] object1 = {"1"};
    Object[] object2 = {"2", "types"};

    @SneakyThrows
    @Test
    public void invokeConstructorSuccess() {
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertEquals("ModelRoot.Batter(id=1, type=null)",
                instance.invokeConstructor(cls, object1).toString());
        assertEquals("ModelRoot.Batter(id=2, type=types)",
                instance.invokeConstructor(cls, object2).toString());
    }

    @SneakyThrows
    @Test
    public void invokeConstructorFail() {
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertThrows(NoSuchElementException.class,
                () -> instance.invokeConstructor(cls, null));
        assertThrows(NoSuchElementException.class,
                () -> instance.invokeConstructor(null, object1));
        assertThrows(NoSuchElementException.class,
                () -> instance.invokeConstructor(null, null));
    }


    @Test
    @SneakyThrows
    public void getMatchingAccessibleConstructorSuccess() {
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");
        Class<?>[] type1 = {String.class};
        Class<?>[] type2 = {String.class, String.class};

        assertEquals(cls.getConstructor(type1),
                instance.getMatchingAccessibleConstructor(cls, type1));
        assertEquals(cls.getConstructor(type2),
                instance.getMatchingAccessibleConstructor(cls, type2));
    }

    @Test
    @SneakyThrows
    public void getMatchingAccessibleConstructorFail() {
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");
        Class<?>[] type = {String.class};

        assertThrows(NoSuchElementException.class,
                () -> instance.getMatchingAccessibleConstructor(null, null));
        assertThrows(NoSuchElementException.class,
                () -> instance.getMatchingAccessibleConstructor(cls, null));
        assertThrows(NoSuchElementException.class,
                () -> instance.getMatchingAccessibleConstructor(null, type));
    }
}
