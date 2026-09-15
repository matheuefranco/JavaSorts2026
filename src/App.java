
public class App {
    public static Integer[] vetorDeNumeros() {
        return new Integer[]{
            88 , 55, 44, 12, 10, 8
        };
    }

    public static Integer[] gerarVetorAleatorio(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }


   public static void main(String[] args) {
        int n = 50000;
        long inicio, fim, tempo;
        Integer[] numerosSelectionSort = gerarVetorAleatorio(n);
        Integer[] numerosBubbleSort = numerosSelectionSort.clone();
        Integer[] numerosInsertionSort = numerosSelectionSort.clone();
        Integer[] numerosQuickSort = numerosSelectionSort.clone();


        //System.out.println("Vetor gerado:"+ Arrays.toString(numeros));
        QuickSort<Integer> quickSort = new QuickSort<>();
        System.out.println("\n *** Quick Sort ***");
        inicio = System.currentTimeMillis();
        quickSort.sort(numerosQuickSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        //System.out.println("Vetor ordenado:"+ Arrays.toString(numeros));
        System.out.println("Comparacoes QuickSort:"+quickSort.getContaComparacoes());
        System.out.println("Trocas QuickSort:"+quickSort.getContaTrocas());
        System.out.println("Tempo(ms) do QuickSort:"+tempo+" ms");

        // Insertion Sort
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        System.out.println("\n *** ISort Sort ***");
        inicio = System.currentTimeMillis();
        insertionSort.sort(numerosInsertionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes ISort:"+insertionSort.getContaComparacoes());        
        System.out.println("Deslocamentos ISort:"+insertionSort.getContaDeslocamentos());        
        System.out.println("Tempo(ms) do InsertionSort:"+tempo+" ms");


        
        //System.out.println("Vetor gerado:"+ Arrays.toString(numeros));
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        System.out.println("\n *** Selection Sort ***");
        inicio = System.currentTimeMillis();
        selectionSort.sort(numerosSelectionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        //System.out.println("Vetor ordenado:"+ Arrays.toString(numeros));
        System.out.println("Comparacoes Selection:"+selectionSort.getContaComparacoes());
        System.out.println("Trocas Selection:"+selectionSort.getContaTrocas());
        System.out.println("Tempo(ms) do Selection:"+tempo+" ms");

        // Bubble Sort
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        System.out.println("\n *** Bubble Sort ***");
        inicio = System.currentTimeMillis();
        bubbleSort.sort(numerosBubbleSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes Bubble Sort:"+bubbleSort.getContaComparacoes());
        System.out.println("Trocas Bubble Sort:"+bubbleSort.getContaTrocas());
        System.out.println("Tempo(ms) do BubbleSort:"+tempo+" ms");

    }
}
