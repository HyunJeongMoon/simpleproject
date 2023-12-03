/*
 * 회원추가하기: InsertNewContact.java
 * 이름,전화번호,주소,구분 입력 받아서 HashMap contactsTable에 넣는다
 * member variable: String newName
 * 					String newAddress
 * 					String newGroup
 * member method:	void insertNew()
 * 					boolean isNumeric()
 *					String filterPhoneNumber() 
 */
package projectCMS.lib;
import java.util.HashMap;
import java.util.Scanner;
//=========================================================
public class InsertNewContact {
		private static String newName;
		private static String newAddress;
		private static String newPhoneNumber;
		private static String newGroup;
//----------------------------------------------------------		
		public void insertNew(HashMap<String, ContactValueObject> contactsTable, Scanner scan) {
			System.out.println("등록할 회원 정보를 입력하세요");
			newName = ContactValueObject.filterName(scan);
			newPhoneNumber=ContactValueObject.filterPhoneNumber(scan);
			if (ContactValueObject.isRedundantPhoneNumber(contactsTable,newPhoneNumber)) {
				System.out.println("입력 전화번호: "+ newPhoneNumber +"- 이미 있는 번호입니다");
				System.out.println("확인 후 다시 시도해 주세요");
				return;
			}
			else {
			System.out.print("주소: ");
			newAddress = scan.nextLine();
			System.out.print("구분(ex:가족,친구,기타): ");
			newGroup = scan.nextLine();
			contactsTable.put(newPhoneNumber, new ContactValueObject(newName,newPhoneNumber,newAddress,newGroup));
			} //else end
		} //insertNew () end
//------------------------------------------------------------
} //InsertNewContact class end