package org.softuni.timeTracker.areas.user.service;

import org.softuni.timeTracker.areas.user.entities.Role;
import org.softuni.timeTracker.areas.user.entities.User;
import org.softuni.timeTracker.areas.user.enumerations.RoleEnum;
import org.softuni.timeTracker.areas.user.model.EditUserBindingModel;
import org.softuni.timeTracker.areas.user.model.RegisterUserBindingModel;
import org.softuni.timeTracker.areas.user.repository.UserRepository;
import org.softuni.timeTracker.utils.ModelParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
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
            throw new UsernameNotFoundException("Username was not found.");
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
    public List<EditUserBindingModel> getAllUsers(String username) {
        List<User> users = this.userRepository.findAllByUsernameIsNotAndUsernameIsNot(username, "admin");
        List<EditUserBindingModel> usersDto = this.modelParser.
                map(users,
                        EditUserBindingModel.class);
        return usersDto;

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

}
