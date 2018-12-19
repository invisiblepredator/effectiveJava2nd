package EffectiveJava.chapter2.singleton;

public enum ElvisEnum {
    INSTANCE;
    private ElvisEnum() {
        System.out.println("Here");
    }

    public void leaveTheBuilding(){

    };
}

///


//public enum MySingleton {
//    INSTANCE;
//
//    public void doSomething() { ... }
//
//    public synchronized String getSomething() { return something; }
//
//    private String something;
//}


//MySingleton.INSTANCE.doSomething();
//String something = MySingleton.INSTANCE.getSomething();