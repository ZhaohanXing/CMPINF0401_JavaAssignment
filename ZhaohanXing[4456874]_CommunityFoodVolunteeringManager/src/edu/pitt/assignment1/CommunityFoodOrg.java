package edu.pitt.assignment1;
/**
 * Class CommunityFoodOrg
 * @author Zhaohan Xing
 * created:10/11/2021
 */

public class CommunityFoodOrg {
	//Attributes Setting
	private String id;
	private String name;
	private Location location;
	private String firstDayOpen;
	private String lastDayOpen;
	private TimeFrame timeOpen;
	private int weeklyVolunteersNeeded;
	private int weeklyVolunteerSignups;
	private boolean offersTransportation;
	//Constructor Definition
	public CommunityFoodOrg(String id,String name,Location loc,String firstDo,
			String lastDo,TimeFrame time,int weekVN,int weekVS,boolean offersT) {
		this.id = id;
		this.name = name;
		this.location = loc;
		if(firstDo.equals("Monday")||firstDo.equals("Tuesday")||firstDo.equals("Wednesday")||
				firstDo.equals("Thursday")||firstDo.equals("Friday")||
				firstDo.equals("Saturday")||firstDo.equals("Sunday")){
			this.firstDayOpen = firstDo;
		}else{
			this.firstDayOpen = "Monday";
			System.out.println("Input a day from Monday to Sunday");
		}
		if(lastDo.equals("Monday")||lastDo.equals("Tuesday")||lastDo.equals("Wednesday")||
				lastDo.equals("Thursday")||lastDo.equals("Friday")||
				lastDo.equals("Saturday")||lastDo.equals("Sunday")){
			this.lastDayOpen = lastDo;
		}else{
			this.lastDayOpen = "Monday";
			System.out.println("Input a day from Monday to Sunday");
		}
		this.timeOpen = time;
		this.weeklyVolunteersNeeded = weekVN;
		if(weekVS <= weekVN && weekVS >= 0){
			this.weeklyVolunteerSignups = weekVS;
		}else if(weekVS < 0){
			this.weeklyVolunteerSignups = 0;
		}else{
			this.weeklyVolunteerSignups = weekVN;
		}
		this.offersTransportation = offersT;
	}
	//Getters
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Location getLocation() {
		return location;
	}
	public String getFirstDayOpen() {
		return firstDayOpen;
	}
	public String getLastDayOpen() {
		return lastDayOpen;
	}
	public TimeFrame getTimeOpen() {
		return timeOpen;
	}
	public int getWeeklyVolunteersNeeded() {
		return weeklyVolunteersNeeded;
	}
	public int getWeeklyVolunteersSignups() {
		return weeklyVolunteerSignups;
	}
	public boolean getOffersTransportation() {
		return offersTransportation;
	}
	//Setters
	public void setID(String newID) {
		id = newID;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setLocation(Location newLoc) {
		//If some location has already be set up(newLoc), it can be set here
		location = newLoc;
	}
	public void setFirstDayOpen(String newFDO) {
		if(newFDO.equals("Monday")||newFDO.equals("Tuesday")||newFDO.equals("Wednesday")||
				newFDO.equals("Thursday")||newFDO.equals("Friday")||
				newFDO.equals("Saturday")||newFDO.equals("Sunday")){
			firstDayOpen = newFDO;
		}else{
			firstDayOpen = "Monday";
			System.out.println("Input a day from Monday to Sunday");
		}
	}
	public void setLastDayOpen(String newLDO) {
		if(newLDO.equals("Monday")||newLDO.equals("Tuesday")||newLDO.equals("Wednesday")||
				newLDO.equals("Thursday")||newLDO.equals("Friday")||
				newLDO.equals("Saturday")||newLDO.equals("Sunday")){
			lastDayOpen = newLDO;
		}else{
			lastDayOpen = "Monday";
			System.out.println("Input a day from Monday to Sunday");
		}
	}
	public void setTimeOpen(TimeFrame newTO) {
		//Similar to the location setter here
		timeOpen = newTO;
	}
	public void setWeeklyVolunteersNeeded(int newNeeded) {
		weeklyVolunteersNeeded = newNeeded;
	}
	public void setWeeklyVolunteerSignups(int newSignups) {
		if(newSignups <= weeklyVolunteersNeeded && newSignups >= 0){
			weeklyVolunteerSignups = newSignups;
		}else if(newSignups < 0){
			weeklyVolunteerSignups = 0;
		}else{
			weeklyVolunteerSignups = weeklyVolunteersNeeded;
		}
	}
	public void setOffersTransportation(boolean newTrans) {
		offersTransportation = newTrans;
	}
	//Methods in this class
	//Find the number of spots of volunteers left the current week
	public int weeklyVolunteerSpotsLeft() {
		int numberLeft = weeklyVolunteersNeeded - weeklyVolunteerSignups;
		return numberLeft;
	}
	//Adds new volunteer sign-up until it reaches the quota
	public boolean signUpVolunteer() {
		if (weeklyVolunteerSpotsLeft() > 0) {
			weeklyVolunteerSignups++;
			return true;	
		}else{
			return false;
		}
	}
	//Check and cancel the Volunteers' Signup
	public void cancelVolunteerSignup() {
		if (weeklyVolunteerSignups > 0) {
			weeklyVolunteerSignups -= 1;
		}else{
			System.out.println("No volunteer has signed up yet");
		}
	}
	//Convert days into index
	public int strToIndexFirstDay(){
		int indexFirstDay = 0;
		if(this.getFirstDayOpen().equals("Monday")){
			indexFirstDay = 0;
		}else if(this.getFirstDayOpen().equals("Tuesday")){
			indexFirstDay = 1;
		}else if(this.getFirstDayOpen().equals("Wednesday")){
			indexFirstDay = 2;
		}else if(this.getFirstDayOpen().equals("Thursday")){
			indexFirstDay = 3;
		}else if(this.getFirstDayOpen().equals("Friday")){
			indexFirstDay = 4;
		}else if(this.getFirstDayOpen().equals("Saturday")){
			indexFirstDay = 5;
		}else if(this.getFirstDayOpen().equals("Sunday")){
			indexFirstDay = 6;
		}
		return indexFirstDay;
	}
	//Similar to the last day open
	public int strToIndexLastDay(){
		int indexLastDay = 0;
		if(this.getLastDayOpen().equals("Monday")){
			indexLastDay = 0;
		}else if(this.getLastDayOpen().equals("Tuesday")){
			indexLastDay = 1;
		}else if(this.getLastDayOpen().equals("Wednesday")){
			indexLastDay = 2;
		}else if(this.getLastDayOpen().equals("Thursday")){
			indexLastDay = 3;
		}else if(this.getLastDayOpen().equals("Friday")){
			indexLastDay = 4;
		}else if(this.getLastDayOpen().equals("Saturday")){
			indexLastDay = 5;
		}else if(this.getLastDayOpen().equals("Sunday")){
			indexLastDay = 6;
		}
		return indexLastDay;
	}


}
