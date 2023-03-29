package com.travelease.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Travels {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelsId;
	@Size(min = 3 , message = "travels name should be more then 2 letters")
	private String travelsName;
	@Size(min = 3 , message = "agent name should be more then 2 letters")
	private String agentName;
	@Embedded
	private AgentAddress address;
	@Pattern(regexp = "[0-9]{10}$")
	private String contact;
	
	
	
	
	
	public Travels() {
		super();
	}





	public Travels(Integer travelsId,
			@NotBlank @NotNull @Size(min = 3, message = "travels name should be more then 3 letters") String travelsName,
			@NotBlank @NotNull @Size(min = 3, message = "agent name should be more then 3 letters") String agentName,
			AgentAddress address, @Pattern(regexp = "[0-9]{10}$") String contact) {
		super();
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}





	public Integer getTravelsId() {
		return travelsId;
	}





	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}





	public String getTravelsName() {
		return travelsName;
	}





	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}





	public String getAgentName() {
		return agentName;
	}





	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}





	public AgentAddress getAddress() {
		return address;
	}





	public void setAddress(AgentAddress address) {
		this.address = address;
	}





	public String getContact() {
		return contact;
	}





	public void setContact(String contact) {
		this.contact = contact;
	}





	@Override
	public String toString() {
		return "Travels [travelsId=" + travelsId + ", travelsName=" + travelsName + ", agentName=" + agentName
				+ ", address=" + address + ", contact=" + contact + "]";
	}
	
	
	
	
	
}
