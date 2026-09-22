
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
        int n = 100000;
        long inicio, fim, tempo;
        Integer[] numerosQuickSort = gerarVetorAleatorio(n);

        //System.out.println("Vetor gerado:"+ Arrays.toString(numerosQuickSort));
        QuickSort<Integer> quickSort = new QuickSort<>();
        System.out.println("\n *** Quick Sort ***");
        inicio = System.currentTimeMillis();
        quickSort.sort(numerosQuickSort);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        //System.out.println("Vetor ordenado:"+ Arrays.toString(numerosQuickSort));
        System.out.println("Comparacoes QuickSort:"+quickSort.getContaComparacoes());
        System.out.println("Trocas QuickSort:"+quickSort.getContaTrocas());
        System.out.println("Tempo(ms) do QuickSort:"+tempo+" ms");

        Busca<Integer> busca = new Busca<>();
        int valorExiste = numerosQuickSort[n/2];
        int valorInexistente = 150;
        System.out.println("Busca Linear ");
        int pos = busca.linear(numerosQuickSort, valorExiste);
        System.out.println("Valor "+ valorExiste + " posicao:"+pos);
        System.out.println("Comparacoes:"+ busca.getContaComparacoes());

        System.out.println("Busca Linear  - Inexistente");
        pos = busca.linear(numerosQuickSort, valorInexistente);
        System.out.println("Valor "+ valorInexistente + " posicao:"+pos);
        System.out.println("Comparacoes:"+ busca.getContaComparacoes());
     
        System.out.println("Busca Binaria ");
        pos = busca.binaria(numerosQuickSort, valorExiste);
        System.out.println("Valor "+ valorExiste + " posicao:"+pos);
        System.out.println("Comparacoes:"+ busca.getContaComparacoes());

        System.out.println("Busca Binaria  - Inexistente");
        pos = busca.binaria(numerosQuickSort, valorInexistente);
        System.out.println("Valor "+ valorInexistente + " posicao:"+pos);
        System.out.println("Comparacoes:"+ busca.getContaComparacoes());

        

    }
}
