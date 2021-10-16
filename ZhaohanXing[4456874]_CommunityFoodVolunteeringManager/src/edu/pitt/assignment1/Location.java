package edu.pitt.assignment1;
/**
 * Class Location
 * @author Zhaohan Xing
 * created:10/11/2021
 */
public class Location {
	//Location Attributes
	public final double EARTH_RADIUS = 3958.8;
	private double latitude;
	private double longitude;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	//Constructor of the location
	public Location(double lat,double lon,String addr, 
			String city, String state, String zip) {
		//Set values
		if(lat >= -90.0 && lat <= 90.0){
			this.latitude = lat;
		}else{
			this.latitude = 0.0;
			System.out.println("The latitude is between -90.0 and 90.0");
		}
		if(lon >= -180.0 && lon <= 180.0){
			this.longitude = lon;
		}else{
			this.longitude = 0.0;
			System.out.println("The longitude is between -180.0 and 180.0");
		}
		this.address = addr;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
	}
	//Getters. By using these methods, one can acquire the details of properties
	public double getEARTH_RADIUS() {
		//If someone does not know how much is the radius, he/she can use this method
		return EARTH_RADIUS;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	//Setters. By using these methods, one can adjust the details of properties.
	public void setLatitude(double newLatitude) {
		if(newLatitude >= -90.0 && newLatitude <=90.0){
			latitude = newLatitude;
		}else{
			latitude = 0.0;
			System.out.println("The latitude is between -90.0 and 90.0");
		}
	}
	public void setLongitude(double newLongitude) {
		if(newLongitude >= -180.0 && newLongitude <= 180.0){
			longitude = newLongitude;
		}else{
			longitude = 0;
			System.out.println("The longitude is between -180.0 and 180.0");
		}
	}
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	public void setCity(String newCity) {
		city = newCity;
	}
	public void setState(String newState) {
		state = newState;
	}
	public void setZipCode(String newZipCode) {
		zipCode = newZipCode;
	}
	//Methods to find distance
	public double distance(Location loc) {
		//Find out the difference between latitude & longitude
		double latDifference = loc.latitude - this.latitude;
		double lonDifference = loc.longitude - this.longitude;
		//Convert the degree into Radians
		double latDiffInRadians = Math.toRadians(latDifference);
		double lonDiffInRadians = Math.toRadians(lonDifference);
		//Find value of a,c by Harvesine distance formula
		double aValue = Math.pow(Math.sin(latDiffInRadians/2.0), 2.0)
				+ Math.cos(this.latitude) * Math.cos(loc.latitude) 
				* Math.pow(Math.sin(lonDiffInRadians/2.0), 2.0);
		double cValue = 2.0 * Math.atan2(Math.sqrt(aValue), Math.sqrt(1.0 - aValue));
		//Calculate the distance
		double dValue = EARTH_RADIUS * cValue;
		//Return Output
		return dValue;
	}


}
