package edu.pitt.assignment1;
/**
 * Class Volunteer
 * @author Zhaohan Xing
 * created 10/11/2021
 */
public class Volunteer {
	//class Volunteer Attributes
	private String id;
	private String fullName;
	private int age;
	private Location location;
	private String dayAvailable;
	private TimeFrame timeAvailable;
	private double distanceAvailable;
	private boolean needsTransportation;
	private CommunityFoodOrg orgVolunteering;
	//Constructor Here
	public Volunteer(String id,String name,int age,Location loc,String dayAv,
			TimeFrame timeAv,double distAv,boolean needTrans){
		this.id = id;
		this.fullName = name;
		//Constriant on Volunteer's age
		if(age >= 18 && age <= 100){
			this.age = age;
		}else{
			//Otherwise here use the default age, which is 18
			this.age = 18;
			System.out.println("The age should be an interger between 18 and 100");
		}
		this.location = loc;
		if(dayAv.equals("Monday")||dayAv.equals("Tuesday")||dayAv.equals("Wednesday")||
				dayAv.equals("Thursday")||dayAv.equals("Friday")||
				dayAv.equals("Saturday")||dayAv.equals("Sunday")){
			this.dayAvailable = dayAv;
		}else{
			this.dayAvailable = "Monday";
		}
		this.timeAvailable = timeAv;
		this.distanceAvailable = distAv;
		this.needsTransportation = needTrans;
		//The organization is set by setter, thus it is not provided by the Volunteer here
		this.orgVolunteering = null;	
	}
	//Getters
	public String getID() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public int getAge() {
		return age;
	}
	public Location getLocation() {
		return location;
	}
	public String getDayAvailable() {
		return dayAvailable;
	}
	public TimeFrame getTimeAvailable() {
		return timeAvailable;
	}
	public double getDistAvailable() {
		return distanceAvailable;
	}
	public boolean getNeedsTransportation() {
		return needsTransportation;
	}
	public CommunityFoodOrg getOrgVolunteering() {
		return orgVolunteering;
	}
	//Setters
	public void setID(String newID) {
		id = newID;
	}
	public void setFullName(String newName) {
		fullName = newName;
	}
	public void setAge(int newAge) {
		if(newAge >= 18 && newAge <= 100){
			age = newAge;
		}else{
			//If it is not in the constraint, set it to default value and alarm the user
			age = 18;
			System.out.println("The age should be an interger between 18 and 100");
		}
	}
	public void setLocation(Location newLocation) {
		//Again, if one have some location already, it can be used here
		location = newLocation;
	}
	public void setDayAvailable(String newDA) {
		if(newDA.equals("Monday")||newDA.equals("Tuesday")||newDA.equals("Wednesday")||
				newDA.equals("Thursday")||newDA.equals("Friday")||
				newDA.equals("Saturday")||newDA.equals("Sunday")){
			dayAvailable = newDA;
		}else {
			dayAvailable = "Monday";
		}
	}
	public void setTimeAvailable(TimeFrame newTA) {
		//Similar to the setters of location
		timeAvailable = newTA;
	}
	public void setDistanceAvailable(double newDistA) {
		distanceAvailable = newDistA;
	}
	public void setNeedsTransportation(boolean newNeedTrans) {
		needsTransportation = newNeedTrans;
	}
	public void setOrgVolunteering(CommunityFoodOrg newORG) {
		//Similar to the setters of location and time available
		orgVolunteering = newORG;
	}
	//Create Methods Here:
	//Method 1:To signs a volunteer up for helping on a specific community food organization
	public void signUp(CommunityFoodOrg org) {
		//Find out whether it is possible to sign up a volunteer
		boolean trueOrFalse = org.signUpVolunteer();
		//If it is possible, assign the volunteer;if not,then nothing's gonna happen
		if (trueOrFalse){
			//If possible, assign it
			orgVolunteering = org;
			System.out.println("The volunteer "+fullName+" are successfully added to "+org.getName());
		}else{
			//If not, error occurs
			System.out.println("No available volunteer spot for "+org.getName());
		}
	}
	//Method 2:To cancel current sign-up
	public void cancelSignUp(){
		orgVolunteering.cancelVolunteerSignup();
		System.out.println("The volunteer "+fullName+" has been successfully cancelled from "+orgVolunteering.getName());
		orgVolunteering = null;
	}
	//Method 3:Check the constraints of transportation
	public boolean orgMatch(CommunityFoodOrg org){
		//A boolean which represents "whether the volunteer needs transportation"
		boolean isTransSatisfied;
		//Booleans which represent "whether the Day/Time is available"
		boolean isDayTimeAvailable;
		boolean isDayAvailable;
		boolean isTimeAvailable;
		//A boolean which represents "whether the distance is acceptable"
		boolean isDistanceReachable;
		//Condition 1:Whether transportation matches
		if(needsTransportation == true && org.getOffersTransportation() == false) {
			//if the volunteer needs transportation but Org does not have, then the condition does not hold
			isTransSatisfied = false;
		}else{
			//It is acceptable under other conditions
			isTransSatisfied = true;
		}
		//Condition 2: Whether Day/Time availability matches.
		//Convert Day available into index
		int indexAvailable = 0;
		if(dayAvailable.equals("Monday")){
			indexAvailable = 0;
		}else if(dayAvailable.equals("Tuesday")){
			indexAvailable = 1;
		}else if(dayAvailable.equals("Wednesday")){
			indexAvailable = 2;
		}else if(dayAvailable.equals("Thurday")){
			indexAvailable = 3;
		}else if(dayAvailable.equals("Firday")){
			indexAvailable = 4;
		}else if(dayAvailable.equals("Saturday")){
			indexAvailable = 5;
		}else if(dayAvailable.equals("Sunday")){
			indexAvailable = 6;
		}
		//Compare the index of day
		if(indexAvailable >=org.strToIndexFirstDay() && indexAvailable <=org.strToIndexLastDay()) {
			isDayAvailable = true;
		}else{
			isDayAvailable = false;
		}
		//Compare the time by using the time frame match method
		isTimeAvailable = org.getTimeOpen().timeFrameMatch(timeAvailable);
		//If both are okay, return true. Otherwise return false
		if(isDayAvailable == true && isTimeAvailable == true){
			isDayTimeAvailable = true;
		}else{
			isDayTimeAvailable = false;
		}
		//Condition 3: whether the distance is okay
		double distance = org.getLocation().distance(this.location);
		if(distance <= distanceAvailable){
			isDistanceReachable = true;
		}else{
			isDistanceReachable = false;
		}
		//Combine: if all 3 cases are true, then this organization is okay
		if(isTransSatisfied == true && isDayTimeAvailable == true && isDistanceReachable == true){
			return true;
		}else{
			return false;
		}
	}





}


