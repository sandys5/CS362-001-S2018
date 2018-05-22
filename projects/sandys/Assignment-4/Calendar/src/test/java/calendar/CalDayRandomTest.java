package calendar;


import org.junit.Test;


import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */


		public Appt tempAppt(){
			long randomseed =System.currentTimeMillis(); //10
			Random random = new Random(randomseed);

			int startHour=ValuesGenerator.RandInt(random) % 60;
			int startMinute=ValuesGenerator.RandInt(random) % 60;
			int startDay=ValuesGenerator.RandInt(random) % 32;
			int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear=ValuesGenerator.RandInt(random);
			String title=ValuesGenerator.getString(random);
			String description=ValuesGenerator.getString(random);

			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour, startMonth, startYear, title, description, "hey@gmail.com");
			return appt;
		}
		/**
		 * Generate Random Tests that tests CalDay Class.
		 */
		@Test
		public void radnomtest()  throws Throwable  {

			System.out.println("Start testing CalDay");

			long randomseed =System.currentTimeMillis(); //10
			Random random = new Random(randomseed);

			int year = ValuesGenerator.RandInt(random);
			int month = ValuesGenerator.RandInt(random);
			int dai = ValuesGenerator.RandInt(random);

			//Construct a new Calendar day object with the initial data
			GregorianCalendar cal = new GregorianCalendar(year,month,dai);
			CalDay day = new CalDay(cal);

			try{
				for (int i = 0; i < 100; i++) {

					Appt appt = tempAppt();
					Appt appt2 = tempAppt();

					//while(!appt.getValid()){appt = tempAppt();}

					day.addAppt(appt);
					day.addAppt(appt2);

					assertTrue(day.getSizeAppts() > 0);
					assertEquals(day.getAppts().get(0), appt);
					assertEquals(day.getAppts().get(1), appt2);

					assertEquals((day.getAppts().get(0)).getStartYear(),appt.getStartYear());
					assertEquals((day.getAppts().get(0)).getStartMonth(),appt.getStartMonth());
					assertEquals((day.getAppts().get(0)).getStartDay(),appt.getStartDay());
					assertEquals((day.getAppts().get(0)).getTitle(),appt.getTitle());
					assertEquals((day.getAppts().get(0)).getDescription(),appt.getDescription());

					assertTrue((day.getAppts().get(0)).getValid());

					//make sure appointments are in chronological order
					/*if(i>0) {
						assertTrue((day.getAppts().get(i)).getStartHour() > (day.getAppts().get(i - 1)).getStartHour());
					}*/


				}
			}catch(NullPointerException e){

			}

			System.out.println("Done testing CalDay");

		}



	}


	

