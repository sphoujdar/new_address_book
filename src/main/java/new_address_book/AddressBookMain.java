package new_address_book;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.printf("Welcome to AddressBook Program.\n\n");
		
		Scanner sc = new Scanner(System.in);
		
		AddressBook book1 = new AddressBook("Book1");
		book1.addContact(sc);
		book1.addContact(sc);
		
		book1.displayBook(book1);
		
		
		
	}
	
}
