
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * Claire Shen
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
         /**
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
         //me.explore();
         //me.write("images/METHOD1.jpg");
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
         //me1.explore();
         //me1.write("images/METHOD2.jpg");
         /**
          * custom color palette
          */
         Color pink = new Color(255,77,164);
         Color royalblue = new Color(97,137,255);
         Color orange = new Color(255,199,77);
         Color darkgreen = new Color(0,255,127);
         Color lightgreen = new Color(158,255,0);

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
                spot.setColor(lightgreen);
            }*/
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
            //Try 3: more color buckets --------------------------------------------------
            /*if (r <= 30){
                spot.setColor(new Color(70, 110, 220)); //dark blue
            }else if (r< 63){
                spot.setColor(royalblue);
            } else if (r<90){
                spot.setColor(new Color(230, 60, 150)); //darker pink
            }else if (r <= 128){
                spot.setColor(pink);
            } else if (r <= 155){
                spot.setColor(new Color(245, 175, 85)); //orange
            } else if (r <= 195){
                spot.setColor(orange);
            } else if (r<= 210){
                spot.setColor(lightgreen);
            } else{
                spot.setColor(new Color(150, 240, 10)); //darker green
            }*/
            //Final Try 4: gradient-------------------------------------
            if (r <= 30){
                spot.setColor(new Color(65, 100, 230));// deep blue
            }else if (r < 63){
                spot.setColor(royalblue); 
            } else if (r <= 100) {
                spot.setColor(new Color(235, 70, 155));//darkpink
            } else if (r <= 125) {
                spot.setColor(pink);
            } else if (r <= 140) {
                spot.setColor(new Color(255, 130, 130));//pinkish orange
            } else if (r <= 165) {
                spot.setColor(new Color(245, 175, 85));//dark orange
            } else if (r <= 200) {
                spot.setColor(orange);
            } else if (r <= 210) {
                spot.setColor(lightgreen);
            } else { 
                spot.setColor(new Color(145, 235, 20));//darker green
            }
         }
         me2.explore();
         me2.write("images/SFmyFinal.jpg");
    }//main       
}//class