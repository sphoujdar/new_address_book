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
		System.out.println("Welcome to AddressBook Program.");
		
		Scanner sc = new Scanner(System.in);

		/*Various functionality available in program right now -
		AddressBook book2 = new AddressBook("Book2"); i.e Managing multiple books
		book1.addContact(sc);
		book1.modifyContact(sc, book1);
		book1.displayBook(book1);
		book1.deleteContact(sc, book1);
		*/

		Contact shubham1 = new Contact("Shubham","Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"sm.phoujdar@gmail.com", 411038, 8806615534L);
		Contact manisha = new Contact("Manisha","Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615535L);
		Contact shivani = new Contact("Shivani","Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615536L);
		Contact shubham2 = new Contact("Shubham","Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615537L);

		AddressBook book1 = new AddressBook("Book1");
		book1.currentAddressBook.add(shubham2);
		book1.currentAddressBook.add(manisha);
		book1.currentAddressBook.add(shivani);
		book1.currentAddressBook.add(shubham1);
		book1.currentAddressBook.add(shubham1);
		book1.displayBook(book1);

		book1.handleDuplicateContacts();
		book1.displayBook(book1);
		

		
		sc.close();
		
	}
	
}
