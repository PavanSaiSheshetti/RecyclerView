package com.example.ignis;

public class Records {

    public static final String DATABASE_NAME = "DETAILS_DB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "DETAILS_TABLE";

    public static final String COL_ID = "ID";
    public static final String COL1 = "Vehicle_Name";
    public static final String COL2 = "Vehicle_Number";
    public static final String COL3 = "Date_of_pickup";
    public static final String COL4 = "Odometer";
    public static final String COL5 = "Additional_Problems";
    public static final String COL6 = "Fuel_Reading";
    public static final String COL7 = "Fuel_type";
    public static final String COL8 = "Belongings_in_car";
    public static final String COL9 = "Dents/Scratches";
    public static final String COL10 = "Estimate";
    public static final String COL11 = "Front_Image";
    public static final String COL12 = "Rear_Image";
    public static final String COL13 = "RtSide_Image";
    public static final String COL14 = "LtSide_Image";
    public static final String COL15 = "odofuel_Image";
    public static final String COL16 = "Shield_Image";
    public static final String COL17 = "Tyre_Condition";
    public static final String COL18 = "Paint_Condition";
    public static final String COL19 = "Engine_oil_Condition";
    public static final String COL20 = "Coolant_Condition";
    public static final String COL21 = "list_of_items";
    public static final String COL22 = "InspectedBy";
    public static final String COL23 = "Pickup_Executive";
    public static final String COL24 = "Customer_Sign";

    public static final String CREATE_TABLE =  "CREATE TABLE " + TABLE_NAME + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL1 + " TEXT," + COL2 + " TEXT," + COL3 + " TEXT," +
            COL4 + " TEXT," + COL5 + " TEXT," + COL6 + " TEXT," + COL7 + " TEXT," + COL8 + " TEXT," + COL9 + " TEXT," +
            COL10 + " TEXT," + COL11 + " TEXT," + COL12 + " TEXT," + COL13 + " TEXT," + COL14 + " TEXT," +
            COL15 + " TEXT," + COL16 + " TEXT," + COL17 + " TEXT," + COL18 + " TEXT," + COL19 + " TEXT," + COL20 + " TEXT," +
            COL21 + " TEXT," + COL22 + " TEXT," + COL23 + " TEXT," + COL24 + " TEXT," + ")";

}
