/*
 * 회원목록보기: ViewAllContacts.java
 * HashMap contactsTable 받아서 모든 회원정보 출력
 * 	member method: vewAllContacts()
 */
package projectCMS.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//========================================================
public class ViewAllContacts {
//--------------------------------------------------------	
	public void viewAllContacts(HashMap<String, ContactValueObject> contactsTable) {
		Iterator<Map.Entry<String,ContactValueObject>> itr = contactsTable.entrySet().iterator();
		System.out.println("\n총 "+contactsTable.size()+"명의 회원이 저장되어 있습니다.");
		while(itr.hasNext()){
			Map.Entry<String, ContactValueObject> entry = itr.next();
			System.out.println(String.format("회원정보 : 이름 = %s, 전화번호 = %s, 주소 = %s, 구분 = %s",
							entry.getValue().getName(), entry.getValue().getPhoneNumber(), 
							entry.getValue().getAddress(),entry.getValue().getGroup()));
		}//while end
	}//viewAllContacts() end
//--------------------------------------------------------	
} // ViewAllContacts class end