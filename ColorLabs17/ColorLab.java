
/**
 * Write a description of class ColorLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*; //imports color class in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
//give range to change an object
//either lighten or darken
public class ColorLab
{
    public static void main(String[] args){
        Picture p = new Picture("images\\beach.jpg");
        Picture p1 = new Picture("images\\beach.jpg");
        Picture p2 = new Picture("images\\beach.jpg");
        Picture p3 = new Picture("images\\beach.jpg");
        Picture p4 = new Picture("images\\beach.jpg");
        
        p.explore();
        
        //adjust--------------------------------------------------
        Pixel[] pixels;
        pixels = p1.getPixels();
        int red,blue,green;
        for (Pixel spot1 : pixels) {
            red = spot1.getRed();
            red = (int)(red*.25);
            spot1.setRed(red);
            blue = spot1.getBlue();
            blue = (int)(blue*Math.random());
            spot1.setBlue(blue);
        
            green = spot1.getGreen();
            green = (int)(green*Math.random());
            spot1.setGreen(green);
        }
        p1.explore();
        
        //negate--------------------------------------------------
        Pixel[] pixels1;
        pixels1 = p2.getPixels();
        for (Pixel spot1 : pixels1) {
            red = spot1.getRed();
            red = (int)(255-red);
            spot1.setRed(red);
            
            blue = spot1.getBlue();
            blue = (int)(255-blue);
            spot1.setBlue(blue);
        
            green = spot1.getGreen();
            green = (int)(255-green);
            spot1.setGreen(green);
        }
        p2.explore();
        
        //grayscale--------------------------------------------------
        Pixel[] pixels2;
        pixels2= p3.getPixels();
        for (Pixel spot1 : pixels2) {
            int avg = (int)(spot1.getAverage());
            spot1.setRed(avg);
            spot1.setBlue(avg);
            spot1.setGreen(avg);
        }
        p3.explore();
        
        //lighten--------------------------------------------------
        Pixel[] pixels3;
        pixels3= p4.getPixels();
        for (Pixel spot1 : pixels3) {
            red = spot1.getRed();
            red = (int)(2*red);
            spot1.setRed(red);
            
            blue = spot1.getBlue();
            blue = (int)(2*blue);
            spot1.setBlue(blue);
        
            green = spot1.getGreen();
            green = (int)(2*green);
            spot1.setGreen(green);
        }
        p4.explore();
        
        //change sky--------------------------------------------------
        Pixel[] pixels4;
        pixels4= p.getPixels();
        Color newColor = new Color(250,128,114);//salmon
        for (Pixel spot1 : pixels4) {
            red = spot1.getRed();
            blue = spot1.getBlue();
            green = spot1.getGreen();
            if (red>130 && red<180 && green<220 &&green>140 && blue>200 &&blue<235){
                spot1.setColor(newColor);
            }
        }
        p.explore();
    }
}
