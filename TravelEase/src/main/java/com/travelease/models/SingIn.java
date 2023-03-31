package com.travelease.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class SingIn {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

 
	@NotNull
	@Pattern(regexp="[a-z]{6,9}", message = "Username must be between 6 to 9 characters, contain lowercase characters only.")
	private String userName;

	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message= "Min 1 uppercase letter.\n"
    		+ "Min 1 lowercase letter.\n"
    		+ "Min 1 special character [@$!%*#?&].\n"
    		+ "Min 1 number.\n"
    		+ "Min 6 characters.")
	private String password;

	@NotNull
	@Pattern(regexp="[6-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNo;

	@Email
	@NotNull
	private String email;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SingIn(Integer userId,
			@NotNull @Pattern(regexp = "[a-z]{6,9}", message = "Username must be between 6 to 9 characters, contain lowercase characters only.") String userName,
			@NotNull @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message = "Min 1 uppercase letter.\nMin 1 lowercase letter.\nMin 1 special character [@$!%*#?&].\nMin 1 number.\nMin 6 characters.") String password,
			@NotNull @Pattern(regexp = "[6-9]{10}", message = "Mobile number must have 10 digits") String mobileNo,
			@Email @NotNull String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public SingIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SingIn [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo + ", email=" + email + "]";
	}
	
	

}
