package com.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Created by c0de8ug on 16-2-15.
 */
@Component
public class TermContainer {
    static List<Term> termList;
    static Date beginTime;
    static HashMap<String, String> map = new HashMap<>();
    final static String lastTermStr = "上学期";
    final static String nextTermStr = "下学期";

    String lastSemester = "2,3,4,5,6,7,8";
    String nextSemester = "1,9,10,11,12";

    TermContainer() {


        for (String temp : lastSemester.split(",")) {
            map.put(temp, lastTermStr);
        }
        for (String temp : nextSemester.split(",")) {
            map.put(temp, nextTermStr);
        }
        beginTime = new GregorianCalendar(2014,1,1).getTime();
        update();
    }

    public static void update() {
        termList = new ArrayList<>();

        Date today = new Date();


        int beginYear = beginTime.getYear();
        int todayYear = today.getYear();
        int count = todayYear - beginYear;

        if (map.get(String.valueOf(today.getMonth())).equals(nextTermStr)) {
            Term term = new Term();
            term.setVal(todayYear + "2");
            term.setText(todayYear + nextTermStr);
            termList.add(term);
        }
        Term term = new Term();
        term.setVal(todayYear + "1");
        term.setText(todayYear + lastTermStr);
        termList.add(term);


        for (int i = 0; i < count; i++) {
            todayYear--;
            term = new Term();
            term.setVal(todayYear + "2");
            term.setText(todayYear + nextTermStr);
            termList.add(term);
            term = new Term();
            term.setVal(todayYear + "1");
            term.setText(todayYear + lastTermStr);
            termList.add(term);

        }

    }


    public static String now() {
        return termList.get(0).getVal();
    }

    public static List<Term> getTermList() {
        return termList;
    }
}
