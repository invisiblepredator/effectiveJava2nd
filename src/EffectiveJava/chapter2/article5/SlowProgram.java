package EffectiveJava.chapter2.article5;

public class SlowProgram {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        Long sum = 0L;      //Long 15 sec long 2 sec 7(times effectively)
        for(long i = 0; i<=Integer.MAX_VALUE; i++){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-timeStart);
    }
}
