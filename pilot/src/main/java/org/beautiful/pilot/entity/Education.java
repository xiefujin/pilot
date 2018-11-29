package org.beautiful.pilot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_education")
public class Education extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false,name="degree_name")
	private String educaDegreeName;

	public String getEducaDegreeName() {
		return educaDegreeName;
	}

	public void setEducaDegreeName(String educaDegreeName) {
		this.educaDegreeName = educaDegreeName;
	}
	
	

}
