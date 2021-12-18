package com.company.utils;

import java.applet.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class sound {

    private final AudioClip ac;

    private final String url;

    private final File f;

    private final URL Audio;

    public sound(String _url) throws MalformedURLException {
        this.url = _url;
        this.f = new File(this.url);
        this.Audio = f.toURL();
        ac = Applet.newAudioClip(Audio);
    }

    public void play() throws InterruptedException {
        ac.play();
        Thread.sleep(5000);
    }
}
