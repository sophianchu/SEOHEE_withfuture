package homework;

public class Test003 {
	public static void main(String[] args) {
		int[][] five1 = new int[5][5];
		int num1 = 1;
		int rowCol = 1;
		int i=0, j=-1, k=5;
		
		while(true) {
			for (int l = 0; l < k; l++) {
				j = j+rowCol;
				five1[i][j] = num1;
				num1 = num1+1;
			}
			k=k-1;
			if(k <=0 ) break;
			for (int l = 0; l < k; l++) {
				i = i + rowCol;
				five1[i][j] = num1;
				num1 = num1+1;
			}
			rowCol = rowCol*-1;
		}
		
		//출력
		for (int a = 0; a < five1.length; a++) {
			for (int b = 0; b < five1.length; b++) {
				System.out.print(five1[a][b]+"\t");
			}
			System.out.println();
		}
	}
}
