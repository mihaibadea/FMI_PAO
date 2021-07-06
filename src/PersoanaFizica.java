import java.util.Scanner;

public class PersoanaFizica extends Persoana{
    private String stareCivila;
    private String cetatenie;

    public String getCetatenie() {
        return cetatenie;
    }

    public void setCetatenie(String cetatenie) {
        this.cetatenie = cetatenie;
    }

    public String getStareCivila() {
        return stareCivila;
    }

    public void setStareCivila(String stareCivila) {
        this.stareCivila = stareCivila;
    }

    public PersoanaFizica(){
        super();
        Scanner read = new Scanner (System.in);
        System.out.println("Stare civila: ");
        String tmp = read.nextLine();
        stareCivila = tmp;
        System.out.println("Cetatenie: ");
        tmp = read.nextLine();
        cetatenie = tmp;
    }

    public PersoanaFizica(String nume, String cif, String rezidenta, String stareCivila, String cetatenie){
        super(nume, cif, rezidenta);
        this.stareCivila=stareCivila;
        this.cetatenie=cetatenie;
    }
}
