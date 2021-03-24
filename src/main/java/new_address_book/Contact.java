package new_address_book;

public class Contact {
	
	public String firstName, lastName, address, city, state, email;
	public int zipCode; 
	public long phoneNumber;

	public Contact(String firstName, String lastName, String address, String city,
				   String state, String email,
				   int zipCode, long phoneNumber) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}
	
	public void displayContact(Contact passedContact) {
		
		System.out.printf("First Name : %s\n",passedContact.firstName);
		System.out.printf("Last Name : %s\n",passedContact.lastName);
		System.out.printf("Address : %s\n",passedContact.address);
		System.out.printf("City : %s\n",passedContact.city);
		System.out.printf("State : %s\n",passedContact.state);
		System.out.printf("Email Address : %s\n",passedContact.email);
		System.out.printf("Zip Code : %d\n",passedContact.zipCode);
		System.out.printf("Phone Number : %d\n",passedContact.phoneNumber);
		
	}
	
	
}
