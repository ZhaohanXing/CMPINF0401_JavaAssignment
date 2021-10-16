package edu.pitt.assignment1;
/**
 * Class TimeFrame
 * @author Zhaohan Xing
 * created:10/11/2021
 */

public class TimeFrame {
	//TimeFrame Attribute
	private int hourStart;
	private int minuteStart;
	private int hourEnd;
	private int minuteEnd;
	//Constructor(and overload of it)
	//Case 1: Start and End Minute are given
	public TimeFrame(int hs,int ms,int he,int me) {
		//If the value is not in the constraint, warn the user and set default value
		if(hs >= 0 && hs <= 23){
			hourStart = hs;
		}else{
			hourStart = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
		if(ms >= 0 && ms <= 59){
			minuteStart = ms;
		}else{
			minuteStart = 0;
			System.out.println("The minute value must be between 0 and 59");
		}
		if(he >= 0 && he <= 23){
			hourEnd = he;
		}else{
			hourEnd = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
		if(me >= 0 && me <= 59){
			minuteEnd = me;
		}else{
			minuteEnd = 0;
			System.out.println("The minute value must be between 0 and 59");
		}
	}
	//Case 2 Start and End time are not given. Set default value 0 to them.
	public TimeFrame(int hs,int he) {
		if(hs >= 0 && hs <= 23){
			hourStart = hs;
		}else{
			hourStart = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
		if(he >= 0 && he <= 23){
			hourEnd = he;
		}else{
			hourEnd = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
		minuteStart = 0;
		minuteEnd = 0;
	}
	//Getters.
	public int getHourStart() {
		return hourStart;
	}
	public int getMinuteStart() {
		return minuteStart;
	}
	public int getHourEnd() {
		return hourEnd;
	}
	public int getMinuteEnd() {
		return minuteEnd;
	}
	//Setters
	public void setHourStart(int newHourStart) {
		if(newHourStart >= 0 && newHourStart <= 23){
			hourStart = newHourStart;
		}else{
			hourStart = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
	}
	public void setMinuteStart(int newMinuteStart) {
		if(newMinuteStart >= 0 && newMinuteStart <= 59){
			minuteStart = newMinuteStart;
		}else{
			minuteStart = 0;
			System.out.println("The minute value must be between 0 and 59");
		}
	}
	public void setHourEnd(int newHourEnd) {
		if(newHourEnd >= 0 && newHourEnd <= 23){
			hourEnd = newHourEnd;
		}else{
			hourEnd = 8;
			System.out.println("The hour value must be between 0 and 23");
		}
	}
	public void setMinuteEnd(int newMinuteEnd) {
		if(newMinuteEnd >= 0 && newMinuteEnd <= 59){
			minuteEnd = newMinuteEnd;
		}else{
			minuteEnd = 0;
			System.out.println("The minute value must be between 0 and 59");
		}
	}
	/**To match the timeframe, the time should start later than the start time of it
	Also, the time should end earlier than the end time of it.
	Thus, it should satisfy both cases. If the hour start(end) time is larger(smaller)
	than the timeframe's, then the condition is satisfied. If the hour start(end) time
	is the same as the timeframe's, then, the minute start(end) time must be larger(smaller)
	than the timeframe's
	 */
	public boolean timeFrameMatch(TimeFrame time) {
		if (
				(
						(time.hourStart > this.hourStart) 
						|| 
						((time.hourStart == this.hourStart)&&(time.minuteStart>=this.minuteStart))
						)
				&&
				(
						(time.hourEnd < this.hourEnd)
						||
						((time.hourEnd == this.hourEnd)&&(time.minuteEnd<=this.minuteEnd))
						)
				){
			return true;
		}else{
			return false;
		}
	}
}