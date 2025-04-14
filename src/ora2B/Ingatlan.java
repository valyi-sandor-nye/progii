package ora2B;

enum Tipus {CSALADIHAZ, TARSASHAZ, HAZRESZ}

public class Ingatlan implements IngatlanInterface, Comparable<Ingatlan> {
    String telepules;
    double ar;
    int nm;
    double szobaszam;
    Tipus tipus;

    @Override
    public String toString() {
        return "Ingatlan{" +
                "telepules='" + telepules + '\'' +
                ", ar=" + ar +
                ", nm=" + nm +
                ", szobaszam=" + szobaszam +
                ", tipus=" + tipus +
                ", teljesar=" + teljesar() +
                ", atlagos negyzetmeterszam=" + atlagos() +
                '}';
    }



    public Ingatlan(String telepules, double ar, int nm, double szobaszam, Tipus tipus) {
        this.telepules = telepules;
        this.ar = ar;
        this.nm = nm;
        this.szobaszam = szobaszam;
        this.tipus = tipus;
    }

      @Override
    public void akcio(int szazalek) {
        ar -= ar*szazalek/100.0;
    }

    @Override
    public int teljesar() {
        double valasz =  (ar*nm);
        switch (telepules) {
            case "Budapest":
                valasz = valasz * 1.30;
                break;
            case "Debrecen":
                valasz = valasz * 1.20;
                break;
            case "Nyíregyháza":
                valasz = valasz * 1.15;
                break;
            default:
                break;
        }
        return (int) valasz;

    }

    @Override
    public double atlagos() {
        return nm/szobaszam;
    }


    @Override
    public int compareTo(Ingatlan o) {
        return Double.compare(teljesar(),o.teljesar());
    }
}

