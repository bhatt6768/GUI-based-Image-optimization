/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import miniproject.Maingui;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author bhatt9697
 */
class ImgArea extends Canvas {

    Image orImg;
    BufferedImage orBufferedImage;
    BufferedImage bimg;
    BufferedImage bimg1;
    BufferedImage bi;
    float e;
    float radian;
    Dimension ds;
   public int mX;
    public int x1, y1,mX1,mY1;
    public int mY; 
    public int x;
    public int y;
    JLabel label;
    static boolean imageLoaded;
    boolean action;
    boolean actionSlided;
    boolean actionResized;
    boolean actionCompressed;
    boolean actionTransparent;
    boolean actionRotated;
    boolean actionDraw;
    boolean drawn;
    MediaTracker mt;
    static Color c;
    Color colorTextDraw;
    Robot rb;
    boolean dirHor;
    String imgFileName;
    String fontName;
    int fontSize;
    String textToDraw;

    public ImgArea() {

        try {
            rb = new Robot(); //create Robot object
        } catch (AWTException e) {
        }

       ds = getToolkit().getScreenSize(); //get the screen size 

        mX = (int) ds.getWidth()/2; //half of the screen width
        mY = (int) ds.getHeight() /2;//half of the screen height

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        //draw the iamge//create Graphics2D object   
        if (imageLoaded) {
            
        mX1 = (int) ds.getWidth() /2-500; //half of the screen width
        mY1 = (int) ds.getHeight() / 2;//half of the screen height
               x1=mX1 - orImg.getWidth(this)/2-500;
                y1= mY1 - orImg.getHeight(this)/2;
 
                //move to coordinate (x,y) 
                
              
                 y = mY - bimg.getHeight() / 2;
               
                g2d.drawImage(orImg, x1,y,750,750, null);
            //draw the update image
            if (actionSlided || actionResized || actionTransparent || actionRotated || drawn) {

                x = mX - bimg.getWidth() /2;
               // y = mY - bimg.getHeight() / 2;
 
                //move to coordinate (x,y) 
                
                       
                //add label to applet
             
               
                g2d.drawImage(bimg, x, y, null);
               

            } else {
                x = mX - orBufferedImage.getWidth() / 2;
            
            y = mY - orBufferedImage.getHeight() / 2;
            g2d.translate(x, y); //move to  coordinate (x,y)
            g2d.drawImage(orBufferedImage, 0, 0, null); //draw image

        }
        g2d.dispose(); //clean the Graphic2D object

    }
    }
  

    //The KList class extends the KeyAdpater class to implement the keyPressed method
    //to handle the key event of the Canvas
    //set the selected color to the c variable
    public void setColor(Color color) {
        c = color;
    }
    //set the image filename to the imgFileName variable

    public void setImgFileName(String fname) {
        imgFileName = fname;
    }
    //initialize variables

    public void initialize() {
        imageLoaded = false;
        actionSlided = false;
        actionResized = false;
        actionCompressed = false;
        actionTransparent = false;
        actionRotated = false;
        actionDraw = false;
        drawn = false;
        action = false;
        dirHor = false;
        c = null;
        radian = 0.0f;
        e = 0.0f;
    }

    //cancel the image editing so we reset the drawing area
    public void reset() {
        if (imageLoaded) {
            prepareImage(imgFileName);
            repaint();
        }

    }
    //Rotate the image shown on the program interface

    public void makeImageRotate(BufferedImage image, int w, int h) {

        BufferedImage bis = (BufferedImage) createImage(w, h);
        Graphics2D g2d = (Graphics2D) bis.createGraphics();
        radian = (float) Math.PI / 2; //angle     
        g2d.translate(w / 2, h / 2);// move to coordinate (w/2,h/2)
        g2d.rotate(radian); //rotate the image
        g2d.translate(-h / 2, -w / 2);
        bimg = bis;//move the coordinate back
        g2d.drawImage(image, 0, 0, null);
        //draw the rotated image
        //update the image so now you see the rotated image
        g2d.dispose();

    }
    //The rotateImage invokes the makeImageRotate method to rotate the image

    public void rotateImage() {
        BufferedImage bis;
        //rotate update image
        if (actionSlided || actionResized || actionTransparent || actionRotated || drawn) {
            bis = bimg;
        } //rotate the original image 
        else {
            bis = orBufferedImage;
        }

        makeImageRotate(bis, bis.getHeight(), bis.getWidth());

        actionRotated = true; //set the actionRotated to true to indicate that 
        //the image is rotated
        repaint(); //repaint the update image

    }
 public void resizeImage(int w,int h){
    BufferedImage bi=(BufferedImage)createImage(w,h);
    Graphics2D g2d=(Graphics2D)bi.createGraphics();
    //resize the update image
 
    if(actionSlided || actionTransparent || actionRotated ||drawn)
     g2d.drawImage(bimg,0,0,w,h,null);
    //resize the original image
    else
     g2d.drawImage(orImg,0,0,w,h,null);
    bimg=bi;
    g2d.dispose();
   
  }
 

   
  
 
 
