package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.bootcamp.Cell.Cell;
import org.academiadecodigo.bootcamp.FileManager.FileManager;

public class Grid {

    //properties
    private Cell[][] cellArrayArray;
    private FileManager fileManager;
    private int cols;
    private int rows;
    private String line = "";


    //constructor
    public Grid(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        cellArrayArray = constructGrid(cols, rows);
        fileManager = new FileManager();
    }


    //constructGrid method
    private Cell[][] constructGrid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;

        cellArrayArray = new Cell[cols][rows];

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                cellArrayArray[col][row] = new Cell(col, row);
                cellArrayArray[col][row].draw();
            }
        }
        return cellArrayArray;
    }

    //saveLine method
    public void saveLine () {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (cellArrayArray[col][row].isBlack())
                line += col + " " + row + " ";
            }
        }
        fileManager.save(line);
    }

    //loadLine
    public void loadLine () {

        String[] toRead;
        int loadCol;
        int loadRow;
        clearAll();
        toRead = fileManager.load().split(" ");
        for (int num = 0; num < toRead.length; num = num + 2) {
           loadCol = Integer.parseInt(toRead[num]);
           loadRow = Integer.parseInt(toRead[num+1]);
           cellArrayArray[loadCol][loadRow].change();
        }
    }


    //clearAll method
    public void clearAll() {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (cellArrayArray[col][row].isBlack()) {
                    cellArrayArray[col][row].change();
                }
            }
        }
    }

    //getList method
    public Cell[][] getCellArray() {
        return cellArrayArray;
    }

    //getRows method
    public int getRows() {
        return rows;
    }

    //getCols method
    public int getCols() {
        return cols;
    }
}
