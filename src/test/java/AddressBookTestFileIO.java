import new_address_book.AddressBook;
import new_address_book.AddressBookMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTestFileIO {

    AddressBookMain runnerObject;

    @Before
    public void setup(){
        runnerObject = new AddressBookMain();
        runnerObject.readAddressBooksFromFile();
    }
    
    @Test
    public void given3Contacts_WriteThemToFile_ReturnTrueIfCorrectlyRetrieved(){
        int countOfContacts = 0;
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        Assert.assertEquals(18, countOfContacts);
    }
}


//    Contact shubham1 = new Contact("Shubham", "Phoujdar", "Kothrud", "Mumbai",
//                "Maharashtra", "sm.phoujdar@gmail.com", 411038, 8806615534L);
//        Contact manisha = new Contact("Manisha", "Phoujdar", "Kothrud", "Pune",
//                "Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615535L);
//        Contact shivani = new Contact("Shivani", "Phoujdar", "Kothrud", "Pune",
//                "Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615536L);
//        Contact shubham2 = new Contact("Shubham", "Phoujdar", "Kothrud", "Pune",
//                "Maharashtra", "ms.phoujdar@gmail.com", 411038, 8806615537L);
//        Contact prince0 = new Contact("Prince", "Singh", "Vadgaon", "Pune",
//                "Maharashtra", "pm.singh@gmail.com", 400001, 8888855555L);
//        Contact prince1 = new Contact("Prince", "Singh", "Andheri", "Mumbai",
//                "Maharashtra", "pm.singh@gmail.com", 400001, 8888855555L);
//        Contact prince2 = new Contact("Prince", "Singh", "Kormangala", "Bangalore",
//                "Karnataka", "pb.singh@gmail.com", 800001, 8888844444L);
//        Contact satej0 = new Contact("Satej", "Joshi", "Mayur Colony", "Pune",
//                "Maharashtra", "st.joshi@gmail.com", 440001, 8888844433L);
//        Contact satej1 = new Contact("Satej", "Joshi", "Powai", "Mumbai",
//                "Maharashtra", "st.joshi@gmail.com", 440001, 8888844433L);
//        Contact satej2 = new Contact("Satej", "Joshi", "College", "Boston",
//                "California", "st1.joshi@gmail.com", 110110, 1008844433L);
//        Contact aditya0 = new Contact("Aditya", "Hardikar", "Karishma", "Pune",
//                "Maharashtra", "st.Hardikar@gmail.com", 440001, 8288844433L);
//        Contact aditya1 = new Contact("Aditya", "Hardikar", "IISC", "Bangalore",
//                "Karnataka", "st.Hardikar@gmail.com", 440001, 8288844433L);
//        Contact aditya2 = new Contact("Aditya", "Hardikar", "NYU", "New York",
//                "New York State", "st1.Hardikar@gmail.com", 110110, 1208844433L);
//        Contact harsh0 = new Contact("Harsh", "Phoujdar", "Job", "Pune",
//                "Maharashtra", "hp.phoujdar@gmail.com", 330450, 3238844433L);
//        Contact harsh1 = new Contact("Harsh", "Phoujdar", "Job", "Dublin",
//                "South Ireland", "hp.phoujdar@gmail.com", 330450, 3238844433L);
//        Contact sagar0 = new Contact("Sagar", "Apshankar", "Aundh", "Pune",
//                "Maharashtra", "srpu.apshankar@gmail.com", 411038, 9658844433L);
//        Contact sagar1 = new Contact("Sagar", "Apshankar", "Paris Suburb", "Paris",
//                "France", "srpa.apshankar@gmail.com", 778009, 7508844433L);
//        AddressBook book1 = new AddressBook("Book1");
//        AddressBook book2 = new AddressBook("Book2");
//        AddressBook book3 = new AddressBook("Book2");
//        runnerObject.allAddressBooks.add(book1);
//        runnerObject.allAddressBooks.add(book2);
//        runnerObject.allAddressBooks.add(book3);
//        book1.addContactByPassingContact(shubham2);
//        book1.addContactByPassingContact(prince2);
//        book1.addContactByPassingContact(manisha);
//        book1.addContactByPassingContact(prince0);
//        book1.addContactByPassingContact(shivani);
//        book1.addContactByPassingContact(prince1);
//        book1.addContactByPassingContact(shubham1);
//        book1.addContactByPassingContact(prince2);
//        book1.addContactByPassingContact(satej0);
//        book1.addContactByPassingContact(aditya0);
//        book1.addContactByPassingContact(satej1);
//        book1.addContactByPassingContact(satej2);
//        book1.addContactByPassingContact(aditya1);
//        book1.addContactByPassingContact(aditya2);
//        book1.addContactByPassingContact(harsh0);
//        book1.addContactByPassingContact(harsh1);
//        book1.addContactByPassingContact(sagar0);
//        book1.addContactByPassingContact(sagar1);