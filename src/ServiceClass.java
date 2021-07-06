import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ServiceClass {
    private static ServiceClass single_instance = null;

    public static ServiceClass getInstance() {
        if (single_instance == null) {
            single_instance = new ServiceClass();
        }
        return single_instance;
    }

    CSVHelper c = CSVHelper.getInstance();

    HashSet<Cont> conturi = new HashSet<Cont>();
    HashSet<Persoana> persoane = new HashSet<Persoana>();
    ArrayList<Tranzactie> tranzactii = new ArrayList<Tranzactie>();
    HashSet<Valuta> monede = new HashSet<Valuta>();
    HashSet<Card> carduri = new HashSet<Card>();
    HashSet<Credit> credite = new HashSet<Credit>();

    public Persoana PersDupaID(int idp){
        for(Persoana p : persoane){
            if(p.id == idp) {
                return p;
            }
        }
        return null;
    }

    public Cont ContDupaID(int idc){
        for(Cont c : conturi){
            if(c.id == idc){
                return c;
            }
        }
        return null;
    }

    public void InitiereRelatieDeAfaceriPF() throws IOException{
        PersoanaFizica persoana = new PersoanaFizica();
        persoane.add(persoana);
        c.audit("InitiereRelatiiDeAfaceriPF");
    }

    public void InitiereRelatieDeAfaceriPJ() throws IOException{
        PersoanaJuridica persoana = new PersoanaJuridica();
        persoane.add(persoana);
        c.audit("InitiereRelatiiDeAfaceriPJ");
    }

    public void DeschidereContCurent() throws IOException{
        Cont cont = new Cont();
        conturi.add(cont);
        c.audit("DeschidereContCurent");
    }

    public void EfectuareTranzactie(int idDebitor, int idCreditor, int valoare) throws IOException {
        Tranzactie tranzactie = new Tranzactie(idDebitor, idCreditor, valoare);
        tranzactii.add(tranzactie);
        Cont contdebitor = ContDupaID(tranzactie.getIdDebitor());
        Cont contcreditor = ContDupaID(tranzactie.getIdCreditor());
        int suma = tranzactie.getValoare();

        contdebitor.setSold(contdebitor.getSold() - suma);
        contcreditor.setSold(contcreditor.getSold() + suma);
        c.audit("EfectuareTranzactie");
    }

    public void GenerareExtras(int idc) throws IOException {
        System.out.println("Sold actual: " + ContDupaID(idc).sold + " lei.");
        Collections.sort(tranzactii, new ComparTranzactiiDupaData());
        System.out.println("Tranzactii:");
        for(Tranzactie t : tranzactii){
            if(t.getIdCreditor() == idc){
                System.out.println("+" + t.getValoare() + " lei la data de " + t.moment);
            }
            else if(t.getIdDebitor() == idc){
                System.out.println("-" + t.getValoare() + " lei la data de " + t.moment);
            }
        }
        c.audit("GenerareExtras");
    }

    public void AdaugareMoneda(String identificator, double curs_vanzare, double curs_cumparare){
        Valuta v = new Valuta(identificator, curs_vanzare, curs_cumparare);
        monede.add(v);
    }

    public void SchimbValutar(int suma, String idv, boolean amlei) throws IOException {
        for(Valuta v : monede){
            if(v.identificator.equals(idv)){
                if(amlei){
                    System.out.println("Banca a primit " + suma + " lei si a dat " + suma / v.curs_vanzare + " " + idv + ".");
                }
                else{
                    System.out.println("Banca a primit " + suma + idv + " si a dat " + suma * v.curs_cumparare + " lei.");
                }
            }
        }
        c.audit("SchimbValutar");
    }

    public void EmiteCard() throws IOException {
        Card card = new Card();
        carduri.add(card);
        c.audit("EmitereCard");
    }

    public void AcordareCredit(int idBeneficiar, int valoare, double dobanda, int pa) throws IOException {
        Credit credit = new Credit(idBeneficiar, valoare, dobanda, pa);
        credite.add(credit);
        c.audit("AcordareCredit");
    }

    public void AnulareCard(int id) throws IOException {
        carduri.removeIf(c -> c.getIdCard() == id);
        c.audit("AnulareCard");
    }

    public void InchidereCont(int id) throws IOException {

        carduri.removeIf(c -> c.getIdCont() == id);

        conturi.removeIf(c -> c.getId() == id && c.getSold() > 0);

        c.audit("InchidereCont");
    }

    public void IntrerupereRelatiedeAfaceri(int id) throws IOException {

        boolean sepoate = true;

        for(Cont c : conturi){
            if (c.idPersoana == id && c.sold < 0) {
                sepoate = false;
                break;
            }
        }


        carduri.removeIf(c -> c.getIdTitular() == id);

        conturi.removeIf(c -> c.getidPersoana() == id && c.sold > 0);

        boolean finalSepoate = sepoate;

        persoane.removeIf(p -> p.getId() == id && finalSepoate);


        c.audit("IntrerupereRelatiiDeAfaceri");

    }



    public void citire() throws IOException {
        ArrayList<String> buf = new ArrayList<>();

        buf = c.citesteFisier("csv/pf.csv");
        for(int i=1; i<buf.size(); i++){
            String[] tmp = buf.get(i).split(", ");
            PersoanaFizica pf = new PersoanaFizica(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
            persoane.add(pf);
            c.audit("InitiereRelatiiDeAfaceriPF");
        }

        buf=c.citesteFisier("csv/pj.csv");
        for(int i=1; i<buf.size(); i++){
            String[] tmp = buf.get(i).split(", ");
            PersoanaJuridica pj = new PersoanaJuridica(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
            persoane.add(pj);
            c.audit("InitiereRelatiiDeAfaceriPJ");
        }

        buf=c.citesteFisier("csv/conturi.csv");
        for(int i=1; i<buf.size(); i++){
            String[] tmp = buf.get(i).split(", ");
            Cont co = new Cont(tmp[0],tmp[1]);
            conturi.add(co);
            c.audit("DeschidereContCurent");
        }

        buf=c.citesteFisier("csv/carduri.csv");
        for(int i=1; i<buf.size(); i++){
            String[] tmp = buf.get(i).split(", ");
            Card ca = new Card(tmp[0], tmp[1]);
            carduri.add(ca);
            c.audit("EmitereCard");
        }
    }
}
