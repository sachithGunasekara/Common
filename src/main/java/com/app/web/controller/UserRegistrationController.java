package com.app.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.UserRoleService;

@Controller
public class UserRegistrationController {

  @Autowired
  @Qualifier(value = "userRolesService")
  private UserRoleService userRoleService;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String viewSignup(Map<String, Object> model) {

    User userForm = new User();
    model.put("userForm", userForm);
    model.put("userRoleNameList", userRoleService.getUserRoles());
    return "signup";
  }
  
  @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
  public String saveNewRegister(@ModelAttribute("userForm") @Validated User user,
      BindingResult result, Model model) {
    System.out.println(user.getPassword());
    System.out.println(user.getUserName());
    System.out.println(passwordEncoder.getClass().getName());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRoleService.saveUser(user);
    return "success";
    
  }
  
}
