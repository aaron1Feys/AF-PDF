package GUI.PrevieuwPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import FileHandling.PDFCreation.AFPDF;

public class TestPrevieuwPanel extends JFrame{

	AFPDF pdf;
	Image i;
	PPP ppp;
	
	public static void main(String[] args) throws IOException, InterruptedException {
	TestPrevieuwPanel p = new TestPrevieuwPanel();
	p.Clock();
	
	}
	
	public TestPrevieuwPanel() throws IOException {
		pdf = new AFPDF();
		i = ImageIO.read(new File("/home/aaronfeys/Documents/Image/pdf.jpg"));
		pdf.PAGES_IMAGE_FORMAT.add(i);
		i = ImageIO.read(new File("/home/aaronfeys/Documents/Image/pdf.jpg"));
		pdf.PAGES_IMAGE_FORMAT.add(i);
		i = ImageIO.read(new File("/home/aaronfeys/Documents/Image/pdf.jpg"));
		pdf.PAGES_IMAGE_FORMAT.add(i);
		
		ppp = new PPP(pdf);
		GridBagConstraints c = new GridBagConstraints();
		
		this.setSize(new Dimension(600, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(ppp, c);
		this.setVisible(true);
		this.setResizable(true);
	}
	
	public void Clock() throws InterruptedException {
		while(true) {
			Thread.sleep(75);
			//System.out.println("Cyclus");
			ppp.getUpdate();
		}
	}
}
