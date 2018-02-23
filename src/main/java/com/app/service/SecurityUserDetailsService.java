package com.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.User;
import com.app.model.UserRole;
import com.app.repository.UserRepository;

@Service("securityUserDetailsService")
public class SecurityUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.
   * String)
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    User user = findUserbyUername(userName);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    for (UserRole role : user.getUserRoles()) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
    }

    return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
        grantedAuthorities);
  }

  private User findUserbyUername(String username) {
    return userRepository.findByUserName(username);
  }

}
