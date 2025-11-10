
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*; //imports color class in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();*/

     //opens a picture using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //Know it, Love it, Live it ON TEST----------------------
     //relative path                dir/folder/file
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture moto = new Picture("images/redMotorcycle.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     //apic.explore(); //DISPLAYS THE PICTURE ------------------------
     ferris1.explore();
     moto.explore();
     
     //makes an array of pixels ----have to do for every picture
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
     
     Pixel[] mpixels;
     mpixels = moto.getPixels();
    
     //how many pixels or how large array ------- not tested on arrays
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    
    //setting colors with pixel documentation
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,283);
    Pixel ferr17 = pixels[17];
    
    ferr17.setGreen(160);
    ferr17.setBlue(200);
    ferr17.setRed(240);//MUST explore again to see it
    
    Color newColor = new Color(250,128,114);//salmon
    spot.setColor(newColor);
    spot2.setColor(Color.blue);
    
    
    ferris1.explore();
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    
    for (int i = 0; i < 10000; i++){
        Pixel yuck = ferris1.getPixel((int)(Math.random()*600), (int)(Math.random()*600));
        yuck.setColor(Color.green);
    }
    ferris1.explore();
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/**/
   // FOR EACH loop to access indexes of array or collection----------------------
    int red;
    int blue,green;
    //for each loop spot  is a ?
    for (Pixel spot1 : mpixels) {
        //System.out.println( spot1 );
        red = spot1.getRed();
        red = (int)(red*.25);
        spot1.setRed(red);
    }
    moto.explore();
    for (Pixel spot1 : mpixels) {
        blue = spot1.getBlue();
        blue = (int)(blue*Math.random());
        spot1.setBlue(blue);
        
        green = spot1.getGreen();
        green = (int)(green*Math.random());
        spot1.setGreen(green);
    }
    
    moto.explore();
   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
