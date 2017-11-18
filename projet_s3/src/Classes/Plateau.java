package Classes;


import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
public class Plateau {

	// ---------------------- ATTRIBUTS ---------------------
	private ArrayList<JP3> list =new ArrayList<JP3>();
	private Case[][] tabCases = new Case [17][17];//[x][
	private Pion p1;
	private Pion p2;
	private Viewplateau tab;
	private Utilisateur u1 = new Utilisateur(1,p1);	// Utilisateur haut
	private Utilisateur u2 = new Utilisateur(2,p2);	// Utilisateur bas
	
	// -------------------- CONSTRUCTEUR --------------------
	
	public Plateau () {
	    
	    this.p1=new Pion (8,0);
	    this.p2=new Pion (8,16);
	   
		for (int y=0 ; y<tabCases.length ; y++) {
			
			for (int x=0 ; x<tabCases.length ; x++) {
				tabCases[x][y] = new Case(x,y);					// rempli le tableau de cases
			}
		}
		tabCases[0][8].setOccupee(true);// il y a le pion p1
		tabCases[16][8].setOccupee(true); // il y a le pion p2
		
		 tab=new Viewplateau();

		
		
	}
	
	// ---------------- METHODES / FONCTIONS ----------------
	
	public String toString () {
		
		
		return "bla";
	}
	public boolean PartieEnCour()  {
		/*prochenement le programme se surement separer en 4 fonction*/
		
		
		int i=0;
		this.list.add(this.tab.getjp3(0, 0));
		this.list.get(0).setEstvalide(true);
		while(this.list.get(0).isTest()==false) {
			i++;
			try{
				Thread.sleep((long) 0.1); // sleep de 100 ms
				  
				}catch(InterruptedException e){
				  e.printStackTrace();
				}
			//System.out.println(this.tab.getjp3(0, 0).isTest());
		}
		System.out.println(i);
		System.out.println(this.tab.getjp3(0, 0).isTest());
		this.list =new ArrayList<JP3>();
		System.out.println(this.list.size());
		/*
		
		int ancX=this.p1.getPosx();
		int ancY=this.p1.getPosy();
		int ancXp2=this.p2.getPosx();
		int ancYp2=this.p2.getPosy();
		System.out.println(ancX+" "+ancY);
		Scanner sc = new Scanner(System.in);
		System.out.println("x=");
		int posX=sc.nextInt();
		System.out.println("y=");
		int posY=sc.nextInt();
		
		while(posX<0 || posX>16 || posY<0 || posY>16 ) {
			System.out.println("saisi icorecte veuillez saisir des coordoneer valide");
			System.out.println("x=");
			posX=sc.nextInt();
			System.out.println("y=");
			posY=sc.nextInt();
		}
		
		
		
		if(this.tabCases[posX][posY].estOccupee()==false) {
			if(this.p1.seDeplacer(posX, posY)==true) {
				this.tabCases[ancX][ancY].setOccupee(false);
				this.tab.setColor(ancX, ancY, Color.black);
				this.tab.setColor(posX, posY, Color.blue);
				this.tabCases[posX][posY].setOccupee(true);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//tour de p2
		
		System.out.println(ancXp2+" "+ancYp2);
		
		System.out.println("x=");
		 posX=sc.nextInt();
		System.out.println("y=");
		 posY=sc.nextInt();
		 
		 while(posX<0 || posX>16 || posY<0 || posY>16 ) {
				System.out.println("saisi icorecte veuillez saisir des coordoneer valide");
				System.out.println("x=");
				posX=sc.nextInt();
				System.out.println("y=");
				posY=sc.nextInt();
			}
		 
		 
		 
		 
		 
		 
		
			if(this.p2.seDeplacer(posX, posY)==true) {
				this.tabCases[ancXp2][ancYp2].setOccupee(false);
				this.tab.setColor(ancXp2, ancYp2, Color.black);
				this.tab.setColor(posY, posY, Color.green);
				this.tabCases[posX][posY].setOccupee(true);
			}
		
	

		
		
		
		 ancX=this.p1.getPosx();
		 ancY=this.p1.getPosy();
		 ancXp2=this.p2.getPosx();
		 ancYp2=this.p2.getPosy();
		if(this.tabCases[ancX][ancY].estGagnantbleu()==true) {
			System.out.println("bleu a gagner");
			return true;
		}else if(this.tabCases[ancXp2][ancYp2].estGagnantvert()==true) {
			System.out.println("vert a gagner");
			return true;
		}
		*/
		return true;
	}

	
	
	

	
	
	
}
