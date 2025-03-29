package ora02;

import ora01.Point;
import ora01.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NG_7_7 {
    static Scanner sc;
    public static void main (String[] args) {
        Point p = new Point(2, 3);
        try {
            sc = new Scanner(new File("pontok.txt"));
        }
        catch (FileNotFoundException ex) {}
        String rectAsText = sc.nextLine();
        String[] fourData = rectAsText.split(" ");
        int x = Integer.parseInt(fourData[0]);
        int y = Integer.parseInt(fourData[1]);
        int width = Integer.parseInt(fourData[2]);
        int height = Integer.parseInt(fourData[3]);
        Rectangle rect = new Rectangle(new Point(x, y), width, height);
         while (sc.hasNextLine()) {
            String pointAsText = sc.nextLine();
            String[] twoData = pointAsText.split(" ");
            x = Integer.parseInt(twoData[0]);
            y = Integer.parseInt(twoData[1]);
            p = new Point(x, y);
            System.out.println(""+p+rect+isInIt(p, rect));
        }
    }
     public static boolean isInIt(Point p, Rectangle r) {
            return r.origin.x <= p.x &&
                    p.x <= r.origin.x+r.height &&
                    r.origin.y <= p.y &&
                    p.y <= r.origin.y+r.width;
    }

    public static void equals_test(String[] args) {
        Point p1 = new Point(10,20);
        Point p2 = new Point(10,20);
        System.out.println(p1.equals(p2));
    }

}
