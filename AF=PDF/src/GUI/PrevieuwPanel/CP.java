package GUI.PrevieuwPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import FileHandling.PDFCreation.AFPDF;


public class CP extends JPanel{
	/**
	 * Configuration Panel for preview
	 */
	private static final long serialVersionUID = 1L;
	
	GridBagConstraints c;
	Font font = new Font("Comic Sans", Font.ITALIC, 20);
	AFPDF MY_PDF;
	JSlider s;
	boolean SomeThingHasChangesed = false;
	
	public CP(AFPDF MyPdf) {
	 MY_PDF = MyPdf;
	 c = new GridBagConstraints();
	 this.setLayout(new GridBagLayout());
	 setPanel();
		
	}
	
	public void Update(AFPDF MyPdf) {
		
	}
	
	public void setPanel() {
		
		
		
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.gridheight = 1;
		
		this.add(MinIcon(),c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;
		c.gridheight = 1;
		
		this.add(Slider(),c);
		c.gridx = 4;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.gridheight = 1;
		
		this.add(PlusIcon(),c);
		
		
	}
	
	public JSlider Slider() {

		s = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);  
		s.addChangeListener(new SliderListener());
	
		
		return s;
		
	}
	
	public JButton PlusIcon() {
		
		JButton b = new JButton();
		b.setText("+");
		b.setFont(font);
		b.setFocusable(false);
		b.setHorizontalAlignment(JButton.HORIZONTAL);
		b.setForeground(Color.LIGHT_GRAY);
		b.setBackground(Color.WHITE);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ik denk dat ik hier te maken heb met een button");
				MY_PDF.SCALE += 5;
				if(MY_PDF.SCALE >= 101) {
					MY_PDF.SCALE = 100;
					
				}
				SomeThingHasChangesed = true;
				s.setValue(MY_PDF.SCALE);
				
			}
			
		});
		
		return b;
	}
	
	public JButton MinIcon() {
		
		JButton b = new JButton();
		b.setText("-");
		b.setFont(font);
		b.setFocusable(false);
		b.setHorizontalAlignment(JButton.HORIZONTAL);
		b.setForeground(Color.LIGHT_GRAY);
		b.setBackground(Color.WHITE);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Ik denk dat ik hier te maken heb met een button");
				
				MY_PDF.SCALE -= 5;
				if(MY_PDF.SCALE <= 0) {
					MY_PDF.SCALE = 1;
				}
				SomeThingHasChangesed = true;
				s.setValue(MY_PDF.SCALE);
				
			}
			
		});
		
		return b;
	}
	
	
	public JPanel getPane() {
		return this;
	}
	
	public AFPDF getAFPDF() {
		return MY_PDF;
	}

	class SliderListener implements ChangeListener {
	    

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
	        if (!source.getValueIsAdjusting()) {
	            int fps = (int)source.getValue();
	            SomeThingHasChangesed = true;
	            MY_PDF.SCALE = fps;
	            System.out.println(fps);
	            System.out.println(MY_PDF.SCALE);
	          
	        }   
			
		}
	}}
