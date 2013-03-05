package jeu;

import jeu.Case.TYPE_CASE;
import affichage.FenetreJeu;

public class Serveur {

	private Case[][] Cases = new Case[Case.NB_CASES_X][Case.NB_CASES_Y];
	private int compteurPoints;
	
	public Serveur(){
		Niveau niv = new Niveau();
		
		compteurPoints = niv.getNbPoint();
		
		Cases = niv.getCases();
		
		Pacman j = new Pacman(Cases);
		
		FenetreJeu fen = new FenetreJeu(Cases);
		
		fen.addChose(j);
		fen.addKeyListener(j);
		
		while(fen.isVisible()){
			
			j.mettreAJour();
			
			fen.repaint();
			
			//Cases[1][6] = new Case(TYPE_CASE.Vide);
			
			try {
	            Thread.sleep(1000 / 30);  // milliseconds
	         } catch (InterruptedException ex) { }
		}
	}
	
	public static void main(String[] args) {
		new Serveur();
		
	}

}
