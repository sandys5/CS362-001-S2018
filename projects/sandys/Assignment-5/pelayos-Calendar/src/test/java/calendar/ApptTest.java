/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(60, 30, 9, 11, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      //assertEquals("\t11/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
      assertFalse(appt0.getValid());
      assertTrue(appt0.getStartMonth() < 13);
      assertTrue(appt0.getStartHour() < 24);
      //assertTrue(appt0.getStartMinute() < 60);
      assertTrue(appt0.getStartDay() < 32);
      assertFalse(appt0.getStartYear() < 0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    int[] arr = new int[]{3, 3, 3};
    Appt myAppt = new Appt(1,2,3,4,2001,"study","get to school","valid@comcast.net");
    myAppt.setRecurrence(arr, 3, 3, 3);
    assertTrue(myAppt.getValid());
    assertEquals(3L, (long)myAppt.getRecurNumber());
    assertEquals(3L, (long)myAppt.getRecurIncrement());
    assertEquals(3L, (long)myAppt.getRecurBy());
    assertEquals(true, myAppt.isRecurring());
    myAppt.setRecurrence((int[])null, 3, 3, 3);
    assertEquals(0L, (long)myAppt.getRecurDays().length);
    assertEquals("valid@comcast.net", myAppt.getEmailAddress());
    assertEquals(myAppt.getStartHour(),1);
    assertEquals(myAppt.getStartMinute(),2);
    assertEquals(myAppt.getStartDay(),3);
    assertEquals(myAppt.getStartYear(),2001);
    assertEquals(myAppt.getTitle(),"study");
    assertEquals(myAppt.getDescription(), "get to school");
    assertTrue(myAppt.getStartMonth() > 0);
    assertTrue(myAppt.getStartHour() >= 0);
    assertTrue(myAppt.getStartMinute() >= 0);
    assertTrue(myAppt.getStartDay() > 0);
    assertTrue(myAppt.getStartYear() >= 0);


}

}
