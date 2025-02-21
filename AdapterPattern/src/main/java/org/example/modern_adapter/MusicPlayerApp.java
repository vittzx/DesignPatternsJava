package org.example.modern_adapter;

public class MusicPlayerApp {
    public static void main(String[] args) {
        final String fileName = "Hotel California - Eagles";

        // fileNameExtension is the parameter for the functional Interface, that can use directly the adaptees
        AudioPlayer audioPlayer = fileNameMp3 -> new Mp3Player().playMp3(fileNameMp3);
        audioPlayer.play(fileName);

        audioPlayer = fileNameWav -> new WavPlayer().playWav(fileNameWav);
        audioPlayer.play(fileName);

        audioPlayer = fileNameFlac -> new FlacPlayer().playFlac(fileNameFlac);
        audioPlayer.play(fileName);
    }
}


// interface & adapter
@FunctionalInterface
interface AudioPlayer {
    void play(String fileName);
}

// Adaptees - (who gonna be adapted)
class Mp3Player {
    public void playMp3(String fileName){
        //execute all logic and return to the "main/principal" method
        System.out.println("Executing mp3 file: " + fileName);
    }
}


class WavPlayer {
    public void playWav(String fileName){
        System.out.println("Executing wav file: " + fileName);
    }
}

class FlacPlayer {
    public void playFlac(String fileName){
        System.out.println("Executing flac file: " + fileName);
    }
}

//
