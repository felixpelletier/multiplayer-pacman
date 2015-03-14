package chose;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Date;

import pathFinder.PathFinder;
import chose.Personnage.DIRECTION;

import affichage.FenetreJeu;

import jeu.Case;

public abstract class Fantome extends Personnage{
	
	protected static Case[][] cases;
	protected static Pacman joueur;
	protected Point targetTile;
	protected Point homeTile;
	
	protected BufferedImage[] sprites;
	
	protected boolean decisionPrise = false;

	public enum MODE{
		Disperser,Chasser;
	}
	
	private static final MODE[] listeMode = {	MODE.Disperser,MODE.Chasser,
												MODE.Disperser,MODE.Chasser,
												MODE.Disperser,MODE.Chasser,
												MODE.Disperser,MODE.Chasser};
	
	private static final float[] tempsMode = {	7,27,
												34,54,
												59,79,
												84};
	
	protected static MODE mode = listeMode[0];
	private static int etape = 0;
	
	private static long tempsDebut = System.currentTimeMillis(); 
	
	public static void initialiser(Case[][] cases, Pacman joueur){
		Fantome.cases = cases;
		Fantome.joueur = joueur;
		
	}
	
	protected void resetTempsDebut(){
		 tempsDebut = System.currentTimeMillis();
	}
	
	public void mettreAJour(){
		if(etape < tempsMode.length && (System.currentTimeMillis() - tempsDebut)/1000 > tempsMode[etape]){
			etape++;
			mode = listeMode[etape];
			renverserDirection();
		}
		
		switch(mode){
		case Chasser:
			targetTile = choisirTargetTile();
			break;
		case Disperser:
			targetTile = homeTile;
			break;
		}
		
		if(!decisionPrise && estSurCaseDecision()){
			
			direction = deciderDirection();
			ajusterPosition();
			decisionPrise = true;
			
			
		}
		else{
			decisionPrise = false;
		}
		
		bouger();
		
		
	}
	
	protected abstract Point choisirTargetTile();
	
	protected DIRECTION deciderDirection() {
		Point[] chemin = PathFinder.getPathExcluding(cases, targetTile, this.getCase(), getProchainePosition(getDirectionInverse(direction)));
		
		Point prochaineCase = chemin[1];
		
		if (prochaineCase.x > getCase().x && direction != DIRECTION.W){
			return DIRECTION.E;
			
		}else if (prochaineCase.x < getCase().x && direction != DIRECTION.E){
			return DIRECTION.W;
		}
		else if (prochaineCase.y > getCase().y && direction != DIRECTION.N){
			return DIRECTION.S;
		}
		else if (prochaineCase.y < getCase().y && direction != DIRECTION.S){
			return DIRECTION.N;
		}
		
		return direction;
	}
	
	public MODE getMode(){
		return MODE.Chasser;
	}
	
	public Fantome() {
		super(cases);
		vitesse = 2;
		this.setDimension(25,25);
	}
	
	protected boolean estCentre(){
		Point2D.Float positionCentre = FenetreJeu.caseVersPosition(getCase());
		double distance = positionCentre.distance(getCenterPosition());
		return distance<(vitesse+1);
	}
	
	protected boolean estSurCaseDecision(){
		if (estCentre()){
		int compteur = 0;
		
		Point caseCourante = getCase();
		
		if (!cases[caseCourante.x-1][caseCourante.y].estBloc()) compteur++;
		if (!cases[caseCourante.x+1][caseCourante.y].estBloc()) compteur++;
		if (!cases[caseCourante.x][caseCourante.y-1].estBloc()) compteur++;
		if (!cases[caseCourante.x][caseCourante.y+1].estBloc()) compteur++;
		
		return compteur>=2;
		
		}
		else{
			return false;
		}
	}
	
	private void renverserDirection(){
		direction = getDirectionInverse(direction);
	}
	
	protected DIRECTION getDirectionInverse(DIRECTION direction){
		switch (direction){
		case E:
			return DIRECTION.W;
		case N:
			return DIRECTION.S;
		case S:
			return DIRECTION.N;
		case W:
			return DIRECTION.E;
		default:
			return null;
		}
		
	}
	
	String couleur;
	Point target;
	
}
