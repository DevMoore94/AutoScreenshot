package brandonmoore.autosavescreenshot.main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class AutoSave {
	
	 public static void main(String[] args) {
	        try {
	        	Random ran = new Random();
	        	int num = ran.nextInt();
	            Robot robot = new Robot();
	            String format = "jpg";
	            String fileName = "FullScreenshot" + num + "." + format;
	             
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	            Process p = new ProcessBuilder("explorer.exe", "/select,C:\\screenshots\\"+fileName).start();
	             

	        } 
	        catch(AWTException e){
	        	 System.err.println(e.getMessage());
	        }
	        catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }

}
