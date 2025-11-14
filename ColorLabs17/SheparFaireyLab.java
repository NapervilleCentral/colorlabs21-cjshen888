
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
         Picture me = new Picture("images/Claire.jpg");
         Picture me1 = new Picture("images/Claire.jpg");
         Picture me2 = new Picture("images/Claire.jpg");
         me.explore();
         
         Color darkblue = new Color(0,0,139);
         Color red = new Color(139,0,0);
         Color lightblue = new Color(224,255,255);
         Color offwhite = new Color(255,250,205);
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
            int r = spot.getRed();//doesn't matter which one you get
            if (r <= 63){
                spot.setColor(darkblue);
            } else if (r <= 128){
                spot.setColor(red);
            } else if (r <= 192){
                spot.setColor(lightblue);
            } else {
                spot.setColor(offwhite);
            }
         }
         me.explore();
         me.write("images/METHOD1.jpg");
         /**
          * method 2 change
          */
         int b = 0;
         int s = 255;
         Pixel[] pixels1;
         pixels1= me1.getPixels();
         for (Pixel spot : pixels1) {
            int avg = (int)(spot.getAverage());
            if (avg >= b) {
                b = avg;
            } else if (avg <= s)
                s = avg; 
            }
            int part = (int)(b-s)/4;
         for (Pixel spot : pixels1) {
            int r = spot.getRed();
            if (r >= 0 && r <= part){
                spot.setColor(darkblue);
            } else if (r >= part && r <= part*2){
                spot.setColor(red);
            } else if (r >= part*2 && r <= part*3){
                spot.setColor(lightblue);
            } else {
                spot.setColor(offwhite);
            }
         }
         me1.explore();
         me1.write("images/METHOD2.jpg");
         /**
          * custom color palette
          */
         //color palettte #1
         Color pink = new Color(255,77,164);
         Color royalblue = new Color(97,137,255);
         Color orange = new Color(255,199,77);
         Color darkgreen = new Color(0,255,127);
         Color lightgreen = new Color(158,255,0);
         
         //color palette #2
         Color r1 = new Color(255,99,71);
         Color r2 = new Color(178,34,34);
         Color r3 = new Color(255,160,122);
         Color r4 = new Color(255,215,0);
         Color r5 = new Color(255,192,203);
         
         //color palette #3
         Color b1 = new Color(0,128,128);
         Color b2 = new Color(32,178,170);
         Color b3 = new Color(64,224,208);//(102,205,170);
         Color b4 = new Color(175,238,238);
         Color b5 = new Color(224,255,255);
         
         //color palette #4
         Color s1 = new Color(25,25,112);//midnight
         Color s2 = new Color(65,105,225);//royal blue
         Color s3 = new Color(100,149,237);//cornflower blue
         Color s4 = new Color(255,160,122);//salmon
         Color s5 = new Color(250,128,114); //light salmon
         Color s6 = new Color(255,228,181); //moccasin
         Pixel[] pixels2;
         pixels2= me2.getPixels();
         for (Pixel spot : pixels2) {
            int avg = (int)(spot.getAverage());
            spot.setRed(avg);
            spot.setBlue(avg);
            spot.setGreen(avg);
            int r = spot.getRed();
             //Try 1---------------------------------------------------
            /*if (r <= 63){
                spot.setColor(royalblue);
            } else if (r <= 128){
                spot.setColor(pink);
            } else if (r <= 192){
                spot.setColor(orange);
            } else {
                spot.setColor(green);
            } 
            */
            // Try 2: added fifth color  ----------------------------------------------------
            /*if (r <= 63){
                spot.setColor(royalblue);
            } else if (r <= 128){
                spot.setColor(pink);
            } else if (r <= 192){
                spot.setColor(orange);
            } else if (r<= 220){
                spot.setColor(lightgreen);
            } else {
                spot.setColor(darkgreen);
            }*/
            //Try 3: different shades of same color --------------------------------------------------
            /*if (r <= 63){
                spot.setColor(b1);
            } else if (r <= 128){
                spot.setColor(b2);
            } else if (r <= 192){
                spot.setColor(b3);
            } else if (r<= 220){
                spot.setColor(b4);
            } else if (r<=240){
                spot.setColor(s5);*/
            //Try 4: 
            if (r <= 63){
                spot.setColor(s1);
            } else if (r <= 130){
                spot.setColor(s2);
            } else if (r <= 200){
                spot.setColor(s3);
            } else if (r<= 210){
                spot.setColor(s4);
            } else if (r<=220){
                spot.setColor(s5);
            } else {
                spot.setColor(s6);
            }
        }
         me2.explore();
         me2.write("images/SFTry3.jpg");
         //this writes a copy of the pic!!!! RENAME PIC!!!!
    }//main       
}//class
