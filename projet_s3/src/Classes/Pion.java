package Classes;

public class Pion {
	
	// ---------------------- ATTRIBUTS ---------------------
	
	private int posx;
	private int posy;
	
	private int murposseder=10;
	// -------------------- CONSTRUCTEUR --------------------
	


	public Pion (int x, int y) {
		this.posx = x;
		this.posy = y;
	}	
	
	// ---------------- METHODES / FONCTIONS ----------------
	
	public boolean seDeplacer(int posX, int posY) {
		
			
				this.posx=posX;
				this.posy=posY;
				return true;

		
		
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
	
	
	public int getMurposseder() {
		return murposseder;
	}

	public void setMurposseder(int murposeder) {
		this.murposseder = murposeder;
	}
	
	
}
