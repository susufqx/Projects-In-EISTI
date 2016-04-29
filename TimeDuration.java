package TestJava;
import java.io.*;
/**
 * class TimeDuration to show the time as the format 'xx h xx m xx s' xx is number here
 * */
public class TimeDuration {
	
	private int h;	// hours
	private int m;	// minutes
	private int s;	// seconds
	
	// main fonction
	//for the test
	public static void main (String [] args) throws BadBadValueException {
		new TimeDuration(0).toString();
		new TimeDuration(732).toString();
		new TimeDuration(7242).toString();
	}
	
	// constructor of TimeDuration
	TimeDuration (int time) throws BadBadValueException {
		if (time >= 0) {
			System.out.println("Time is ok!");
		} else {
			throw new BadBadValueException ("Time can't be negative, it's wrong!"); // throws a exception
		}
		// calculate the time and use the format 'xx h xx m xx s'
		calculateTime(time);
	}
	
	// to calculate the time 
	void calculateTime (int t) {	
		if (t < 60) {
			h		=	00;
			m		=	00;
			s		=	t;
		} else if (t < 3600) {
			h		=	00;
			s		=	t % 60 ;	// the rest is second
			m		=	t / 60;	
		} else {
			s		=		t % 60;
			m		=		(t / 60) % 60;
			h		=		(t / 60) / 60;
		}
	}
	
	 public String toString(){
		String	msg;
		Integer	hour	=	new Integer (h);
		Integer minute	=	new Integer (m);
		Integer second	=	new Integer (s);
		if (h == 0 && m == 0) {
			msg		=	"Time duration is "+second.toString()+"s";
			System.out.println(msg);
			return msg;
		} else if (h == 0) {
			msg		= 	"Time duration is "+minute.toString()+"m "+second.toString()+"s";
			System.out.println(msg);
			return msg;
		} else {
			msg		=	"Time duration is "+hour.toString()+"h "+minute.toString()+"m "+second.toString()+"s";
			System.out.println(msg);
			return msg;
		}
	}
	
}

/**
 * class of throw the exception when the time number is negative
 * */
class BadBadValueException extends Exception{
	String message;  
	// parent method 
	public BadBadValueException (String ErrorMessage) {
		message		=	ErrorMessage;
	}
	//override the method getMessage()
	public String getMessage() {
		return message;
	}
}