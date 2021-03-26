package new_address_book;

import java.util.Scanner;

public interface IAddressBook{

	void displayBook();
	void handleDuplicateContacts();
	void addContact (Scanner sc);
	void modifyContact (Scanner sc, AddressBook book1);
	void deleteContact (Scanner sc, AddressBook book1);
	
}
