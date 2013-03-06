package jeu;

import java.awt.Point;
import java.awt.geom.Point2D;

import affichage.FenetreJeu;

public abstract class Personnage extends Chose{

	protected float vitesse;
	protected boolean bouge = false;
	protected Case[][] cases;
	
	public Personnage(Case[][] cases){

	}
	
	public enum DIRECTION{
		N,E,S,W;
	}
	
	protected DIRECTION direction = DIRECTION.E;
	protected DIRECTION nouvelleDirection = DIRECTION.E;
	
	protected void bouger(){
		switch (direction){
			case N:
				position.setLocation(position.x, position.y - vitesse);
				break;
			case S:
				position.setLocation(position.x, position.y + vitesse);
				break;
			case E:
				position.setLocation(position.x + vitesse, position.y);
				break;
			case W:
				position.setLocation(position.x - vitesse, position.y);
				break;
		}
	}
	
	protected Case getProchaineCase(){
		return getProchaineCase(direction);
	}
	
	protected Case getProchaineCase(DIRECTION direction){
		Point prochaineCase = null;
		switch(direction){
		case E:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x + FenetreJeu.TAILLE_CASE / 2, getCenterPosition().y);
			break;
		case N:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x, getCenterPosition().y - FenetreJeu.TAILLE_CASE / 2);
			break;
		case S:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x, getCenterPosition().y + FenetreJeu.TAILLE_CASE / 2);
			break;
		case W:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x - FenetreJeu.TAILLE_CASE / 2, getCenterPosition().y);
			break;
		default:
			break;
		}
		
		return cases[prochaineCase.x][prochaineCase.y];
	}
	
	protected void verifierCollision() {

		if(nouvelleDirection != null && !getProchaineCase(nouvelleDirection).estBloc()){
			changerDirection();
		}
		
		if(getProchaineCase().estBloc()){
			bouge = changerDirection();
		}
		
		
		
	}
	
	public boolean changerDirection(){
		if(nouvelleDirection != null && !getProchaineCase(nouvelleDirection).estBloc()){
			direction = DIRECTION.values()[nouvelleDirection.ordinal()];
			nouvelleDirection = null;
			return true;
		}
		else{
			return false;
		}
	}
	
	public DIRECTION getDirection() {
		return direction;
	}

	public void setDirection(DIRECTION direction) {
		this.direction = direction;
	}

	public Point2D.Float getPosition() {
		return position;
	}

	
	
	
	
	
	
	
}
