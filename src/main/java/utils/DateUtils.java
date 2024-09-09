package utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtils {

    // Converte java.util.Date para java.sql.Date
    public static Date toSqlDate(java.util.Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new Date(utilDate.getTime());
    }

    // Converte java.sql.Date para java.util.Date
    public static java.util.Date toUtilDate(Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        return new java.util.Date(sqlDate.getTime());
    }
}
