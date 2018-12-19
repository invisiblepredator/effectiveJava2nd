package EffectiveJava.chapter_3_MethodsForAllObjects.article10;

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

    /**
     * @return
     * Возвращает представление данного номера в виде строки.
     * Строка состоит из четырнадцати символов, имеющих формат
     * "(XXX ) YYY-ZZZZ", где XXX - код зоны, YYY - префикс,
     * ZZZZ - номер линии. (Каждая прописная буква представляет одну десятичную цифру.)
     *
     *
     * Если какая-либо из трех частей телефонного номера слишком мала и не заполняет полностью свое поле,
     * последннее дополняется ведущими нулями.
     * Например, если значение номера абонента в ATC равно 123, то последними
     * четырьмя символами в строковом представлении будут "0123"
     *
     * Заметим, что закрывающую скобку, следующую за кодом зоны, и первую цифру префикса разделяет один пробел.
     */

    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode,prefix, lineNumber);
    }

    public static void main(String[] args) {

    }
}
