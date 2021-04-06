package new_address_book;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook  implements IAddressBook{
	
	String currentAddressBookName;
	public List<Contact> currentAddressBook = new ArrayList<>();

	public AddressBook() {
	}
	public AddressBook(String currentAddressBookName) {
		super();
		this.currentAddressBookName = currentAddressBookName;
	}

	public List<Contact> getCurrentAddressBook() {
		return currentAddressBook;
	}

	public void displayBook() {
		System.out.printf("\n\nAddress Book Name is %s. \n\n", this.currentAddressBookName);
		Contact blankContact = new Contact(null, null, null, null, null, null, 0, 0);
		System.out.println("\n\n----------------------------------------------------\n\n");
		for (int i = 0 ; i<this.currentAddressBook.size(); i++) {
			System.out.printf("Contact %d :\n",i+1);
			blankContact.displayContact(this.currentAddressBook.get(i));
			System.out.println("\n\n----------------------------------------------------\n");
		}
	}

	public int countContactsInBook() {
		return this.currentAddressBook.size();
	}

	public void handleDuplicateContacts() {
		int arraySize = this.currentAddressBook.size();
		ArrayList<String> contactListNames = new ArrayList<>(arraySize);
		List<Contact> contactListWithoutDuplicates = new ArrayList<>();

		System.out.println("***********************************Before Removing Duplicates***********************************");
		this.displayBook();
		contactListWithoutDuplicates = this.currentAddressBook.stream()
									   .distinct()
									   .collect(Collectors.toList());
		this.currentAddressBook = contactListWithoutDuplicates;
		System.out.println("***********************************After Removing Duplicates***********************************");
		this.displayBook();
	}
	
	public void addContactByUserInput(Scanner sc) {
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("Enter Details of the new Contact you want to add - ");
		Contact newContact = createContact(sc);
		this.currentAddressBook.add(newContact);
		addToFile(newContact);
	}

	public void addContactByPassingContact(Contact contactToAdd) {
		this.currentAddressBook.add(contactToAdd);
		addToFile(contactToAdd);
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
	
	public int findContact(Scanner sc) {
		
		System.out.println("\n\n----------------------------------------------------\n");
		System.out.printf("You are in %s :\n",this.currentAddressBookName);
		System.out.println("Please Enter First Name of Contact to find :");
		String fName = sc.next();
		
		System.out.println("Please Enter Last Name of Contact to find :");
		String lName = sc.next();
		
		for (int i = 0 ; i<currentAddressBook.size(); i++) {
			
			if(currentAddressBook.get(i).getFirstName().equals(fName)
			   && currentAddressBook.get(i).getLastName().equals(lName)) {
				
				System.out.printf("\nContact is at [%d] position in %s.\n", 
						          i+1, this.currentAddressBookName);
				System.out.println("\n\n----------------------------------------------------\n");
				
				return i;
			}
		}
		
		System.out.println("\nContact not in Address Book.\n");
		System.out.println("\n\n----------------------------------------------------\n");
		
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

	public void sortAddressBookByContactName(){
		Comparator<Contact> fullNameComparator = new Comparator<Contact>() {
			@Override
			public int compare(Contact contact, Contact t1) {
				String contactFullName = contact.getFirstName()+contact.getLastName();
				String t1FullName = t1.getFirstName()+t1.getLastName();
				return contactFullName.compareTo(t1FullName);
			}
		};
		ArrayList<Contact> sortedAddressBook = new ArrayList<>(this.currentAddressBook.size());
		sortedAddressBook = (ArrayList<Contact>) this.currentAddressBook.stream()
																		.sorted(fullNameComparator)
																		.collect(Collectors.toList());
		this.currentAddressBook = sortedAddressBook;
	}

	public void sortAddressBookByContactCity(){
		Comparator<Contact> cityComparator = new Comparator<Contact>() {
			@Override
			public int compare(Contact contact, Contact t1) {
				return contact.getCity().compareTo(t1.getCity());
			}
		};
		ArrayList<Contact> sortedAddressBook = new ArrayList<>(this.currentAddressBook.size());
		sortedAddressBook = (ArrayList<Contact>) this.currentAddressBook.stream()
				.sorted(cityComparator)
				.collect(Collectors.toList());
		this.currentAddressBook = sortedAddressBook;
	}

	public void sortAddressBookByContactState(){
		Comparator<Contact> stateComparator = new Comparator<Contact>() {
			@Override
			public int compare(Contact contact, Contact t1) {
				return contact.getState().compareTo(t1.getState());
			}
		};
		ArrayList<Contact> sortedAddressBook = new ArrayList<>(this.currentAddressBook.size());
		sortedAddressBook = (ArrayList<Contact>) this.currentAddressBook.stream()
				.sorted(stateComparator)
				.collect(Collectors.toList());
		this.currentAddressBook = sortedAddressBook;
	}

	public void sortAddressBookByContactZipCode(){
		Comparator<Contact> zipCodeComparator = new Comparator<Contact>() {
			@Override
			public int compare(Contact contact, Contact t1) {
				return contact.getZipCode()- t1.getZipCode();
			}
		};
		ArrayList<Contact> sortedAddressBook = new ArrayList<>(this.currentAddressBook.size());
		sortedAddressBook = (ArrayList<Contact>) this.currentAddressBook.stream()
				.sorted(zipCodeComparator)
				.collect(Collectors.toList());
		this.currentAddressBook = sortedAddressBook;
	}

	private void addToFile(Contact person) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(AddressBookMain.fileAsDatabase , true))) {
			writer.write("+++++\n" +
					this.currentAddressBookName + "\n"
					+ person.getFirstName() + "\n"
					+ person.getLastName() + "\n"
					+ person.getAddress() + "\n"
					+ person.getCity() + "\n"
					+ person.getState() + "\n"
					+ person.getEmail() + "\n"
					+ person.getZipCode() + "\n"
					+ person.getPhoneNumber() + "\n"
					+ "-----\n");
		} catch(IOException e) {
			System.out.println(e);
		}
	}

}
