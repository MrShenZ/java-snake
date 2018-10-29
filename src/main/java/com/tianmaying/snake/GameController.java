package com.tianmaying.snake;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private final Grid grid;
    private final GameView gameView;

    public GameController(Grid grid, GameView gameView) {
        this.grid = grid;
        this.gameView = gameView;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // your code here
    	int code=e.getKeyCode();
    	if(code==KeyEvent.VK_UP){
    		grid.changeDirection(Direction.UP);
    	}else if(code==KeyEvent.VK_RIGHT){
    		grid.changeDirection(Direction.RIGHT);
    	}else if(code==KeyEvent.VK_DOWN){
    		grid.changeDirection(Direction.DOWN);
    	}else if(code==KeyEvent.VK_LEFT){
    		grid.changeDirection(Direction.LEFT);
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
