import java.util.Comparator;

public class HeapSort<T extends Comparable<T>> {

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

    private void ajustarHeap(
            T[] array,
            int tamanho,
            int raiz,
            Comparator<T> comparador) {

        int maior = raiz;
        int filhoEsquerdo = 2 * raiz + 1;
        int filhoDireito = 2 * raiz + 2;

        if (filhoEsquerdo < tamanho) {
            contaComparacoes++;
            if (comparador.compare(array[filhoEsquerdo], array[maior]) > 0) {
                maior = filhoEsquerdo;
            }
        }

        if (filhoDireito < tamanho) {
            contaComparacoes++;
            if (comparador.compare(array[filhoDireito], array[maior]) > 0) {
                maior = filhoDireito;
            }
        }

        if (maior != raiz) {
            trocar(array, raiz, maior);
            ajustarHeap(array, tamanho, maior, comparador);
        }
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        contaComparacoes = 0;
        contaTrocas = 0;

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            ajustarHeap(array, array.length, i, comparador);
        }

        for (int fim = array.length - 1; fim > 0; fim--) {
            trocar(array, 0, fim);
            ajustarHeap(array, fim, 0, comparador);
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> a.compareTo(b));
    }
}