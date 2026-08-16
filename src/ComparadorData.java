import java.util.Comparator;
public class ComparadorData implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return p1.getDataNascimento().compareTo(p2.getDataNascimento());
    }
}

