package org.softuni.timeTracker.areas.user.model;


import org.softuni.timeTracker.areas.user.entities.Role;
import org.softuni.timeTracker.areas.user.entities.customValidator.ConfirmPassword;
import org.softuni.timeTracker.areas.user.entities.customValidator.ConfirmUserName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@ConfirmPassword
public class EditUserBindingModel {

    private static final String USERNAME_MUST_BE_BETWEEN_4_AND_20_CHARACHTERS = "Username must be between 4 and 20 charachters.";
    private static final String PATTERN_USERNAME_LENGHT = "(.){4,20}";

    @NotNull()
    @ConfirmUserName()
    @Pattern(regexp = PATTERN_USERNAME_LENGHT, message = USERNAME_MUST_BE_BETWEEN_4_AND_20_CHARACHTERS)
    private String username;


    private Set<String> simpleRoles;

    private Boolean enabled;


    public EditUserBindingModel() {
        this.simpleRoles = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Set<String> getSimpleRoles() {
        return simpleRoles;
    }

    public void setSimpleRoles(Set<String> simpleRoles) {
        this.simpleRoles = simpleRoles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "RegisterUserBindingModel{" +
                "username='" + username + '\'' +
                '}';
    }
}
