package dannyssohawt;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DannysSoHawt {
	
		static String randWordList = "";
		static String[] randWordArr;
		static JLabel backgroundText;
		
	public static void main(String[] argumentos) throws Exception {
		
		//System.in.read();
		System.out.write("Hi".getBytes());
		
		JFrame startFrame = new JFrame("starting");
		startFrame.setSize(10000, 0);
		startFrame.setVisible(true);
		
		
		
		BufferedReader input = new BufferedReader(new FileReader("words.txt"));
		
		int i = 0;
		String line;
		while((line = input.readLine())  != null) {
			System.out.println(i);
			randWordList += line + '\n';
			i++;
		}
		
		input.close();
		
		randWordArr = randWordList.split("\n");
		System.out.println(randWordArr[0]);
		
		startFrame.setVisible(false);
		startFrame.dispose();
		
		JFrame frame = new JFrame();
		frame.setTitle("random words");
		frame.setSize(500, 500);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		JLabel l = new JLabel("Danny", SwingConstants.CENTER);
		l.setSize(100, 100);
		l.setLocation(50, 250);
		l.setFont(new Font("Arial", Font.BOLD, 145));
		
		/*
		backgroundText = new JLabel("tryt6uyrdfyu6tyrd", SwingConstants.LEFT);
		backgroundText.setSize(100, 100);
		backgroundText.setLocation(0, 0);
		backgroundText.setFont(new Font("Arial", Font.BOLD, 15));
		*/
		
		frame.add(l);
		//frame.add(backgroundText);
		
		frame.setVisible(true);
		
		while(true) {
			
			Color color = new Color((int)(Math.random() * 0x1000000)).brighter().brighter();
			String s = getRandWord();
			
			Thread.sleep(500);
			
			l.setText(s);
			l.setForeground(getContrastColor(color));
			//addToBackground(s);
			
			frame.getContentPane().setBackground(color);
			
		}
		
	}
	
	static void addToBackground(String s) {
		//String toAdd = s;
		
		//if(backgroundText.getText().split("\n")[0].length() > 100){
		//	toAdd += '\n';
		//}
		
		//backgroundText.setText(backgroundText.getText() + toAdd);
	}
	
	public static Color getContrastColor(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		int a = color.getAlpha();
		
		r = r % 255;
		g = g % 255;
		b = b % 255;
		
		//return new Color(r, g, b, a);
		return new Color(0,0,0);
	}
	
	public static String getRandWord() {
		return randWordArr[(int)(Math.random() * randWordArr.length)];
	}
}
