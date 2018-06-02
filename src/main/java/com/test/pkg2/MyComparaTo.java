package com.test.pkg2;

import java.util.Comparator;

public class MyComparaTo implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if ((o1+o2).compareTo(o2+o1)>0){
            return 1;
        }
        return 0;
    }
}
