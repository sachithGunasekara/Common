package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Find by user name.
   *
   * @param userName the user name
   * @return the user
   */
  User findByUserName(String userName);
}
