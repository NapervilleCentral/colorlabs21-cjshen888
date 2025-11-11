
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
          /*
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();*/
         
         //relative path
         //Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/Claire.jpg");
         Picture me1 = new Picture("images/Claire.jpg");
         Picture me2 = new Picture("images/Claire.jpg");
         
         /** 63,64,64,64 ---- (0,63) (64,127) (128,192) (193,255)
          * method 1 change
          */
         Pixel[] pixels;
         pixels= me.getPixels();
         for (Pixel spot : pixels) {
            int avg = (int)(spot.getAverage());
            spot.setRed(avg);
            spot.setBlue(avg);
            spot.setGreen(avg);
            
            Color darkblue = new Color(0,0,139);
            Color red = new Color(0,0,139);
            Color lightblue = new Color(224,255,255);
            Color offwhite = new Color(255,250,205);
            int r = spot.getRed();//doesn't matter which one you get
            if (r >= 0 && r <= 63){
                spot.setColor(darkblue);
            } else if (r >= 64 && r <= 127){
                spot.setColor(red);
            } else if (r >= 64 && r <= 127){
                spot.setColor(lightblue);
            } else {
                spot.setColor(offwhite);
            }
         }
         me.explore();
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

         //this writes a copy of the pic!!!! RENAME PIC!!!!
         me1.write("images/SFTry1.jpg");
    }//main       
}//class
