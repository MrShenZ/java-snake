package com.tianmaying.snake;


public class Grid {
    private Snake snake;
    {
    	snake=new Snake();
    }
    private int width;
    private int height;
    public Grid(int width, int height) {
        this.width=width;
        this.height=height;
    }
    public Snake getSnake(){
    	return snake;
    }
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
    }
}
