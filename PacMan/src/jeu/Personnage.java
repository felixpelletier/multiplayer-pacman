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
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x + FenetreJeu.TAILLE_CASE * 0.5 + 1, getCenterPosition().y);
			break;
		case N:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x, getCenterPosition().y - FenetreJeu.TAILLE_CASE *0.5 - 1);
			break;
		case S:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x, getCenterPosition().y + FenetreJeu.TAILLE_CASE *0.5 + 1);
			break;
		case W:
			prochaineCase = FenetreJeu.positionVersCase(getCenterPosition().x - FenetreJeu.TAILLE_CASE *0.5 - 1, getCenterPosition().y);
			break;
		default:
			break;
		}
		
		return cases[prochaineCase.x][prochaineCase.y];
	}
	
	protected void verifierCollision() {

		if(nouvelleDirection != null && !getProchaineCase(nouvelleDirection).estBloc() && (getCenterPosition().x + FenetreJeu.TAILLE_CASE/2) % FenetreJeu.TAILLE_CASE < vitesse && (getCenterPosition().y + FenetreJeu.TAILLE_CASE/2) % FenetreJeu.TAILLE_CASE < vitesse){
			changerDirection();
		}else if(getProchaineCase().estBloc()){
			bouge = changerDirection();
		}
		
		
		
	}
	
	public void ajusterPosition(){
		
		Point2D.Float ajustement = new Point2D.Float();
		ajustement.x = (getCenterPosition().x + FenetreJeu.TAILLE_CASE/2) % FenetreJeu.TAILLE_CASE;
		ajustement.y = (getCenterPosition().y + FenetreJeu.TAILLE_CASE/2) % FenetreJeu.TAILLE_CASE;
		
		
		switch(direction){
		case E:
			if (ajustement.x > FenetreJeu.TAILLE_CASE/2)
				ajustement.x= ajustement.x - FenetreJeu.TAILLE_CASE;
				
			System.out.println("Avant: " + position.x);
			position.x -= ajustement.x;
			System.out.println("Après: " + position.x);
			break;
		case N:
			if (ajustement.y > FenetreJeu.TAILLE_CASE/2)
				ajustement.y=  ajustement.y - FenetreJeu.TAILLE_CASE;
				position.y -= ajustement.y;
			break;
		case S:
			if (ajustement.y > FenetreJeu.TAILLE_CASE/2)
				ajustement.y=  ajustement.y - FenetreJeu.TAILLE_CASE;
			
				position.y -= ajustement.y;
			break;
		case W:
			if (ajustement.x > FenetreJeu.TAILLE_CASE/2)
				ajustement.x= ajustement.x - FenetreJeu.TAILLE_CASE;
				position.x -= ajustement.x;
			break;
		default:
			break;
		}
	}
	
	public boolean changerDirection(){
		
		ajusterPosition();
		
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
