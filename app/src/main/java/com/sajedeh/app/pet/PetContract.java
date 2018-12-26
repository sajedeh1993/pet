package com.sajedeh.app.pet;

import android.provider.BaseColumns;

class PetContract {
    public class PetEntity implements BaseColumns {
        public static final String TABLE_NAME = "pet";
        public static final String COLUMN_ID = _ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_PIC = "pic";


        public static final int GENDER_MALE = 0;
        public static final int GENDER_FAMALE = 1;
        public static final int GENDER_UNKNOWN = 2;


        public static final int PIC_CAT = 0;
        public static final int PIC_DOG = 1;
        public static final int PIC_MOUSE = 2;
    }
}