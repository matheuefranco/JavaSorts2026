
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



    public static void main(String[] args) throws Exception {
        int n = 50000;
        long inicio, fim, tempo;
        Integer[] numerosSelectionSort = gerarVetorAleatorio(n);
        Integer[] numerosBubbleSort = numerosSelectionSort.clone();
        Integer[] numerosInsertionSort = numerosSelectionSort.clone();

        // Insertion Sort
        InsertionSort insertionSort = new InsertionSort<>();
        inicio = System.currentTimeMillis();
        insertionSort.sort(numerosInsertionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo(ms) do InsertionSort:"+tempo);
        System.out.println("Comparacoes ISort:"+insertionSort.getContaComparacoes());        
        System.out.println("Deslocamentos ISort:"+insertionSort.getContaDeslocamentos());        

        
        //System.out.println("Vetor gerado:"+ Arrays.toString(numeros));
        SelectionSort selectionSort = new SelectionSort<>();
        inicio = System.currentTimeMillis();
        selectionSort.sort(numerosSelectionSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        //System.out.println("Vetor ordenado:"+ Arrays.toString(numeros));
        System.out.println("Comparacoes Selection:"+selectionSort.getContaComparacoes());
        System.out.println("Trocas Selection:"+selectionSort.getContaTrocas());
        System.out.println("Tempo(ms) do Selection:"+tempo);

        // Bubble Sort
        BubbleSort bubbleSort = new BubbleSort<>();
        inicio = System.currentTimeMillis();
        bubbleSort.sort(numerosBubbleSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Comparacoes Bubble Sort:"+bubbleSort.getContaComparacoes());
        System.out.println("Trocas Bubble Sort:"+bubbleSort.getContaTrocas());
        System.out.println("Tempo(ms) do BubbleSort:"+tempo);

        


    }
}
