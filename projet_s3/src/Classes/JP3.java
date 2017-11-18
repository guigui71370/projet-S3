package Classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JP3 extends JPanel implements MouseListener {
	private boolean test=false;
	private boolean estvalide=false;
	public JP3() {
		super();
		this.addMouseListener(this);
	}
	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ok");
		if(this.estvalide==true) {		
			this.test=true;
		}
	}


	public boolean isEstvalide() {
		return estvalide;
	}
	public void setEstvalide(boolean estvalide) {
		this.estvalide = estvalide;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
