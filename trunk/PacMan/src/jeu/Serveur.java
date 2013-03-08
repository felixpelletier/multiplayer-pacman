package jeu;

import jeu.Case.TYPE_CASE;
import affichage.FenetreJeu;

public class Serveur {
	
	private Case[][] cases = new Case[Case.NB_CASES_X][Case.NB_CASES_Y];
	private int compteurPoints;
	public static long frame = 0;
	public static int FRAMERATE = 30;
	
	public Serveur(){
		Niveau niv = new Niveau();
		
		compteurPoints = niv.getNbPoint();
		
		cases = niv.getCases();
		
		Pacman j = new Pacman(cases);
		
		Fantome.initialiser(cases, j);
	
		
		
		FenetreJeu fen = new FenetreJeu(cases);
		
		fen.addChose(j);
		fen.addKeyListener(j);
		
		while(fen.isVisible()){
			
			j.mettreAJour();
			
			fen.repaint();
			
			frame++;
			
			//Cases[1][6] = new Case(TYPE_CASE.Vide);
			
			try {
	            Thread.sleep(1000 / FRAMERATE);  // milliseconds
	         } catch (InterruptedException ex) { }
		}
	}
	
	public static int getSecondes(){
		return (int) (frame/FRAMERATE);
	}
	
	public static void main(String[] args) {
		new Serveur();
		
	}

}
