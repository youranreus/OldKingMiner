package com.company;

import com.company.controller.GUIController;
import com.company.controller.GameController;
import com.company.controller.GameProcessController;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController(2);
        GameProcessController c = new GameProcessController(game);
    }
}
