package com.example.readcontentproviderdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity
{
    Button readContact;
    ListView viewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readContact=findViewById(R.id.readdatabtn);
        viewContacts=findViewById(R.id.listview);

        readContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllContacts();
            }
        });

    }

    void getAllContacts()
    {
        Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        String[] data={ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

        int[] id={android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,data,id);
        viewContacts.setAdapter(simpleCursorAdapter);
    }
}