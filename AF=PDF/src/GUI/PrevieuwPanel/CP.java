package GUI.PrevieuwPanel;

import javax.swing.JPanel;

import FileHandling.PDFCreation.AFPDF;

public class CP extends JPanel{
	/**
	 * Configuration Panel for preview
	 */
	private static final long serialVersionUID = 1L;
	
	AFPDF MY_PDF;

	
	public CP(AFPDF MyPdf) {
		
		
		
	}
	
	public JPanel getPane() {
		
		return this;
	}

}
