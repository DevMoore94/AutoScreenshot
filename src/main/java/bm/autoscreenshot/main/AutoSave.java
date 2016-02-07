package bm.autoscreenshot.main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import bm.autoscreenshot.util.*; 

public class AutoSave 
{
	
	 public static void main(String[] args) 
	 {
	        try 
	        {	
	        	Random ran = new Random();
	        	int num = ran.nextInt();
	            Robot robot = new Robot();
	            
	            String format = "jpg";
	            String fileName = "FullScreenshot" + num + "." + format;
	             
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	            
	            //Triggers windows explorer folder that file was saved in
	            Process p = new ProcessBuilder("explorer.exe", "/select,C:\\screenshots\\"+fileName).start();
	             
	        } 
	        catch(AWTException e1)
	        {
	        	 System.err.println(e1.getMessage());
	        }
	        catch (IOException e2) 
	        {
	            System.err.println(e2.getMessage());
	        }
	        catch (Exception e3)
	        {
	        	System.err.println(e3.getMessage());
	        }
	    }

}
