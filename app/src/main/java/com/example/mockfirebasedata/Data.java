package com.example.mockfirebasedata;

public class Data {

    private String DataID;
    private String Day;
    private String Hours;

    public Data () {

    }

    public Data(String dataID, String day, String hours) {
        DataID = dataID;
        Day = day;
        Hours = hours;
    }

    public String getDataID() {
        return DataID;
    }

    public String getDay() {
        return Day;
    }

    public String getHours() {
        return Hours;
    }
}
