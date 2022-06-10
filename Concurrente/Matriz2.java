package Concurrente;

import java.util.ArrayList;
import java.util.List;

public class Matriz2 {
    private int[][] values;

    public Matriz2(int[][] values) {
        this.values = values;
    }

    public int[] getRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < values.length) {
            return values[rowIndex];
        } else {
            throw new IllegalArgumentException("Indice no válido");
        }
    }

    public int[] getColumn(int colIndex) {
        int[] output = new int[values.length];
        if (colIndex < values[0].length) {
            for (var i = 0; i < values.length; i++) {
                output[i] = values[i][colIndex];
            }
        }
        return output;
    }

    public String toString() {
        String output = "";
        for (var fila : values) {
            output += "{";
            for (var value : fila) {
                output += value + "\t";
            }
            output += "}\n";
        }
        return "{\n" + output + "}";
    }

    public Matriz2 multiplyWithThreads(Matriz2 mat2) throws InterruptedException {
        List<TaskCalcElement> threads;

        if (values.length == mat2.values[0].length) {
            int[][] output = new int[values.length][mat2.values[0].length];
            threads = new ArrayList<>();

            for (var i = 0; i < output.length; i++) {
                for (var j = 0; j < output[0].length; j++) {
                    TaskCalcElement thread = new TaskCalcElement(getRow(i), mat2.getColumn(j), i, j);
                    thread.start();
                    threads.add(thread);
                }
            }
            setWaitThreads(threads);
            for (var t : threads) {
                output[t.getRowIndex()][t.getColIndex()] = t.getElement();
            }

            return new Matriz2(output);
        } else {
            throw new IllegalArgumentException("No se puede multiplicar");
        }
    }

    private static void setWaitThreads(List<TaskCalcElement> threads) throws InterruptedException {
        for (var t : threads) {
            t.join();
        }
    }

}
