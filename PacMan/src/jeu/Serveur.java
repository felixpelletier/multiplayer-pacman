package jeu;

import jeu.Case.TYPE_CASE;
import affichage.FenetreJeu;

public class Serveur {

	private Case[][] Cases = new Case[Case.NB_CASES_X][Case.NB_CASES_Y];
	
	public Serveur(){
		Niveau niv = new Niveau();
		
		FenetreJeu fen = new FenetreJeu(niv.getCases());
		
		System.out.println(niv.getNbPoint());
		
	}
	
	public static void main(String[] args) {
		new Serveur();
		
	}

}
