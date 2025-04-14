package ora2B;

public class Panel extends Ingatlan implements PanelInterface{
    int emelet;
    boolean szigetelt;

    @Override
    public String toString() {
        return "Panel{" +
                "telepules='" + telepules + '\'' +
                ", ar=" + ar +
                ", nm=" + nm +
                ", szobaszam=" + szobaszam +
                ", tipus=" + tipus +
                ", emelet=" + emelet +
                ", szigetelt=" + szigetelt +
                ", teljesar=" + teljesar() +
                ", atlagos negyzetmeterszam=" + atlagos() +
                '}';
    }

    public Panel(String telepules, double ar, int nm, double szobaszam, Tipus tipus, int emelet, boolean szigetelt) {
        super(telepules, ar, nm, szobaszam, tipus);
        this.emelet = emelet;
        this.szigetelt = szigetelt;
    }

    // A panelmentes teljesar()-hoz képest értjük
    @Override
    public int teljesar() {
        double emeles1=0, emeles2=0;
        int arLakásként = super.teljesar();
        if ((2 >= emelet) && (emelet >= 0)) {emeles1 = arLakásként*0.05;}
        else if (emelet == 10) {emeles1 = - arLakásként*0.05;}
        if (szigetelt) emeles2 = arLakásként-0.05;
        return (int)(arLakásként + emeles1 + emeles2);
    }


    @Override
    public boolean ugyanannyi(Ingatlan ing) {
        return teljesar() == ing.teljesar();
    }

    @Override
    public int szobaar() {
        return (int)(ar*nm/szobaszam);
    }
}
