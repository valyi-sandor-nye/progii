package ora01;

public class StringSplitDemo {
public static void main(String[]args){
    String inputLine = "Jozsi;2;3;5.0;7;B";
    String[] pieces = inputLine.split(";");
    for (String piece : pieces ) System.out.println(piece);
    String nev = pieces[0];
    int angolJegy = Integer.parseInt(pieces[1]);
    int matekJegy = Integer.parseInt(pieces[2]);
    double átlag =  Double.parseDouble(pieces[3]);
    int évfolyam =   Integer.parseInt(pieces[4]);
    Character osztály = pieces[5].charAt(0);




}

        }
