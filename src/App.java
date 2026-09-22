
public class App {
    public static Integer[] vetorDeNumeros() {
        return new Integer[] {
                88, 55, 44, 12, 10, 8
        };
    }

    public static Integer[] gerarVetorAleatorio(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }

    // para comparar tempos dos algoritmos de ordenação
    static void executarBusca() {
        int n = 100000;
        long inicio, fim, tempo;
        Integer[] numerosQuickSort = gerarVetorAleatorio(n);

        // System.out.println("Vetor gerado:"+ Arrays.toString(numerosQuickSort));
        QuickSort<Integer> quickSort = new QuickSort<>();
        System.out.println("\n *** Quick Sort ***");
        inicio = System.currentTimeMillis();
        quickSort.sort(numerosQuickSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        // System.out.println("Vetor ordenado:"+ Arrays.toString(numerosQuickSort));
        System.out.println("Comparacoes QuickSort:" + quickSort.getContaComparacoes());
        System.out.println("Trocas QuickSort:" + quickSort.getContaTrocas());
        System.out.println("Tempo(ms) do QuickSort:" + tempo + " ms");

        Busca<Integer> busca = new Busca<>();
        int valorExiste = numerosQuickSort[n / 2];
        int valorInexistente = 150;
        System.out.println("Busca Linear ");
        int pos = busca.linear(numerosQuickSort, valorExiste);
        System.out.println("Valor " + valorExiste + " posicao:" + pos);
        System.out.println("Comparacoes:" + busca.getContaComparacoes());

        System.out.println("Busca Linear  - Inexistente");
        pos = busca.linear(numerosQuickSort, valorInexistente);
        System.out.println("Valor " + valorInexistente + " posicao:" + pos);
        System.out.println("Comparacoes:" + busca.getContaComparacoes());

        System.out.println("Busca Binaria ");
        pos = busca.binaria(numerosQuickSort, valorExiste);
        System.out.println("Valor " + valorExiste + " posicao:" + pos);
        System.out.println("Comparacoes:" + busca.getContaComparacoes());

        System.out.println("Busca Binaria  - Inexistente");
        pos = busca.binaria(numerosQuickSort, valorInexistente);
        System.out.println("Valor " + valorInexistente + " posicao:" + pos);
        System.out.println("Comparacoes:" + busca.getContaComparacoes());

    }

    // para comparar tempos dos algoritmos de ordenação
    static void comparaTemposOrdenacao() {
         int n = 100000;
        long inicio, fim, tempo;
        Integer[] numerosQuickSort = gerarVetorAleatorio(n);
        Integer[] numerosSelectionSort = numerosQuickSort.clone();
        Integer[] numerosMergeSort = numerosQuickSort.clone();
        Integer[] numerosHeapSort = numerosQuickSort.clone();
        //Integer[] numerosBubbleSort = numerosQuickSort.clone();
        Integer[] numerosInsertionSort = numerosQuickSort.clone();
        Integer[] numerosShellSort = numerosQuickSort.clone();
        Integer[] numerosCountingSort = numerosQuickSort.clone();
        

        // System.out.println("Vetor gerado:"+ Arrays.toString(numerosQuickSort));
        QuickSort<Integer> quickSort = new QuickSort<>();
        System.out.println("\n *** Quick Sort ***");
        inicio = System.currentTimeMillis();
        quickSort.sort(numerosQuickSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        // System.out.println("Vetor ordenado:"+ Arrays.toString(numerosQuickSort));
        System.out.println("Comparacoes QuickSort:" + quickSort.getContaComparacoes());
        System.out.println("Trocas QuickSort:" + quickSort.getContaTrocas());
        System.out.println("Tempo(ms) do QuickSort:" + tempo + " ms");

        MergeSort<Integer> mergeSort = new MergeSort<>();
        System.out.println("\n *** Merge Sort ***");
        inicio = System.currentTimeMillis();
        mergeSort.sort(numerosMergeSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes MergeSort:" + mergeSort.getContaComparacoes());
        System.out.println("Trocas MergeSort:" + mergeSort.getContaTrocas());
        System.out.println("Tempo(ms) do MergeSort:" + tempo + " ms");

        HeapSort<Integer> heapSort = new HeapSort<>();
        System.out.println("\n *** Heap Sort ***");
        inicio = System.currentTimeMillis();
        heapSort.sort(numerosHeapSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes HeapSort:" + heapSort.getContaComparacoes());
        System.out.println("Trocas HeapSort:" + heapSort.getContaTrocas());
        System.out.println("Tempo(ms) do HeapSort:" + tempo + " ms");

        ShellSort<Integer> shellSort = new ShellSort<>();
        System.out.println("\n *** Shell Sort ***");
        inicio = System.currentTimeMillis();
        shellSort.sort(numerosShellSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes ShellSort:" + shellSort.getContaComparacoes());
        System.out.println("Trocas ShellSort:" + shellSort.getContaTrocas());
        System.out.println("Tempo(ms) do ShellSort:" + tempo + " ms");

        CountingSort<Integer> countingSort = new CountingSort<>();
        System.out.println("\n *** Counting Sort ***");
        inicio = System.currentTimeMillis();
        countingSort.sort(numerosCountingSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes CountingSort:" + countingSort.getContaComparacoes());
        System.out.println("Trocas CountingSort:" + countingSort.getContaTrocas());
        System.out.println("Tempo(ms) do CountingSort:" + tempo + " ms");

        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        System.out.println("\n *** Insertion Sort ***");
        inicio = System.currentTimeMillis();
        insertionSort.sort(numerosInsertionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes InsertionSort:" + insertionSort.getContaComparacoes());
        System.out.println("Deslocamentos InsertionSort:" + insertionSort.getContaDeslocamentos());
        System.out.println("Tempo(ms) do InsertionSort:" + tempo + " ms");

        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        System.out.println("\n *** Selection Sort ***");
        inicio = System.currentTimeMillis();
        selectionSort.sort(numerosSelectionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes SelectionSort:" + selectionSort.getContaComparacoes());
        System.out.println("Trocas SelectionSort:" + selectionSort.getContaTrocas());
        System.out.println("Tempo(ms) do SelectionSort:" + tempo + " ms");

    }

    public static void main(String[] args) {
        comparaTemposOrdenacao();
        executarBusca();
    }

}
