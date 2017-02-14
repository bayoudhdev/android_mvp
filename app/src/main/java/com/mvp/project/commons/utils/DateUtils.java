package com.mvp.project.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bayoudh on 25/01/2017.
 */

public class DateUtils {

    public static Date parseDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.ENGLISH);

        Date result = null;
        try {
            result = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String getDateNow() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.ENGLISH);
        return sdf.format(date);
    }


    public static Date getDateFromString(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.ENGLISH);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
