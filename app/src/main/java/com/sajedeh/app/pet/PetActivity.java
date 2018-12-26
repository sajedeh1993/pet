package com.sajedeh.app.pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class PetActivity extends AppCompatActivity {

    EditText nameEditText, ageEditText;
    Spinner genderSpinner;
    ImageView dogImageView, catImageView, mouseImageView;

    Pet pet;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        pet = new Pet();
        dbHelper = new DBHelper(this);


        nameEditText = findViewById(R.id.editText_name);
        ageEditText = findViewById(R.id.editText_age);
        genderSpinner = findViewById(R.id.spinner_gender);
        dogImageView = findViewById(R.id.imageView_dog);
        mouseImageView = findViewById(R.id.imageView_mouse);
        catImageView = findViewById(R.id.imageView_cat);


        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                pet.gender = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dogImageView.setOnClickListener(imageViewClickLisener);
        catImageView.setOnClickListener(imageViewClickLisener);
        mouseImageView.setOnClickListener(imageViewClickLisener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pet_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_save:
                Pet pet=getpet();
                dbHelper.insertPet(pet);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private Pet getpet() {

        pet.name = nameEditText.getText().toString();

        pet.age = Integer.parseInt(ageEditText.getText().toString());


        return pet;
    }

    private View.OnClickListener imageViewClickLisener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.imageView_cat:
                    pet.pic = PetContract.PetEntity.PIC_CAT;
                    Toast.makeText(PetActivity.this, "Cat Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageView_dog:
                    pet.pic = PetContract.PetEntity.PIC_DOG;
                    Toast.makeText(PetActivity.this, "Dog Selected", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.imageView_mouse:
                    pet.pic = PetContract.PetEntity.PIC_MOUSE;
                    Toast.makeText(PetActivity.this, "Mouse Selected", Toast.LENGTH_SHORT).show();

                    break;

            }

        }
    };
}
