package new_address_book;
import java.util.Objects;

public class Contact {
	private String firstName, lastName, address, city, state, email;
	private int zipCode;
	private long phoneNumber;

	public Contact() {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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
}
