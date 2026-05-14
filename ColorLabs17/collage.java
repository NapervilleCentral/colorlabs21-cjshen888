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
        
        copytoCanvas(collage,acanvas,0,0);
        
        edgeDetection(collage, 22);
        copytoCanvas(collage,acanvas,0,1208);
        
        sepia(collage2);
        copytoCanvas(collage2,acanvas,0,2416);
        
        mirrorVertical(collage3);
        copytoCanvas(collage3,acanvas,1007,0);

        copyPictureSmallerorLarger(collage4,acanvas,1,1007,1208);
        
        stripe(collage5,100);
        copytoCanvas(collage5,acanvas,1007,2416);
        
        //acanvas.explore();
        acanvas.write("images/finalcollage.jpg");
    }
    
    public static void stripe(Picture collage, int height) {
        Pixel[] pixels = collage.getPixels();
        int width = collage.getWidth();
        for (int i = 0; i<pixels.length; i++) {
            int row = i/width;
            if ((row/height) % 2 == 0) {
                Pixel p = pixels[i];
                p.setRed(255 - p.getRed());
                p.setGreen(255 - p.getGreen());
                p.setBlue(255 - p.getBlue());
            }
        }
    }
    
    public static void copyPictureSmallerorLarger(Picture source, Picture target, int scale, int x, int y){
        if (scale >=10) 
            return;
        Pixel sourcePix = null;
        Pixel targetPix = null;
        int shiftX = (source.getWidth()-source.getWidth()/scale)/2;
        int shiftY = (source.getHeight()-source.getHeight()/scale)/2;
        //loop through the columns (targetX is the starting point on the Canvas) sourceX += 2 - smaller copy every other pixel
        //                                                                     sourceX+=.5 - larger, copy every pixel twice, cast as int in the getPix & setcolor
        for (int sourceX = 0, targetX = x+shiftX; sourceX < source.getWidth(); sourceX+=scale, targetX++)
        {
            //loop through the rows                                               sourceY+=2 - smaller
            //                                                                    sourceX+=.5 - larger, copy every pixel twice
            for (int sourceY = 0, targetY = y+shiftY; sourceY < source.getHeight(); sourceY+=scale, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        copyPictureSmallerorLarger(source,target,scale+1, x,y);
    }
    
    public static void sepia(Picture collage) {
        Pixel[] pixels; 
        pixels = collage.getPixels();
         for (Pixel spot : pixels) {
            int avg = (int)(spot.getAverage());
            spot.setRed(Math.min(255, avg+55));
            spot.setGreen(Math.min(255, avg+20));
            spot.setBlue(Math.max(0, avg-40));
        }
    } 
    
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
    * Method to mirror on a vertical line in the middle of the picture based on the width
    */
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        for (int y = 0; y < source.getHeight(); y++) //loop through all the rows
        {
            for (int x = 0; x < mirrorPoint; x++) //loop from 0 to the middle (mirror Point)
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
        //width of the source must be <= to the canvas I am going to copy
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

        //colorReplacement(collage5,60,new Color(243,124,0),Color.yellow);
        //colorReplacement(collage5,60,new Color(238,9,29),Color.blue);
        
/*public static void colorReplacement(Picture collage, double distance, Color oldcol, Color newcol) {
        Pixel[] pixels = collage.getPixels();
        for (Pixel spot : pixels) {
            if (Pixel.colorDistance(spot.getColor(), oldcol) < distance) {
                spot.setColor(newcol);
            }
        }
    }
    
    public static void posterize(Picture collage,double amount) {
        Pixel[] pixels = collage.getPixels();
        int step = (int)(255/amount);
        for (Pixel p : pixels) {
            int r = (p.getRed()/step)*step;
            int g = (p.getGreen()/step)*step;
            int b = (p.getBlue()/step)*step;
            p.setRed(r);
            p.setGreen(g);
            p.setBlue(b);
        }
    }*/
//posterize(collage5,2.3);