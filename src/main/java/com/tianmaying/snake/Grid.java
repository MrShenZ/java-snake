package com.tianmaying.snake;

import java.util.Arrays;
import java.util.Random;

public class Grid {
	private int speed;
	private String praise;
    public final boolean status[][];
    private final int width;
    private final int height;
    private int score;
    private Snake snake;
    private Node food;

    // 初始方向设置为向左
    private Direction snakeDirection;
    private Direction lastDirection;
    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
        status = new boolean[width][height];

        init();
    }

    public void init() {
        for (int i = 0; i < width; ++i) {
            Arrays.fill(status[i], false);
        }
        praise="小菜鸡→_→";
		speed=200;
        score=0;
        snakeDirection = Direction.LEFT;
        lastDirection=Direction.LEFT;
        initSnake();
        createFood();
    }

    /**
     * 初始化棋盘上的贪吃蛇
     * @return
     */
    private Snake initSnake() {
        snake = new Snake();

        int initialSnakeBodyLength = width / 3;
        for (int i = initialSnakeBodyLength - 1; i >= 0; --i) {
            int x = width / 2 + i;
            int y = height / 2;
            snake.getBody().addFirst(new Node(x, y));
            status[x][y] = true;
        }

        return snake;
    }

    /**
     * 随机产生一个食物（Node类型），并返回该Node
     * @return
     */
    public Node createFood() {
        int x, y;

        do {
            Random r = new Random();
            x = r.nextInt(width);
            y = r.nextInt(height);
        } while (status[x][y]);

        food = new Node(x, y);
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
        lastDirection=snakeDirection;
        if (validPosition(snakeHead)) {
            if (isFood(snakeHead)) {
                snake.addTail(snakeTail);
                score++;
                createFood();
            } else {
                dispose(snakeTail);
            }
            occupy(snakeHead);
            return true;
        }
        
        return false;
    }

    public void changeDirection(Direction newDirection) {
    	if (lastDirection.compatibleWith(newDirection) || lastDirection==newDirection) {
            snakeDirection = newDirection;
        }
    }

    public boolean validPosition(Node area) {
        int x = area.getX(), y = area.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !status[x][y];
    }

    private void dispose(Node node) {
        status[node.getX()][node.getY()] = false;
    }

    private void occupy(Node node) {
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
    public int getScore(){
    	return score;
    }
    public int speed(){
		int score=getScore();
		switch(score){
			case 100:
				speed=195;
				praise="加油！^_^";
				break;
			case 20:
				speed=190;
				praise="很棒(*^▽^*)";
				break;
			case 30:
				speed=185;
				praise="111分有福利哦！";
				break;
			case 40:
				speed=180;
				praise="大神";
				break;
			case 66:
				speed=175;
				praise="66大神";
				break;
			case 88:
				speed=190;
				praise="88大神";
				break;
			case 99:
				speed=185;
				praise="99大神";
				break;
			case 111:
				speed=180;
				praise="你通关了我可以请你喝奶茶吗";
				break;
		}
		return speed;
	}
	public String getPraise(){
		return praise;
	}
}
