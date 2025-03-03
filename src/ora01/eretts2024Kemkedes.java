package ora01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Esemény {
    String tanulóKód;
    int óra;
    int perc;
    int akció;

    public Esemény(String tanulóKód, int óra, int perc, int akció) {
        this.tanulóKód = tanulóKód;
        this.óra = óra;
        this.perc = perc;
        this.akció = akció;
    }

    @Override
    public String toString() {
        return "Esemény{" +
                "tanulóKód='" + tanulóKód + '\'' +
                ", óra=" + óra +
                ", perc=" + perc +
                ", akció=" + akció +
                '}';
    }
}

public class eretts2024Kemkedes {

    Esemény[] adatsor = new Esemény[2000];  // később listára alakthatjuk

    public static void main(String[] args) {
        eretts2024Kemkedes megoldó = new eretts2024Kemkedes();
        Esemény[] akt_adatsor = megoldó.adatsor;
        megoldó.beolvasás(akt_adatsor);
        int N = megoldó.adatsorhossz(akt_adatsor);
        System.out.println("N = "+N );
        System.out.println(akt_adatsor[N-1]);
        megoldó.feladat2(akt_adatsor,N);



    }

    void beolvasás(Esemény[] adatsor) {
//        adatsor[0] = new Esemény("KYPG",14,01,1);
//        adatsor[1] = new Esemény("ABCD",14,02,2);
//        adatsor[2] = new Esemény("ABCD",14,02,1);
//              // TODO igazi beolv...
        Scanner sc;
        try  {
            sc = new Scanner(new File("bedat.txt"));
            int index = 0;
            while (sc.hasNextLine()) {
                String sor = sc.nextLine();
                System.out.println(sor);
                String tKód = sor.substring(0,4);
                int óra = Integer.parseInt(sor.substring(5,7));
                int perc = Integer.parseInt(sor.substring(8,10));
                int akció = Integer.parseInt(sor.substring(11,12));
                Esemény  es = new Esemény(tKód,óra, perc, akció);
                adatsor[index] = es;
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


      }

      int adatsorhossz(Esemény[] adatsor) {
        int N = 0;
        while (adatsor[N] != null) N++;
        return N;
      }

      void feladat2(Esemény[] adatsor, int N) {
          int óra1 = -1, óra2 = -1, perc1 = -1, perc2 = -1;
          for (int i=0; i<N; i++) {
            if (óra1<0 && adatsor[i].akció == 1) {óra1 = adatsor[i].óra; perc1 = adatsor[i].perc;  }
              if (adatsor[i].akció == 2) {óra2 = adatsor[i].óra; perc2 = adatsor[i].perc;  }
          }
          PrintStream out = null;
          try {
              out = new PrintStream(System.out, true, "UTF-8");
          } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
          }
          out.printf("2. feladat\n"+
                  "Az első tanuló %02d:%02d-kor lépett be a főkapun."+
                  "Az utolsó tanuló %02d:%02d-kor lépett ki a főkapun.",óra1,perc1,óra2,perc2);


      }
}
