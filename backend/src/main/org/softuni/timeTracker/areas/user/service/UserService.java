package org.softuni.timeTracker.areas.user.service;

import org.softuni.timeTracker.areas.user.models.EditUserBindingModel;
import org.softuni.timeTracker.areas.user.models.RegisterUserBindingModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(RegisterUserBindingModel user);

    boolean userExists(String username);

    List<EditUserBindingModel> getAllUsers();

    EditUserBindingModel promote(String username);

    EditUserBindingModel demote(String username);

    EditUserBindingModel enable(String username, Boolean enable);

}
