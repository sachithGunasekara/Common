package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.User;
import com.app.model.UserRole;
import com.app.repository.UserRepository;
import com.app.repository.UserRoleRepository;
import com.app.service.UserRoleService;

@Service("userRolesService")
public class UserRolesServiceImpl implements UserRoleService {

  @Autowired
  private UserRoleRepository userRoleRepository;
  
  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public List<String> getUserRoles() {
    List<String> userRoleNameList = null;
    List<UserRole> userRoles = userRoleRepository.findAll();
    if (userRoles != null && !userRoles.isEmpty()) {
      userRoleNameList = new ArrayList<>(userRoles.size());
      for (UserRole userRole : userRoles) {
        userRoleNameList.add(userRole.getRole());
      }
    }

    return userRoleNameList;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public User saveUser(User user) {
    return userRepository.save(user);
  }

}
