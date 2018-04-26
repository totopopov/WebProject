package org.softuni.timeTracker.areas.user.service;

import org.softuni.timeTracker.areas.user.enumerations.RoleEnum;
import org.softuni.timeTracker.areas.user.entities.Role;
import org.softuni.timeTracker.areas.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Todor Popov using Lenovo on 22.4.2018 г. at 20:05.
 */

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(RoleEnum roleEnum) {
        return this.roleRepository.findByAuthority(roleEnum.getRoleName());
    }


}
