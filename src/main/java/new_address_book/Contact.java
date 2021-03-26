package new_address_book;
import java.util.Objects;

public class Contact {
	public String firstName, lastName, address, city, state, email;
	public int zipCode; 
	public long phoneNumber;

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(!(obj instanceof Contact))
			return false;
		Contact currentContact = (Contact) obj;
		return firstName.equals(currentContact.firstName)&&lastName.equals(currentContact.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName+lastName);
	}

	@Override
	public String toString() {
		System.out.println("-------------------------------------------------------");
		System.out.printf("First Name : %s\n",this.firstName);
		System.out.printf("Last Name : %s\n",this.lastName);
		System.out.printf("Address : %s\n",this.address);
		System.out.printf("City : %s\n",this.city);
		System.out.printf("State : %s\n",this.state);
		System.out.printf("Email Address : %s\n",this.email);
		System.out.printf("Zip Code : %d\n",this.zipCode);
		System.out.printf("Phone Number : %d\n",this.phoneNumber);
		System.out.println("-------------------------------------------------------");
		return "\n";
	}

	public Contact(String firstName, String lastName, String address, String city,
				   String state, String email,
				   int zipCode, long phoneNumber) {
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
