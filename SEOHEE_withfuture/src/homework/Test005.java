package homework;

import java.util.Calendar;
import java.util.Scanner;

public class Test005 {
	public static void main(String[] args) {
		Object calendar[][] = new Object[5][7];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 년도와 달을 입력해주세요");
		System.out.print("년 입력 (예 :2019) : ");
		int inputYear = sc.nextInt();
		System.out.print("월 입력 (예 :2) : ");
		int inputMonth = sc.nextInt();
		
		//1일이 시작하는 요일
		int yoil = 0; //1~6
		Calendar start = Calendar.getInstance();
		start.set(inputYear, inputMonth-1, 1);
		int cal_yoil = start.get(Calendar.DAY_OF_WEEK);
		switch(cal_yoil){
			case(1) : yoil= 0; break;
		 	case(2) : yoil= 1; break;
		 	case(3) : yoil= 2; break;
		 	case(4) : yoil= 3; break;
		 	case(5) : yoil= 4; break;
		 	case(6) : yoil= 5; break;
		 	case(7) : yoil= 6; break;
	 	}
		
		//마지막 날(28 or 29 or 30 or 31)
		Calendar last = Calendar.getInstance();
		last.set(inputYear, inputMonth, 1);
		//다음달의 첫 날에서 하루를 빼면 현재 달의 마지막 날이 됨
		last.add(Calendar.DATE, -1); 
		int lastdate = last.get(Calendar.DATE);
		
		//setData
		int num = 1;
		int limit = 7;
		for (int i = 0; i < calendar.length; i++) {
			if(yoil == 7 ) {
				for (int j = yoil; j<limit; j++) {
					if(num > lastdate) break;
					calendar[i][j] = num;
					num++;
				}
			}else {
				for (int j = yoil; j<limit; j++) {
					if(num > lastdate) break;
					calendar[i][j] = num;
					num++;
				}
				yoil = 0;
			}
		}
		
		
		//출력
		System.out.println();
		System.out.println("====================== " + inputYear +". "+ inputMonth +". ======================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < calendar.length; i++) {
			for (int j = 0; j < 7; j++) {
				if((Integer)calendar[i][j] == (Integer)0 || calendar[i][j] == null) {
					calendar[i][j] = String.format("  ");
					System.out.print(calendar[i][j]+"\t");
				}else {
					System.out.print(calendar[i][j]+"\t");
				}
			}
			System.out.println();
		}
		System.out.println("======================================================");
	}
}
