package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int seconds=Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}

	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getTotalSeconds("10:00");});
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"00:10:45", "00:10:59"})
	void testGetTotalSecondsBoundary(String candidate) {
		int seconds=Time.getTotalMinutes(candidate);
		assertTrue(seconds>0 && seconds<=59);	
	}
	
	@Test
	void testGetMilliSecondsGood() {
		int milliSeconds=Time.getMilliSeconds("12:05:05:005");
		assertTrue("The seconds were not calculated properly", milliSeconds==005);
	}
	
	@Test
	void testGetMilliSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getMilliSeconds("11:59:05:5");});
	}
	
	@ParameterizedTest
	@ValueSource( strings= {"00:00:00:001", "00:00:00:999"})
	void testGetMilliSecondsBoundary(String candidate) {
		int milliSeconds=Time.getMilliSeconds(candidate);
		assertTrue(milliSeconds>000 && milliSeconds<=999);
	}
	
	@Test
	void testGetSecondsGood() {
		int seconds=Time.getSeconds("10:59:58");
		assertTrue("The seconds were not calculated properly", seconds==58);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getSeconds("11:59");});
	}

	@ParameterizedTest
	@ValueSource( strings= {"00:00:01", "00:00:59"})
	void testGetSecondsBoundary(String candidate) {
		int seconds=Time.getSeconds(candidate);
		assertTrue(seconds>0 && seconds<=59);
	}
	
	
	@Test
	void testGetTotalMinutesGood() {
		int minutes=Time.getTotalMinutes("05:15:05");
		assertTrue("The minutes were not calculated properly", minutes==15);
	}
	
	@Test
	void testGetMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getTotalMinutes("10:9");});
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"00:01:00", "00:59:00"})
	void testGetTotalMinutesBoundary(String candidate) {
		int minutes=Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", (minutes>0 && minutes<=59));	
	}
	

	@Test
	void testGetTotalHoursGood() {
		int hours=Time.getTotalHours("05:15:05");
		assertTrue("The hours were not calculated properly", hours==5);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getTotalHours("1");});

	}
	
	@ParameterizedTest
	@ValueSource( strings = {"01:00:00", "11:59:59"})
	void testGetTotalHoursBoundary(String candidate) {
		int hours=Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", (hours>0 && hours<12));
	}
	
	
}
