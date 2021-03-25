/*Query 1 - How can I use the displayContact() function 
			w/o having to make a blank object to access it?*/

/*Query 2 - Where and how exactly were interfaces supposed to 
			be used in this program?*/

/*Query 3 - How to enter String arguments in console with spaces 
			included? eg. "7 Suramya" as one single field.*/

/*Various functionality available in program right now -
		AddressBook book2 = new AddressBook("Book2"); i.e Managing multiple books
		book1.addContact(sc);
		book1.modifyContact(sc, book1);
		book1.displayBook(book1);
		book1.deleteContact(sc, book1);
		book1.handleDuplicateContacts();
		book1.displayBook(book1);
*/


package new_address_book;

import java.util.*;

public class AddressBookMain {

	ArrayList<AddressBook> allAddressBooks = new ArrayList<>();
	Map<String,Contact> contactByCity = new HashMap<>();
	Map<String,Contact> contactByState = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook Program.");
		Scanner sc = new Scanner(System.in);

		Contact shubham1 = new Contact("Shubham", "Phoujdar", "Kothrud", "Mumbai", "Maharashtra",
				"sm.phoujdar@gmail.com", 411038, 8806615534L);
		Contact manisha = new Contact("Manisha", "Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615535L);
		Contact shivani = new Contact("Shivani", "Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615536L);
		Contact shubham2 = new Contact("Shubham", "Phoujdar", "Kothrud", "Pune", "Maharashtra",
				"ms.phoujdar@gmail.com", 411038, 8806615537L);
		Contact prince1 = new Contact("Prince", "Singh", "Andheri", "Mumbai", "Maharashtra",
				"pm.singh@gmail.com", 400001, 8888855555L);
		Contact prince2 = new Contact("Prince", "Singh", "Kormangala", "Bangalore", "Karnataka",
				"pb.singh@gmail.com", 800001, 8888844444L);

		AddressBook book1 = new AddressBook("Book1");
		AddressBook book2 = new AddressBook("Book2");

		AddressBookMain runnerObject = new AddressBookMain();
		runnerObject.allAddressBooks.add(book1);
		runnerObject.allAddressBooks.add(book2);

		book1.currentAddressBook.add(shubham2);
		book1.currentAddressBook.add(manisha);
		book1.currentAddressBook.add(shivani);
		book2.currentAddressBook.add(shubham1);
		book2.currentAddressBook.add(prince1);
		book2.currentAddressBook.add(prince2);

		//runnerObject.printContactByCityOrState(sc);

		runnerObject.populateCityStateDictionaries();

		sc.close();
	}

	public void populateCityStateDictionaries(){
		for (AddressBook book : this.allAddressBooks) {
			for (Contact currentContact : book.currentAddressBook) {
						this.contactByCity.put(currentContact.city,currentContact);
			}
		}

		for (Map.Entry mapElement : contactByCity.entrySet()) {
			String currentCity = mapElement.getKey().toString();
			Contact currentContact = (Contact) mapElement.getValue();
			System.out.printf("\nContact : %s %s  |  City : %s",currentContact.firstName,currentContact.lastName,currentCity );
		}

		for (AddressBook book : this.allAddressBooks) {
			for (Contact currentContact : book.currentAddressBook) {
				this.contactByState.put(currentContact.state,currentContact);
			}
		}

		for (Map.Entry mapElement : contactByState.entrySet()) {
			String currentState = mapElement.getKey().toString();
			Contact currentContact = (Contact) mapElement.getValue();
			System.out.printf("\nContact : %s %s  |  State : %s",currentContact.firstName,currentContact.lastName,currentState);
		}
	}


	public void printContactByCityOrState(Scanner sc) {
		ArrayList<Contact> contactListByCityOrState = new ArrayList<>();
		this.populateCityStateDictionaries();
		int choice;
		do {
			System.out.println("\nEnter Input : \n\n1. Search by City\n2. Search by State");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 2);

		if (choice == 1)
			System.out.println("Enter City to search Contacts in:");
		else
			System.out.println("Enter State to search Contacts in:");
		String cityOrState = sc.next();


		for (AddressBook book : this.allAddressBooks) {
			for (Contact currentContact : book.currentAddressBook) {
				if (choice == 1) {
					if (currentContact.city.equals(cityOrState)) {
						contactListByCityOrState.add(currentContact);
					}
				} else {
					if (currentContact.state.equals(cityOrState)) {
						contactListByCityOrState.add(currentContact);
					}
				}
			}
		}

		for (Contact currentContact : contactListByCityOrState) {
			currentContact.displayContact(currentContact);
		}
	}
}

