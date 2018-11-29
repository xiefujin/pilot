package org.beautiful.pilot.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BasePersonEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false,name="name")
	protected String name;
	
	@Column(nullable = false,name="nationality")
	protected String nationality;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false,name="birthday")
	protected Date birthday;
	
	@Column(nullable = false,name="birthplace")
	protected String Birthplace;
	
	@Column(nullable = false,name="current_address")
	protected String currentAddress;
	
	@OneToOne(targetEntity = Sexual.class)
	@JoinColumn(name="sex_type",referencedColumnName="idx")
	protected Sexual sex;
	
	@OneToOne(targetEntity=Education.class)
	@JoinColumn(name="education_type",referencedColumnName="idx")
	protected Education education;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="time_of_graduation")
	protected Date timeOfGraduation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return Birthplace;
	}

	public void setBirthplace(String birthplace) {
		Birthplace = birthplace;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Sexual getSex() {
		return sex;
	}

	public void setSex(Sexual sex) {
		this.sex = sex;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Date getTimeOfGraduation() {
		return timeOfGraduation;
	}

	public void setTimeOfGraduation(Date timeOfGraduation) {
		this.timeOfGraduation = timeOfGraduation;
	}
	
	
	
}
