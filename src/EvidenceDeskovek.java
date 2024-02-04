import java.util.ArrayList;
import java.util.List;

public class EvidenceDeskovek {
    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public EvidenceDeskovek() {
        seznamDeskovek.add(new Deskovka("Člověče nezlob se", true, 1));
        seznamDeskovek.add(new Deskovka("Prší", false, 2));
        seznamDeskovek.add(new Deskovka("UNO", true, 3));
    }

    public Deskovka vratDeskovku(int index) {
        return seznamDeskovek.get(index);
    }

}