    //The resizeImage method has code to resize the image
    //This method is invoked when the user clicks OK button on the image resize window
    //The image resize window is displayed when you select the Image resize sub-menu item
    //Prepare the image so it is ready to display and editable
    public void prepareImage(String filename) {
        initialize();
        try {
            //track the image loading
            mt = new MediaTracker(this);
            orImg = Toolkit.getDefaultToolkit().getImage(filename);
            mt.addImage(orImg, 0);

            mt.waitForID(0);
            //get the image width and height  
          int width =750;
   int height=750;

            //create buffered image from the image so any change to the image can be made
            orBufferedImage = createBufferedImageFromImage(orImg, width, height, false);
            //create the blank buffered image
            //the update image data is stored in the buffered image
          
            
           
            bimg=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imageLoaded = true; //now the image is loaded

        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public void toGray(BufferedImage image, int w, int h) {
        BufferedImage bis = (BufferedImage) createImage(w, h);
        Graphics2D g2d = (Graphics2D) bis.createGraphics();
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed() * 0.21);
                int green = (int) (c.getGreen() * 0.72);
                int blue = (int) (c.getBlue() * 0.07);
                int sum = red + green + blue;
                Color newColor = new Color(sum, sum, sum);
                image.setRGB(j, i, newColor.getRGB());

            }
        }
        bimg = bis;

        g2d.drawImage(image, 0, 0, null); //draw the rotated image
        g2d.dispose();
        //update the image so now you see the rotated image
    }

    public void tograyscale() {
        BufferedImage bis;
        //rotate update image
        if (actionSlided || actionResized || actionTransparent || actionRotated || drawn) {
            bis = bimg;
        } //rotate the original image 
        else {
            bis = orBufferedImage;
        }

        toGray(bis, bis.getHeight(), bis.getWidth());

        //set the actionRotated to true to indicate that 
        //the image is rotated
        repaint(); //repaint the update image

    }

    public void tonegative(BufferedImage image, int w, int h) {
        BufferedImage bis = (BufferedImage) createImage(w, h);
        Graphics2D g2d = (Graphics2D) bis.createGraphics();
        int width = image.getWidth();
        int height = image.getHeight();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int p = image.getRGB(i, j);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                //subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                //set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(i, j, p);
                bimg = bis;
            }
        }

        g2d.drawImage(image, 0, 0, null); //draw the rotated image
        g2d.dispose();
        //update the image so now you see the rotated image
    }

    public void negative() {
        BufferedImage bis;
        //rotate update image

        bis = orBufferedImage;

        tonegative(bis, bis.getHeight(), bis.getWidth());

        //set the actionRotated to true to indicate that 
        //the image is rotated
        repaint(); //repaint the update image

    }

    //The filterImage method applies brightness to the image when the knob of the image slider is 
    //making changed.
    //When the value of the image slider changes it affects the e variable
    //so the image is brighter or darker
    public void filterImage() {
        float[] elements = {0.0f, 1.0f, 0.0f, -1.0f, e, 1.0f, 0.0f, 0.0f, 0.0f};
        Kernel kernel = new Kernel(3, 3, elements);  //create keynel object to encapsulate the elements array
        ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null); //create ConvolveOp to encapsulate 
        //the kernel
        bimg = new BufferedImage(orBufferedImage.getWidth(), orBufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        cop.filter(orBufferedImage, bimg); //start filtering the image 
        //the filtered image is stored in the bimg buffered image
        //now the image increases or decreases its brightness   
    }

    public void saveToFile(String filename) {
        String ftype = filename.substring(filename.lastIndexOf('.') + 1);
        try {
            //save the compressed image
            //we separate the compression action from other actions on the image
            if (actionSlided || actionResized || actionTransparent || actionRotated || drawn) {
                ImageIO.write(bimg, ftype, new File(filename));
            } else {
                ImageIO.write(orBufferedImage, ftype, new File(filename));
            }

        } catch (IOException e) {
            System.out.println("Error in saving the file");
        }
    }

    //set a value to e variable 
    //this method is invoked when the user makes change to the  image slider
    public void setValue(float value) {
        e = value;
    }

    //Set a boolean value the actionSlided variable 
    public void setActionSlided(boolean value) {
        actionSlided = value;
    }
    //Set a boolean value the actionResized variable   

    public void setActionResized(boolean value) {
        actionResized = value;
    }
    //Set a boolean value the actionCompressed variable   

    public void setActionCompressed(boolean value) {
        actionCompressed = value;
    }
    //Set a boolean value the actionDraw variable   

    public void setActionDraw(boolean value) {
        actionDraw = value;

    }

    //The createBufferedImageFromImage method is abled to generate a buffered image from an input image
    public BufferedImage createBufferedImageFromImage(Image image, int width, int height, boolean tran) {
        BufferedImage dest;
          
        if (tran) {
            dest = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        } else {
            dest = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g2 = dest.createGraphics();
         g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(image, 0, 0,width,height, null);
        g2.dispose();
        return dest;
    }
    
   
    


    //Save the image file
    //Assign values to the variables used in drawing text on the image
}
