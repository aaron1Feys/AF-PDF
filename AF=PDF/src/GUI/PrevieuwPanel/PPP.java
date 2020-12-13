package GUI.PrevieuwPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import FileHandling.PDFCreation.AFPDF;

public class PPP extends JPanel{
	
	/**
	 * Aaron
	 */
	private static final long serialVersionUID = 1L;
	

	AFPDF MY_PDF; 
	CP CONFIGURATION_PANEL;
	SP SCROLPANE_PANEL;
	
	
	public PPP(AFPDF MyPdf) {
		MY_PDF = MyPdf;
		this.setLayout(new GridBagLayout());
		CONFIGURATION_PANEL = new CP(MY_PDF);
		SCROLPANE_PANEL = new SP(MY_PDF);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		
		c.weightx = 1;
		c.weighty = 1;
		
		c.fill = GridBagConstraints.BOTH;
		
		
		this.add(SCROLPANE_PANEL, c);
		
		c.gridx = 0;
		c.gridy = 1;
		
		c.weightx = 0.1;
		c.weighty = 0.1;
		
		c.fill = GridBagConstraints.BOTH;
		
		this.add(CONFIGURATION_PANEL, c);
	}
	
	
	public JPanel getPrevieuwPanel() {
		
		return this;
	}
	
	public AFPDF GetUpdate() {
		
		return MY_PDF;
		
	}
	
	public void getUpdate() {
		if(CONFIGURATION_PANEL.SomeThingHasChangesed) {
		MY_PDF = CONFIGURATION_PANEL.MY_PDF;
		SCROLPANE_PANEL.Update(MY_PDF);
		CONFIGURATION_PANEL.SomeThingHasChangesed = false;
		}
	}
	
	
	public void CreatPrevieuw() {
		
	}
	
	
}
