package Classes;



public class Case {
	
	// ---------------------- ATTRIBUTS ---------------------
	
	private int posx, posy;
	private boolean occupee = false, emplacementMur = false, gagnantBlanc = false, gagnantNoir = false,estmorte;
	
	
	// -------------------- CONSTRUCTEUR --------------------
	
	public Case (int posX, int posY) {
		this.posx = posX;
		this.posy = posY;
		if (this.posx%2 != 0 || this.posy%2 != 0)  emplacementMur = true;
		if (this.posy == 16) gagnantBlanc = true;					// ligne du haut
		if (this.posy == 0) gagnantNoir = true;// ligne du bas
		if(posx%2!=0)emplacementMur=true;
		if(posy%2!=0) {emplacementMur=true;}
		if(posx%2!=0 && posy%2!=0)estmorte=true;
	}
	
	// ---------------- METHODES / FONCTIONS ----------------
	
	public boolean isEstmorte() {
		return estmorte;
	}

	public boolean estEmplacementMur () {
		return this.emplacementMur;
	}
	
	public boolean estOccupee () {
		return this.occupee;
	}
	


	public boolean estGagnantbleu () {
		return this.gagnantBlanc;
	}
	
	public boolean estGagnantvert () {
		return this.gagnantNoir;
	}
	
	public String printCoordonnees() {
		return "["+this.posy+","+this.posx+"]";
	}

	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}
	
	
	
	public void setGagnantbleu(boolean gagnantBlanc) {
		this.gagnantBlanc = gagnantBlanc;
	}

	public void setGagnantvert(boolean gagnantNoir) {
		this.gagnantNoir = gagnantNoir;
	}

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

}
