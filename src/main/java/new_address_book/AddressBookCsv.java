package new_address_book;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Iterator;


public class AddressBookCsv {
    public static final String fileName = "/home/phoujdar/eclipse-workspace/new_address_book/src/test/resources/contactFileCsv.csv";

    public void readAddressBooksFromCsv(AddressBookMain runnerObject) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName))) {
            CsvToBean<Contact> csvReader= new CsvToBeanBuilder<Contact>(reader)
                                            .withType(Contact.class)
                                            .withIgnoreLeadingWhiteSpace(true)
                                            .build();
            Iterator<Contact> csvContactIterator = csvReader.iterator();
            runnerObject.allAddressBooks.add(new AddressBook("Book1"));
            while (csvContactIterator.hasNext()) {
                Contact currentContact = csvContactIterator.next();
                runnerObject.allAddressBooks.get(0).addContactByPassingContact(currentContact);
            }
        }
    }

    public void writeAddressBooksToCsv(AddressBookMain runnerObject) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName))) {
            StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
                                                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                                                    .build();

            for (AddressBook currentAddressBook : runnerObject.allAddressBooks) {
                beanToCsv.write(currentAddressBook.arrayListOfContacts);
            }
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }




}


