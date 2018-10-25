package com.sample.service.format;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Delivery {
	@Id
	@GeneratedValue
	private Long deliveryId;
	private String destination;
	private String delivery_date;
	private String status; 

	public Delivery() {
		super();
	}

	public Delivery(Long deliveryId, String destination, String delivery_date, String status) {
		super();
		this.deliveryId = deliveryId;
		this.destination = destination;
		this.delivery_date = delivery_date;
		this.status = status;
	}

	/**
	 * @return the deliveryId
	 */
	public Long getDeliveryId() {
		return deliveryId;
	}

	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
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
	 * @return the delivery_date
	 */
	public String getDelivery_date() {
		return delivery_date;
	}

	/**
	 * @param delivery_date the delivery_date to set
	 */
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
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
		return "Delivery [deliveryId=" + deliveryId + ", destination=" + destination + ", delivery_date="
				+ delivery_date + ", status=" + status + "]";
	}

	
	

	
}
