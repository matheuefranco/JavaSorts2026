import java.util.Comparator;

public class QuickSort<T extends Comparable<T>> {

    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    private void trocar(T[] v, int i, int j) {
        T aux = v[i];
        v[i] = v[j];
        v[j] = aux;

        contaTrocas++;
    }

    private int particionar(
            T[] v,
            int inicio,
            int fim,
            Comparator<T> comparador) {

        // Pivô: elemento central do vetor/subvetor
        int meio = inicio + (fim - inicio) / 2;
        T pivot = v[meio];

        int esquerda = inicio;
        int direita = fim;

        while (esquerda <= direita) {

            while (true) {
                contaComparacoes++;

                if (comparador.compare(v[esquerda], pivot) < 0) {
                    esquerda++;
                } else {
                    break;
                }
            }

            while (true) {
                contaComparacoes++;

                if (comparador.compare(v[direita], pivot) > 0) {
                    direita--;
                } else {
                    break;
                }
            }

            if (esquerda <= direita) {

                if (esquerda != direita) {
                    trocar(v, esquerda, direita);
                }

                esquerda++;
                direita--;
            }
        }

        return esquerda;
    }

    private void quickSort(
            T[] v,
            int inicio,
            int fim,
            Comparator<T> comparador) {

        if (inicio >= fim) {
            return;
        }

        int indice = particionar(v, inicio, fim, comparador);

        if (inicio < indice - 1) {
            quickSort(v, inicio, indice - 1, comparador);
        }

        if (indice < fim) {
            quickSort(v, indice, fim, comparador);
        }
    }

    public T[] sort(T[] array, Comparator<T> comparador) {

        this.contaComparacoes = 0;
        this.contaTrocas = 0;

        if (array.length > 1) {
            quickSort(
                    array,
                    0,
                    array.length - 1,
                    comparador);
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> a.compareTo(b));
    }
}