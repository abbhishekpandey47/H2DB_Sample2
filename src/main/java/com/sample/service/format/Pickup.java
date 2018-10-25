package com.sample.service.format;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pickup {
	
	@Id
	@GeneratedValue
	private Long pickupId;
	private String destination;
	private String pickup_date;
	private String status;
	
		
	public Pickup() {
		super();		
	}

	public Pickup(Long pickupId, String destination, String pickup_date, String status) {
		super();
		this.pickupId = pickupId;
		this.destination = destination;
		this.pickup_date = pickup_date;
		this.status = status;
	}

	/**
	 * @return the pickupId
	 */
	public Long getPickupId() {
		return pickupId;
	}

	/**
	 * @param pickupId the pickupId to set
	 */
	public void setPickupId(Long pickupId) {
		this.pickupId = pickupId;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the pickup_date
	 */
	public String getPickup_date() {
		return pickup_date;
	}

	/**
	 * @param pickup_date the pickup_date to set
	 */
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pickup [pickupId=" + pickupId + ", destination=" + destination + ", pickup_date=" + pickup_date
				+ ", status=" + status + "]";
	} 
	
}
