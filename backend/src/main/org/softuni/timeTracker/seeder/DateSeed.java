package org.softuni.timeTracker.seeder;

import org.softuni.timeTracker.areas.user.entities.Role;
import org.softuni.timeTracker.areas.user.entities.User;
import org.softuni.timeTracker.areas.user.enumerations.RoleEnum;
import org.softuni.timeTracker.areas.user.repository.RoleRepository;
import org.softuni.timeTracker.areas.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 22.4.2018 г. at 18:46.
 */

@Component
public class DateSeed {

    public static final String USER_LOG = " ==================== userLog: ";
    public static final String USERS_SEEDING_NOT_REQUIRED = "Users Seeding Not Required";
    public static final String USER_SEEDED = "User Seeded";
    public static final String ADMIN = "admin";
    public static final String ROLES_SEED_NOT_REQUIRED = "Roles seed not required";
    public static final String ROLSE_SEED = "Rolse seed";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DateSeed(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRolesTable();
        seedUsersTable();

    }

    private List<String> checkRoles(List<Role> roles) {
        boolean result = false;
        List<String> currentRoles = roles.stream().map(Role::getAuthority).collect(Collectors.toList());
        List<String> enumeratedRolse = Arrays.stream(RoleEnum.values()).map(RoleEnum::getRoleName).collect(Collectors.toList());

        enumeratedRolse.removeIf(currentRoles::contains);

        return enumeratedRolse;
    }

    private void seedRolesTable() {
        List<Role> roles = roleRepository.findAll();
        List<String> rolesToSeed = checkRoles(roles);

        if (rolesToSeed.size() > 0) {
            for (String role : rolesToSeed) {
                Role newRole = new Role();
                newRole.setAuthority(role);
                roleRepository.save(newRole);
            }
            this.declareMessage(ROLSE_SEED);
        } else {

            this.declareMessage(ROLES_SEED_NOT_REQUIRED);
        }
    }


    private void seedUsersTable() {

        User u = userRepository.findByUsername(ADMIN);

        List<Role> roles = roleRepository.findAll();

        if (u == null) {
            User user = new User();
            user.setUsername(ADMIN);
            user.setPassword(this.bCryptPasswordEncoder.encode(ADMIN));
            user.setRoles(new HashSet<>(roles));
            user.setAccountNonExpired(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setAccountNonLocked(true);

            userRepository.save(user);
            this.declareMessage(USER_SEEDED);
        } else {
            this.declareMessage(USERS_SEEDING_NOT_REQUIRED);
        }
    }

    private void declareMessage(String message) {
        System.out.println(new Date() + USER_LOG + message);
    }
}
