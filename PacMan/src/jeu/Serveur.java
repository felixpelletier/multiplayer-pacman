package jeu;

import java.util.LinkedList;

import chose.Chose;
import chose.Fantome;
import chose.FantomeRouge;
import chose.Pacman;
import jeu.Case.TYPE_CASE;
import affichage.FenetreJeu;

public class Serveur {
	
	private Case[][] cases = new Case[Case.NB_CASES_X][Case.NB_CASES_Y];
	private int compteurPoints;
	public static long frame = 0;
	public static int FRAMERATE = 30;
	
	public LinkedList<Chose> listeChoses;
	
	public Serveur(){
		Niveau niv = new Niveau();
		
		compteurPoints = niv.getNbPoint();
		
		cases = niv.getCases();
		
		listeChoses = new LinkedList<Chose>();
		
		Pacman j = new Pacman(cases);
		listeChoses.add(j);
		
		Fantome.initialiser(cases, j);
		
		FantomeRouge rouge = new FantomeRouge();
		listeChoses.add(rouge);
	
		FenetreJeu fen = new FenetreJeu(cases,listeChoses);
		
		fen.addKeyListener(j);
		
		while(fen.isVisible()){
			
			for (Chose chose : listeChoses){
				chose.mettreAJour();
			}

			fen.repaint();
			
			frame++;
			
			compteurPoints = niv.getNbPoint();
			
			if (compteurPoints == 0){
				System.exit(0);
			}
			
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
