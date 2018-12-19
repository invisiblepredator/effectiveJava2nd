package EffectiveJava.chapter_3_MethodsForAllObjects.article12_Comparable;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


/*
    Эта программа используя тот факт, что класс String рефлизует интерфейс Comparble,
    печатает в алфавитном порядке список аргументовб указанных в командной строкеб удаляя при этом дубликаты.
 */
public class WordLIst {
    public static void main(String[] args) {
        Set s = new TreeSet();
        s.addAll(Arrays.asList(args));
        System.out.println(s);
    }
}
