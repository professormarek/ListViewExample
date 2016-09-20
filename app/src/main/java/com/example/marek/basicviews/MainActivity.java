package com.example.marek.basicviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    create an OnItemClickListener object and override its onItemClick method
    (much like the anonymous class example shown earlier)
     */
    private AdapterView.OnItemClickListener myMessageClickHandler = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //get data from the view that was clicked
            String data = parent.getItemAtPosition(position).toString();
            //show a toast for now.. or do whatever!
            Toast.makeText(view.getContext(), data, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //let's create some data in an array note: this could come from a file, database, the web.. whatever
        String[] data = new String[] {"Chicken", "Pizza", "Hamburger"};
        /*
        create an ArrayAdapter for Strings
        the constructor for ArrayAdaptor requires a "sample list item" layout
        make sure you have created one in res/layout
        (Context, sample_layout_id, array)
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, data);
        //get a reference to the ListView we created (activity_main.xml)
        ListView listView = (ListView) findViewById(R.id.listView);

        //set the adapter for the listView to be our array adapter
        listView.setAdapter(adapter);

        //tell the listview to use the listener we created above
        listView.setOnItemClickListener(myMessageClickHandler);


    }
}
