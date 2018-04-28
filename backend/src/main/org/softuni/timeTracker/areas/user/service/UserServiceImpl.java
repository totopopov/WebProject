package org.softuni.timeTracker.areas.user.service;

import org.softuni.timeTracker.areas.user.entities.Role;
import org.softuni.timeTracker.areas.user.entities.User;
import org.softuni.timeTracker.areas.user.enumerations.RoleEnum;
import org.softuni.timeTracker.areas.user.models.EditUserBindingModel;
import org.softuni.timeTracker.areas.user.models.RegisterUserBindingModel;
import org.softuni.timeTracker.areas.user.repository.UserRepository;
import org.softuni.timeTracker.utils.ModelParser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    public static final String ADMIN = "admin";
    public static final String USERNAME_WAS_NOT_FOUND = "Username was not found.";
    private final UserRepository userRepository;

    private final ModelParser modelParser;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelParser modelParser, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelParser = modelParser;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(USERNAME_WAS_NOT_FOUND);
        }

        return user;
    }

    @Override
    public boolean save(RegisterUserBindingModel userModel) {
        User user = this.modelParser.map(userModel, User.class);

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = this.roleService.getRole(RoleEnum.USER);
        user.addRole(role);
        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean userExists(String username) {
        if (username == null) {
            return false;
        }
        return this.userRepository.findByUsername(username) != null;
    }

    @Override
    public User userByName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<EditUserBindingModel> getAllUsers() {
        List<User> users = this.userRepository.
                findAllByUsernameIsNotAndUsernameIsNot(SecurityContextHolder.getContext().getAuthentication().
                        getPrincipal().toString(), ADMIN);
        List<EditUserBindingModel> usersDto = this.modelParser.
                map(users,
                        EditUserBindingModel.class);
        usersDto = usersDto.stream().sorted((x1, x2) -> x1.getUsername().compareToIgnoreCase(x2.getUsername())).collect(Collectors.toList());

        return Collections.unmodifiableList(usersDto);

    }

    @Override
    public EditUserBindingModel promote(String username) {
        User user = this.userRepository.findByUsername(username);
        Role role = this.roleService.getRole(RoleEnum.ADMIN);
        user.addRole(role);
        return this.modelParser.map(this.userRepository.save(user), EditUserBindingModel.class);
    }

    @Override
    public EditUserBindingModel demote(String username) {
        User user = this.userRepository.findByUsername(username);
        Role role = this.roleService.getRole(RoleEnum.ADMIN);
        user.removeRole(role);
        return this.modelParser.map(this.userRepository.save(user), EditUserBindingModel.class);
    }


    @Override
    public EditUserBindingModel enable(String username, Boolean enable) {
        User user = this.userRepository.findByUsername(username);
        user.setEnabled(enable);
        return this.modelParser.map(this.userRepository.save(user), EditUserBindingModel.class);
    }

}
