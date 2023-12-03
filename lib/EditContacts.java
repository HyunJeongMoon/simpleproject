/*
 * 회원 정보 수정하기: EditContacts.java
 * 1) 회원 "이름" searchTerm 입력 받아서 같은 이름인 회원들을 검색한다
 * 2) 검색된 인원수를 일련번호로 회원정보와 함께 출력한다
 * 3) 수정하고자 하는 회원의 일련번호를 받아서 해당회원의 새로운 정보를 입력받는다
 * 4) 새로 입력받은 회원 정보를 회원정보 HashMap에 추가한다.
 * 
 * member method:	void editContact()
 * 					HashMap searchResult()
 * 					boolean isNumeric()
 *					String filterPhoneNumber()
 */
package projectCMS.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//===============================================================
public class EditContacts {
//---------------------------------------------------------------	
	public void editContact(HashMap<String, ContactValueObject> contactsTable, Scanner scan) {
	System.out.println("수정할 회원의 이름을 입력하세요");
	String searchTerm = ContactValueObject.filterName(scan);
	HashMap<String,ContactValueObject> tempTable = ContactValueObject.searchResult(contactsTable, searchTerm);
	if(tempTable.size()==0) {
		System.out.println("해당하는 회원 정보가 없습니다.");
	} else {
		Iterator<Map.Entry<String, ContactValueObject>> resultItr = tempTable.entrySet().iterator();
		System.out.println("\n총 "+tempTable.size()+"개의 목록이 검색되었습니다.");
		System.out.println("아래 목록중 수정할 회원의 번호를 입력하세요.");
		while(resultItr.hasNext()) {
			Map.Entry<String, ContactValueObject> tempEntry = resultItr.next();
			System.out.println(String.format("%s. 회원정보 : 이름 = %s, 전화번호 = %s, 주소 = %s, 구분 = %s"
			  	, tempEntry.getKey(),tempEntry.getValue().getName(), tempEntry.getValue().getPhoneNumber(), 
			  	tempEntry.getValue().getAddress(),tempEntry.getValue().getGroup()));	
		}
		String selectIndex;
		while(true){
			System.out.print("번호: ");
			selectIndex = scan.nextLine();
			if(selectIndex.isEmpty()) {
				System.out.println("번호를 선택해 주세요.");
				continue;
			}
			break;
		}//while end
		if(ContactValueObject.isNumeric(selectIndex)) {
			if ((Integer.parseInt(selectIndex)>=1) && (Integer.parseInt(selectIndex)<=tempTable.size())) {
					ContactValueObject selectedContact = tempTable.get(String.valueOf(selectIndex));
					System.out.println("수정할 회원 정보를 입력하세요");
					String newName = ContactValueObject.filterName(scan);
					String newPhoneNumber = ContactValueObject.filterPhoneNumber(scan);
					if (ContactValueObject.isRedundantPhoneNumber(contactsTable,newPhoneNumber)&
							!ContactValueObject.isRedundantPhoneNumber(tempTable,newPhoneNumber)) {
						System.out.println("입력 전화번호: "+ newPhoneNumber +"- 이미 있는 번호입니다");
						System.out.println("확인 후 다시 시도해 주세요");
						return;
					}
					else {
						System.out.print("주소: ");
						String newAddress = scan.nextLine();
						System.out.print("구분(ex:가족,친구, 기타): ");
						String newGroup = scan.nextLine();
						contactsTable.remove(selectedContact.getPhoneNumber());
						contactsTable.put(newPhoneNumber, new ContactValueObject(newName,newPhoneNumber,newAddress,newGroup));
						System.out.println("수정이 완료되었습니다.");
					}
				}
				else { 
						System.out.println("잘못된 입력입니다");
						System.out.println("확인 후 다시 시도해 주세요");
				}//else end
			}else {
				System.out.println("잘못된 입력입니다");
				System.out.println("확인 후 다시 시도해 주세요");
			}//else end
		}//else end
	}//editContact() end
//--------------------------------------------------------------------------	
} //EditContacts class end