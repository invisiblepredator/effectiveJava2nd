package EffectiveJava.chapter_3_MethodsForAllObjects.article9;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    private volatile int hashCode; //Отложенная инициализация кэшируемый hashCode

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");

        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name){
        if(arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }
        //Нарушение соглашения метода у двух объектов будет разный hashCode
        //hashCode - ы разные то метод equals вызван не будет
    @Override
    public int hashCode() {
        int result = hashCode;
            if(hashCode == 0){
                result = 17;
                result = 31 * result + areaCode;
                result = 31 * result + prefix;
                result = 31 * result + lineNumber;
                hashCode = result;
            }
        //return Objects.hash(areaCode, prefix, lineNumber);
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        PhoneNumber phoneNumber = new PhoneNumber(707, 867, 5309);
        m.put(phoneNumber, "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
