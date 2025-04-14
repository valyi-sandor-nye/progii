package ora2B;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Ingatlanos {
    static TreeSet<Ingatlan> ingatlanok = new TreeSet<>();
    static int panellakas = 0;
    static int N = 0;
    static Ingatlan[] ingatlanosTomb;

    public Ingatlanos() {
        Scanner sc;
        try {
            Tipus tipus = null;
            boolean szigetelt = false;
            sc = new Scanner(new File("3ingatlan.txt"));
            int index = 0;
            panellakas = 0;
            while (sc.hasNextLine()) {
                String sor = sc.nextLine();
                System.out.println(sor);
                String[] darabok = sor.split("#");
                if (darabok.length == 6 && darabok[0].equals("INGATLAN")) {
                    String telepules = darabok[1];
                    int nmar = Integer.parseInt(darabok[2]);
                    int nm = Integer.parseInt(darabok[3]);
                    double szobaszam = Double.parseDouble(darabok[4]);
                    switch (darabok[5]) {
                        case "társasház":
                            tipus = Tipus.TARSASHAZ;
                            break;
                        case "családiház":
                            tipus = Tipus.CSALADIHAZ;
                            break;
                        case "házrész":
                            tipus = Tipus.HAZRESZ;
                            break;
                    }
                    Ingatlan ingatlan = new Ingatlan(telepules, nmar, nm, szobaszam, tipus);
                    ingatlanok.add(ingatlan);
                }
                index++;

                if (darabok.length == 8 && darabok[0].equals("PANEL")) {
                    String telepules = darabok[1];
                    int nmar = Integer.parseInt(darabok[2]);
                    int nm = Integer.parseInt(darabok[3]);
                    double szobaszam = Double.parseDouble(darabok[4]);
                    switch (darabok[5]) {
                        case "társasház":
                            tipus = Tipus.TARSASHAZ;
                            break;
                        case "családiház":
                            tipus = Tipus.CSALADIHAZ;
                            break;
                        case "házrész":
                            tipus = Tipus.HAZRESZ;
                            break;
                    }
                    int emelet = Integer.parseInt(darabok[6]);
                    switch (darabok[7]) {
                        case "igen":
                            szigetelt = true;
                            break;
                        default:
                            szigetelt = false;
                            break;
                    }

                    Panel panel = new Panel(telepules, nmar, nm, szobaszam, tipus, emelet, szigetelt);
                    ingatlanok.add(panel);
                }
                index++;
                panellakas++;
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        N = ingatlanok.size();
        ingatlanosTomb = new Ingatlan[N];
        int i = 0;
        for (Object ing : new ArrayList<Ingatlan>(ingatlanok).toArray()) {
            ingatlanosTomb[i] = (Ingatlan) ing;
            i++;
        }
        System.out.println(i);


    }



    void megoldas() {
         feladat1();

    }

    void feladat1() {
        double osszeg = 0;
        double atlagar = 0;
        for (int i=0;i<N;i++) {
            osszeg += ingatlanosTomb[i].ar;
        }
        if (N>0) atlagar = osszeg / N;
        System.out.println("Az elsúfeléadat megoldása, az átlag nmár: "+atlagar);
    }
}

