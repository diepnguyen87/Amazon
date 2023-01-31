package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        String date1Str = "December 2, 2024";
        String date2Str = "January 19, 2021";
        Date date1 = sdf.parse(date1Str);
        Date date2 = sdf.parse(date2Str);
        Date today = new Date();

        List<Date> dateList = new ArrayList<>();
        dateList.add(date1);
        //dateList.add(date2);
        dateList.add(today);
        System.out.println(isSorted(dateList));

    }

    public static boolean isSorted(List<Date> listOfDate) {
        if (listOfDate.isEmpty() || listOfDate.size() == 1) {
            return true;
        }

        Iterator<Date> iter = listOfDate.iterator();
        Date current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) < 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}
