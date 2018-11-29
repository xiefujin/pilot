package org.beautiful.pilot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_system_menu")
public class Menu extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="menu_name")
	private String menuName;
	
	@Column(name="menu_url")
	private String menuUrl;
	
	@Column(name="menu_permission")
	private String menuPermission;
	
	@ManyToMany
	@JoinTable(name="t_system_role_menu",joinColumns={@JoinColumn(name="menuid",referencedColumnName="idx")},
	inverseJoinColumns= {@JoinColumn(name="roleid",referencedColumnName="idx")})
	private Set<Role> roles;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuPermission() {
		return menuPermission;
	}

	public void setMenuPermission(String menuPermission) {
		this.menuPermission = menuPermission;
	}
}
