package com.sajedeh.app.pet;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PetAdapter extends CursorAdapter {
    public PetAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(R.layout.pet_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(PetContract.PetEntity.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(PetContract.PetEntity.COLUMN_AGE));
        int pic = cursor.getInt(cursor.getColumnIndex(PetContract.PetEntity.COLUMN_PIC));

        TextView nameTextView = view.findViewById(R.id.name);
        nameTextView.setText(name);

        TextView ageTextView = view.findViewById(R.id.age);
        ageTextView.setText(Integer.toString(age));

        ImageView picImageView = view.findViewById(R.id.picture);

        switch (pic) {
            case PetContract.PetEntity.PIC_CAT:
                picImageView.setImageResource(R.drawable.ic_cat);
                break;
            case PetContract.PetEntity.PIC_DOG:
                picImageView.setImageResource(R.drawable.ic_dog);
                break;
            case PetContract.PetEntity.PIC_MOUSE:
                picImageView.setImageResource(R.drawable.ic_mouse);
                break;
        }

    }
}
