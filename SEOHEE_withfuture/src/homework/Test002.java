package homework;

public class Test002 {
	public static void main(String[] args) {
		int[][] five = new int[5][5];
		int num = 1;
		int a=1, b=0, c=4;
		
		for (int i = 0; i < five.length; i++) {
			for (int j = b; j!=c+a; j=j+a) {
				five[i][j] = num++;
			}
			int temp = b;
			b = c;
			c = temp;
			a = -a;
		}
		
		//출력
		for (int i = 0; i < five.length; i++) {
			for (int j = 0; j < five.length; j++) {
				System.out.print(five[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
