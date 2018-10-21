package com.tianmaying.snake;

/**
 * 贪吃蛇前进的方向
 */
public enum Direction {

    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private final int directionCode;

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

    public int directionCode() {
        return directionCode;
    }

    /**
     * 判断方向改变是否有效，例如从向上变为向下为无效，从向上变为向左为有效
     * @param direction
     * @return
     */
    public boolean compatibleWith(Direction direction) {
        switch(direction){
        case UP:
        	LEFT.equals(true);
        	RIGHT.equals(true);
        	DOWN.equals(false);
        	UP.equals(false);
        	break;
        case RIGHT:
        	UP.equals(true);
        	DOWN.equals(true);
        	LEFT.equals(false);
        	RIGHT.equals(false);
        	break;
        case DOWN:
        	LEFT.equals(true);
        	RIGHT.equals(true);
        	DOWN.equals(false);
        	UP.equals(false);
        	break;
        case LEFT:
        	UP.equals(true);
        	DOWN.equals(true);
        	LEFT.equals(false);
        	RIGHT.equals(false);
        	break;
        }
        return true;
    }
    public static void main(String args[]){
    	
    }
}
