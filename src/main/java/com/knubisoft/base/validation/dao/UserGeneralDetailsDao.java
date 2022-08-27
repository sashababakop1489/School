package com.knubisoft.base.validation.dao;

import com.knubisoft.base.validation.ValidationTasks;

import java.util.Optional;

public interface UserGeneralDetailsDao {
    Optional<ValidationTasks.UserGeneralDetails> getById(Long id);
}