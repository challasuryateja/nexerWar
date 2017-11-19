package com.teja.controllers;

public class Registation {
	
	/**
     * SupplierId : 123456
     * UserName : dydf@xf.com
     * Password : t
     * ReTypePassword : t
     * FirstName : y
     * PhoneNumber : 85555
     * IpAddress : 192.168.43.160
     * RegistrationId : cSlBP4ehM9k:APA91bH6XHUhPVxTN7ffG2ySjt2yFsOsLxicRJgMm31Bf2KNTMldyzVM-DqB1uVlM6K9j1YAY1YtHUxC6eBUMvqCXDH52wcLjKaPcuCvu4s0rM1VuIWmOxrhBtYR8uNU3oVi07YwjM7P
     * DeviceType : Android
     * Location : lat, lang
     */

    private String SupplierId;
    private String UserName;
    private String Password;
    private String LastName;
    private String FirstName;
    private String PhoneNumber;
    private String IpAddress;
    private String RegistrationId;
    private String DeviceType;
    private String Location;

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String IpAddress) {
        this.IpAddress = IpAddress;
    }

    public String getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(String RegistrationId) {
        this.RegistrationId = RegistrationId;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
