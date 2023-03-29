package com.travelease.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LogIn {
	
	@NotNull
	@Email
	private String email;
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message= "Min 1 uppercase letter.\n"
    		+ "Min 1 lowercase letter.\n"
    		+ "Min 1 special character [@$!%*#?&].\n"
    		+ "Min 1 number.\n"
    		+ "Min 6 characters.")
	private String password;
	@NotNull
	private UserType userType;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public LogIn(@NotNull @Email String email, @NotNull String password, @NotNull UserType userType) {
		super();
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, userType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogIn other = (LogIn) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& userType == other.userType;
	}
	@Override
	public String toString() {
		return "LogIn email=" + email + ", password=" + password + ", userType=" + userType + "";
	}
	
}
