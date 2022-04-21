package ch7;

import ch7_class.PointOverride;

public class Override {
    public static void main(String[] args) {
        PointOverride p = new PointOverride();
        p.x = 10;
        p.y = 10;
        p.z = 10;

        System.out.println(p.getLocation());
    }
}
