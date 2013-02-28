package jeu;

import affichage.FenetreJeu;

public class Serveur {

	private Case[][] Cases = new Case[Case.NB_CASES_X][Case.NB_CASES_Y];
	
	public Serveur(){
		Cases[5][5] = new Case(Case.TYPE_CASE.BlocNW);
		FenetreJeu fen = new FenetreJeu(Cases);
		
	}
	
	public static void main(String[] args) {
		new Serveur();

	}

}
