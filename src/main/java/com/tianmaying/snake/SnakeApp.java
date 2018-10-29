package com.tianmaying.snake;

import javax.swing.*;
import java.awt.*;

public class SnakeApp {
    
    Grid grid;
    GameView gameView;
    GameController gameController;

    public void init() {

        grid = new Grid(Settings.DEFAULT_GRID_WIDTH / Settings.DEFAULT_NODE_SIZE,
                Settings.DEFAULT_GRID_HEIGHT / Settings.DEFAULT_NODE_SIZE);

        JFrame window = new JFrame("天码营贪吃蛇游戏");
        Container contentPane = window.getContentPane();
        gameView = new GameView(grid);
        gameView.init();
        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        GameController controller=new GameController(grid, gameView);
        window.addKeyListener(controller);
        // your code here： 初始化gameController，并为window设置监听器
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}