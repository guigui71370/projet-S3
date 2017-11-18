package Classes;


import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
public class Plateau {

	// ---------------------- ATTRIBUTS ---------------------
	private ArrayList<Case> voisin =new ArrayList<Case>();
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
		this.tourp1();
		 int ancX=this.p1.getPosx();
		 int ancY=this.p1.getPosy();
		
		if(this.tabCases[ancX][ancY].estGagnantbleu()==true) {
			System.out.println("bleu a gagner");
			return true;
		}
		this.tourp2();
		int ancXp2=this.p2.getPosx();
		int ancYp2=this.p2.getPosy();

		if(this.tabCases[ancXp2][ancYp2].estGagnantvert()==true) {
			System.out.println("vert a gagner");
			return true;
		}
		
		return false;
	}
	

	
	public void tourp1() {
		/*prochenement le programme se surement separer en 4 fonction*/
		/*obtention de la liste des voisin d'une case se fera dan une autre fonction*/
		
		int compteur=0;
		
		ArrayList<JP3> list =new ArrayList<JP3>();
		
		
		
		int ancX=this.p1.getPosx();
		int ancY=this.p1.getPosy();
		this.voisin=this.estvoisin(ancX, ancY);
		for(int i=0;i<this.voisin.size();i++) {
			list.add(this.tab.getjp3(this.voisin.get(i).getPosx(),this.voisin.get(i).getPosy()));
		}
		boolean tab1[]=new boolean [list.size()];
		
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(true);
			
		}
		

		
		
		
		for (int i=0;i<tab1.length;i++) {
			tab1[i]=list.get(i).isTest();;
		}
		int test=0 ;
		
		boolean ok=list.get(0).isTest();
		while(ok==false) {
			try{
				Thread.sleep(10); // sleep de 10 ms
				  
				}catch(InterruptedException e){
				  e.printStackTrace();
				}
			
			for(int i=0;i<tab1.length;i++) {

				tab1[i]=list.get(i).isTest();

				if(tab1[i]==true) {
					ok=true;					
				}
				
			}
			
		}
		
		
		
		while(tab1[compteur]==false) {
			compteur+=1;
		}
		int posX=0;
		int posY=0;
		if(tab1[compteur]){
			posX=list.get(compteur).getPosx();
			posY=list.get(compteur).getPosy();
		}
		System.out.println(posY);
		
		this.tabCases[ancX][ancY].setOccupee(false);
		this.tab.setColor(ancX, ancY, Color.black);
		this.tab.setColor(posX, posY, Color.blue);
		this.tabCases[posX][posY].setOccupee(true);
		this.p1.seDeplacer(posX, posY);
		
		
		
	
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(false);
			
		}
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setTest(false);
			
		}
		list =new ArrayList<JP3>();
		this.voisin=new ArrayList<Case>();
	}
	
	public void tourp2() {
		int compteur=0;
		
		ArrayList<JP3> list =new ArrayList<JP3>();
		
		
		
		int ancX=this.p2.getPosx();
		int ancY=this.p2.getPosy();
		this.voisin=this.estvoisin(ancX, ancY);
		for(int i=0;i<this.voisin.size();i++) {
			list.add(this.tab.getjp3(this.voisin.get(i).getPosx(),this.voisin.get(i).getPosy()));
		}
		boolean tab1[]=new boolean [list.size()];
		
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(true);
			
		}
		

		
		
		
		for (int i=0;i<tab1.length;i++) {
			tab1[i]=list.get(i).isTest();;
		}
		int test=0 ;
		
		boolean ok=list.get(0).isTest();
		while(ok==false) {
			try{
				Thread.sleep(10); // sleep de 10 ms
				  
				}catch(InterruptedException e){
				  e.printStackTrace();
				}
			
			for(int i=0;i<tab1.length;i++) {

				tab1[i]=list.get(i).isTest();

				if(tab1[i]==true) {
					ok=true;					
				}
				
			}
			
		}
		
		
		
		while(tab1[compteur]==false) {
			compteur+=1;
		}
		int posX=0;
		int posY=0;
		if(tab1[compteur]){
			posX=list.get(compteur).getPosx();
			posY=list.get(compteur).getPosy();
		}
		System.out.println(posY);
		
		this.tabCases[ancX][ancY].setOccupee(false);
		this.tab.setColor(ancX, ancY, Color.black);
		this.tab.setColor(posX, posY, Color.GREEN);
		this.tabCases[posX][posY].setOccupee(true);
		this.p2.seDeplacer(posX, posY);
		
		
		
	
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(false);
			
		}
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setTest(false);
			
		}
		list =new ArrayList<JP3>();
		this.voisin=new ArrayList<Case>();
	}

	
	
	
	
	
	
	
	
	
	
	public ArrayList<Case> estvoisin(int posx,int posy) {
		/*structure de base a codee pour calcul les voisin des case x et y
		 *action :calcule les case  voisine d'une autre qui sont acessible a partir des 
		 * coordonee doner en paramètre
		 *retourne la liste des voisin 
		 */
		ArrayList<Case> courant=new ArrayList<Case>();
		//
		courant.add(this.tabCases[0][2]);
		courant.add(this.tabCases[4][0]);
		courant.add(this.tabCases[6][8]);
		
		return courant;
		
	}
	
}
