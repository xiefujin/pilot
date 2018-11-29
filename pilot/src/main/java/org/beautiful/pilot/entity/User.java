package org.beautiful.pilot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_system_user")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false,name="username")
	private String username;
	
	@Column(nullable=false,name="password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_system_user_roles",joinColumns={@JoinColumn(name="userid",referencedColumnName="idx")},
	inverseJoinColumns= {@JoinColumn(name="roleid",referencedColumnName="idx")})
	private Set<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
