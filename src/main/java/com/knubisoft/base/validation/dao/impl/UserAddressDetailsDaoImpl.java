package com.knubisoft.base.validation.dao.impl;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;
import com.knubisoft.base.validation.dao.UserAddressDetailsDao;
import java.util.Optional;

public class UserAddressDetailsDaoImpl implements UserAddressDetailsDao {
    private final ValidationTasks instance = new ValidationTasksImpl();

    @Override
    public Optional<ValidationTasks.UserAddressDetails> getById(Long id) {
        return Optional.ofNullable(instance.buildUserAddressDetails());
    }
}
