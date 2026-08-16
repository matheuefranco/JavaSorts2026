
public class App {
     public static Integer[] vetorDeNumeros() {
        return new Integer[]{
            10, 14, 63, 29, 95
        };
    }


    public static void main(String[] args) throws Exception {
        Integer[] numeros = vetorDeNumeros();
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sortVerbose(numeros);
    }
}
