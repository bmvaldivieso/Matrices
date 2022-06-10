package Concurrente;

public class TaskCalcElement extends Thread {
    private int element = 0;
    private int[] row;
    private int[] col;
    private int i;
    private int j;

    public TaskCalcElement(int[] row, int[] col, int i, int j) {
        this.element = getElement();
        this.col = col;
        this.row = row;
        this.i = i;
        this.j = j;
    }

    @Override
    public void run() {
        for (var i = 0; i < row.length; i++) {
            element += row[i] * col[i];
        }
    }

    public int getRowIndex() {
        return i;
    }

    public int getColIndex() {
        return j;
    }

    public int getElement() {
        return element;
    }
}
