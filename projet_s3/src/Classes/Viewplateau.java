package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings({ "serial", "unused" })
public class Viewplateau extends JFrame  {

	private JP3 tab[][]=new JP3[17][17];
	
	public Viewplateau() {
		setTitle("Quoridor");// nom de la fen�tre
		setSize(700,700);//taille de la fenn�tre
		setResizable(false);//modifier la taille de la fenn�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//position  d'origine
		setVisible(true);
		
		
		
		JP3 content = new JP3(0,0);
	    content.setPreferredSize(new Dimension(60, 60));
	    content.setBackground(Color.WHITE);
	    //On d�finit le layout manager
	    content.setLayout(new GridBagLayout());
			
	    //L'objet servant  positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
			
	    //On positionne la case de d�part du composant

	    //La taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    
	    for (int y=0 ; y<tab.length ; y++) {
			
			for (int x=0 ; x<tab.length ; x++) {
				tab[x][y] = new JP3(x,y);					// rempli le tableau de cases
			}
		}
	    
	    
	    
	    
	    
	    
		for (int y=0 ; y<tab.length ; y++) {
			for (int x=0 ; x<tab.length ; x++) {
				if(y%2==0) {
					tab[x][y].setBackground(Color.BLACK);
					tab[x][y].setPreferredSize(new Dimension(60, 60));
					if(x%2!=0) {
						tab[x][y].setBackground(Color.RED);
						tab[x][y].setPreferredSize(new Dimension(10, 60));
					}
				}else
				{
					tab[x][y].setBackground(Color.RED);
					if(x%2!=0 && y%2!=0) {
						tab[x][y].setPreferredSize(new Dimension(10, 10));
					}else {
						tab[x][y].setPreferredSize(new Dimension(60, 10));	}
				}
				
				gbc.gridx=x;
				gbc.gridy=y;
				
				
				content.add(tab[x][y], gbc);
				
			    
			}

			
			


		}
	    
		setContentPane(content);
		tab[8][0].setBackground(Color.BLUE); //Utilisateur haut
		tab[8][16].setBackground(Color.green);// Utilisateur bas
		
		
		
	}
	
	
	public void setColor(int posx, int posy, Color e) {
		
		this.tab[posx][posy].setBackground(e);
		
	}
	
	
	
	




	
	public JP3 getjp3(int posx,int posy) {
		return this.tab[posx][posy];
	}
	
	
}
