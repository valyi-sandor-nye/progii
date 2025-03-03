package ora01;

public class Test {
    public static void main (String args []) {
        int age = 42;
        age = max(age,52);
        System.out.println("The age is " + age);
    }

    static int max (int x, int z) {return x>z?x:z;}


}