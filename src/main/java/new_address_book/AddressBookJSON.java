package new_address_book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddressBookJSON {

    public static final String fileName = "/home/phoujdar/eclipse-workspace/new_address_book/src/test/resources/contactFileJson.json";

    public void readAddressBooksFromJson(AddressBookMain runnerObject) throws IOException {
        Gson gson = new GsonBuilder().create();
        JsonReader jsonReader = new JsonReader(new FileReader("/home/phoujdar/eclipse-workspace/new_address_book/src/test/resources/contactFileJson.json"));
        Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
        List<Contact> userListFromJsonFile = gson.fromJson(jsonReader,contactListType);
        runnerObject.allAddressBooks.add(new AddressBook("Book1"));
        runnerObject.allAddressBooks.get(0).arrayListOfContacts = userListFromJsonFile;
        jsonReader.close();
    }

    public void writeAddressBooksToJson(AddressBookMain runnerObject) throws IOException {
        Gson gson = new GsonBuilder().create();
        FileWriter fileWriter = new FileWriter("/home/phoujdar/eclipse-workspace/new_address_book/src/test/resources/contactFileJson.json");
        for (AddressBook currentAddressBook : runnerObject.allAddressBooks) {
            List<Contact> userListFromArrayList = currentAddressBook.arrayListOfContacts;
            gson.toJson(userListFromArrayList,fileWriter);
            fileWriter.flush();
        }
        fileWriter.close();
    }
}
