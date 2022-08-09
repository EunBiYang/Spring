package sample4;

import java.util.Calendar;

public abstract class AbstractTest {
	
	abstract public String dayInfo();
	
	
	public static AbstractTest getInstance() {
		Calendar calender = Calendar.getInstance();
		int dayNum = calender.get(Calendar.DAY_OF_WEEK);	//요일수: 오늘이 이번주의 몇번째 날인지
		
		switch (dayNum) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		return null;
	}
	
}
