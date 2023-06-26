package com.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {

                DATE_FORMATER.applyPattern(pattern[0]);

            }
            if (date == null) {
                return DateHelper.now();
            }
            System.out.println(date);
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static String dateString(Date date) {
		String str = "";
		if (date.getDate() < 10) {
			str = "0" + date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
		if ((date.getMonth() + 1) < 10) {
			str = date.getDate() + "/" + "0" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}

		if ((date.getMonth() + 1) < 10 && date.getDate() < 10) {
			str = "0" + date.getDate() + "/0" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
		if (date.getMonth() + 1 >= 10 && date.getDate() >= 10) {
			str = date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
//		str = date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
//		System.out.println(str);
		return str;
	}

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    public static java.sql.Date now() {
        long milis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(milis);
        return date;
    }

    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }
}
