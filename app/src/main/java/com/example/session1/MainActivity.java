package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //declaring variable component to be used in this class
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting layout to activity_main from layout resource file
        setContentView(R.layout.activity_main);

        //locating listView in layout resource file
        listView = findViewById(R.id.listView);
        //set onclick listener to element selected from list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0){
                    //setting intent to open PostActivity activity
                    Intent intent = new Intent(MainActivity.this, PostActivity.class);
                    //start activity beginning the above intent
                    startActivity(intent);
                }
            }
        });

    }
}
