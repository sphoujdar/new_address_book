package new_address_book;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	
	String currentAddressBookName;
	ArrayList<Contact> currentAddressBook = new ArrayList<Contact>();
	
	
	public AddressBook(String currentAddressBookName) {
		super();
		this.currentAddressBookName = currentAddressBookName;
	}
	

	public void addContact (Scanner sc) {
		System.out.println("Enter Details of Contact you want to add -");
		
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
		
		
		Contact currentContact = new Contact(firstName,lastName, address, city, state, 
											 emailAddress, zipCode, phoneNumber);
		this.currentAddressBook.add(currentContact);	
		
	}
	
	
	
	
	public void displayBook(AddressBook passedAddressBook) {
		
		System.out.printf("Address Book Name is %s. \n\n", passedAddressBook.currentAddressBookName);
		Contact blankContact = new Contact(null, null, null, null, null, null, 0, 0);
		
		System.out.printf("\n\n----------------------------------------------------\n\n");
		for (int i = 0 ; i<passedAddressBook.currentAddressBook.size(); i++) {
			System.out.printf("Contact %d :\n",i+1);
			
			//How can use the following function w/o having to make a blank object to access it?
			blankContact.displayContact(passedAddressBook.currentAddressBook.get(i));
			
			System.out.printf("\n\n----------------------------------------------------\n\n");
			
		}
		
	}
	
	/*
	public AddressBook addNewAddressBook(Scanner sc) {
		
		System.out.println("Enter Name of the new Address Book-");
		String addressBookName = sc.next();
		
		System.out.println("How many contacts do you want to add to start with?");
		int numberOfContactsToAdd = sc.nextInt();
		
		AddressBook currentAddressBook = new AddressBook(addressBookName);
		
		for (int i = 0; i < numberOfContactsToAdd; i++) {
			
			 currentAddressBook.addContact(sc);
	
		}
		
	}*/

	
	
}
