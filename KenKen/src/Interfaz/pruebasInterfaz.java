/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author krisc
 */
public class pruebasInterfaz {
    
    public static void playMusic(){
        try{
            File path= new File("scr/sonido/aplausos.wav");
            if (path.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                JOptionPane.showMessageDialog(null, "Holi");
            }else{
                System.out.println("Can't find file");
            }
        }catch(HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println("Rayos");
        }
    }
    
    public static void main(String[] args) {
        pruebasInterfaz.playMusic();
    }
}
