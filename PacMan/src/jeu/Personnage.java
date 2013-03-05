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
	
	protected void verifierCollision() {
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
		
		if(cases[prochaineCase.x][prochaineCase.y].estBloc()){
			bouge = false;
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
