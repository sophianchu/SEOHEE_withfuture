package homework;

import java.util.Calendar;
import static java.util.Calendar.*;

public class Test004 {
	public static void main(String[] args) {
		
		int year=2019, month=12, date=25;
//		int year=1, month=1, date=31; //test
		
		//1. 요일 구하기
		Calendar cal = getInstance();
		cal.set(year, month-1, date); //month : 0~11
		int yoil = cal.get(DAY_OF_WEEK); //일요일=1, 토요일=7
		String stYoil = null;
	 	switch(yoil){
		 	case(1) : stYoil= "일"; break;
		 	case(2) : stYoil= "월"; break;
		 	case(3) : stYoil= "화"; break;
		 	case(4) : stYoil= "수"; break;
		 	case(5) : stYoil= "목"; break;
		 	case(6) : stYoil= "금"; break;
		 	case(7) : stYoil= "토"; break;
	 	}
	 	
	 	//2. 총날수
	 	long total = dayDiff(1,1,1,year,month,date);
	 	
	 	//출력
	 	System.out.printf("1. %d. %d. %d -> %s요일", year, month, date, stYoil);
		System.out.println();
	 	System.out.printf("2. 서기 1년1월1일(월) ~ %d년%d월%d일 총날수 : %d일", year, month, date, total);
		
	}
	
	public static long dayDiff(int y, int m, int d, int yy, int mm, int dd) {
		Calendar l_cal = getInstance(); 
		l_cal.set(y, m-1, d, 0, 0, 0); 
		Calendar r_cal = getInstance(); 
		r_cal.set(yy, mm-1, dd, 0, 0, 0); 
		
		long diff = (r_cal.getTimeInMillis() - l_cal.getTimeInMillis())/1000/24/60/60;
		
		return diff;
	}
	
}
