import java.time.LocalDate;
import java.util.Scanner;

public class Credit {

    private int idBeneficiar;
    private int valoare;
    private double dobanda;
    private LocalDate scadenta;

    public Credit(){
        Scanner read = new Scanner(System.in);
        System.out.println("ID Beneficiar: ");
        String tmp = read.nextLine();
        idBeneficiar = Integer.parseInt(tmp);
        System.out.println("Valoare: ");
        tmp = read.nextLine();
        valoare = Integer.parseInt(tmp);
        System.out.println("Dobanda: ");
        tmp = read.nextLine();
        dobanda = Double.parseDouble(tmp);
        System.out.println("Perioada in ani: ");
        tmp=read.nextLine();
        int pa = Integer.parseInt(tmp);
        LocalDate tmpd = LocalDate.now();
        scadenta = LocalDate.of(tmpd.getYear()+pa, tmpd.getMonth(), tmpd.getDayOfMonth());
    }

    public Credit(int idBeneficiar, int valoare, double dobanda, int pa){
        this.idBeneficiar=idBeneficiar;
        this.valoare=valoare;
        this.dobanda=dobanda;
        LocalDate tmpd = LocalDate.now();
        scadenta = LocalDate.of(tmpd.getYear()+pa, tmpd.getMonth(), tmpd.getDayOfMonth());
    }
}
