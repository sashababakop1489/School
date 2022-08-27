package com.knubisoft.base.validation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTasksTest {
    private static ValidationTasks instance;
    private static ValidationTasks.User user;
    private static ValidationTasks.UserGeneralDetails details;
    private static ValidationTasks.UserAddressDetails address;

    @BeforeAll
    public static void init() {
        instance = new ValidationTasksImpl();
        details = instance.buildUserGeneralDetails();
        address = instance.buildUserAddressDetails();
    }

    @BeforeEach
    public void creatUser() {
        user = instance.buildUser();
    }

    @Test
    @SneakyThrows
    void validateMaxLength() throws IllegalAccessException {
        user.setName("userNameFalse");
        assertThrows(IllegalArgumentException.class,() -> instance.validate(user));
    }

    @Test
    @SneakyThrows
    void validatePrimaryKey() {
        user.setId(1L);
        assertThrows(IllegalArgumentException.class, () -> instance.validate(user));
    }

    @Test
    @SneakyThrows
    void validateReferClass() {
        user.setFkUserGeneralDetails(2L);
        assertThrows(IllegalArgumentException.class, () -> instance.validate(user));
    }

    @Test
    @SneakyThrows
    void validateNotNull() {
        user.setSurname(null);
        assertThrows(NullPointerException.class, () -> instance.validate(user));
    }

    @Test
    void buildUser() {
        assertEquals(ValidationTasks.User.class, user.getClass());
    }

    @Test
    void buildUserGeneralDetails() {
        assertEquals(ValidationTasks.UserGeneralDetails.class,
                details.getClass());
    }

    @Test
    void buildUserAddressDetails() {
        assertEquals(ValidationTasks.UserAddressDetails.class,
                address.getClass());
    }
}
