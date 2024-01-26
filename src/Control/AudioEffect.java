package Control;

import Field.Settings;
import javafx.scene.media.AudioClip;

public class AudioEffect {
	private static final String stone="file:res/stone2.wav";
	private static final String run="file:res/run.wav";
	private static final String spike="file:res/spike.wav";
	private static final String warp="file:res/warp.wav";
	private static final String posion="file:res/potion.wav";
	private static final String box="file:res/box.wav";
	private static AudioClip sound=new AudioClip(run);
	
	public static void setAudio(String st) {
		
		sound.stop();
		switch(st) {
		case "run":sound = new AudioClip(run);setVolume(Settings.sound); break;
		case "stone":sound = new AudioClip(stone);setVolume(Settings.sound); break;
		case "spike":sound = new AudioClip(spike);setVolume(Settings.sound); break;
		case "warp":sound = new AudioClip(warp);setVolume(Settings.sound); break;
		case "posion":sound = new AudioClip(posion);setVolume(Settings.sound); break;
		case "box":sound = new AudioClip(box);setVolume(Settings.sound); break;
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