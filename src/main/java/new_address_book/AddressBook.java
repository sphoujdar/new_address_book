package new_address_book;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook  implements IAddressBook{
	
	String currentAddressBookName;
	ArrayList<Contact> currentAddressBook = new ArrayList<>();
	
	
	public AddressBook(String currentAddressBookName) {
		super();
		this.currentAddressBookName = currentAddressBookName;
	}
	

	public void displayBook(AddressBook passedAddressBook) {
		
		System.out.printf("\n\nAddress Book Name is %s. \n\n", passedAddressBook.currentAddressBookName);
		Contact blankContact = new Contact(null, null, null, null, null, null, 0, 0);
		
		System.out.println("\n\n----------------------------------------------------\n\n");
		for (int i = 0 ; i<passedAddressBook.currentAddressBook.size(); i++) {
			System.out.printf("Contact %d :\n",i+1);
			
			/*Query - How can I use the displayContact() function 
			w/o having to make a blank object to access it?*/
			
			blankContact.displayContact(passedAddressBook.currentAddressBook.get(i));
			
			System.out.println("\n\n----------------------------------------------------\n");
			
		}
		
	}

	public void handleDuplicateContacts() {

		int arraySize = this.currentAddressBook.size();
		ArrayList<String> contactListNames = new ArrayList<>(arraySize);
		ArrayList<Contact> contactListWithoutDuplicates = new ArrayList<>();

		for (Contact currentContact : this.currentAddressBook){
			if(!contactListNames.contains(currentContact.firstName+currentContact.lastName)){
				contactListWithoutDuplicates.add(currentContact);
				contactListNames.add(currentContact.firstName+currentContact.lastName);
			}else{
				System.out.printf("This duplicate Contact found in %s.\n\n" , this.currentAddressBookName);
				currentContact.displayContact(currentContact);
				System.out.println("Removing this duplicate Entry.\n\n");
			}
		}
		this.currentAddressBook = contactListWithoutDuplicates;

	}


	public Contact createContact (Scanner sc) {
		
		System.out.println("Please Enter First Name");
		String firstName = sc.next();
		System.out.println("Please Enter Last Name");
		String lastName = sc.next();
		System.out.println("Please Enter Address");
		String address = sc.next();
		System.out.println("Please Enter City");
		String city = sc.next();
		System.out.println("Please Enter State");
		String state = sc.next();
		System.out.println("Please Enter Zip Code");
		int zipCode = sc.nextInt();
		System.out.println("Please Enter Phone Number");
		long phoneNumber = sc.nextLong();
		System.out.println("Please Enter Email Address");
		String emailAddress = sc.next();

		return new Contact(firstName,lastName, address, city, state,
											 emailAddress, zipCode, phoneNumber);
		
	}
	
	
	public void addContact (Scanner sc) {
		
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("Enter Details of the new Contact you want to add -");
		
		Contact newContact = createContact(sc);
		
		this.currentAddressBook.add(newContact);	
		
	}
	
	
	public int findContact(Scanner sc) {
		
		System.out.println("\n\n----------------------------------------------------\n");
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("Please Enter First Name of Contact to find :");
		String fName = sc.next();
		
		System.out.println("Please Enter Last Name of Contact to find :");
		String lName = sc.next();
		
		for (int i = 0 ; i<currentAddressBook.size(); i++) {
			
			if(currentAddressBook.get(i).firstName.equals(fName)
			   && currentAddressBook.get(i).lastName.equals(lName)) {
				
				System.out.printf("\nContact is at [%d] position in %s.\n", 
						          i+1, this.currentAddressBookName);
				System.out.println("\n\n----------------------------------------------------\n");
				
				return i;
			}
		}
		
		System.out.println("\nContact not in Address Book.\n");
		System.out.println("\n\n----------------------------------------------------\n" +
				"");
		
		return -999;
	}
	
	
	public void modifyContact(Scanner sc, AddressBook book1) {
		
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("We will update contact now.");
		
		int index = book1.findContact(sc);
		if(index != -999) {
			System.out.println("Enter the updated Contact Details : ");

			Contact updatedContact = createContact(sc);
			book1.currentAddressBook.set(index, updatedContact);

			System.out.println("Contact Details have been updated.");
		}
	}
	
	
	public void deleteContact(Scanner sc, AddressBook book1) {
		
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("We will delete contact now.");
		
		int index = book1.findContact(sc);
		if(index != -999) {
			book1.currentAddressBook.remove(index);
			System.out.println("Contact has been deleted.");
		}
	}


	
	
}
