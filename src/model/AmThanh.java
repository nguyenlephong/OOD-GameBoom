package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Timer;

import javax.sound.sampled.*;

public class AmThanh{
	public static final String Sound_Bomb ="sound/bomb.wav";
	public static final String Sound_BombNoDai ="sound/bombNoDai.wav";
	public static final String Sound_Item ="sound/item.wav";
	public static final String Sound_Backgound ="sound/bg.wav";
	public static final String Sound_Die ="sound/die.wav";
	public static final String Sound_GameOver ="sound/gameover.wav";
	//public static final String Sound_Background ="sound/gameover.wav";
	
	
	public static void music(String url) {
		SourceDataLine soundLine = null;
		int BUFFER_SIZE = 64 * 1024; // 64 KB

		try {
			File soundFile = new File(url);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat audioFormat = audioInputStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			soundLine = (SourceDataLine) AudioSystem.getLine(info);
			soundLine.open(audioFormat);
			soundLine.start();
			int nBytesRead = 0;
			byte[] sampledData = new byte[BUFFER_SIZE];
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
				if (nBytesRead >= 0) {
					soundLine.write(sampledData, 0, nBytesRead);
				}
			}
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} finally {
			soundLine.drain();
			soundLine.close();
		}
	}
}