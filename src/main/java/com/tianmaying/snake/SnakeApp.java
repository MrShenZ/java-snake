package com.tianmaying.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class SnakeApp {

    public void init() {
        // your code here: 初始化Grid
    	Grid grid=new Grid(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);
        //创建游戏窗体
        JFrame window = new JFrame("天码营贪吃蛇游戏");
        GameView gameView=new GameView(grid);
        // your code here: 初始化GameView，并放到window中
        gameView.init();
        gameView.getCanvas().setPreferredSize(new Dimension(grid.getWidth(), grid.getHeight()));
        Container contentPane=window.getContentPane();
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}