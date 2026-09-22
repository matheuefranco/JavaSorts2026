import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountingSort<T extends Comparable<T>> {

    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        contaComparacoes = 0;
        contaTrocas = 0;

        List<T> valores = new ArrayList<>();
        List<Integer> quantidades = new ArrayList<>();

        for (T elemento : array) {
            int indice = 0;
            while (indice < valores.size()) {
                contaComparacoes++;
                int resultado = comparador.compare(elemento, valores.get(indice));
                if (resultado == 0) {
                    quantidades.set(indice, quantidades.get(indice) + 1);
                    break;
                }
                if (resultado < 0) {
                    break;
                }
                indice++;
            }

            if (indice == valores.size() || comparador.compare(elemento, valores.get(indice)) != 0) {
                valores.add(indice, elemento);
                quantidades.add(indice, 1);
            }
        }

        int indiceArray = 0;
        for (int i = 0; i < valores.size(); i++) {
            for (int repeticao = 0; repeticao < quantidades.get(i); repeticao++) {
                array[indiceArray++] = valores.get(i);
                contaTrocas++;
            }
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> a.compareTo(b));
    }
}