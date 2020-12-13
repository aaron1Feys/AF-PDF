package GUI.PrevieuwPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import FileHandling.PDFCreation.AFPDF;

public class SP extends JScrollPane {
	/**		_____________________________________________________________________________________________________
	 * 		|                                                                                                    |        
	 * 		|        o       o o o o o         o o o    o o o   o o o   o o  o o       o    o o o o              |                              
	 * 		|       o o      o                o        o     o  o    o   o   o  o      o   o                     |         
	 * 		|      o   o     o               o        o       o o    o   o   o   o     o  o                      |             
	 * 		|     o     o    o o o   o o o   o        o       o o    o   o   o    o    o  o                      |             
	 * 		|    o o o o o   o               o        o       o o    o   o   o     o   o  o   o o o              |        	
	 * 		|   o         o  o                o        o     o  o    o   o   o      o  o   o       o             |                	
	 * 		|  o           o o                 o o o    o o o   o o o   o o  o       o o    o o o o              |                         
	 * 		|_________________________________________________________________________________________Aaron Feys_|
	 * 
	 * 
	 * SP class stands for ScrollPane, it a class that transforms an AFPDF object into a ScrollPane.
	 * The SP class is an object made for the PPP class.  
	 * 
	 * {Working} 	
	 * 		It makes a panel for in the JScrollPane, that panel has all pages of the AFPDF object. 
	 * 		An AFPDF object has an array of images this images transform first in an ImagIcon and then a JLabel. Then the label will be added on to the panel.
	 * 		Every time that the CP class gives feedback that the scale has changed will be recreated with the new scale.
	 * 
	 * {Constructor}
	 * 		The constructor gives first a sign that the object will be created. After that the panel is declared. And the background color is set to Gray.
	 * 		Then the fore the first time will the Update method been used, this is a method that you can use all the time.
	 * 	
	 * {Update}
	 * 		When you ask fore an update, 
	 * 
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	JPanel MyPanel;

	public SP(AFPDF MyPdf) { 
		
		System.out.println("UPDATE: ScrollPane is creating.");
		MyPanel = new JPanel();
		MyPanel.setBackground(Color.DARK_GRAY);
		Update(MyPdf);
		
	}

	public void Update(AFPDF MyPdf) {
		
		MyPanel.removeAll();
		this.setViewportView(CreatePanel(MyPdf));
		this.doLayout();
		
	}
	
	private JPanel CreatePanel(AFPDF MyPdf) {
		
		GridBagConstraints c = new GridBagConstraints();		
	
		MyPanel.setLayout(new GridBagLayout());
		
		int b = MyPdf.PAGES_IMAGE_FORMAT.get(0).getWidth(null);
		int bs = (b / 100) * MyPdf.SCALE;
		int h = MyPdf.PAGES_IMAGE_FORMAT.get(0).getHeight(null);
		int hs =  (bs * h ) / b;
		
		for(int i = 0; i < MyPdf.PAGES_IMAGE_FORMAT.size(); i++) {
			Image MyImage;
			ImageIcon IMAGE_ICON;
			JLabel MyLabel;
		
			MyImage = MyPdf.PAGES_IMAGE_FORMAT.get(i).getScaledInstance( bs, hs,  java.awt.Image.SCALE_SMOOTH);
			IMAGE_ICON = new ImageIcon(MyImage);		
			MyLabel = new JLabel(IMAGE_ICON);
			
			c.gridy = i;
			c.gridx = 0;
			c.fill = GridBagConstraints.BOTH;
			
			MyPanel.add(MyLabel, c);
		}
		
		return MyPanel;
	}
	
}
