package com.escom.ipn.mx.sharedpreferences;

import android.provider.BaseColumns;

public final class DbContract {

    private DbContract() {
    }

    public static class ExampleEntry implements BaseColumns{
        public static final String TABLE_NAME = "example";
        public static final String COLUMN_NAME_ID= "id";
        public static final String COLUMN_NAME_NAME= "name";
    }


}
