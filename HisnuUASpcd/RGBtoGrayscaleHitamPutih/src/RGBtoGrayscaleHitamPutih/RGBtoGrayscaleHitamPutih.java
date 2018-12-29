/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGBtoGrayscaleHitamPutih;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Amigo Paradise
 */

public class RGBtoGrayscaleHitamPutih {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedImage img = null;
    File f = null;

    //read image
    try{
      f = new File("E:\\Kuliah\\Semester 5\\Pengolahan Citra Digital\\HisnuUASpcd\\Jhon.jpg");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }

    //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();

    //convert to grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        //calculate average
        int avg = (r+g+b)/3;

        //replace RGB value with avg
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }

    //write image
    try{
      f = new File("E:\\Kuliah\\Semester 5\\Pengolahan Citra Digital\\HisnuUASpcd\\Jhon-grayscale.png");
      ImageIO.write(img, "png", f);
    }catch(IOException e){
      System.out.println(e);
    }
        
    }
    
}
