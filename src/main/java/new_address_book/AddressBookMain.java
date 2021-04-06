/*Query - How to enter String arguments in console with spaces
		  included? eg. "7 Suramya" as one single field.
*/
package new_address_book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
	public ArrayList<AddressBook> allAddressBooks = new ArrayList<>();
	Map<String, ArrayList<Contact>> contactByCity = new HashMap<>();
	Map<String, ArrayList<Contact>> contactByState = new HashMap<>();
	static Integer count = 0;

	public static final File fileAsDatabase = new File("/home/phoujdar/eclipse-workspace/new_address_book/src/test/resources/contactFile.txt");

	public void displayStateDictionaries(){
		for (String StateKey : contactByState.keySet()){
			System.out.printf("Contacts in %s :\n",StateKey);
			for (Contact currentContact : contactByState.get(StateKey)){
				System.out.println(currentContact);
			}
		}
	}

	public void displayCityDictionaries(){
		for (String CityKey : contactByCity.keySet()){
			System.out.printf("Contacts in %s :\n",CityKey);
			for (Contact currentContact : contactByCity.get(CityKey)){
				System.out.println(currentContact);
			}
		}
	}

	public void printContactByCityOrState(Scanner sc) {
		ArrayList<Contact> contactListByCityOrState;
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

		if (choice == 1){
			contactListByCityOrState = (ArrayList<Contact>) allAddressBooks.stream()
					.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
					.filter(contact -> contact.getCity().equals(cityOrState))
					.collect(Collectors.toList());
		}else{
			contactListByCityOrState = (ArrayList<Contact>) allAddressBooks.stream()
					.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
					.filter(contact -> contact.getState().equals(cityOrState))
					.collect(Collectors.toList());
		}

		for (Contact currentContact : contactListByCityOrState) {
			currentContact.displayContact(currentContact);
		}
	}

	public void populateCityStateDictionaries(){
		//Is the space complexity too large?
		this.allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
				.forEach(contact -> {
							ArrayList<Contact> cityContacts;
							if(!contactByCity.containsKey(contact.getCity())){
								cityContacts = new ArrayList<>();
								System.out.println("hash Code" + cityContacts.hashCode());
							}else{
								cityContacts = contactByCity.get(contact.getCity());
							}
							cityContacts.add(contact);
							contactByCity.put(contact.getCity(), cityContacts);
						}
				);
		this.allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
				.forEach(contact -> {
							ArrayList<Contact> stateContacts;
							if(!contactByState.containsKey(contact.getState())){
								stateContacts = new ArrayList<>();
							}else{
								stateContacts = contactByState.get(contact.getState());
							}
							stateContacts.add(contact);
							contactByState.put(contact.getState(), stateContacts);
						}
				);
	}

	public void countContactByCityAndState() {

		HashMap<String, Integer> uniqueCityList = new HashMap<>();
		HashMap<String, Integer> uniqueStateList = new HashMap<>();
		allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
				.forEach(contact -> {
							if (!uniqueStateList.containsKey(contact.getState())) {
								uniqueStateList.put(contact.getState(), 1);
							} else {
								uniqueStateList.put(contact.getState(), uniqueStateList.get(contact.getState()) + 1);
							}
						}
				);
		allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.arrayListOfContacts.stream())
				.forEach(contact -> {
							if (!uniqueCityList.containsKey(contact.getCity())) {
								uniqueCityList.put(contact.getCity(), 1);
							} else {
								uniqueCityList.put(contact.getCity(), uniqueCityList.get(contact.getCity()) + 1);
							}
						}
				);
		System.out.println("City Scores -\n" + uniqueCityList.toString());
		System.out.println("State Scores -\n" + uniqueStateList.toString());
	}

	public void readAddressBooksFromTxtFile(){
		try(BufferedReader reader = new BufferedReader(new FileReader(AddressBookMain.fileAsDatabase))) {
			Contact person;
			AddressBook currentAddressBook;
			while(reader.readLine() != null) {
				person = new Contact();
				String currentAddressBookName = reader.readLine();
				if(this.allAddressBooks.size() == 0){
					person.setFirstName(reader.readLine());
					person.setLastName(reader.readLine());
					person.setAddress(reader.readLine());
					person.setCity(reader.readLine());
					person.setState(reader.readLine());
					person.setEmail(reader.readLine());
					person.setZipCode(Integer.parseInt(reader.readLine()));
					person.setPhoneNumber(Long.parseLong(reader.readLine()));
					reader.readLine();
					currentAddressBook = new AddressBook(currentAddressBookName);
					currentAddressBook.arrayListOfContacts.add(person);
					this.allAddressBooks.add(currentAddressBook);
				}else{
					for (AddressBook addressBookIterator: this.allAddressBooks) {
						if(addressBookIterator.currentAddressBookName.equals(currentAddressBookName)){
							currentAddressBook = addressBookIterator;
							person.setFirstName(reader.readLine());
							person.setLastName(reader.readLine());
							person.setAddress(reader.readLine());
							person.setCity(reader.readLine());
							person.setState(reader.readLine());
							person.setEmail(reader.readLine());
							person.setZipCode(Integer.parseInt(reader.readLine()));
							person.setPhoneNumber(Long.parseLong(reader.readLine()));
							reader.readLine();
							currentAddressBook.arrayListOfContacts.add(person);
						}
					}
				}
			}
		}
		catch ( IOException e) {
			System.out.println(e);
		}
	}

