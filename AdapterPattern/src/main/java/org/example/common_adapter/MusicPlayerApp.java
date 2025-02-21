package org.example.common_adapter;

public class MusicPlayerApp{

    public static void main(String[] args) {
        final String fileName = "Hotel California - Eagles";

        AudioPlayer audioPlayer = new Mp3Player();
        audioPlayer.play(fileName);

        audioPlayer = new FlacAdapter(new FlacPlayer());
        audioPlayer.play(fileName);

        audioPlayer = new WavAdapter(new WavPlayer());
        audioPlayer.play(fileName);
    }
}


// interface

interface AudioPlayer {
    void play(String fileName);
}

// Adaptees -> Call the "API's"

class Mp3Player implements AudioPlayer {
    public void play(String fileName){
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

// Adaptaders

class WavAdapter implements AudioPlayer{

    private final WavPlayer wavPlayer;

    public WavAdapter(WavPlayer wavPlayer){
        this.wavPlayer = wavPlayer;
    }

    @Override
    public void play(String fileName){
        wavPlayer.playWav(fileName);
    }
}


class FlacAdapter implements AudioPlayer{

    private final FlacPlayer flacPlayer;

    public FlacAdapter(FlacPlayer flacPlayer){
        this.flacPlayer = flacPlayer;
    }


    @Override
    public void play(String fileName) {
        flacPlayer.playFlac(fileName);
    }
}