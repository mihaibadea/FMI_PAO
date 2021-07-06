import java.util.Comparator;

public class ComparTranzactiiDupaData implements Comparator<Tranzactie> {
    public int compare(Tranzactie t1, Tranzactie t2){
        return t1.getMoment().compareTo(t2.getMoment());
    }
}
