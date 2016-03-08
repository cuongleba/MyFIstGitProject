package com.example.mrcuong.lab_9_contentprovider;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Browser;
import android.provider.ContactsContract;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri allContacts = Uri.parse("content://contacts/people");
//        Uri allContacts = Uri.parse("content://com.android.chrome.browser/bookmarks");

        Cursor cursor;
        CursorLoader cursorLoader = new CursorLoader(this, allContacts,
                null, null, null, null);
        cursor = cursorLoader.loadInBackground();

        String[] columns = new String[]{
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID
        };

        int[] views = new int[]{R.id.contact_name, R.id.contact_id};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, cursor,
                columns, views, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        this.setListAdapter(adapter);
    }
}
