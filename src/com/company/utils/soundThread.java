package com.company.utils;

import java.net.MalformedURLException;

public class soundThread extends Thread{

    String audioUrl;

    boolean play = false;

    boolean first = true;

    public soundThread(String url) {
        this.audioUrl = url;
        this.start();
    }

    public void play() {
        this.play = true;
        System.out.println("播放音频");
        new PlayWav(this.audioUrl);
    }

    @Override
    public void run() {
        while(this.first) {
            if(this.play) {
                new PlayWav(this.audioUrl);
                this.play = false;
            }
        }
    }
}
