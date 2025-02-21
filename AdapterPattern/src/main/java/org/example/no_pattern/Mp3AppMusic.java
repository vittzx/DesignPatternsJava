package org.example.no_pattern;

public class Mp3AppMusic {
    public static void main(String[] args) {
        final String fileName = "Hotel California - Eaglies";

        Mp3Player mp3Player = new Mp3Player();
        mp3Player.playMp3(fileName);

        WavPlayer wavPlayer = new WavPlayer();
        wavPlayer.playWav(fileName);

        FlacPlayer flacPlayer = new FlacPlayer();
        flacPlayer.playFlac(fileName);
    }

}

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

