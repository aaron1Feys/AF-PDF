package GUI.PreviewPanel;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import FileHandling.PDFCreation.AFPDF;

public class PPP extends JPanel{
	
	/**
	 * halo
	 */
	private static final long serialVersionUID = 1L;
	

	AFPDF MY_PDF; 
	
	CP CONFIGURATION_PANEL = new CP(MY_PDF);
	SP SCROLPANE_PANEL = new SP(MY_PDF);

	public PPP(AFPDF MyPdf) {
		MY_PDF = MyPdf;
		this.setLayout(new GridBagLayout());
	}
	
	
	public JPanel getPrevieuwPanel() {
		
		return this;
	}
	
	
	public void CreatPrevieuw() {
		
	}
	
	
}
