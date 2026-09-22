import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> {

	private long contaComparacoes;
	private long contaTrocas;

	public long getContaComparacoes() {
		return contaComparacoes;
	}

	public long getContaTrocas() {
		return contaTrocas;
	}

	private void merge(
			T[] array,
			int inicio,
			int meio,
			int fim,
			Comparator<T> comparador) {

		// Clona apenas o trecho [inicio..fim], não o array inteiro
		T[] auxiliar = Arrays.copyOfRange(array, inicio, fim + 1);

		int tamanhoEsquerda = meio - inicio + 1;
		int tamanhoTotal = fim - inicio + 1;

		int esquerda = 0;
		int direita = tamanhoEsquerda;

		for (int i = inicio; i <= fim; i++) {
			if (esquerda >= tamanhoEsquerda) {
				array[i] = auxiliar[direita++];
				contaTrocas++;
			} else if (direita >= tamanhoTotal) {
				array[i] = auxiliar[esquerda++];
				contaTrocas++;
			} else {
				contaComparacoes++;
				if (comparador.compare(auxiliar[esquerda], auxiliar[direita]) <= 0) {
					array[i] = auxiliar[esquerda++];
				} else {
					array[i] = auxiliar[direita++];
				}
				contaTrocas++;
			}
		}
	}

	private void mergeSort(
			T[] array,
			int inicio,
			int fim,
			Comparator<T> comparador) {

		if (inicio >= fim) {
			return;
		}

		int meio = inicio + (fim - inicio) / 2;
		mergeSort(array, inicio, meio, comparador);
		mergeSort(array, meio + 1, fim, comparador);
		merge(array, inicio, meio, fim, comparador);
	}

	public T[] sort(T[] array, Comparator<T> comparador) {
		contaComparacoes = 0;
		contaTrocas = 0;

		if (array.length > 1) {
			mergeSort(array, 0, array.length - 1, comparador);
		}

		return array;
	}

	public T[] sort(T[] array) {
		return sort(array, (a, b) -> a.compareTo(b));
	}
}