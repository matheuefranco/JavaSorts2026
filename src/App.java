
public class App {
    public static Integer[] vetorDeNumeros() {
        return new Integer[]{
            10, 14, 63, 29, 95
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
        int n = 150000;
        long inicio, fim, tempo;
        Integer[] numeros = gerarVetorAleatorio(n);
        Integer[] numerosBubbleSort = numeros.clone();
        //System.out.println("Vetor gerado:"+ Arrays.toString(numeros));
        SelectionSort selectionSort = new SelectionSort<>();
        inicio = System.currentTimeMillis();
        selectionSort.sort(numeros);
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
        System.out.println("Tempo(ms) do BubbleSort:"+tempo);



    }
}
