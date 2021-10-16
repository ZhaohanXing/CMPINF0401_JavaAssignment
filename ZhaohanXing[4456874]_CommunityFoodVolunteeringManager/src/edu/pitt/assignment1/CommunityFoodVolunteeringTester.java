package edu.pitt.assignment1;
/**
 * Class:CommunityFoodVolunteeringTester
 * @author Zhaohan Xing
 * Create time:10/13/2021
 */
public class CommunityFoodVolunteeringTester {

	public static void main(String[] args) {
		//Find two locations
		//location 1:North Hills Food Bank - Amarraca Branch (Source:https://www.foodpantries.org/li/north-hills-food-bank)
		TimeFrame timeForPantry1 = new TimeFrame(9,0,13,0);
		Location locForPantry1 = new Location(40.546880,-80.020620,"99 Corbett Court","Pittsburgh","PA","15237");
		CommunityFoodOrg pantry1 = new CommunityFoodOrg("1","North Hills Food Bank - Amarraca Branch",locForPantry1,"Tuesday","Tuesday",timeForPantry1,100,0,true);

		//Location 2:Wilkinsburg Community Ministry(Source:https://www.foodpantries.org/li/pa_15221_wilkinsburg-community-ministry)
		TimeFrame timeForPantry2 = new TimeFrame(9,0,13,0);
		Location locForPantry2 = new Location(36.634102,-82.500076,"702 Wood Street","Pittsbutgh","PA","15221");
		CommunityFoodOrg pantry2 = new CommunityFoodOrg("2","Wilkinsburg Community Ministry",locForPantry2,"Monday","Friday",timeForPantry2,100,0,false);

		//Volunteer 1:Myself
		TimeFrame timeForVolunteer1 = new TimeFrame(13,30,15,0);
		Location locForVolunteer1 = new Location(40.437670,-79.962580,"3333 Forbes Avenue","Pittsburgh","PA","15213");
		Volunteer volunteer1 = new Volunteer("1","Zhaohan Xing",21,locForVolunteer1,"Saturday",timeForVolunteer1,100.0,true);

		//Volunteer 2:My Friend
		TimeFrame timeForVolunteer2 = new TimeFrame(10,30,12,45);
		Location locForVolunteer2 = new Location(40.432600,-79.927650,"5806 Hobart Street","Pittsburgh","PA","15217");
		Volunteer volunteer2 = new Volunteer("2","Zeyu Yao",22,locForVolunteer2,"Friday",timeForVolunteer2,999.0,false);

		//Check:Distance
		System.out.println("The distance between Pantry"+pantry1.getName()+" and "+volunteer1.getFullName()+" is "+locForPantry1.distance(locForVolunteer1));
		System.out.println("The distance between Pantry"+pantry2.getName()+" and "+volunteer1.getFullName()+" is "+locForPantry2.distance(locForVolunteer1));
		System.out.println("The distance between Pantry"+pantry1.getName()+" and "+volunteer2.getFullName()+" is "+locForPantry1.distance(locForVolunteer2));
		System.out.println("The distance between Pantry"+pantry2.getName()+" and "+volunteer2.getFullName()+" is "+locForPantry2.distance(locForVolunteer2));

		//Check:Time Available or not
		System.out.println(timeForPantry1.timeFrameMatch(timeForVolunteer1));
		System.out.println(timeForPantry2.timeFrameMatch(timeForVolunteer1));
		System.out.println(timeForPantry1.timeFrameMatch(timeForVolunteer2));
		System.out.println(timeForPantry2.timeFrameMatch(timeForVolunteer2));


		//Result:whether the volunteer can be signed up or not
		if(volunteer1.orgMatch(pantry1)){
			System.out.println(volunteer1.getFullName()+" can volunteer on "+pantry1.getName()+" on "+volunteer1.getDayAvailable());	
		}else{
			System.out.println(volunteer1.getFullName()+" cannot volunteer on "+pantry1.getName()+" on "+volunteer1.getDayAvailable());
		}

		if(volunteer1.orgMatch(pantry2)){
			System.out.println(volunteer1.getFullName()+" can volunteer on "+pantry2.getName()+" on "+volunteer1.getDayAvailable());	
		}else{
			System.out.println(volunteer1.getFullName()+" cannot volunteer on "+pantry2.getName()+" on "+volunteer1.getDayAvailable());
		}

		if(volunteer2.orgMatch(pantry1)){
			System.out.println(volunteer2.getFullName()+" can volunteer on "+pantry1.getName()+" on "+volunteer2.getDayAvailable());	
		}else{
			System.out.println(volunteer2.getFullName()+" cannot volunteer on "+pantry1.getName()+" on "+volunteer2.getDayAvailable());
		}

		if(volunteer2.orgMatch(pantry2)){
			System.out.println(volunteer2.getFullName()+" can volunteer on "+pantry1.getName()+" on "+volunteer2.getDayAvailable());	
		}else{
			System.out.println(volunteer2.getFullName()+" cannot volunteer on "+pantry1.getName()+" on "+volunteer2.getDayAvailable());
		}

		//From the result we can see that volunteer 1 cannot have a volunteering job. Thus we should modify some of it
		//It shows that I cannot.Maybe the first pantry adjust the time to 12:00 to 16:30
		//Adjust the first pantry's time
		timeForPantry1.setHourStart(12);
		timeForPantry1.setMinuteStart(0);
		timeForPantry1.setHourEnd(16);
		timeForPantry1.setMinuteEnd(30);
		//Adjust Volunteer's time
		volunteer1.setDayAvailable("Tuesday");
		//Find out the result
		if(volunteer1.orgMatch(pantry1)){
			System.out.println(volunteer1.getFullName()+" can volunteer on "+pantry1.getName()+" on "+volunteer1.getDayAvailable());	
		}else{
			System.out.println(volunteer1.getFullName()+" cannot volunteer on "+pantry1.getName()+" on "+volunteer1.getDayAvailable());
		}

		if(volunteer1.orgMatch(pantry2)){
			System.out.println(volunteer1.getFullName()+" can volunteer on "+pantry2.getName()+" on "+volunteer1.getDayAvailable());	
		}else{
			System.out.println(volunteer1.getFullName()+" cannot volunteer on "+pantry2.getName()+" on "+volunteer1.getDayAvailable());
		}
		//Now we can sign up the volunteers.
		//Find out whether it is possible to add the volunteer
		if(volunteer1.orgMatch(pantry1)){
			volunteer1.signUp(pantry1);
		}
		//Case 2
		if(volunteer1.orgMatch(pantry2)){
			volunteer1.signUp(pantry2);
		}
		//Case 3
		if(volunteer2.orgMatch(pantry1)){
			volunteer2.signUp(pantry1);
		}
		//Case 4
		if(volunteer2.orgMatch(pantry2)){
			volunteer2.signUp(pantry2);
		}
		//Cancel the sign up of volunteer1 (myself) since I do not have time now
		//Before that, check the number of volunteers to make sure the volunteer is removed
		System.out.println(pantry1.getWeeklyVolunteersSignups());
		//Cancel the sign up
		volunteer1.cancelSignUp();
		//Check point for the number of volunteers to find out whether the volunteer is removed
		System.out.println(pantry1.getWeeklyVolunteersSignups());



	}

}
