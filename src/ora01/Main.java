package ora01;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

enum Irány {ÉSZAK, KELET, DÉL, NYUGAT}



class Ember {
    private float x;
    private float y;
    private float iránySzög;
    private Irány irány;

    public Ember(float x, float y, float iránySzög) {
        this.x = x;
        this.y = y;
        this.iránySzög = iránySzög;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Ember{" +
                "sor=" + x +
                ", oszlop=" + y +
                ", iránySzög=" + iránySzög +
                '}';
    }

    void megy(float a) {
        x = (float) (x+a*cos(iránySzög));
        y = (float) (y+a*sin(iránySzög));
    }

    void fordul(float fok) {
        iránySzög += 2*3.14159*fok/360.0;
    }


}

public class Main {

    public static void main(String[] args) {
        Ember andor = new Ember(70,30,0);
        System.out.println(andor);
        andor.megy(30); // x az 100 lesz
        System.out.println(andor);
        andor.fordul(90);
        andor.megy(30); // x az 100 lesz
        System.out.println(andor);
        andor.setX(10);
        System.out.println(andor);
        String s = new String(andor.toString());
        s = "10.0";
        System.out.println(s);


    }

    private static int f(int x) {
        return x+1;
    }
}
