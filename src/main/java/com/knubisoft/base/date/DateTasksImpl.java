package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        LocalDate localDate = LocalDate.parse(date);
        localDate = localDate.plusDays(1);
        return localDate.toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
        LocalDate myDate = LocalDate.parse(date, df);
        return myDate.getMonthValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.parse(date1, dtf);
        LocalDateTime localDateTime2 = LocalDateTime.parse(date2, dtf);
        LocalDateTime localDateTime3 = LocalDateTime.parse(date3, dtf);
        if (localDateTime1.isEqual(localDateTime2) && localDateTime1.isEqual(localDateTime3))
            return localDateTime1.toString().replace("T", " ");
        ;
        if (localDateTime1.isAfter(localDateTime2) && localDateTime1.isAfter(localDateTime3))
            return localDateTime1.toString().replace("T", " ");
        if (localDateTime2.isAfter(localDateTime1) && localDateTime2.isAfter(localDateTime3))
            return localDateTime2.toString().replace("T", " ");
        if (localDateTime3.isAfter(localDateTime1) && localDateTime3.isAfter(localDateTime2))
            return localDateTime3.toString().replace("T", " ");
        return "How to get here?";
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
    LocalDate localDate = LocalDate.parse(date);
    int endDay = localDate.lengthOfMonth();
    while (localDate.getDayOfMonth() != endDay) {
        localDate = localDate.plusDays(1);
    }
    return localDate.toString();
}
    @Override
    public String sumTimes(String time1, String time2) {
        LocalTime myTime1 = LocalTime.parse(time1);
        LocalTime myTime2 = LocalTime.parse(time2);
        myTime1 = myTime1.plusSeconds(myTime2.getSecond());
        myTime1 = myTime1.plusMinutes(myTime2.getMinute());
        myTime1 = myTime1.plusHours(myTime2.getHour());
        if (myTime1.getSecond() == 0)
            return myTime1.toString() + ":00";
       return myTime1.toString();
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.plusWeeks(2).toString();
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate;
        Date secondDate;
        try {
          firstDate = df.parse(date1);
          secondDate = df.parse(date2);
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
        return (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        String[] ans = new String[2];
        LocalDate localDate = LocalDate.parse(date);
        System.out.println(localDate);
        ans[0] = localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)).toString();
        ans[1] = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).toString();
        return ans;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return 12 - localDate.getMonthValue();
    }
}
