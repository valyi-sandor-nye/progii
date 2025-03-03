package ora01;

public class ForEachDemo {
    public static void main(String[] args) {
        int[] arrayOfInts = { 32, 87, 3, 589, 12,
                1076, 2000, 8, 622, 127 };
        for (int element : arrayOfInts) {
            System.out.print(element%2 + " ");
        }
        System.out.println();
    }
}
