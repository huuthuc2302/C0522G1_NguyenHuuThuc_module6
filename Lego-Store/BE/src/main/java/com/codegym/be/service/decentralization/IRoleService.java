package com.codegym.be.service.decentralization;

import com.codegym.be.model.decentralization.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRole();

    List<Role> getAllRoles();

    void saveCreateGmail(String email);

    List<Role> getRoleByUsername(String email);

}
