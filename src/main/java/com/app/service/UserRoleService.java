package com.app.service;

import java.util.List;

import com.app.model.User;

public interface UserRoleService {

  public List<String> getUserRoles();
  
  public User saveUser(User user);
}
