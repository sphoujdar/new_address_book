/*Query - How to enter String arguments in console with spaces
		  included? eg. "7 Suramya" as one single field.
**Had to @Override equals() and hashCode() for the following to work with streams
		book1.handleDuplicateContacts();

		1. sortAddressBookByContactName, is use of streams really necessary?
		2. populateCityStateDictionaries, is space complexity too large?
		3. Compare override and comparator class usage for UC11 vs UC12
		   implementation, is use of streams really necessary?
*/
package new_address_book;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
	ArrayList<AddressBook> allAddressBooks = new ArrayList<>();
	Map<String, ArrayList<Contact>> contactByCity = new HashMap<>();
	Map<String, ArrayList<Contact>> contactByState = new HashMap<>();

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
		book1.currentAddressBook.add(shubham2);
		book1.currentAddressBook.add(prince2);
		book1.currentAddressBook.add(manisha);
		book1.currentAddressBook.add(prince0);
		book1.currentAddressBook.add(shivani);
		book1.currentAddressBook.add(prince1);
		book1.currentAddressBook.add(shubham1);
		book1.currentAddressBook.add(prince2);
		book1.currentAddressBook.add(satej0);
		book1.currentAddressBook.add(aditya0);
		book1.currentAddressBook.add(satej1);
		book1.currentAddressBook.add(satej2);
		book1.currentAddressBook.add(aditya1);
		book1.currentAddressBook.add(aditya2);
		book1.currentAddressBook.add(harsh0);
		book1.currentAddressBook.add(harsh1);
		book1.currentAddressBook.add(sagar0);
		book1.currentAddressBook.add(sagar1);

		book1.displayBook();
		book1.sortAddressBookByContactName();
		book1.displayBook();

		sc.close();
	}

	public void populateCityStateDictionaries(){
		//Is the space complexity too large?
		this.allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.currentAddressBook.stream())
				.forEach(contact -> {
						ArrayList<Contact> cityContacts;
						if(!contactByCity.containsKey(contact.city)){
							cityContacts = new ArrayList<Contact>();
							System.out.println("hash Code" + cityContacts.hashCode());
						}else{
							cityContacts = contactByCity.get(contact.city);
						}
						cityContacts.add(contact);
						contactByCity.put(contact.city, cityContacts);
						}
				);
		this.allAddressBooks.stream()
				.flatMap(addressBook -> addressBook.currentAddressBook.stream())
				.forEach(contact -> {
							ArrayList<Contact> stateContacts;
							if(!contactByState.containsKey(contact.state)){
								stateContacts = new ArrayList<Contact>();
							}else{
								stateContacts = contactByState.get(contact.state);
							}
							stateContacts.add(contact);
							contactByState.put(contact.state, stateContacts);
						}
				);
	}

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
		ArrayList<Contact> contactListByCityOrState = new ArrayList<>();
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
					.flatMap(addressBook -> addressBook.currentAddressBook.stream())
					.filter(contact -> contact.city.equals(cityOrState))
					.collect(Collectors.toList());
		}else{
			contactListByCityOrState = (ArrayList<Contact>) allAddressBooks.stream()
					.flatMap(addressBook -> addressBook.currentAddressBook.stream())
					.filter(contact -> contact.state.equals(cityOrState))
					.collect(Collectors.toList());
		}

		for (Contact currentContact : contactListByCityOrState) {
			currentContact.displayContact(currentContact);
		}
	}

	public void countContactByCityAndState() {

		HashMap<String, Integer> uniqueCityList = new HashMap<String, Integer>();
		HashMap<String, Integer> uniqueStateList = new HashMap<String, Integer>();
		allAddressBooks.stream()
						.flatMap(addressBook -> addressBook.currentAddressBook.stream())
						.forEach(contact -> {
											if (!uniqueStateList.containsKey(contact.state)) {
												uniqueStateList.put(contact.state, 1);
											} else {
												uniqueStateList.put(contact.state, uniqueStateList.get(contact.state) + 1);
											}
						}
						);
		allAddressBooks.stream()
						.flatMap(addressBook -> addressBook.currentAddressBook.stream())
						.forEach(contact -> {
											if (!uniqueCityList.containsKey(contact.city)) {
												uniqueCityList.put(contact.city, 1);
											} else {
												uniqueCityList.put(contact.city, uniqueCityList.get(contact.city) + 1);
											}
						}
						);
		System.out.println("City Scores -\n" + uniqueCityList.toString());
		System.out.println("State Scores -\n" + uniqueStateList.toString());
	}
}

