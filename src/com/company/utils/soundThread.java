package com.company.utils;

import java.net.MalformedURLException;

public class soundThread extends Thread{

    sound bgm;

    boolean play = false;
    boolean first = true;

    public soundThread(String url) throws MalformedURLException {
        bgm = new sound(url);
        this.start();
    }

    public void play() {
        this.play = true;
    }

    @Override
    public void run() {
        super.run();
        while(this.play || this.first) {
            try {
                this.bgm.play();
                this.play = false;
                this.first = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
