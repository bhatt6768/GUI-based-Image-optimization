/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import miniproject.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bhatt9697
 */
class  Maingui extends JFrame implements ActionListener{
  
 ImgArea ia;
 JFileChooser chooser; 
 JMenuBar mainmenu;
 JMenu menu;
 JMenu editmenu;
  JMenu processmenu;
 JLabel label;
 JLabel label4;
 JMenuItem mopen;
 JMenuItem msaveas;
 int X1,Y1;
 JMenuItem msave;
 JMenuItem mexit; 
 JMenuItem mbright; 
 JMenuItem mcompress; 
 JMenuItem mresize;
 JMenuItem mrotate;
 JMenuItem mtransparent;
 JMenuItem maddtext;
 JMenuItem mcancel;
 JMenuItem mgrayscale;
  JMenuItem mnegative;
  JMenuItem mthresold;
   JMenuItem mresampling;
  JButton b;
  double kilobytes;
  double bytes;
  
 String filename;
 Maingui(){
  ia=new ImgArea();
  JButton b = new JButton("save");
  Container cont=getContentPane();
 /* Dimension ds = getToolkit().getScreenSize(); //get the screen size 

        X1 = (int) ds.getWidth() / 2; //half of the screen width
        Y1 = (int) ds.getHeight() / 2;//half of the screen height*/
   b.setBounds(1900,1500,150,50);
    b.setActionCommand("save");
  b.addActionListener(this);
  cont.add(b);
 JLabel label= new JLabel();
         label.setText("original Image"+kilobytes);     
 label.setBounds(900, 500, 120, 120);
 JLabel label1= new JLabel();
         label1.setText("Optimized Image");
 label1.setBounds(1500, 500, 120, 120);
 JSeparator jSeparator1 = new javax.swing.JSeparator();
 jSeparator1.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
       
        
jSeparator1.setBounds(1400, 110, 60, 1440);
cont.add(jSeparator1);
 JTabbedPane jTabbedPane1 = new javax.swing.JTabbedPane();
  JPanel      jPanel1 = new javax.swing.JPanel();
 JCheckBox  jCheckBox1 = new javax.swing.JCheckBox();
  JCheckBox      jCheckBox2 = new javax.swing.JCheckBox();
        JSlider jSlider2 = new javax.swing.JSlider();
  
jTabbedPane1.setBackground(new java.awt.Color(0, 204, 153));

jTabbedPane1.setBounds(20, 1560, 2620, 360);
jPanel1.setBounds(250, 150, 1020, 1390);

    jTabbedPane1.addTab("ImageAdjustment", jPanel1);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

       
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jCheckBox1.setText("Negative");
       
        jCheckBox2.setText("GRAY-SCALE");
        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                       
                        .addGap(175, 175, 175)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)))
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2073, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(9, 9, 9)
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jCheckBox2)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        
                        .addContainerGap())))
        );

        
        cont.add(jTabbedPane1);
    
        cont.add(jCheckBox1);
         cont.add(jCheckBox2);
       
        
 cont.add(label);
 cont.add(label1);
 cont.add(ia,BorderLayout.CENTER );  
  mainmenu=new JMenuBar();
  menu=new JMenu("File");
  menu.setMnemonic(KeyEvent.VK_F);
 
 
  
    
  
  mopen=new JMenuItem("Open...");
  mopen.setMnemonic(KeyEvent.VK_O);
  mopen.addActionListener(this);

  msaveas=new JMenuItem("Save as...");
  msaveas.setMnemonic(KeyEvent.VK_S);
  msaveas.addActionListener(this);

  msave=new JMenuItem("Save");
  msave.setMnemonic(KeyEvent.VK_V);
  msave.addActionListener(this);  

  mexit=new JMenuItem("Exit");
  mexit.setMnemonic(KeyEvent.VK_X);
  mexit.addActionListener(this);
  menu.add(mopen);
  //menu.add(msaveas);
  menu.add(msave);
  menu.add(mexit);  

  editmenu=new JMenu("Edit");
  editmenu.setMnemonic(KeyEvent.VK_E);
  mbright=new JMenuItem("Image brightness");
  mbright.setMnemonic(KeyEvent.VK_B);
  mbright.addActionListener(this);

  maddtext=new JMenuItem("Add text on image");
  maddtext.setMnemonic(KeyEvent.VK_A);
  maddtext.addActionListener(this);  

  mresize=new JMenuItem("Image resize");
  mresize.setMnemonic(KeyEvent.VK_R);
  mresize.addActionListener(this);
 
  mcompress=new JMenuItem("Image compression");
  mcompress.setMnemonic(KeyEvent.VK_P);
  mcompress.addActionListener(this);

  mrotate=new JMenuItem("Image rotation");
  mrotate.setMnemonic(KeyEvent.VK_T);
  mrotate.addActionListener(this);

  mtransparent=new JMenuItem("Image transparency");
  mtransparent.setMnemonic(KeyEvent.VK_T);
  mtransparent.addActionListener(this);
 
  mcancel=new JMenuItem("Cancel editing");
  mcancel.setMnemonic(KeyEvent.VK_L);
  mcancel.addActionListener(this);
  
   processmenu=new JMenu("Process");
   processmenu.setMnemonic(KeyEvent.VK_P);
   mgrayscale=new JMenuItem("Gray Scale");
 
  mgrayscale.addActionListener(this);
  
  
  mnegative=new JMenuItem("Negative");
 
  mnegative.addActionListener(this);
  mthresold=new JMenuItem("Thresold");
 
  mthresold.addActionListener(this);
   mresampling=new JMenuItem("Resampling");
 
  mresampling.addActionListener(this);

  editmenu.add(maddtext);
  editmenu.add(mbright);
  editmenu.add(mcompress);
  editmenu.add(mresize);
  editmenu.add(mrotate);
 // editmenu.add(mtransparent);
  editmenu.add(mcancel);
   
  processmenu.add(mgrayscale);
  processmenu.add(mnegative);
  processmenu.add(mthresold);
   processmenu.add(mresampling);
  
  mainmenu.add(menu);
  mainmenu.add(editmenu);
  mainmenu.add(processmenu);
  setJMenuBar(mainmenu);
  
  setTitle("Image Editor");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
     setVisible(true); 

  chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "gif","bmp","png");
      chooser.setFileFilter(filter);
      
      chooser.setMultiSelectionEnabled(false);
  enableSaving(false);
  ia.requestFocus();
  }
    
  private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

 
  ////start the ImageBrightness class
 //The ImageBrightness class represents the interface to allow the user to make the image 
 //brighter or darker by changing the value of the image slider
 //The ImageBrightness class is in the Main class
 public class ImageBrightness extends JFrame implements ChangeListener{
  JSlider slider;
 
  ImageBrightness(){
  addWindowListener(new WindowAdapter(){
     public void windowClosing(WindowEvent e){
      dispose();
      
     }
    });
  Container cont=getContentPane();  
  slider=new JSlider(-5,5,0); 
  slider.setEnabled(false);
  slider.addChangeListener(this);
  cont.add(slider,BorderLayout.CENTER); 
  slider.setEnabled(true);
  setTitle("Image brightness");
  setPreferredSize(new Dimension(300,100));
  setVisible(true);
  pack();
  enableSlider(false);
  }
  public void enableSlider(boolean enabled){
   slider.setEnabled(enabled);
  }
  public void stateChanged(ChangeEvent e){
    ia.setValue(slider.getValue()/10.0f);
  
    ia.setActionSlided(true); 
    ia.filterImage();
    ia.repaint();
  
    enableSaving(true);
   
  }

 }

