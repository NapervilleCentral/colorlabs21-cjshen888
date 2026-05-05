/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*; // the color class is in the awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class PosterMain
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/ //what does this do
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //KNOW IT, LOVE IT, LIVE IT (will be on the test)
     //relative path (will be on the test) - dir/folder/file
     Picture parthenon = new Picture("images/temple.jpg");
     mirrorVertical(parthenon);
     parthenon.explore();
     //copyToCanvas(apic, acanvas, 0, 0);
  }//main
 
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
     
      //loop through all the rows //source.getHeight()
      for (int y = 0; y < 159; y++)
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
   * copy one pic to another pic/canvas
   * add two ints to the params to place you want picture on the target
   */
  public static void copyToCanvas(Picture source, Picture target, int x, int y)
  {
      Pixel sourcePix = null;
      Pixel targetPix = null;
     
      //loop through the columns (targetX is the starting point on the Canvas) sourceX += 2 - smaller copy every other pixel
        //                                                                     sourceX+=.5 - larger, copy every pixel twice, cast as int in the getPix & setcolor
      for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
      {
          //loop through the rows                                               sourceY+=2 - smaller
          //                                                                    sourceX+=.5 - larger, copy every pixel twice
          for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
          {
              sourcePix = source.getPixel(sourceX, sourceY);
              targetPix = target.getPixel(targetX, targetY);
              targetPix.setColor(sourcePix.getColor());
          }
      }
  }
}//class