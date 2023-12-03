/*
 * 회원관리 메뉴 클래스: CMSMenu.java
 * showCMSMenu(): 회원관리메뉴 출력
 * selectMenu(): 1~5 선택한 번호 selectedMenuNumber 리턴, 이외의 입력은 "INVALID_INPUT" 리턴 
 */
package projectCMS.lib;

import java.util.Scanner;
//=====================================================
public class CMSMenu {
	
	private final String INVALID_INPUT = "INVALID_INPUT"; 
	private String selectedMenuNumber;
//-------------------------------------------------------	
	private void showCMSMenu() {
		System.out.println();
		System.out.println("====================");
		System.out.println(" 회원관리프로그램 ");
		System.out.println("====================");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 목록");
		System.out.println("3. 회원 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.print  ("번호 입력 : ");
	}//showCMSMenuNumber() end
//------------------------------------------------------	
	public String selectMenu(Scanner scan) {
		showCMSMenu();
		selectedMenuNumber = scan.nextLine();
		if (selectedMenuNumber.equals("5")){
			return selectedMenuNumber; 
		}else if (selectedMenuNumber.equals("4")){
			return selectedMenuNumber;
		}else if (selectedMenuNumber.equals("3")){
			return selectedMenuNumber;
		}else if (selectedMenuNumber.equals("2")){
			return selectedMenuNumber;
		}else if (selectedMenuNumber.equals("1")){
			return selectedMenuNumber;
		}else {
			return INVALID_INPUT;
		} //else end
	}//selectMenu() end
//-----------------------------------------------	
}//CMSMenu class end
