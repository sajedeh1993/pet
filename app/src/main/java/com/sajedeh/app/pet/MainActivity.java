package com.sajedeh.app.pet;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView PetListView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PetListView=findViewById(R.id.listView);

        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,PetActivity.class);
                startActivity(intent);
            }
        });

        PetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor= (Cursor) adapterView.getItemAtPosition(i);
                int id=cursor.getInt(cursor.getColumnIndex(PetContract.PetEntity.COLUMN_ID));
                Intent intent=new Intent(MainActivity.this,PetActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    private void loadPets(){
        DBHelper dbHelper=new DBHelper(this);
        PetAdapter adapter=new PetAdapter(this,dbHelper.getAll());
        PetListView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPets();
    }


}
