package com.knubisoft.base.validation.dao.impl;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;
import com.knubisoft.base.validation.dao.UserGeneralDetailsDao;
import java.util.Optional;

public class UserGeneralDetailsDaoImpl implements UserGeneralDetailsDao {
    private final ValidationTasks instance = new ValidationTasksImpl();
    @Override
    public Optional<ValidationTasks.UserGeneralDetails> getById(Long id) {
        if (id != 4) {
            return Optional.empty();
        }
        return Optional.ofNullable(instance.buildUserGeneralDetails());
    }
}
