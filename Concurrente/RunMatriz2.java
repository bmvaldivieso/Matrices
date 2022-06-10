package Concurrente;

public class RunMatriz2 {

    public static void main(String[] args) throws InterruptedException {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        Matriz2 m1 = new Matriz2(mat1Values);
        int[][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };
        Matriz2 m2 = new Matriz2(mat2Values);

        Matriz2 result = m1.multiplyWithThreads(m2);

        System.out.println(result);

    }
}
