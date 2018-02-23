package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -7477992410553479471L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id = 0;

  /** The user name. */
  @Column(name = "user_name")
  private String userName = null;

  /** The password. */
  @Column(name = "password")
  private String password = null;

  /** The user roles. */
  @ManyToMany
  @JoinTable(name = "user_user_roles", joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "user_role_id")})
  private Set<UserRole> userRoles;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the user roles.
   *
   * @return the user roles
   */
  public Set<UserRole> getUserRoles() {
    return userRoles;
  }

  /**
   * Sets the user roles.
   *
   * @param userRoles the new user roles
   */
  public void setUserRoles(Set<UserRole> userRoles) {
    this.userRoles = userRoles;
  }

}
