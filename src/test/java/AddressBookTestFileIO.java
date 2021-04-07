import new_address_book.AddressBook;
import new_address_book.AddressBookCsv;
import new_address_book.AddressBookJSON;
import new_address_book.AddressBookMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddressBookTestFileIO {

    AddressBookMain runnerObject;
    AddressBookMain runnerObjectTwo;
    AddressBookCsv csvRunnerObject;
    AddressBookJSON jsonRunnerObject;

    @Before
    public void setup(){
        runnerObject = new AddressBookMain();
        runnerObjectTwo = new AddressBookMain();
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

    @Test
    public void givenContacts_WriteThemToJsonFile_ReturnTrueIfCorrectlyRetrieved() throws IOException {
        FileWriter fw = new FileWriter(AddressBookJSON.fileName, false);
        PrintWriter printWriter = new PrintWriter(fw, false);
        printWriter.flush();
        printWriter.close();
        fw.close();
        int countOfContacts = 0;
        runnerObject.readAddressBooksFromTxtFile();
        jsonRunnerObject = new AddressBookJSON();
        jsonRunnerObject.writeAddressBooksToJson(runnerObject);
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        Assert.assertEquals(18, countOfContacts);
    }

    @Test
    public void givenContactsInJsonFile_ReadThemFromFile_ReturnTrueIfCorrectlyRetrieved() throws IOException {
        int countOfContacts = 0;
        jsonRunnerObject = new AddressBookJSON();
        jsonRunnerObject.readAddressBooksFromJson(runnerObject);
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks){
            countOfContacts = currentAddressBook.countContactsInBook();
        }
        Assert.assertEquals(18, countOfContacts);
    }
}