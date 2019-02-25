/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_npl;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author COMPUTER MSI
 */
public class SplashClass {
    public static void main (String[] arg) {
        Splashscreen sp = new Splashscreen();
        sp.setVisible(true);
        //UIMAIN u = new UIMAIN();
        Home h = new Home();
        playSound("Sound\\\\Sweep2.wav");
                try {
                    for(int i = 0; i <101; i++){
                        Thread.sleep (20);
                        sp.jLabel1.setText(Integer.toString(i));
                        sp.jProgressBar1.setValue(i);
                        
                        if(i==100){
                            sp.setVisible(false);
                            h.setVisible(true);
                            //u.setVisible(true);
                            playMusic("Sound\\\\POL-final-act-short.wav");
                        }
                    }
                }catch(Exception e) {  
                    e.printStackTrace();
                }  
    }
    public static void playSound (String filepath){
        InputStream music;
                try {
                        music = new FileInputStream(new File(filepath));
                        AudioStream audios = new AudioStream(music);
                        AudioPlayer.player.start(audios);
                     
                }catch(Exception e) {  
                    
                }  
    }
    public static void playMusic (String filepath){
        InputStream music;
                try {
                        AudioData data = new AudioStream(new FileInputStream(filepath)).getData();
                        ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
                        AudioPlayer.player.start(sound);
                     
                }catch(Exception e) {  
                    
                }  
    }
}
