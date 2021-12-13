package juegoSnake;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(Audio.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	}
	
	public static Clip LoadSound(String direction){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Audio.class.getResource(direction)));
			return clip;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
