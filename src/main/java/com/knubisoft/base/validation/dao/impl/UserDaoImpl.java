package com.knubisoft.base.validation.dao.impl;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.dao.UserDao;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static List<Long> uniqIdStorage = List.of(1L, 2L, 3L);

    @Override
    public List<Long> getAllId() {
        return uniqIdStorage;
    }

    @Override
    public ValidationTasks.User findById(Long id) {
        return null;
    }
}
