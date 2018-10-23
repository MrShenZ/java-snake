package com.tianmaying.snake;

import java.util.LinkedList;
import java.util.Random;

public class Grid {

    public final boolean status[][];
    private final int width;
    private final int height;

    private Snake snake;
    private Node food;

    // 初始方向设置为向左
    private Direction snakeDirection = Direction.LEFT;
    
    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
        status = new boolean[width][height];

        initSnake();
        createFood();
    }

    /**
     * 初始化棋盘上的贪吃蛇
     * @return
     */
    private Snake initSnake() {
        snake = new Snake();
        LinkedList<Node> body=snake.getBody();
        for(int i=0;i<getWidth()/3;++i){
        	Node node=new Node((getWidth()/2)+i,getHeight()/2);
        	body.add(node);
        	noPlace(node);
        }
        // your code here：用一个循环设置Snake的Body并更新棋盘覆盖状态
        return snake;
    }

    /**
     * 随机产生一个食物（Node类型），并返回该Node
     * @return
     */
    public Node createFood() {
    	Random random=new Random();
        // your code here
    	boolean flag=false;
        while(flag==false){
        	int x =random.nextInt(getWidth());
        	int y=random.nextInt(getHeight());
        	food = new Node(x,y);
        	flag=validPosition(food);
        }
        return food;
    }

    /**
     * 贪吃蛇往snakeDirection方向移动一格
     *
     * @return 如果游戏结束，返回false，否则返回true
     */
    public boolean nextRound() {
        Node snakeTail = snake.move(snakeDirection);
        Node snakeHead = snake.getHead();

        // your code here

        return false;
    }
    
    public void changeDirection(Direction newDirection) {
        if (snakeDirection.compatibleWith(newDirection)) {
            snakeDirection = newDirection;
        }
    }

    public boolean validPosition(Node area) {
        int x = area.getX(), y = area.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !status[x][y];
    }

    private void place(Node node) {
        status[node.getX()][node.getY()] = false;
    }

    private void noPlace(Node node) {
        status[node.getX()][node.getY()] = true;
    }


    public boolean isFood(Node area) {
        int x = area.getX(), y = area.getY();
        return x == food.getX() && y == food.getY();
    }

    public Node getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
