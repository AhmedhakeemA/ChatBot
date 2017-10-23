package com.Heart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;



public class Face {

	public Face() throws IOException {
	
		Color color=new Color(38, 38, 38);
		Color color_2=new Color(59, 63, 55);
		
			JFrame frame=new JFrame("Chat");
			frame.setUndecorated(true);
		    frame.setLayout(null);
		    frame.getContentPane().setBackground(color);

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(700,500);
		    frame.setLocationRelativeTo(null);
		    
		    //-----------------------------------------
		    FrameDragListener frameDragListener = new FrameDragListener(frame);
	        frame.addMouseListener(frameDragListener);
	        frame.addMouseMotionListener(frameDragListener);
		    //----------------------------------------------
		    
		    
		    JPanel panel=new JPanel();
		    panel.setSize(700,50);
		    panel.setLayout(null);
		    panel.setLocation(0,420);
		    panel.setBackground(color);
		    
		    
		    JPanel panel_2=new JPanel();
		    panel_2.setSize(90,500);
		    panel_2.setLayout(null);
		    panel_2.setLocation(590,5);
		    panel_2.setBackground(color);
		    
		    JButton button=new JButton("X");
		    button.setSize(50,50);
		    //button.setBounds(100,100,50,50);
		    button.setLocation(20,20);
		   
		  
		    button.setBackground(color);
		    button.setForeground(color_2);
		    button.setOpaque(true);
		    
		    
		    button.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	 //button.setBackground(color);
		            	System.exit(0);
		            	
		             }
		               
		        });
		    
		    
		    
		    JTextField fi=new JTextField();
			fi.setSize(70, 30);
			fi.setBackground(color_2);
			fi.setBounds(10,5,560,30);
			
			JTextArea area=new JTextArea();
			area.setLocation(8, 5);
			area.setBackground(Color.white);
			area.setBackground(color);
			area.setLineWrap(true);
            area.setWrapStyleWord(true);
            
           // area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			JScrollPane scroll = new JScrollPane ( area );
		    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );	
		    scroll.setBounds(5,5,575,400);
		    
			panel.add(fi);
			panel_2.add(button);
		   
			frame.getContentPane().add(scroll);
		    frame.add(panel);
		    frame.add(panel_2);
		    frame.setVisible(true);
		    
		    //-------------------------------------------
	    	try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		            | UnsupportedLookAndFeelException e1) {
		        e1.printStackTrace();
		    }
			//----------------------------------------------
		
	    	
		
	
		
		
		
	 Font font = new Font("ARIAL", Font.TYPE1_FONT, 15);
		 area.setFont(font);
		 area.setForeground(Color.WHITE);
		 
		//-------------------------------------------------
		
		
		
		
		
		
		
		//--------------------------------------------------
		
		fi.addActionListener(new ActionListener() {
	        
	      
			@Override
			public void actionPerformed(ActionEvent e) {
				Brain br=new Brain();
				
				String talk=fi.getText();
				try {
					
					String a=br.tunnel(talk);
					
					//--------------------
					if (a==null) {
						 
						area.append("Ahmed"+":  "+talk+"\n"+"\n");
						
						area.append("Yuri"+":  "+"i don't know !"+"\n"+"\n");
						area.append("Yuri"+":  "+"could you Please tell me about"+"  "+talk+"\n"+"\n");
						String anS=talk;
						//System.out.println(anS);
					
							
							
					
						        
						        
						        Learn leo=new Learn(); 
							
							leo.add_knowledge_frame(anS);
							
							
							area.append("Yuri"+":  "+"Thanks for new info"+"  "+talk+"\n"+"\n");
							//---------------------------------
							///do learn here
							
					}
						
					
					//--------------------
					else if(a!=null){
						area.append("Ahmed"+":  "+talk+"\n"+"\n");
						
						area.append("Yuri"+":  "+a+"\n"+"\n");
						
						
					}
					
					fi.setText("");
					
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
								
				
				
				
				
			}
				
				
				
	    });
		
		
		
		
	}
	
	
	public static class FrameDragListener extends MouseAdapter {

	    private final JFrame frame;
	    private Point mouseDownCompCoords = null;

	    public FrameDragListener(JFrame frame) {
	        this.frame = frame;
	    }

	    public void mouseReleased(MouseEvent e) {
	        mouseDownCompCoords = null;
	    }

	    public void mousePressed(MouseEvent e) {
	        mouseDownCompCoords = e.getPoint();
	    }

	    public void mouseDragged(MouseEvent e) {
	        Point currCoords = e.getLocationOnScreen();
	        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	    }
	}

}
