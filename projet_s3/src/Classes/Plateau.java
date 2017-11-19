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
		 Scanner sc=new Scanner(System.in);
		 
		
		 
		 
		 System.out.println("que voulez voulez vous faire:");
		 System.out.println("	1=deplacement ");
		 System.out.println("	2= poser un mur");
		 int i=sc.nextInt();
		do {
			 if(i==1) {
			 	this.tourp1(); 
		 	}else if(i==2 && this.p1.getMurposseder()>0) {
			 	this.posermur(this.p1);
		 	}else {
				 System.out.println("erreur de saisi veuilez recomencer la saisi :");
				 System.out.println("	1=deplacement ");
				 System.out.println("	2= poser un mur");
				 i=sc.nextInt();

		 	}
		 } while(i!=1 && i!=2);
		 
		 int ancX=this.p1.getPosx();
		 int ancY=this.p1.getPosy();
		 
		 if(this.tabCases[ancX][ancY].estGagnantbleu()==true) {
			System.out.println("bleu a gagner");
			return true;
		}
		 
		 
		 
		 
		
		 
		 
		 
		 
		 
		
		 System.out.println("que voulez voulez vous faire:");
		 System.out.println("	1=deplacement ");
		 System.out.println("	2= poser un mur");
		 i=sc.nextInt();
		do {
			 if(i==1) {
			 	this.tourp2(); 
		 	}else if(i==2 && this.p2.getMurposseder()>0) {
			 	this.posermur(this.p2);
		 	}else {
				 System.out.println("erreur de saisi veuilez recomencer la saisi :");
				 System.out.println("	1=deplacement ");
				 System.out.println("	2= poser un mur");
				 i=sc.nextInt();

		 	}
		 } while(i!=1 && i!=2);
	
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
		
		boolean ok=false;
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

	
	public void posermur(Pion p) {
		int compteur=0;
		ArrayList<Case> morte=new ArrayList<Case>();
		ArrayList<JP3> list =new ArrayList<JP3>();
		ArrayList<Case> enplacementmur=new ArrayList<Case>();
		for(int y=0;y<this.tabCases.length;y++) {
			for(int x=0;x<this.tabCases.length;x++) {
				if(this.tabCases[x][y].isEstmorte()==true && this.tabCases[x][y].estOccupee()==false) {
					morte.add(this.tabCases[x][y]);
				}
			}	
		}
		for(int i=0;i<morte.size();i++) {
			list.add(this.tab.getjp3(morte.get(i).getPosx(),morte.get(i).getPosy()));
		}
		boolean tab1[]=new boolean [list.size()];
		for(int i=0;i<morte.size();i++) {
			list.get(i).setEstvalide(true);
		}	
		for (int i=0;i<tab1.length;i++) {
			tab1[i]=list.get(i).isTest();;
		}
		
		
		
		boolean ok=false;
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
		int posXmorte=0;
		int posYmorte=0;
		if(tab1[compteur]){
			posXmorte=list.get(compteur).getPosx();
			posYmorte=list.get(compteur).getPosy();
		}
		
		if(this.tabCases[posXmorte][posYmorte].estOccupee()==false) {
			this.tabCases[posXmorte][posYmorte].setOccupee(true);
			this.tab.setColor(posXmorte, posYmorte, Color.cyan);
		}
			
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(false);
			
		}
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setTest(false);
			
		}
		
		
		
		list =new ArrayList<JP3>();//supression des donnee
		
		
		
		if(this.tabCases[posXmorte-1][posYmorte].isEstmorte()==false && this.tabCases[posXmorte-1][posYmorte].estEmplacementMur()==true && this.tabCases[posXmorte-1][posYmorte].estOccupee()==false  &&this.tabCases[posXmorte+1][posYmorte].estOccupee()==false) {
			enplacementmur.add(this.tabCases[posXmorte-1][posYmorte]);
		}
		
		
		if(this.tabCases[posXmorte+1][posYmorte].isEstmorte()==false && this.tabCases[posXmorte+1][posYmorte].estEmplacementMur()==true && this.tabCases[posXmorte-1][posYmorte].estOccupee()==false  &&this.tabCases[posXmorte+1][posYmorte].estOccupee()==false) {
			enplacementmur.add(this.tabCases[posXmorte+1][posYmorte]);
		}
		
		
		
		if(this.tabCases[posXmorte][posYmorte-1].isEstmorte()==false && this.tabCases[posXmorte][posYmorte-1].estEmplacementMur()==true && this.tabCases[posXmorte][posYmorte-1].estOccupee()==false  &&this.tabCases[posXmorte][posYmorte+1].estOccupee()==false) {
			enplacementmur.add(this.tabCases[posXmorte][posYmorte-1]);
		}
		
		if(this.tabCases[posXmorte][posYmorte+1].isEstmorte()==false && this.tabCases[posXmorte][posYmorte+1].estEmplacementMur()==true && this.tabCases[posXmorte][posYmorte-1].estOccupee()==false  &&this.tabCases[posXmorte][posYmorte+1].estOccupee()==false) {
			enplacementmur.add(this.tabCases[posXmorte][posYmorte+1]);
		}
		
		
		for(int i=0;i<enplacementmur.size();i++) {
			list.add(this.tab.getjp3(enplacementmur.get(i).getPosx(),enplacementmur.get(i).getPosy()));
		}
		boolean tab2[]=new boolean [list.size()];
		
		
		
		
		
		for(int i=0;i<list.size();i++) {
			list.get(i).setEstvalide(true);
		}	
		for (int i=0;i<tab2.length;i++) {
			tab2[i]=list.get(i).isTest();;
		}
		
		compteur=0;
		ok=false;
		while(ok==false) {
			try{
				Thread.sleep(10); // sleep de 10 ms 
				}catch(InterruptedException e){
				  e.printStackTrace();
				}
			for(int i=0;i<tab2.length;i++) {
				tab2[i]=list.get(i).isTest();
				if(tab2[i]==true) {
					ok=true;					
				}	
			}
		}
		while(tab2[compteur]==false) {
			compteur+=1;
		}
		
		int posXmur1=0;
		int posYmur1=0;
		if(tab2[compteur]){
			posXmur1=list.get(compteur).getPosx();
			posYmur1=list.get(compteur).getPosy();
		}
		
		int posXmur2=0;
		int posYmur2=0;
		if(posXmur1+1== posXmorte && posYmur1== posYmorte) {
			posXmur2=posXmorte+1;
			posYmur2=posYmorte;
		}
		if(posXmur1-1== posXmorte && posYmur1== posYmorte) {
			posXmur2=posXmorte-1;
			posYmur2=posYmorte;
		}
		
		if(posXmur1== posXmorte && posYmur1+1== posYmorte) {
			posXmur2=posXmorte;
			posYmur2=posYmorte+1;
		}
		
		
		if(posXmur1== posXmorte && posYmur1-1== posYmorte) {
			posXmur2=posXmorte;
			posYmur2=posYmorte-1;
		}
		
		
		
	
		this.tabCases[posXmur1][posYmur1].setOccupee(true);
		
		this.tabCases[posXmur2][posYmur2].setOccupee(true);
		
			
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setEstvalide(false);
			
		}
		for(int i=0;i<this.voisin.size();i++) {
			list.get(i).setTest(false);
			
		}
		
		
		
		list =new ArrayList<JP3>();//supression des donnee
		if(this.arbitre()==true) {
			this.tab.setColor(posXmur1, posYmur1, Color.cyan);
			this.tab.setColor(posXmur2, posYmur2, Color.cyan);
			p.setMurposseder(p.getMurposseder()-1);
		}else {
			this.tab.setColor(posXmorte, posXmorte, Color.red);
			this.tabCases[posXmur1][posYmur1].setOccupee(false);
			this.tabCases[posXmorte][posXmorte].setOccupee(false);
			this.tabCases[posXmur2][posYmur2].setOccupee(false);
		}
		
	}
	
	
	
	
	
	
	
	
	private boolean arbitre() {
		// TODO a codee
		
		
		return true;
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
