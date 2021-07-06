import java.util.Scanner;

public class PersoanaJuridica extends Persoana{
    private String sediu;
    private int capitalSocial;

    public String getSediu() {
        return sediu;
    }

    public void setSediu(String sediu) {
        this.sediu = sediu;
    }

    public int getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(int capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public PersoanaJuridica(){
        super();
        Scanner read = new Scanner (System.in);
        System.out.println("Sediu: ");
        String tmp = read.nextLine();
        sediu = tmp;
        System.out.println("Capital social: ");
        tmp = read.nextLine();
        capitalSocial = Integer.parseInt(tmp);
    }

    public PersoanaJuridica(String nume, String cif, String rezidenta, String sediu, String cs){
        super(nume, cif, rezidenta);
        this.sediu = sediu;
        this.capitalSocial = Integer.parseInt(cs);
    }

}
