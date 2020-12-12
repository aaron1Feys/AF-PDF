package GUI.PrevieuwPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import FileHandling.PDFCreation.AFPDF;

public class SP extends JScrollPane {
	/**
	 * Scrollpane for preview panel
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	


	public SP(AFPDF MyPdf) { 
		// the Update method does everything also when you start. By Aaron Feys
		
		Update(MyPdf);
	}

	public void Update(AFPDF MyPdf) {
		
		this.setViewportView(CreatePanel(MyPdf));
		this.doLayout();
		
	}
	
	private JPanel CreatePanel(AFPDF MyPdf) {
		
		/* 
		 * JPanel CreatePanel 
		 * 
		 * 	This method is used for creating and updating the ScrollPane.
		 * 	It Works as follow:
		 * 			- First it removes all the components from the ScrollPane, so that we can start with a completely clean ScrollPane (It Also wipes the Panel).
		 * 			- Then it makes a GridBagConstraint, this object is used for every page so i declared it in the beginning of the method.
		 * 			- It makes a JPanel to add the labels on.
		 * 			- Then it calculates the scale, it does this with the first image.
		 * 			- Then the for loop begins with adding all the images 
		 * 				- i work on the following way to add an image to a JPanel; 
		 * 				- i take the image of the AFPDF object (that is in an ArrayList) and make with the scale in mind a new image.
		 * 				- an JLabel only accepts an ImageIcon so i make one 
		 * 			
		 * 
		 * 	INPUTS:
		 * 		-AFPDF object
		 * 		-Panel
		 * 	
		 * 	Outputs:
		 * 		-Panel with images on in a scale that you can choose.
		 * 
		 * 
		 * IMPORTANT: This is a method that is meant to be redone every time something has changed to the PDF.
		 * 
		 * 
		 * by: Aaron Feys
		 */
		
		
		
		this.removeAll(); 										
		
		GridBagConstraints c = new GridBagConstraints();		
		
		JPanel MyPanel = new JPanel();
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
			c.weightx = 1;
			c.weighty = 1;
			
			MyPanel.add(MyLabel, c);
		}
		
		return MyPanel;
	}
	
	public JScrollPane getPane() {
	/*
	 * This is meant for a the PPP class of AF=PDF 
	 * 
	 * by Aaron Feys
	 */
		return this;
	}
}
