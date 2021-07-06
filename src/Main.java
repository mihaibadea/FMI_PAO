import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        ServiceClass s = ServiceClass.getInstance();
        s.citire();
        s.AcordareCredit(2,5000,4.3, 2);
        s.IntrerupereRelatiedeAfaceri(1);
        s.EfectuareTranzactie(4,3,500);
        s.EfectuareTranzactie(2,4,1000);
        s.GenerareExtras(4);
        s.AdaugareMoneda("EUR", 4.5, 4.5);
        s.SchimbValutar(450, "EUR", true);
        s.AnulareCard(1);
        s.InchidereCont(2);
    }
}
