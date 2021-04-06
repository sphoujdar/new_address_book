import new_address_book.AddressBook;
import new_address_book.AddressBookCsv;
import new_address_book.AddressBookMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddressBookTestFileIO {

    AddressBookMain runnerObject;
    AddressBookCsv csvRunnerObject;

    @Before
    public void setup(){
        runnerObject = new AddressBookMain();
    }
    
    @Test
    public void givenContacts_WriteThemToTxtFile_ReturnTrueIfCorrectlyRetrieved(){
        int countOfContacts = 0;
        runnerObject.readAddressBooksFromTxtFile();
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        Assert.assertEquals(18, countOfContacts);
    }

    @Test
    public void givenContactsInCsvFile_ReadThemFromFile_ReturnTrueIfCorrectlyRetrieved() throws IOException {
        int countOfContacts = 0;
        csvRunnerObject = new AddressBookCsv();
        csvRunnerObject.readAddressBooksFromCsv(runnerObject);
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        Assert.assertEquals(18, countOfContacts);
    }

    @Test
    public void givenContacts_WriteThemToCsvFile_ReturnTrueIfCorrectlyRetrieved() throws IOException {
        FileWriter fw = new FileWriter(AddressBookCsv.fileName, false);
        PrintWriter printWriter = new PrintWriter(fw, false);
        printWriter.flush();
        printWriter.close();
        fw.close();
        int countOfContacts = 0;
        csvRunnerObject = new AddressBookCsv();
        runnerObject.readAddressBooksFromTxtFile();
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        csvRunnerObject.writeAddressBooksToCsv(runnerObject);
        Assert.assertEquals(18, countOfContacts);
    }
}

//ADDRESS,CITY,EMAIL,FIRSTNAME,LASTNAME,PHONENUMBER,STATE,ZIPCODE
//        Paris Suburb,Paris,srpa.apshankar@gmail.com,Sagar,Apshankar,7508844433,France,778009
//        Kothrud,Pune,ms.phoujdar@gmail.com,Shubham,Phoujdar,8806615537,Maharashtra,411038
//        Kormangala,Bangalore,pb.singh@gmail.com,Prince,Singh,8888844444,Karnataka,800001
//        Kothrud,Pune,ms.phoujdar@gmail.com,Manisha,Phoujdar,8806615535,Maharashtra,411038
//        Vadgaon,Pune,pm.singh@gmail.com,Prince,Singh,8888855555,Maharashtra,400001
//        Kothrud,Pune,ms.phoujdar@gmail.com,Shivani,Phoujdar,8806615536,Maharashtra,411038
//        Andheri,Mumbai,pm.singh@gmail.com,Prince,Singh,8888855555,Maharashtra,400001
//        Kothrud,Mumbai,sm.phoujdar@gmail.com,Shubham,Phoujdar,8806615534,Maharashtra,411038
//        Kormangala,Bangalore,pb.singh@gmail.com,Prince,Singh,8888844444,Karnataka,800001
//        Mayur Colony,Pune,st.joshi@gmail.com,Satej,Joshi,8888844433,Maharashtra,440001
//        Karishma,Pune,st.Hardikar@gmail.com,Aditya,Hardikar,8288844433,Maharashtra,440001
//        Powai,Mumbai,st.joshi@gmail.com,Satej,Joshi,8888844433,Maharashtra,440001
//        College,Boston,st1.joshi@gmail.com,Satej,Joshi,1008844433,California,110110
//        IISC,Bangalore,st.Hardikar@gmail.com,Aditya,Hardikar,8288844433,Karnataka,440001
//        NYU,New York,st1.Hardikar@gmail.com,Aditya,Hardikar,1208844433,New York State,110110
//        Job,Pune,hp.phoujdar@gmail.com,Harsh,Phoujdar,3238844433,Maharashtra,330450
//        Job,Dublin,hp.phoujdar@gmail.com,Harsh,Phoujdar,3238844433,South Ireland,330450
//        Aundh,Pune,srpu.apshankar@gmail.com,Sagar,Apshankar,9658844433,Maharashtra,411038

//        Commented Code as it is may be needed later to add new contacts
//        Contact shubham1 = new Contact("Shubham", "Phoujdar", "Kothrud", "Mumbai",
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
