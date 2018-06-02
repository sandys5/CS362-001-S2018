/*package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */
/*
public class DataHandlerRandomTest {
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
/*
		public static String randMethod(Random random){
			String[] methodArray = new String[] {"getApptRange","deleteAppt"};// The list of the of methods to be tested in the Appt class

			int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

			return methodArray[n] ; // return the method name
		}

		public GregorianCalendar makeDay(){
			long randomseed =System.currentTimeMillis(); //10
			Random random = new Random(randomseed);

			int year = ValuesGenerator.RandInt(random);
			int month = ValuesGenerator.RandInt(random);
			int dai = ValuesGenerator.RandInt(random);

			GregorianCalendar cal = new GregorianCalendar(year,month,dai);

			return cal;
		}

		public CalDay makeCal(){
			CalDay day = new CalDay(makeDay());
			return day;
		}

		public LinkedList<Appt> makeAppts(){
			long randomseed =System.currentTimeMillis(); //10
			Random random = new Random(randomseed);

			CalDay day = makeCal();


			for(int i=0; i< 10; i++){
				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title=ValuesGenerator.getString(random);
				String description=ValuesGenerator.getString(random);

				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startDay, startMonth, startYear, title, description, "hey@gmail.com");

				day.addAppt(appt);

			}
			return day.getAppts();
		}
		/**
		 * Generate Random Tests that tests TimeTable Class.
		 */
	/*	@Test
		public void radnomtest()  throws Throwable  {

			System.out.println("Start testing TimeTable");

			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			long randomseed =System.currentTimeMillis(); //10
			Random random = new Random(randomseed);

			DataHandler timeTable = new DataHandler();

			try {

					for (int k = 0; k < 100; k++) {

						String methodName = DataHandlerRandomTest.randMethod(random);

						if (methodName.equals("getApptRange")) {
							GregorianCalendar firstDay = makeDay();
							GregorianCalendar lastDay = makeDay();

							while (!firstDay.before(lastDay)) {
								firstDay = makeDay();
							}
							LinkedList<Appt> appts = makeAppts();

							List<CalDay> calDays = timeTable.getApptRange(firstDay, lastDay);


							//assertTrue(calDays.size() <= appts.size());

							for (int i = 0; i < calDays.size(); i++) {
								for (int j = 0; j < calDays.get(i).getSizeAppts(); j++) {
									Appt appt = (Appt) calDays.get(i).getAppts().get(j);
									assertTrue(appt.getValid());

									assertEquals((calDays.get(i)).getYear(), appt.getStartYear());
									assertEquals((calDays.get(i)).getMonth(), appt.getStartMonth());
									assertEquals((calDays.get(i)).getDay(), appt.getStartDay());
								}
							}
						}

						else if (methodName.equals("deleteAppt")) {
						LinkedList<Appt> appts = makeAppts();

						int randnum = ValuesGenerator.RandInt(random) % 10;

						Appt appt = appts.get(randnum);
						if(appt.getValid() == false || appt.getXmlElement() == null){
							assertFalse(timeTable.deleteAppt(appt));
						}
						}
					}
			}
			catch(NullPointerException e){

			}

		}


	}
*/