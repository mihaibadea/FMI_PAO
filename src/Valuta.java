import java.util.Scanner;

public class Valuta {
    String identificator;
    double curs_vanzare, curs_cumparare;

    public Valuta(){
        Scanner read = new Scanner(System.in);
        System.out.println("Identificator: ");
        String tmp = read.nextLine();
        identificator = tmp.strip();
        System.out.println("Curs vanzare: ");
        tmp = read.nextLine();
        curs_vanzare = Double.parseDouble(tmp);
        System.out.println("Curs cumparare: ");
        tmp = read.nextLine();
        curs_cumparare = Double.parseDouble(tmp);
    }

    public Valuta(String identificator, double curs_vanzare, double curs_cumparare){
        this.identificator=identificator;
        this.curs_vanzare=curs_vanzare;
        this.curs_cumparare=curs_cumparare;
    }
}
