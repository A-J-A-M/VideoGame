/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author jordi
 */
public class Sound {
    public static long clipTime;
    public static Clip clip;
    
    public long getClipTime() {
        return clipTime;
    }

    public void setClipTime(long clipTime) {
        this.clipTime = clipTime;
    }
    public static void loopMusic(String filepath){
        try {
            File file = new File(filepath);
            if (file.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audio);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(20f*(float)Math.log10(0.5));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                JOptionPane.showMessageDialog(null, "Music path not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in music");
        }
    }
    public static void playMusic(String filepath){
        try {
            File file = new File(filepath);
            if (file.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            } else {
                JOptionPane.showMessageDialog(null, "Music path not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error in music");
        }
    }
    public static void pauseMusic(){
        try {
            clipTime = clip.getMicrosecondPosition();
            clip.stop();
        } catch (Exception e) {
        }
    }
    public static void resumeMusic(){
        try {
            clip.setMicrosecondPosition(clipTime);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) { 
        }
    }
    public static void stopMusic(){
        try {
            clip.stop();
        } catch (Exception e) {
        }
    }
}
