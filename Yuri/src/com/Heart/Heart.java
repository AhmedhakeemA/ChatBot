package com.Heart;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





public class Heart {

	public Heart() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
	
		  //-------------------------------------------
    	try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
	            | UnsupportedLookAndFeelException e1) {
	        e1.printStackTrace();
	    }
		//----------------------------------------------
    	
   	 final JFrame frame = new JFrame("Brain");
	   frame.setUndecorated(true);
	    frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
	    frame.setLayout(new FlowLayout());
	   

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,500);
	   
	    
	    frame.setLocationRelativeTo(null);
	   
	    
	    
	    ImageIcon loading = new ImageIcon("daBIrIm.gif");
	    
	    JLabel label=new JLabel(loading);
	    label.setSize(100,100);
	    label.setLocation(100,100);
	    frame.add(label);
	    label.setText("Loading");
	    frame.add(label);
	   // frame.add(new JLabel("loading... ", loading, JLabel.CENTER));
	   //-------------------------------------------------------------
	  
      
	    	frame.add(label);
	    	frame.setVisible(true);
	  //------------------------------------------------
	    	try {
				Thread.sleep(2000);
				frame.dispose();
				Face face=new Face();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //close the frame after 1 second.
		
		

	}

}
