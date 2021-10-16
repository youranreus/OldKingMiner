package com.company;

import com.company.controller.GameProcessController;
import com.company.controller.GameController;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        GameController game = new GameController(2);
        GameProcessController c = new GameProcessController(game);
        c.start();
    }
}
