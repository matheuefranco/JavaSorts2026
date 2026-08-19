import java.util.*;

public class BubbleSort<T extends Comparable<T>> {
    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaTrocas() {
        return contaTrocas;
    }

    private void troca(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        this.contaTrocas++;
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int fase = 1; fase < n; fase++) {
            // j controla comparações
            for (int j = 0; j < n - fase; j++) {
                this.contaComparacoes++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
                }
            }
        }
        return array;
    }// fim sort

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }

    public T[] sortVerbose(T[] array, Comparator<T> comparator) {
        int n = array.length;
        int comparacoes = 0;
        for (int fase = 1; fase < n; fase++) {
            System.out.println("Fase " + fase + ": " + Arrays.toString(array));
            // j controla comparações
            for (int j = 0; j < n - fase; j++) {
                System.out.println("Comparando: " + array[j] + " e " + array[j + 1]);
                comparacoes++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    System.out.println("Trocando: " + array[j] + " e " + array[j + 1]);
                    troca(array, j, j + 1);
                }
            }
        }
        System.out.println("Total de comparações: " + comparacoes);
        return array;
    }// fim sort

    public T[] sortVerbose(T[] array) {
        return sortVerbose(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }

    public T[] sortOtimizado(T[] array, Comparator<T> comparator) {
        int n = array.length;
        int comparacoes = 0;
        boolean trocou = false;
        for (int fase = 1; fase < n; fase++) {
            System.out.println("Fase " + fase + ": " + Arrays.toString(array));
            // j controla comparações
            for (int j = 0; j < n - fase; j++) {
                System.out.println("Comparando: " + array[j] + " e " + array[j + 1]);
                comparacoes++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    System.out.println("Trocando: " + array[j] + " e " + array[j + 1]);
                    trocou = true;
                    troca(array, j, j + 1);
                }
            }
            // acabou de terminar a fase
            if(!trocou)
                break; // para a execução das fases
            else
                trocou = false;
        }
        System.out.println("Total de comparações: " + comparacoes);
        return array;
    }// fim sort

    public T[] sortOtimizado(T[] array) {
        return sortOtimizado(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }

}
