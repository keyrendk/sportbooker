package com.example.sportbooker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // database
    private static final String DB_NAME = "sportbooker";
    private static final int DB_VERSION = 1;

    // users table
    private static final String USERS_TABLE = "users";
    private static final String COL_USERS_ID = "user_id";
    private static final String COL_USERS_NAME = "name";
    private static final String COL_USERS_GENDER = "gender";
    private static final String COL_USERS_EMAIL = "email";
    private static final String COL_USERS_PASSWORD = "password";

    // facilities table
    private static final String FACILITIES_TABLE = "facilities";
    private static final String COL_FACILITIES_ID = "facility_id";
    private static final String COL_FACILITIES_NAME = "facility_name";
    private static final String COL_FACILITIES_TYPE = "type";
    private static final String COL_FACILITIES_OPENING_HOUR = "opening_hour";
    private static final String COL_FACILITIES_CLOSING_HOUR = "closing_hour";
    private static final String COL_FACILITIES_PRICE = "price";

    // bookings table
    private static final String BOOKINGS_TABLE = "bookings";
    private static final String COL_BOOKINGS_ORDER_DATE = "order_date";
    private static final String COL_BOOKINGS_USE_DATE = "use_date";
    private static final String COL_BOOKINGS_START_TIME = "start_time";
    private static final String COL_BOOKINGS_FINISH_TIME = "finish_time";
    private static final String COL_BOOKINGS_PRICE = "price";
    private static final String COL_BOOKINGS_STATUS = "status";

    // schedules table
    private static final String SCHEDULES_TABLE = "schedules";
    private static final String COL_SCHEDULES_DATE = "date";
    private static final String COL_SCHEDULES_OPENING_HOUR = "opening_hour";
    private static final String COL_SCHEDULES_CLOSING_HOUR = "closing_hour";
    private static final String COL_SCHEDULES_PRICE = "price";

    // transactions table
    private static final String TRANSACTIONS_TABLE = "transactions";
    private static final String COL_TRANSACTIONS_BOOKING_DATE = "booking_date";
    private static final String COL_TRANSACTIONS_TIME = "time";
    private static final String COL_TRANSACTIONS_STATUS = "status";
    private static final String COL_TRANSACTIONS_AMOUNT = "amount";
    private static final String COL_TRANSACTIONS_METHOD = "method";

    // constructor DBHandler
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + USERS_TABLE + " (" +
                COL_USERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERS_NAME + " TEXT, " +
                COL_USERS_GENDER + " TEXT, " +
                COL_USERS_EMAIL + " TEXT, " +
                COL_USERS_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);

        String createFacilitiesTabel = "CREATE TABLE " + FACILITIES_TABLE + " (" +
                COL_FACILITIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FACILITIES_NAME + " TEXT, " +
                COL_FACILITIES_TYPE + " TEXT, " +
                COL_FACILITIES_OPENING_HOUR + " TEXT, " +
                COL_FACILITIES_CLOSING_HOUR + " TEXT, " +
                COL_FACILITIES_PRICE + " TEXT)";
        String insertFacility1 = "INSERT INTO " + FACILITIES_TABLE + " (" +
                COL_FACILITIES_ID + ", " +
                COL_FACILITIES_NAME + ", " +
                COL_FACILITIES_TYPE + ", " +
                COL_FACILITIES_OPENING_HOUR + ", " +
                COL_FACILITIES_CLOSING_HOUR + ", " +
                COL_FACILITIES_PRICE + ") VALUES ('F01', 'Footbal Field A', 'Inside', '08:00', '21:00', '50000')";
        db.execSQL(createFacilitiesTabel);
        db.execSQL(insertFacility1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }
}
