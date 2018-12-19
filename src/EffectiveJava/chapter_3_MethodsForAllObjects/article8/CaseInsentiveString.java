package EffectiveJava.chapter_3_MethodsForAllObjects.article8;

public final class CaseInsentiveString {
    private String s;

    public CaseInsentiveString(String s){
        if(s == null)
            throw new NullPointerException();
            this.s = s;
    }

    @Override
    public boolean equals(Object o) {
//Mistake
//        if(o instanceof CaseInsentiveString)
//            return s.equalsIgnoreCase(((CaseInsentiveString)o).s);
//        if(o instanceof String)
//            return s.equalsIgnoreCase((String)o);
//        return false;
        return o instanceof CaseInsentiveString &&                  //удалена нейдачная попытка взаимодействия с классом
                ((CaseInsentiveString)o).s.equalsIgnoreCase(s);     //String


    }
    //... Остальное опущено
    public static void main(String[] args) {
        CaseInsentiveString cis = new CaseInsentiveString("Polish");
        String s = "polish";

        cis.equals(s); //true
        s.equals(cis); //false
    }
}
