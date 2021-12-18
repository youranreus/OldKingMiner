package com.company.utils;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayWav {

    public PlayWav(String file) {
        try {
            // read wav file to audio stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
            // read audio format from stream
            AudioFormat audioFormat = audioInputStream.getFormat();
            // SourceDataLine info
            Info dataLineInfo = new Info(SourceDataLine.class, audioFormat);

            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while ((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }

            audioInputStream.close();
            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
}
