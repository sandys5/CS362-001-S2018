package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	/* @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }*/

	public static String CUTrand(Random random){
		String[] methodArray = new String[] {"setValid","setRecurDays", "isOn"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	@Test
	public void validTest() throws Throwable{
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		//DO ISON METHOD


		System.out.println("Start testing Appt");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				String title=ValuesGenerator.getString(random);
				String description=ValuesGenerator.getString(random);


				//Construct a new Appointment object with the initial data

				Appt appt = new Appt(1,2,2000,"appointment","study", "hey@gmail.com");

				//if(!appt.getValid())continue;

				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.CUTrand(random);
					if (methodName.equals("setValid")){
						appt.setStartHour(ValuesGenerator.RandInt(random));
						appt.setStartMinute(ValuesGenerator.RandInt(random));
						appt.setStartDay(ValuesGenerator.RandInt(random));
						appt.setStartMonth(ValuesGenerator.getRandomIntBetween(random, 1, 11));
						appt.setStartYear(ValuesGenerator.RandInt(random));

						if(appt.getStartHour() < 0 || appt.getStartHour() > 23) {
							assertFalse(appt.getValid());
						}

						else if(appt.getStartMinute() < 0 || appt.getStartMinute() > 59){
							assertFalse(appt.getValid());
						}
						else if(appt.getStartDay() < 1 ){

							assertFalse(appt.getValid());
						}
						else if(appt.getStartDay() > 29 && appt.getStartMonth() == 2){
							assertFalse(appt.getValid());
						}
						else if(appt.getStartMonth() < 1 || appt.getStartMonth() > 12){
							assertFalse(appt.getValid());
						}
						else if(appt.getStartYear() <= 0){
							assertFalse(appt.getValid());
						}
					}
					else if (methodName.equals("setRecurDays")){
						int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						int recur=ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);

						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

						if(sizeArray == 0){
							assertTrue(recurDays.length <1);
						}

					}
					else if (methodName.equals("isOn")){
						appt.setStartDay(ValuesGenerator.RandInt(random));;
						appt.setStartMonth(ValuesGenerator.getRandomIntBetween(random, 1, 11));
						appt.setStartYear(ValuesGenerator.RandInt(random));

						assertTrue(appt.isOn(appt.getStartDay(),appt.getStartMonth(), appt.getStartYear()));
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing Appt");
	}
}


	


	