//Main

/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain runnerObject = new AddressBookMain();
		Contact shubham1 = new Contact("Shubham", "Phoujdar", "Kothrud", "Mumbai",
				"Maharashtra", "sm.phoujdar@gmail.com", 411038, 8806615534L);
		Contact manisha = new Contact("Manisha", "Phoujdar", "Kothrud", "Pune",
				"Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615535L);
		Contact shivani = new Contact("Shivani", "Phoujdar", "Kothrud", "Pune",
				"Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615536L);
		Contact shubham2 = new Contact("Shubham", "Phoujdar", "Kothrud", "Pune",
				"Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615537L);
		Contact prince0 = new Contact("Prince", "Singh", "Vadgaon", "Pune",
				"Maharashtra", "pm.singh@gmail.com", 400001, 8888855555L);
		Contact prince1 = new Contact("Prince", "Singh", "Andheri", "Mumbai",
				"Maharashtra", "pm.singh@gmail.com", 400001, 8888855555L);
		Contact prince2 = new Contact("Prince", "Singh", "Kormangala", "Bangalore",
				"Karnataka", "pb.singh@gmail.com", 800001, 8888844444L);
		Contact satej0 = new Contact("Satej", "Joshi", "Mayur Colony", "Pune",
				"Maharashtra", "st.joshi@gmail.com", 440001, 8888844433L);
		Contact satej1 = new Contact("Satej", "Joshi", "Powai", "Mumbai",
				"Maharashtra", "st.joshi@gmail.com", 440001, 8888844433L);
		Contact satej2 = new Contact("Satej", "Joshi", "College", "Boston",
				"California", "st1.joshi@gmail.com", 110110, 1008844433L);
		Contact aditya0 = new Contact("Aditya", "Hardikar", "Karishma", "Pune",
				"Maharashtra", "st.Hardikar@gmail.com", 440001, 8288844433L);
		Contact aditya1 = new Contact("Aditya", "Hardikar", "IISC", "Bangalore",
				"Karnataka", "st.Hardikar@gmail.com", 440001, 8288844433L);
		Contact aditya2 = new Contact("Aditya", "Hardikar", "NYU", "New York",
				"New York State", "st1.Hardikar@gmail.com", 110110, 1208844433L);
		Contact harsh0 = new Contact("Harsh", "Phoujdar", "Job", "Pune",
				"Maharashtra", "hp.phoujdar@gmail.com", 330450, 3238844433L);
		Contact harsh1 = new Contact("Harsh", "Phoujdar", "Job", "Dublin",
				"South Ireland", "hp.phoujdar@gmail.com", 330450, 3238844433L);
		Contact sagar0 = new Contact("Sagar", "Apshankar", "Aundh", "Pune",
				"Maharashtra", "srpu.apshankar@gmail.com", 411038, 9658844433L);
		Contact sagar1 = new Contact("Sagar", "Apshankar", "Paris Suburb", "Paris",
				"France", "srpa.apshankar@gmail.com", 778009, 7508844433L);
		AddressBook book1 = new AddressBook("Book1");
		AddressBook book2 = new AddressBook("Book2");
		AddressBook book3 = new AddressBook("Book2");
		runnerObject.allAddressBooks.add(book1);
		runnerObject.allAddressBooks.add(book2);
		runnerObject.allAddressBooks.add(book3);
		book1.addContactByPassingContact(shubham2);
		book1.addContactByPassingContact(prince2);
		book1.addContactByPassingContact(manisha);
		book1.addContactByPassingContact(prince0);
		book1.addContactByPassingContact(shivani);
		book1.addContactByPassingContact(prince1);
		book1.addContactByPassingContact(shubham1);
		book1.addContactByPassingContact(prince2);
		book1.addContactByPassingContact(satej0);
		book1.addContactByPassingContact(aditya0);
		book1.addContactByPassingContact(satej1);
		book1.addContactByPassingContact(satej2);
		book1.addContactByPassingContact(aditya1);
		book1.addContactByPassingContact(aditya2);
		book1.addContactByPassingContact(harsh0);
		book1.addContactByPassingContact(harsh1);
		book1.addContactByPassingContact(sagar0);
		book1.addContactByPassingContact(sagar1);

		sc.close();
	}
*/

}