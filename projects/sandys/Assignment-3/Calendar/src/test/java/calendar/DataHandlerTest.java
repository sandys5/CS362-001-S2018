
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void datatest00()  throws Throwable  {
    Appt newAppt = new Appt(35,2,2020,"leap year", "doing some leaping","johns@gmail.com");
    GregorianCalendar greg = new GregorianCalendar(2020, 2, 2);
    assertTrue(greg.isLeapYear(greg.getWeekYear()));
    int [] arr = new int [] {3,5,3};
    newAppt.setRecurrence(arr,3,3,3);
    //assertFalse(newAppt.getValid());
    assertEquals(newAppt.getRecurBy(), 3);
    assertEquals(newAppt.getRecurIncrement(), 3);
    assertEquals(newAppt.getRecurNumber(), 3);
  }
  @Test(timeout = 4000)
  public void datatest01()  throws Throwable  {
      DataHandler data = new DataHandler("calendar.xml");
      Appt valAppt = new Appt(25,3,2018,"valid", "doing valid", "smithj@gmail.com");
      Appt invAppt = new Appt(3, 76, 23, 4, 2017, "title", "description", "email@gmail.com");
      assertTrue(data.saveAppt(valAppt));
      assertFalse(data.saveAppt(invAppt));
      assertTrue(data.deleteAppt(valAppt));
      assertFalse(data.deleteAppt(invAppt));
  }

}
