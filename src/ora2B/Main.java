package ora2B;
public class Main {

    public static void main(String[] a) {
        Ingatlan ing1 = new Ingatlan("Debrecen", 1000000.0, 100, 2.5, Tipus.TARSASHAZ);
        Panel pan1 = new Panel("Debrecen", 800000.0, 100, 4, Tipus.TARSASHAZ, 4, false);
        ing1.akcio(20);
        pan1.akcio(0);
        System.out.println(ing1);
        System.out.println(pan1);
        System.out.println("ugyannayi-e? " + pan1.ugyanannyi(ing1));
        System.out.println("szobaár: " + pan1.szobaar());
        new Ingatlanos().megoldas();


    }
}