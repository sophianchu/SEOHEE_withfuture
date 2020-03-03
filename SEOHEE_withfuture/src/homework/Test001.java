package homework;

public class Test001 {
	
	public static void main(String[] args) {
		String name[] = {"아이언맨", "헐크", "캡틴", "토르", "호크아이"};
		String hap[] = new String[5];
		String jang[] = {"", "", "", "", ""};
		String star[] = {"", "", "", "", ""};
		
		int[] kor = {100,20,90,70,35};
		int[] eng = {100,50,95,80,100};
		int[] mat = {100,30,90,60,100};
		int sum[] = new int[5];
		int avg[] = new int[5];
		int rank[] = {1, 1, 1, 1, 1};
		
		//합
		for (int i=0; i<sum.length; i++) {
			sum[i] = (kor[i]+eng[i]+mat[i]);
		}
		
		//평균
		for (int i = 0; i < avg.length; i++) {
			avg[i] = (int)((sum[i]/3*100+0.5)/100);
		}
		
		//등수
		for(int i=0; i<rank.length; i++){
			rank[i]=1;
			for(int j=0; j<name.length; j++){
				if(sum[i]<sum[j]){
					rank[i]++;
				}
			}
		}
		
		//합격여부 (평균 70점 미만 불합격 , 과목 과락 60점 재시험)
		for (int i = 0; i < hap.length; i++) {
			if(avg[i]>=70 && kor[i]>=60 && eng[i]>=60 && mat[i]>=60) {
				hap[i] = "합격";
			}else if(avg[i]<70) {
				hap[i] = "불합격";
			}else if(avg[i]>=70 && (kor[i]<60 || eng[i]<60 || mat[i]<60)) {
				hap[i] = "재시험";
			}
		}
		
		//장학생
		for (int i = 0; i < rank.length; i++) {
			if(rank[i] == 1) {
				jang[i] = "장학생";
			}else {
				jang[i] = " ";
			}
		}
		
		//랭킹 (평균점수 100점대 별10개 ~ 10점대 별1개 )
		for (int i = 0; i < avg.length; i++) {
			int compare = avg[i]/10;
			switch (compare) {
			case 10:
				star[i] = "**********";
				break;
			case 9:
				star[i] = "*********";
				break;	
			case 8:
				star[i] = "********";
				break;	
			case 7:
				star[i] = "*******";
				break;	
			case 6:
				star[i] = "******";
				break;	
			case 5:
				star[i] = "*****";
				break;	
			case 4:
				star[i] = "****";
				break;	
			case 3:
				star[i] = "***";
				break;	
			case 2:
				star[i] = "**";
				break;	
			case 1:
				star[i] = "*";
				break;	
			default:
				star[i] = " ";
				break;
			}
		}
		
		//출력
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]+"\t");
			System.out.print(kor[i]+"\t");
			System.out.print(eng[i]+"\t");
			System.out.print(mat[i]+"\t");
			System.out.print(avg[i]+"\t");
			System.out.print(rank[i]+"\t");
			System.out.print(hap[i]+"\t");
			System.out.print(jang[i]+"\t");
			System.out.print(star[i]);
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
}