////end of the ImageBrightness class
public class ImageResize extends JFrame implements ActionListener {
  JPanel panel;
  JTextField txtWidth;
  JTextField txtHeight;
  JButton btOK;
  ImageResize(){
  setTitle("Image resize");
  //setDefaultCloseOperation(EXIT_ON_CLOSE);
  setPreferredSize(new Dimension(400,100));
  
  btOK=new JButton("OK");
  btOK.setBackground(Color.BLACK);
  btOK.setForeground(Color.BLUE);  
  btOK.addActionListener(this);

  txtWidth=new JTextField(4);
  txtWidth.addKeyListener((KeyListener) new KeyList());
  txtHeight=new JTextField(4);
  txtHeight.addKeyListener((KeyListener) new KeyList());
  panel=new JPanel();
  panel.setLayout(new FlowLayout());
  panel.add(new JLabel("Width:"));
  panel.add(txtWidth);
  panel.add(new JLabel("Height:"));
  
  panel.add(txtHeight);
  panel.add(btOK);
  panel.setBackground(Color.GRAY);
  add(panel, BorderLayout.CENTER);
  setVisible(true);
  pack();
  enableComponents(false);
  }
  //This method can be invoked to  enable the text boxes of image width and height
  public void enableComponents(boolean enabled){
   txtWidth.setEnabled(enabled);
   txtHeight.setEnabled(enabled);
   btOK.setEnabled(enabled);
  }
  //This method works when you click the OK button to resize the image
  public void actionPerformed(ActionEvent e){
   if(e.getSource()==btOK){
    ia.setActionResized(true);     
    ia.resizeImage(Integer.parseInt(txtWidth.getText()),Integer.parseInt(txtHeight.getText()));
    enableSaving(true);
    ia.repaint();
    }
  }
  
  
  
  
  //Restrict the key presses
  //Only number, backspace, and delete keys are allowed
  public class KeyList extends KeyAdapter{
     public void keyTyped(KeyEvent ke){
 
    char c = ke.getKeyChar(); 
    int intkey=(int)c;
    if(!(intkey>=48 && intkey<=57 || intkey==8 || intkey==127))
     {
     ke.consume(); //hide the unwanted key
  
      }  
     
   }
  
  } 
 }////end of the ImageResize class
 ////start the ImageResize class
 //The ImageResize class represents the interface that allows you to resize the image 
 //by making changes to its width and height
 //The ImageResize class is in the Main class
 public class TextAdd extends JFrame implements ActionListener {
  JPanel panel;
  JTextArea txtText;
  JComboBox cbFontNames;
  JComboBox cbFontSizes;
  JButton btOK;
  JButton btSetColor;
  String seFontName;
  Color colorText;
  int seFontSize;
  TextAdd(){
  colorText=null;
  setTitle("Add text to the image");
  //setDefaultCloseOperation(EXIT_ON_CLOSE);
  setPreferredSize(new Dimension(400,150));
  
  btOK=new JButton("OK");
  btOK.setBackground(Color.BLACK);
  btOK.setForeground(Color.BLUE);  
  btOK.addActionListener(this);

  btSetColor=new JButton("Set text color");
  btSetColor.setBackground(Color.BLACK);
  btSetColor.setForeground(Color.WHITE);  
  btSetColor.addActionListener(this);

  txtText=new JTextArea(1,30);
  cbFontNames=new JComboBox();
  cbFontSizes=new JComboBox();
  panel=new JPanel();
  panel.setLayout(new GridLayout(4,1));
  panel.add(new JLabel("Text:"));
  panel.add(txtText);
  panel.add(new JLabel("Font Name:"));  
  panel.add(cbFontNames);
  panel.add(new JLabel("Font Size:"));  
  panel.add(cbFontSizes);
  panel.add(btSetColor);
  panel.add(btOK);
  panel.setBackground(Color.GRAY);
  add(panel, BorderLayout.CENTER);
  setVisible(true);
  pack();
  listFonts();
  }

  
  public void actionPerformed(ActionEvent e){
   if(e.getSource()==btOK){ //the button OK is clicked so the text is ready to place on the image
    ia.setActionDraw(true); 
    String textDraw=txtText.getText(); 
    String fontName=cbFontNames.getSelectedItem().toString();
    int fontSize=Integer.parseInt(cbFontSizes.getSelectedItem().toString());
   // ia.setText(textDraw,fontName,fontSize,colorText);
    dispose();
    }
   else if(e.getSource()==btSetColor){ //show color chooser dialog for color selection
    JColorChooser jser=new JColorChooser();   
    colorText=jser.showDialog(this,"Color Chooser",Color.BLACK);
     
   }
  }
  
  //The listFonts method get all available fonts from the system 
  public void listFonts(){
   //get the available font names and add them to the font names combobox
   GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment(); 
   String[] fonts=ge.getAvailableFontFamilyNames();
   for(String f:fonts)
    cbFontNames.addItem(f);
   //Initialize font sizes
   for(int i=8;i<50;i++)
    cbFontSizes.addItem(i);
   
  }
 }

 //handling events of sub-menu items on the main program interface
 public void actionPerformed(ActionEvent e){
      if(e.getSource()==b){
     showSaveFileDialog(); 
   
    }
  // JButton b=(JButton)(e.getSource());
  JMenuItem source = (JMenuItem)(e.getSource());
  if(source.getText().compareTo("Open...")==0)
    {
    setImage();
    
    ia.repaint();
      validate();
      
     }
  else if(source.getText().compareTo("Save as...")==0)
    {
    showSaveFileDialog(); 
    
      
     }
  else if(source.getText().compareTo("Save")==0)
    {
       showSaveFileDialog(); 
 // ia.saveToFile(filename);  
     }
  /* else if(b.getActionCommand().compareTo("save")==0)
    {
     
 showSaveFileDialog(); 
     }*/
  else if(source.getText().compareTo("Add text on image")==0)
    {
    new TextAdd(); 
    }

  else if(source.getText().compareTo("Image brightness")==0)
    {
     
        ImageBrightness ib=new ImageBrightness(); 
    if(ImgArea.imageLoaded)
     ib.enableSlider(true); 
   
   
    
     }
  else if(source.getText().compareTo("Image compression")==0)
    {
    if(ImgArea.imageLoaded){
     ia.setActionCompressed(true);
     enableSaving(true);
     } 
     }
  
  else if(source.getText().compareTo("Image resize")==0)
    {
     
     ImageResize ir=new ImageResize();
    if(ImgArea.imageLoaded)
     ir.enableComponents(true);  
  
    
     }
  else if(source.getText().compareTo("Image rotation")==0)
    {
     
    if(ImgArea.imageLoaded){
     ia.rotateImage();
     enableSaving(true);
     } 
    }
   else if(source.getText().compareTo("Gray Scale")==0)
    {
     
    if(ImgArea.imageLoaded){
     
   ia.tograyscale();
   enableSaving(true);
     } 
    }
   else if(source.getText().compareTo("Negative")==0)
    {
     
    if(ImgArea.imageLoaded){
     
   ia.negative();
   enableSaving(true);
     } 
    }
    else if(source.getText().compareTo("Resampling")==0)
    {
     
    if(ImgArea.imageLoaded){
     //ia.blurImage();
     
   //ia.resampling();
   enableSaving(true);
     } 
    }
   
    else if(source.getText().compareTo("Thresold")==0)
    {
     
    if(ImgArea.imageLoaded){
     
   
     } 
    }
  
  else if(source.getText().compareTo("Image transparency")==0){
   if(ImgArea.c==null){
    JOptionPane dialog=new JOptionPane();
    dialog.showMessageDialog(this,"Click the background area of the image first","Error",JOptionPane.ERROR_MESSAGE);
   }
   else if(ImgArea.imageLoaded){
   
    enableSaving(true);
    }
  } 
  
  else if(source.getText().compareTo("Cancel editing")==0) {
    ia.setImgFileName(filename);
    ia.reset();
    }
  
  else if(source.getText().compareTo("Exit")==0) 
    System.exit(0);
     
    
  } 
   public void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {                                        
         if(ImgArea.imageLoaded){
     
   ia.negative();
   enableSaving(true);
     } 
    }        
 //The setImage method has code to open the file dialog so the user can choose
 //the file to show on the program interface
 public void setImage(){
  
  int returnVal = chooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION) {   
   filename=chooser.getSelectedFile().toString();
  //  bytes=filename.length();
    //        kilobytes = (bytes / 1024);
   
         
        //  System.out.println("kilobytes : " + kilobytes);
   
   ia.prepareImage(filename);
  
   }
           
  }

 //The showSaveFileDialog method has code to display the save file dialog
 //It is invoked when the user select Save as... sub-menu item
 public void showSaveFileDialog(){
       int returnVal = chooser.showSaveDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION) {  
   String filen=chooser.getSelectedFile().toString();
     ia.saveToFile(filen);  
             
            }
   }


 //The enableSaving method defines code to enable or  disable saving sub-menu items
 public void enableSaving(boolean f){
  msaveas.setEnabled(f);
  msave.setEnabled(f); 
  
  }

 } ////end of the Main class


