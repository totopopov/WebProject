package org.softuni.timeTracker.areas.user.models;


import org.softuni.timeTracker.areas.user.entities.customValidator.ConfirmPassword;
import org.softuni.timeTracker.areas.user.entities.customValidator.ConfirmUserName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ConfirmPassword
public class RegisterUserBindingModel {

    private static final String USERNAME_MUST_BE_BETWEEN_4_AND_20_CHARACHTERS = "Username must be between 4 and 20 charachters.";
    private static final String PATTERN_USERNAME_LENGHT = "(.){4,20}";
    private static final String PASSWORD_MUST_BE_BETWEEN_8_AND_14_CHARACHTERS = "Password must be between 8 and 14 charachters.";
    private static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_UPPER_CASE_LETTER = "Password must contain at least one upper case letter.";
    private static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_LOWER_CASE_LETTER = "Password must contain at least one lower case letter.";
    private static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_DIGIT = "Password must contain at least one digit.";
    private static final String PATTERN_PASSWORD_LENGHT = "(.){8,14}";
    private static final String PATTERN_UPPER_CASE = "(?=.*[A-Z]).+";
    private static final String PATTERN_LOWER_CASE = "(?=.*[a-z]).+";
    private static final String PATTERN_DIGIT = "(?=.*[0-9]).+";


    @NotNull()
    @ConfirmUserName()
    @Pattern(regexp = PATTERN_USERNAME_LENGHT,message = USERNAME_MUST_BE_BETWEEN_4_AND_20_CHARACHTERS)
    private String username;

    @NotNull
    @Pattern(regexp = PATTERN_PASSWORD_LENGHT,message = PASSWORD_MUST_BE_BETWEEN_8_AND_14_CHARACHTERS)
    @Pattern(regexp = PATTERN_UPPER_CASE,message = PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_UPPER_CASE_LETTER)
    @Pattern(regexp = PATTERN_LOWER_CASE,message = PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_LOWER_CASE_LETTER)
    @Pattern(regexp = PATTERN_DIGIT,message = PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_DIGIT)
    private String password;

    @NotNull
    private String confirmPassword;

    public RegisterUserBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "RegisterUserBindingModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
