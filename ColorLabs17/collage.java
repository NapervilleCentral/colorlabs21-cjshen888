import java.awt.*;
import java.util.*;
import java.util.List;
/**
* Write a description of class posterSample5 here.
* 1 Copyed orginal]
* 2 Mirror
*
* @author (Mr. Hayes)
* @version (Poster Project May 23)
*/
public class collage
{
    public static void main(String[] args)
    {
        Picture acanvas = new Picture("images/finalcollage.jpg");
        Picture collage = new Picture("images/chicken.jpg");
        Picture collage2 = new Picture("images/chicken.jpg");
        Picture collage3 = new Picture("images/chicken.jpg");
        Picture collage4 = new Picture("images/chicken.jpg");
        Picture collage5 = new Picture("images/chicken.jpg");
        //collage.explore();
        
        copytoCanvas(collage,acanvas,0,0); //edit canvas size 2014x3124
        
        edgeDetection(collage, 15);
        copytoCanvas(collage,acanvas,0,1208);
        
        sepia(collage2);
        copytoCanvas(collage2,acanvas,0,2416);
        
        mirrorVertical(collage3);
        copytoCanvas(collage3,acanvas,1007,0);
        
        for (int i=1;i<10;i+=1){
            copyPictureSmallerorLarger(collage4,acanvas,i, 1007,1208);
        }
        
        posterize(collage5,1);
        copytoCanvas(collage5,acanvas,1007,2416);
        
        //acanvas.explore();
        acanvas.write("images/canvas.jpg");
    }
    
    public static void posterize(Picture collage, double amount){
        Pixel[] pixels;
         pixels= collage.getPixels();
        for (Pixel spot : pixels) {
            int avg = (int)(spot.getAverage());
            Color pink = new Color(255,77,164);
            Color royalblue = new Color(97,137,255);
            Color orange = new Color(255,199,77);
            Color darkgreen = new Color(0,255,127);
            Color lightgreen = new Color(158,255,0);
            int r = spot.getRed();//doesn't matter which one you get
            if (r <= 63){
                spot.setColor(royalblue);
            } else if (r <= 128){
                spot.setColor(royalblue);
            } else if (r <= 192){
                spot.setColor(orange);
            } else {
                spot.setColor(lightgreen);
            }
        }
    }
    
    public static void copyPictureSmallerorLarger(Picture source, Picture target, int scale, int x, int y){

        Pixel sourcePix = null;
        Pixel targetPix = null;
        //loop through the columns (targetX is the starting point on the Canvas) sourceX += 2 - smaller copy every other pixel
        //                                                                     sourceX+=.5 - larger, copy every pixel twice, cast as int in the getPix & setcolor
        for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX+=scale, targetX++)
        {
            //loop through the rows                                               sourceY+=2 - smaller
            //                                                                    sourceX+=.5 - larger, copy every pixel twice
            for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY+=scale, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }
    
    public static void sepia(Picture collage) {
        Pixel[] pixels; //make more blue??
        pixels = collage.getPixels();
         for (Pixel spot : pixels) {
            int avg = (int)(spot.getAverage());
            spot.setRed(avg);
            spot.setBlue(avg);
            spot.setGreen(avg);
        }
    }
    
    /*
     * double newr = (spot.getRed()*.393)+(spot.getGreen()*.769)+(spot.getBlue()*.189)+1;
            double newg = (spot.getRed()*.349)+(spot.getGreen()*.686)+(spot.getBlue()*.168)+1;
            double newb = (spot.getRed()*.272)+(spot.getGreen()*.534)+(spot.getBlue()*.131)+1;
            Color color = new Color((int)newr,(int)newg,(int)newb);
            spot.setColor(color);
     */
    
    public static void edgeDetection(Picture collage, double amount){
        Pixel[] pixels;
        pixels = collage.getPixels();
        for (int i=0; i<pixels.length-1; i++)
        {
            int avg = (int)(pixels[i].getAverage());
            int avg2 = (int)(pixels[i+1].getAverage());
            if (Math.abs(avg-avg2)< amount){
                pixels[i].setRed(0);
                pixels[i].setBlue(0);
                pixels[i].setGreen(0);                
            } else {
                pixels[i].setRed(255);
                pixels[i].setBlue(255);
                pixels[i].setGreen(255);
            }
        }
    }
    
    /**
    * Method to mirror on a vertical line in the middle of the picture based on
    * the width
    */
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows
        for (int y = 0; y < source.getHeight(); y++)
        {
            //loop from 0 to the middle (mirror Point)
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
    * copy from source to target
    * position of int x, y for placement on the target
    */
    public static void copytoCanvas( Picture sourcePic, Picture targetPic, int x, int y)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        //width of the source must be <= to the canvas I am
        //going to copy
        //targetx and y was 100 and 100
        for (int sourceX = 0, targetX = x; sourceX<sourcePic.getWidth(); sourceX++, targetX ++)
        {
            for (int sourceY = 0, targetY = y; sourceY<sourcePic.getHeight(); sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
    }
}
