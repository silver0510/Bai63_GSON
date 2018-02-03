package com.example.sinki.bai63_gson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sinki.model.Contact;
import com.example.sinki.model.GData;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<Contact>dsContact;
    ArrayAdapter<Contact>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        dsContact = new ArrayList<>();
        adapter = new ArrayAdapter<Contact>(MainActivity.this,android.R.layout.simple_list_item_1,dsContact);
        lvContact.setAdapter(adapter);

        ContactTask task = new ContactTask();
        task.execute();
    }

    private class ContactTask extends AsyncTask<Void,Void,ArrayList<Contact>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            adapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<Contact> contacts) {
            super.onPostExecute(contacts);
            adapter.clear();
            adapter.addAll(contacts);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected ArrayList<Contact> doInBackground(Void... params) {
            ArrayList<Contact>ds = new ArrayList<>();
            GData data = null;
            try
            {
                String link = "https://api.androidhive.info/contacts/";
                URL url = new URL(link);
                InputStreamReader reader = new InputStreamReader(url.openStream(),"UTF-8");
                data = new Gson().fromJson(reader,GData.class);
                ds = data.getContacts();
            }
            catch (Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return ds;
        }
    }
}
