import java.util.Scanner;

public class Valuta {
    private String identificator;
    private double curs_vanzare, curs_cumparare;

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public double getCurs_cumparare() {
        return curs_cumparare;
    }

    public void setCurs_cumparare(double curs_cumparare) {
        this.curs_cumparare = curs_cumparare;
    }

    public double getCurs_vanzare() {
        return curs_vanzare;
    }

    public void setCurs_vanzare(double curs_vanzare) {
        this.curs_vanzare = curs_vanzare;
    }

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
