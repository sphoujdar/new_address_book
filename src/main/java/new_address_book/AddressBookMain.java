/*Query 1 - How can I use the displayContact() function 
			w/o having to make a blank object to access it?*/

/*Query 2 - Where and how exactly were interfaces supposed to 
			be used in this program?*/

/*Query 3 - How to enter String arguments in console with spaces 
			included? eg. "7 Suramya" as one single field.*/


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
		
		
		book1.modifyContact(sc, book1);
		book1.displayBook(book1);
		
		
		book1.deleteContact(sc, book1);
		book1.displayBook(book1);
		
		
	}
	
}
