package org.beautiful.pilot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="t_pilot")
public class Pilot extends BasePersonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false,name="pilot_serial_number")
	private String pilotSerialNumber;
	
	@Column(nullable=false,name="time_of_enlistment")
	@Temporal(TemporalType.DATE)
	private Date timeOfEnlistment;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false,name="time_of_join_party")
	private Date timeOfJoinParty;

	public String getPilotSerialNumber() {
		return pilotSerialNumber;
	}

	public void setPilotSerialNumber(String pilotSerialNumber) {
		this.pilotSerialNumber = pilotSerialNumber;
	}

	public Date getTimeOfEnlistment() {
		return timeOfEnlistment;
	}

	public void setTimeOfEnlistment(Date timeOfEnlistment) {
		this.timeOfEnlistment = timeOfEnlistment;
	}

	public Date getTimeOfJoinParty() {
		return timeOfJoinParty;
	}

	public void setTimeOfJoinParty(Date timeOfJoinParty) {
		this.timeOfJoinParty = timeOfJoinParty;
	}
	
	

}
