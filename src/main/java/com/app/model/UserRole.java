package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5213953830924494158L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id = 0;

  /** The role. */
  @Column(name = "role_name")
  private String role;

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
   * Gets the role.
   *
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * Sets the role.
   *
   * @param role the new role
   */
  public void setRole(String role) {
    this.role = role;
  }

}
