package bank;

import java.util.Scanner;

public class View {
	
	String id = "";
	String pass = "";
	int val = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public void startMethod() {
		System.out.println("==================================");
		System.out.println("=======  WithFuture Bank  ========");
		System.out.println("==================================");
		while (true) {
			System.out.println();
			System.out.println("---메뉴---");
			System.out.println("1. 가입");
			System.out.println("2. 조회");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 종료");
			System.out.println("---------");
			System.out.println("원하는 서비스 번호 입력 후 Enter");
			System.out.println("---------");
			
			int result = 0;
			result = sc.nextInt();
			
			switch (result) {
			case 1:
				join(); 
				break;
			case 2:
				select();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				System.out.println("프로그램이 종료 되었습니다.");
				return;
			default:
				System.out.println("메뉴에서만 고르세요");
			}
		}
	}

	private void join() {
		System.out.println("---가입 화면----");
		System.out.println("아이디, 비밀번호, 금액을 입력하세요");
		System.out.print("아이디 입력 : ");
		id = sc.next();
		System.out.print("비밀번호 입력 : ");
		pass = sc.next();
		System.out.print("금액 입력 : ");
		val = sc.nextInt();
		
		System.out.println();
		System.out.println("가입 성공! 메뉴로 이동합니다.");
	}

	private void select() {
		while(true) {
		System.out.println("---조회 화면----");
		System.out.println("아이디와 비밀번호를 입력하세요");
		System.out.print("아이디 입력 : ");
		String inputId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String inputPass = sc.next();
			if(id.equals(inputId) && pass.equals(inputPass)) {
				System.out.println("*********************************");
				System.out.println("       현재 잔액은 "+val+"원 입니다.");
				System.out.println("*********************************");
				return;
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원번호가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
	}

	private void deposit() {
		while(true) {
		System.out.println("---입금 화면----");
		System.out.println("아이디와 비밀번호를 입력하세요");
		System.out.print("아이디 입력 : ");
		String inputId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String inputPass = sc.next();
			if(id.equals(inputId) && pass.equals(inputPass)) {
				System.out.print("입금할 금액 입력 : ");
				val = val+sc.nextInt();
				System.out.println("*********************************");
				System.out.println("       현재 잔액은 "+val+"원 입니다.");
				System.out.println("*********************************");
				return;
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원번호가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
		
	}

	private void withdraw() {
		while(true) {
			System.out.println("---출금 화면----");
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			System.out.print("비밀번호 입력 : ");
			String inputPass = sc.next();
			if(id.equals(inputId) && pass.equals(inputPass)) {
				while(true) {
					System.out.print("출금할 금액 입력 : ");
					int inputVal = sc.nextInt();
					if(inputVal > val) {
						System.out.println("*********************************");
						System.out.println("현재 잔액보다 많습니다. 금액을 다시 입력하세요.");
						System.out.println("*********************************");
						continue;
					}else {
						val = val - inputVal;
						System.out.println("*********************************");
						System.out.println("       현재 잔액은 "+val+"원 입니다.");
						System.out.println("*********************************");
						return;
					}
				}
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원번호가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
	}
}
