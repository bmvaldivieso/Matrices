package Secuencial;

public class RunMatriz {
    public static void main(String[] args) {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        Matriz m1 = new Matriz(mat1Values);
        int[][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };
        Matriz m2 = new Matriz(mat2Values);

        Matriz result = m1.multiply(m2);

        System.out.println(result);
    }
}
