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
        Picture collage = new Picture("images\\temple.jpg");
        Picture acanvas = new Picture("images\\canvas.jpg");
        //makes an array of pixels--GIVEN YOU NEED THIS
        Pixel[] pixels;
        //gets pixels from picture and assigns to pixels array
        pixels = collage.getPixels();//GET ALL THE PIXELS
        for (Pixel spot : pixels)
        {
            //System.out.println( spot );
            spot.setRed((int)(spot.getRed() *.1));
        }

        copytoCanvas(collage,acanvas);
        mirrorVertical(collage);
        acanvas.explore();
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
    public static void copytoCanvas( Picture sourcePic, Picture targetPic)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        //width of the source must be <= to the canvas I am
        //going to copy to
        for (int sourceX = 0, targetX = 100; sourceX<sourcePic.getWidth(); sourceX++, targetX ++)
        {
            for (int sourceY = 0, targetY = 100; sourceY<sourcePic.getHeight(); sourceY++, targetY ++)
            {
                //set the target pix color of the source pix
                sourcePix = sourcePic.getPixel(sourceX,sourceY);
                targetPix = targetPic.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
            }//loop
        }//loop
    }//end of copyKatie
}
