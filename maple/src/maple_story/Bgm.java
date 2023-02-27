package maple_story;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bgm {
	public Bgm() {
		try {
			AudioInputStream music = AudioSystem.getAudioInputStream(new File("music/FloralLife.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(music);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0); 
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}