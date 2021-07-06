import java.time.LocalDate;
import java.util.Scanner;

public class Tranzactie {
    private int idDebitor, idCreditor;

    private int valoare;

    private LocalDate moment;

    public int getIdCreditor() {
        return idCreditor;
    }

    public void setIdCreditor(int idCreditor) {
        this.idCreditor = idCreditor;
    }

    public int getIdDebitor() {
        return idDebitor;
    }

    public void setIdDebitor(int idDebitor) {
        this.idDebitor = idDebitor;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public Tranzactie(){
        Scanner read = new Scanner(System.in);
        System.out.println("ID debitor: ");
        String tmp = read.nextLine();
        idDebitor = Integer.parseInt(tmp);
        System.out.println("ID creditor: ");
        tmp = read.nextLine();
        idCreditor = Integer.parseInt(tmp);
        System.out.println("Suma: ");
        tmp = read.nextLine();
        valoare = Integer.parseInt(tmp);
        moment = LocalDate.now();
    }

    public Tranzactie(int idDebitor, int idCreditor, int valoare){
        this.idDebitor=idDebitor;
        this.idCreditor=idCreditor;
        this.valoare=valoare;
        moment = LocalDate.now();
    }
}
