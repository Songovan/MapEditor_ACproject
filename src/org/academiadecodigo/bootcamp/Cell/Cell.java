package org.academiadecodigo.bootcamp.Cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private boolean black;
    protected int cellSize = 20;
    protected Rectangle rectangle;
    protected int padding = 10;
    protected int col;
    protected int row;

    //constructor
    public Cell (int col, int row) {
        this.col = col;
        this.row = row;
        rectangle = new Rectangle(padding + col*cellSize,padding + row*cellSize, cellSize, cellSize);
    }

    //change method
    public void change () {
        if (!isBlack()) {
            black = true;
            rectangle.setColor(Color.BLACK);
            rectangle.fill();
        } else {
            black = false;
            rectangle.draw();
        }
    }

    //draw method
    public void draw(){
        rectangle.draw();
    }

    //isBlack method
    public boolean isBlack() {
        return black;
    }

    //getCol method
    public int getCol() {
        return col;
    }

    //getRow method
    public int getRow() {
        return row;
    }
}
