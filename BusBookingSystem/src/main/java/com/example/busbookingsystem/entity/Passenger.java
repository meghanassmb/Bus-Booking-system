package com.example.busbookingsystem.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@SequenceGenerator(name = "Passenger_Info", sequenceName = "seq2", initialValue = 100)
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Passenger_Info")
	private int passId;

	@NotEmpty(message = "name is required")
	private String passName;


	@Pattern(regexp = "\\d{10}", message = "Please enter 10 digit phone number")
	private String phoneNumber;

	@Email(message = "Invalid Email")
	@NotBlank(message = "Email Id is mandatory")
	private String emailId;

	@Pattern(regexp = "^(?!\\d+$)(?:[a-zA-Z0-9][a-zA-Z0-9 @&$]*)?$", message = "Password must contain atleast 1 uppercase,1 lowercase and 1 digit")
	private String password;

	private int passCount;
	
	private LocalDateTime arrivalDateTime;

	private String source;
	
	private String destination;
	
	@OneToMany(mappedBy = "passenger")
	@JsonIgnore
	private List<BusDetails> bus = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "busNumber")
    private BusDetails busdetails;

	public Passenger() {
		super();
	}

	public Passenger(int passId, @NotEmpty(message = "name is required") String passName,
			@Pattern(regexp = "\\d{10}", message = "Please enter 10 digit phone number") String phoneNumber,
			@Email(message = "Invalid Email") @NotBlank(message = "Email Id is mandatory") String emailId,
			@Pattern(regexp = "^(?!\\d+$)(?:[a-zA-Z0-9][a-zA-Z0-9 @&$]*)?$", message = "Password must contain atleast 1 uppercase,1 lowercase and 1 digit") String password,
			int passCount, LocalDateTime arrivalDateTime, String source, String destination, List<BusDetails> bus,
			BusDetails busdetails) {
		super();
		this.passId = passId;
		this.passName = passName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.passCount = passCount;
		this.arrivalDateTime = arrivalDateTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
		this.busdetails = busdetails;
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<BusDetails> getBus() {
		return bus;
	}

	public void setBus(List<BusDetails> bus) {
		this.bus = bus;
	}

	public BusDetails getBusdetails() {
		return busdetails;
	}

	public void setBusdetails(BusDetails busdetails) {
		this.busdetails = busdetails;
	}

	@Override
	public String toString() {
		return "Passenger [passId=" + passId + ", passName=" + passName + ", phoneNumber=" + phoneNumber + ", emailId="
				+ emailId + ", password=" + password + ", passCount=" + passCount + ", arrivalDateTime="
				+ arrivalDateTime + ", source=" + source + ", destination=" + destination + ", bus=" + bus
				+ ", busdetails=" + busdetails + "]";
	}
	
   


}