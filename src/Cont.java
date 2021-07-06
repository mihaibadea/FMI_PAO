import java.util.Scanner;

public class Cont {
    static int nrConturi = 0;
    int id;
    int idPersoana;
    int sold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getidPersoana() {
        return idPersoana;
    }

    public void setidPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Cont(){
        Scanner read = new Scanner(System.in);
        nrConturi++;
        id = nrConturi;
        System.out.println("ID Persoana: ");
        String tmp = read.nextLine();
        idPersoana = Integer.parseInt(tmp);
        System.out.println("Sold initial: ");
        tmp = read.nextLine();
        sold = Integer.parseInt(tmp);
        System.out.println("A fost inregistrat contul cu ID-ul " + id + ".");
    }

    public Cont(String idP, String s){
        nrConturi++;
        id = nrConturi;
        this.idPersoana=Integer.parseInt(idP);
        this.sold = Integer.parseInt(s);
    }

}
