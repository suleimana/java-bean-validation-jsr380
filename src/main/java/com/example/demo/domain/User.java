package com.example.demo.domain;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.validation.PrimaryUserInfo;
import com.example.demo.validation.StringUpperCase;

public class User {
	
	@NotNull(message = "Name cannot be null")
	@StringUpperCase(message ="username must be all uppercase")
	private String username;
	
	@NotBlank(message = "Name cannot be null", groups = {PrimaryUserInfo.class})
	private String firstName;
	
	@NotBlank(message = "Name cannot be null")
	private String lastName;
	
	@AssertTrue
	private boolean active;

	
	@Past(message="Date of birth should be in the past")
	private LocalDate dateOfBirth;
		
	
	@Email(message = "Email should be valid")
	private String email;
	
	@Pattern(regexp="^[2-9]\\d{2}-\\d{3}-\\d{4}$", message= "Phone should be hyphen separated US phone number,"
			+ " of the form ANN-NNN-NNNN, where A is between 2 and 9 and N is between 0 and 9 ")
	private String phone;
	
	
	private Address Address; 	
	
	@Min(value = 18, message = "Age should not be less than 18")  
	@Max(value = 100, message = "Age should not be greater than 100")
	private int age;
	
	@NotEmpty
	@Size(min=45, max=200, message="Bio must be between 45 and 200 characters")
	private String bio;
	
	 
	@NotEmpty(message = "At leas one hobby is required")
	private List<String> hobbies; 
	
	private List<@NotEmpty String> favoriteBooks;
					

	public String getUsername() {
		return username;
	}
	
	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}



	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public List<String> getFavoriteBooks() {
		return favoriteBooks;
	}



	public void setFavoriteBooks(List<String> favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getBio() {
		return bio;
	}



	public void setBio(String bio) {
		this.bio = bio;
	}



	public List<String> getHobbies() {
		return hobbies;
	}



	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	

}
