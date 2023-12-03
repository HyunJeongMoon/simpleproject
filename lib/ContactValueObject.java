/*
 * 회원정보 저장을 위한 클래스: ContactValueObject.java
 * 변수: name address phoneNumber group
 * 메소드: 생성자
 * 		getName, setName,getAddress,setAddress, getPhoneNumber,getGroup,setGroup
 * 
 * 
 */
package projectCMS.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//================================================================
public class ContactValueObject {
	private String name;
	private String address;
	private String phoneNumber;
	private String group;
//---------------------------------------------------------------	
	public ContactValueObject(String name, String phoneNumber, String address, String group) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.group = group;
	}
//----------------------------------------------------------------	
	public void setName(String name) {
		this.name = name;
	}
//----------------------------------------------------------------	
	public String getName() {
		return name;
	}
//----------------------------------------------------------------	
	public void setAddress(String address) {
		this.address = address;
	}
//----------------------------------------------------------------	
	public String getAddress() {
		return address;
	}
//----------------------------------------------------------------	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//----------------------------------------------------------------	
	public String getPhoneNumber() {
		return phoneNumber;
	}
//----------------------------------------------------------------	
	public void setGroup(String group) {
		this.group = group;
	}
//----------------------------------------------------------------	
	public String getGroup() {
		return group;
	}
//----------------------------------------------------------------	
	@Override
	public String toString() {
		return  "[이름=" + name + ", 주소=" + address + ", 전화번호=" + phoneNumber + ", 그룹=" + group
				+ "]";
	}
//--------숫자인가?-------------------------------------------	
	public static boolean isNumeric(String input) {
	    try {
	        Double.parseDouble(input);
	        return true;
	    }
	    catch (NumberFormatException e) {
	        return false;
	    }
	}
//--------전화번호는 숫자만 허용, 숫자 아니면 숫자 넣을때 까지 반복--------------	
	public static String filterPhoneNumber(Scanner scan) {
		System.out.print("전화번호(ex:01012345678): ");
		String newPhoneNumber = scan.nextLine();
		while(!(isNumeric(newPhoneNumber))){
			System.out.println("전화번호는 숫자로 입력해 주세요. 다시 입력하세요.");
			System.out.print("전화번호(ex:01012345678): ");
			newPhoneNumber = scan.nextLine();
		}
		return newPhoneNumber;
	}
//---------이름은 공백 입력 안됨------------------------------------------	
	public static String filterName(Scanner scan) {
		String newName;
		while(true){
			System.out.print("이름: ");
			newName = scan.nextLine();
			if(newName.isEmpty()) {
				System.out.println("이름은 1자 이상 입력해 주세요. 다시 입력하세요.");
				continue;
			}
			break;
		}
		return newName;
	}
//---------HashMap에 이미 있는 전화번호인가?--------------------------------
	public static boolean isRedundantPhoneNumber(HashMap<String, ContactValueObject> contactsTable, String newPhoneNumber) {
		Iterator<Map.Entry<String,ContactValueObject>> itr = contactsTable.entrySet().iterator();
		boolean isRedundant = false;
		while(itr.hasNext()){
			Map.Entry<String, ContactValueObject> entry = itr.next();
			if (entry.getValue().getPhoneNumber().equals(newPhoneNumber)) {
				isRedundant = true;
				break;
			}
			else {
				isRedundant = false;
			}
  		} 
		return isRedundant;
	}
//------HashMap에서 문자열 검색해서 검색결과를 새 HashMap으로 만들어 보냄-------------
public static HashMap<String,ContactValueObject> searchResult(HashMap<String, ContactValueObject> contactsTable, String searchTerm){
		HashMap<String,ContactValueObject> tempTable = new HashMap<String,ContactValueObject>();
		Iterator<Map.Entry<String,ContactValueObject>> itr = contactsTable.entrySet().iterator();
		int count=0;		
		while(itr.hasNext()){
		  Map.Entry<String, ContactValueObject> entry = itr.next();
		  if (entry.getValue().getName().equals(searchTerm)) {
			  ++count;
			  tempTable.put(String.valueOf(count), entry.getValue());
		  }
  		} 
		return tempTable;
	}
//---------------------------------------------------------------------	
} //ContactValueObject class end