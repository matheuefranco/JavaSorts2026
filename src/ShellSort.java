import java.util.Comparator;

public class ShellSort<T extends Comparable<T>> {

    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    private void trocar(T[] array, int i, int j) {
        T auxiliar = array[i];
        array[i] = array[j];
        array[j] = auxiliar;
        contaTrocas++;
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        contaComparacoes = 0;
        contaTrocas = 0;

        for (int intervalo = array.length / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < array.length; i++) {
                int j = i;
                while (j >= intervalo) {
                    contaComparacoes++;
                    if (comparador.compare(array[j - intervalo], array[j]) <= 0) {
                        break;
                    }
                    trocar(array, j - intervalo, j);
                    j -= intervalo;
                }
            }
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> a.compareTo(b));
    }
}