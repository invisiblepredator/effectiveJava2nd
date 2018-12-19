package EffectiveJava.chapter_3_MethodsForAllObjects.article8;

import java.util.Objects;

public class Point {
    public final int x;
    public final int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
