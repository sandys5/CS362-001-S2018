/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;

import java.util.GregorianCalendar;


public class CalDayTest{

  @Test(timeout = 4000)
  public void caltest00()  throws Throwable  {
    GregorianCalendar day = new GregorianCalendar(1995, 2, 2);
    Appt appt = new Appt(2, 2, 1995, "party", "have fun", "john@gmail.com" );
    CalDay calday = new CalDay(day);
    assertEquals(1995L, (long)calday.getYear());
    assertEquals(2L, (long)calday.getMonth());
    assertEquals(2L, (long)calday.getDay());
    assertEquals(0L, (long)calday.getSizeAppts());
    calday.addAppt(appt);
    DataHandler data = new DataHandler("calendar.xml");
    //assertTrue(data.deleteAppt(appt));
  }

  @Test(timeout = 4000)
  public void caltest01()  throws Throwable  {
    GregorianCalendar day = new GregorianCalendar(1995, 2, 2);
    CalDay calday = new CalDay(day);
    Appt myAppt = new Appt(3, 6, 2, 2, 1995, "Party", "partay", "beeop@valid.com");

    assertEquals(3L, (long)myAppt.getStartHour());
    assertEquals(6L, (long)myAppt.getStartMinute());
    assertEquals(2L, (long)myAppt.getStartDay());
    assertEquals(2L, (long)myAppt.getStartMonth());
    assertEquals(1995L, (long)myAppt.getStartYear());
    assertEquals("Party", myAppt.getTitle());
    assertEquals("partay", myAppt.getDescription());
    assertEquals((long)myAppt.getStartDay(), (long)calday.getDay());
    assertEquals((long)myAppt.getStartMonth(), (long)calday.getMonth());
    assertEquals((long)myAppt.getStartYear(), (long)calday.getYear());
  }

}
