package de.ur.mi.android.u05todolistemitdatum;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

public class TaskItem {

    private String task;
    private GregorianCalendar date;

    public TaskItem(String task, String date) {
        this.task = task;
        this.date = getDateFromString(date);
    }

    private GregorianCalendar getDateFromString(String date) {
        GregorianCalendar cal = new GregorianCalendar();

        try {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);
            cal.setTime(Objects.requireNonNull(df.parse(date)));
        } catch (ParseException e) {
            //Wenn parsing fehlschlägt benutzt der erstellte GregCalender automatisch das aktuelle Datum
            e.printStackTrace();
        }

        return cal;
    }

    public String getFormattedDate(GregorianCalendar date) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.GERMANY);

        return df.format(date.getTime());
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return getFormattedDate(date);
    }



}
