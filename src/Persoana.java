import java.util.Scanner;

public abstract class Persoana {
    static int nrPersoane = 0;
    int id;
    String cif, nume, rezidenta;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCif() {
        return cif;
    }

    public void setCnp(String cif) {
        this.cif = cif;
    }

    public String getRezidenta() {
        return rezidenta;
    }

    public void setRezidenta(String rezidenta) {
        this.rezidenta = rezidenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persoana(){
        Scanner read = new Scanner(System.in);
        nrPersoane++;
        id = nrPersoane;
        System.out.println("Numele: ");
        String tmp = read.nextLine();
        nume = tmp;
        System.out.println("CNP/CUI/CIF: ");
        tmp = read.nextLine();
        cif = tmp;
        System.out.println("Rezidenta fiscala: ");
        tmp = read.nextLine();
        rezidenta = tmp;
        System.out.println("A fost inregistrata persoana " + nume + " cu ID-ul " + id + ".");
    }

    public Persoana(String nume, String cif, String rezidenta){
        this.nume=nume;
        this.cif=cif;
        this.rezidenta=rezidenta;
    }

}

