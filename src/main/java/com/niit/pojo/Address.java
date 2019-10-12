package com.niit.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1229845343653235358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public

    int id;
	
    @NotBlank(message="Please enter the door number!!!")
	String dnumber;
    @NotBlank(message="Please enter the street name!!!")
    String stname;
    @NotBlank(message="Please enter the area!!!")
    String area;
    @NotBlank(message="Please enter the city!!!")
    String city;
    @NotBlank(message="Please enter the pincode!!!")
    String pincode;

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

}
