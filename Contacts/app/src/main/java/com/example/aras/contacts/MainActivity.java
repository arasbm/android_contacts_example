package com.example.aras.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        contactView = (ListView)findViewById(R.id.contactList);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Zooby", "1111"));
        db.addContact(new Contact("Bob", "2222"));
        db.addContact(new Contact("Alice", "3333"));
        db.addContact(new Contact("Jane", "4444"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        ContactsAdapter contactsAdapter = new ContactsAdapter(this, contacts);
        
        contactView.setAdapter(contactsAdapter);

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
