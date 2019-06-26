package org.academiadecodigo.bootcamp.Cell;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Selector extends Cell implements KeyboardHandler {

    //properties
    private Grid grid;

    //constructor
    public Selector (Grid grid) {
        super(0,0);
        this.grid = grid;
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        configureKeyboard();

    }

    //configureKeyboard method
    public void configureKeyboard () {

        //keyboard instance
        Keyboard keyboard = new Keyboard(this);

        //Event Keys
        KeyboardEvent eventSpace = new KeyboardEvent();
        KeyboardEvent eventW = new KeyboardEvent();
        KeyboardEvent eventA = new KeyboardEvent();
        KeyboardEvent eventS = new KeyboardEvent();
        KeyboardEvent eventD = new KeyboardEvent();
        KeyboardEvent eventO = new KeyboardEvent();
        KeyboardEvent eventP = new KeyboardEvent();
        KeyboardEvent eventK = new KeyboardEvent();
        //Set Events
        eventSpace.setKey(KeyboardEvent.KEY_SPACE);
        eventW.setKey(KeyboardEvent.KEY_W);
        eventA.setKey(KeyboardEvent.KEY_A);
        eventS.setKey(KeyboardEvent.KEY_S);
        eventD.setKey(KeyboardEvent.KEY_D);
        eventO.setKey(KeyboardEvent.KEY_O);
        eventP.setKey(KeyboardEvent.KEY_P);
        eventK.setKey(KeyboardEvent.KEY_K);

        //Set Event Type
        eventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventO.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventK.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //Keyboard Event Listener
        keyboard.addEventListener(eventSpace);
        keyboard.addEventListener(eventW);
        keyboard.addEventListener(eventA);
        keyboard.addEventListener(eventS);
        keyboard.addEventListener(eventD);
        keyboard.addEventListener(eventO);
        keyboard.addEventListener(eventP);
        keyboard.addEventListener(eventK);

    }

    //keyPressed method
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A && this.getCol() > 0) {
            col--;
            rectangle.translate(-cellSize, 0);
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_D && this.getCol() < grid.getCols() - 1) {
            col++;
            rectangle.translate(cellSize, 0);
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_S && this.getRow() < grid.getRows() - 1) {
            row++;
            rectangle.translate(0, cellSize);
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_W && this.getRow() > 0) {
            row--;
            rectangle.translate(0, -cellSize);
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            grid.getCellArray()[col][row].change();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_O) {
            grid.saveLine();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_P) {
            grid.loadLine();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
            grid.clearAll();
        }
    }

    //TODO moveUp, moveDown, moveLeft, moveRight

    //keyReleased method
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
