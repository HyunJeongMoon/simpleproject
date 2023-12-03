/*
 * 연락처 관리 프로그램 ContactsManagementSystem:CMS
 * 1. 메뉴출력
 * 2. 메뉴 선택 입력: 1.회원 추가 2. 회원 목록 보기 3. 회원 정보 수정 4. 회원 삭제 5. 종료
 * 3. 5(종료)입력 하면 프로그램 종료
 */
package projectCMS.main;

import java.util.HashMap;
import java.util.Scanner;

import projectCMS.lib.CMSMenu;
import projectCMS.lib.ContactValueObject;
import projectCMS.lib.DeleteContacts;
import projectCMS.lib.EditContacts;
import projectCMS.lib.InsertNewContact;
import projectCMS.lib.ViewAllContacts;
//=======================================================
public class ContactsManagementSystem {
//-------------------------------------------------------
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String selectedMenu;
		HashMap <String, ContactValueObject> contactsTable = new HashMap<String, ContactValueObject>();
		
		while(true) {	
			selectedMenu = new CMSMenu().selectMenu(scan);
			if(selectedMenu.equals("5")) {
				System.out.println("종료되었습니다");
				scan.close();
				return;
			}else if(selectedMenu.equals("INVALID_INPUT")) {
				System.out.println("번호를 선택해 주세요.");
			}else if(selectedMenu.equals("1")) {
				new InsertNewContact().insertNew(contactsTable,scan);
			}else if(selectedMenu.equals("2")) {
				new ViewAllContacts().viewAllContacts(contactsTable);			
			}else if(selectedMenu.equals("3")) {
				new EditContacts().editContact(contactsTable,scan);
			}else if(selectedMenu.equals("4")) {
				new DeleteContacts().removeContact(contactsTable,scan);
			}
		}//while end
	}//main() end
//---------------------------------------------------------	
}//CMS Class end
