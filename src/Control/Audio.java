package Control;
import Field.Settings;
import javafx.scene.media.AudioClip;

public class Audio {
	private static final String audio1="file:res/SoundChill.mp3";
	private static final String audio2="file:res/DarkSoul.mp3";
	private static AudioClip sound=new AudioClip(audio1);
	public static void setAudio(int n) {
		sound.stop();
		switch(n) {
		case 1:sound = new AudioClip(audio1);setVolume(Settings.music); break;
		case 2:sound = new AudioClip(audio2);setVolume(Settings.music*0.6); break;
		}
	}
	public static void setVolume(double n) {
		sound.stop();
		sound.setVolume(n);
		sound.play();
	}
	public static void stop() {
		sound.stop();
	}
}
