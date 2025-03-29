package ora01;
public class Rectangle {
    public int width = 0;
    public int height = 0;
    public Point origin;
    public Rectangle() {
        origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
        origin = p;
    }
    public Rectangle(int w, int h) {
        this(new Point(0, 0), w, h);
    }
    public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }
    public int area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", origin=" + origin +
                '}';
    }
}
