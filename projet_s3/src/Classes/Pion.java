package Classes;

public class Pion {
	
	// ---------------------- ATTRIBUTS ---------------------
	
	private int posx;
	private int posy;
	
	private int poseder=10;
	// -------------------- CONSTRUCTEUR --------------------
	
	public Pion (int x, int y) {
		this.posx = x;
		this.posy = y;
	}	
	
	// ---------------- METHODES / FONCTIONS ----------------
	
	public boolean seDeplacer(int posX, int posY) {
		
			if(this.posx+2==posX && this.posy==posY||this.posx==posX && this.posy+2==posY||
				this.posx-2==posX && this.posy==posY||this.posx==posX && this.posy-2==posY) { 
				this.posx=posX;
				this.posy=posY;
				return true;
			}
			else {
				System.out.println("saisi incorecte le déplacement est ilégale");
				return false;
			}
		
		
	}
	
	
	public void deplacementpardessus(int posX, int posY) {
		this.posx=posX;
		this.posy=posY;
	}

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}
	
	
	
	
	
}
