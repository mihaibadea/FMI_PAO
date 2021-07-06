import java.time.LocalDate;
import java.util.Scanner;

public class Card {
    private static int nrCarduri = 0;
    private int idCard;
    private int idTitular;
    private int idCont;

    private LocalDate dataexpirare;

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public int getIdCont() {
        return idCont;
    }

    public void setIdCont(int idCont) {
        this.idCont = idCont;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public Card(){
        Scanner read = new Scanner(System.in);
        nrCarduri++;
        idCard = nrCarduri;
        System.out.println("ID Titular: ");
        String tmp = read.nextLine();
        idTitular = Integer.parseInt(tmp);
        System.out.println("ID Cont: ");
        tmp = read.nextLine();
        idCont = Integer.parseInt(tmp);
        LocalDate tmpd = LocalDate.now();
        dataexpirare = LocalDate.of(tmpd.getYear()+5, tmpd.getMonth(), tmpd.getDayOfMonth());
    }

    public Card(String idT, String idC){
        nrCarduri++;
        idCard = nrCarduri;
        this.idTitular = Integer.parseInt(idT);
        this.idCont = Integer.parseInt(idC);
    }
}
