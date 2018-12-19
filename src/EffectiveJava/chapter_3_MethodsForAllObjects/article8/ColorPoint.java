package EffectiveJava.chapter_3_MethodsForAllObjects.article8;

import java.awt.Color;
import java.util.Objects;

public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    //....Остальное упущено


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ColorPoint)) return false;
//        if (!super.equals(o)) return false;
//        ColorPoint that = (ColorPoint) o;
//        return Objects.equals(color, that.color);
//    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass())
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }



//    @Override
//    public boolean equals(Object o) {
//       if(!(o instanceof Point))
//           return false;
//
//       //Если о - обычная точка, выпалнить сравнение без проверки цвета
//        if(!(o instanceof ColorPoint))
//            return o.equals(this);
//        //Если о - цветная точка, выполнить полное сравнение
//        return super.equals(o) && color == ((ColorPoint) o).color;
//    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(1,2,Color.RED);
        Point p = new Point(1,2);
        ColorPoint cp2 = new ColorPoint(1,2,Color.BLUE);

        System.out.println(p.equals(cp));   //true
        System.out.println(p.equals(cp2));  //true
        System.out.println(cp.equals(cp2)); //false     //Нарушение транзитивности


        //Не существует способа расширить класс порождаюший экземпляры, и добавить к нему компонент значения,
        //сохранив при этом соглашения для метода equals





//        p.equals(cp);   //true
//        cp.equals(p);   //false
//        System.out.println(p.equals(cp));
//        System.out.println(cp.equals(p));
    }
}
