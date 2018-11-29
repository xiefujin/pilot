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
@Table(name="t_system_role")
public class Role extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false,name="role_name")
	private String roleName;
	
	@ManyToMany
	@JoinTable(name="t_system_user_roles",joinColumns={@JoinColumn(name="roleid",referencedColumnName="idx")},
	inverseJoinColumns= {@JoinColumn(name="userid",referencedColumnName="idx")})
	private Set<User> users;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="t_system_role_menu",joinColumns={@JoinColumn(name="roleid",referencedColumnName="idx")},
	inverseJoinColumns= {@JoinColumn(name="menuid",referencedColumnName="idx")})
	private Set<Menu> menus;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	

}
