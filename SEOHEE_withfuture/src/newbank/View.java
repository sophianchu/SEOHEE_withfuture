package newbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
	List<Person> personList = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public void startMethod() {
		System.out.println("==================================");
		System.out.println("=========  Bank ver.2  ==========");
		System.out.println("==================================");
		while (true) {
			Scanner scn = new Scanner(System.in);
			System.out.println();
			System.out.println("---메뉴---");
			System.out.println("1. 가입");
			System.out.println("2. 조회");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 종료");
			System.out.println("6. 삭제");
			System.out.println("---------");
			System.out.println("원하는 서비스 번호 입력 후 Enter");
			System.out.println("---------");
			
			int result = 0;
			try {
				result = scn.nextInt();
			} catch (Exception e) {
				System.err.println("숫자만 입력하세요!");
				continue;
			}
			
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
				System.err.println("프로그램이 종료 되었습니다.");
				return;
			case 6:
				delete();
				break;
			default:
				System.err.println("메뉴에서만 고르세요");
				continue;
			}
		}
	}

	/**
	 * 가입
	 * @throws CustomException 
	 */
	private void join() throws CustomException {
		Person p = new Person();
		//중복체크
		while(true) {
		System.out.println("---가입 화면----");
		System.out.println("아이디, 비밀번호, 금액을 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			boolean idCheckResult = idCheck(inputId);//중복체크
			if(idCheckResult) {
				p.setId(inputId);
			}else {
				System.out.println();
				System.err.println("중복된 아이디 입니다.");
				System.out.println();
				continue;
			}
			System.out.print("비밀번호 입력 : ");
			p.setPass(sc.next());
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("금액 입력 : ");
				try {
					p.setVal(sc.nextInt()); 
				}catch (Exception e) {
					System.out.println();
					System.err.println("숫자만 입력 가능합니다.");
					System.out.println();
				continue;
				}
				break;
			}
			personList.add(p);
			
			System.out.println();
			System.err.println("가입 성공! 메뉴로 이동합니다.");
			return;
		}
	}
	
	/**
	 * 아이디 중복체크
	 * @param inputId
	 * @return 중복아이디 false
	 */
	private boolean idCheck(String inputId) {
		for (Person person : personList) {
			if(person.getId().contains(inputId)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 조회
	 */
	private void select() {
		while(true) {
			System.out.println("---조회 화면----");
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			System.out.print("비밀번호 입력 : ");
			String inputPass = sc.next();
			//id, pass 검증
			Integer index = loginCheck( inputId, inputPass);
			
			if("admin".equals(inputId) && "admin".equals(inputPass)) {
				System.out.println();
				System.out.println("------admin 전체 사용자 조회-------------");
				if(personList.size() > 0) {
					for (int i = 0; i < personList.size(); i++) {
						System.out.println((i+1)+". ID : " + personList.get(i).getId() +", PASS : " + personList.get(i).getPass() +", VAL : " + personList.get(i).getVal() );
					}
				}else {
					System.out.println(" ※조회 할 사용자가 없습니다.");
				}
				System.out.println("-----------------------------------");
				System.out.println();
				return;
			}else if(index != null) {
				System.out.println("*********************************");
				System.out.println(inputId + "님  비밀번호는 "+ inputPass +", 현재 잔액은 "+personList.get(index).getVal()+"원 입니다.");
				System.out.println("*********************************");
				return;
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원정보가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
	}
	
	/**
	 * 아이디, 비밀번호 체크
	 * @param inputId
	 * @param inputPass
	 * @return 해당 아이디의 index
	 */
	private Integer loginCheck(String inputId, String inputPass) {
		for (int j = 0; j < personList.size(); j++) {
			if(inputId.equals(personList.get(j).getId()) && inputPass.equals(personList.get(j).getPass())) {
				return j;
			}
		}
		return null;
	}

	/**
	 * 입금
	 */
	private void deposit() {
		while(true) {
			System.out.println("---입금 화면----");
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			System.out.print("비밀번호 입력 : ");
			//id, pass 검증
			String inputPass = sc.next();
			Integer index = loginCheck( inputId, inputPass);
			if(index != null) {
				int inputVal= 0;
				while(true) {
					Scanner sc = new Scanner(System.in);
					System.out.print("입금할 금액 입력 : ");
					try {
						inputVal = sc.nextInt(); 
					}catch (Exception e) {
						System.out.println();
						System.err.println("숫자만 입력 가능합니다.");
						System.out.println();
					continue;
					}
					break;
				}
				
				personList.get(index).setVal(personList.get(index).getVal()+inputVal);
				System.out.println("*********************************");
				System.out.println(inputId + "님 현재 잔액은 "+personList.get(index).getVal()+"원 입니다.");
				System.out.println("*********************************");
				return;
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원정보가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
	}

	/**
	 * 출금
	 */
	private void withdraw() {
		while(true) {
			System.out.println("---출금 화면----");
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			System.out.print("비밀번호 입력 : ");
			String inputPass = sc.next();
			//id, pass 검증
			Integer index = loginCheck( inputId, inputPass);
			if(index != null) {
				while(true) {
					int inputVal= 0;
					Scanner sc = new Scanner(System.in);
					System.out.print("출금할 금액 입력 : ");
					try {
						inputVal = sc.nextInt(); 
					}catch (Exception e) {
						System.out.println();
						System.err.println("숫자만 입력 가능합니다.");
						System.out.println();
						continue;
					}
				
					if(inputVal > personList.get(index).getVal()) {
						System.out.println("*********************************");
						System.out.println("현재 잔액보다 많습니다. 금액을 다시 입력하세요.");
						System.out.println("*********************************");
						continue;
					}else {
						personList.get(index).setVal(personList.get(index).getVal()-inputVal);
						System.out.println("*********************************");
						System.out.println(inputId + "님 현재 잔액은 "+personList.get(index).getVal()+"원 입니다.");
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
	
	/**
	 * 정보 삭제
	 */
	private void delete() {
		while(true) {
			System.out.println("---삭제 화면----");
			System.out.println("삭제할 아이디와 비밀번호를 입력하세요");
			System.out.print("아이디 입력 : ");
			String inputId = sc.next();
			System.out.print("비밀번호 입력 : ");
			String inputPass = sc.next();
			//id, pass 검증
			Integer index = loginCheck( inputId, inputPass);
			if(index != null) {
				System.out.println();
				System.out.println("==!=============================");
				System.out.println(" 아이디 "+personList.get(index).getId()+"이(가) 삭제 되었습니다.");
				System.out.println(" ( 잔액 "+personList.get(index).getVal()+"원 소멸 )");
				System.out.println("================================");
				System.out.println();
				
				personList.remove((int)index);

				return;
			}else {
				System.out.println("*********************************");
				System.out.println(" 회원번호가 일치하지 않습니다. 다시 입력하세요.");
				System.out.println("*********************************");
				continue;
			}
		}
	}
}
