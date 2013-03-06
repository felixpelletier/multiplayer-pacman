package jeu;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import jeu.Case.TYPE_CASE;

import affichage.FenetreJeu;
import affichage.outils.SpriteSheetLoader;

public class Pacman extends Personnage implements KeyListener{

	private BufferedImage[] sprites;

	private int points = 0;
	
	//Faire interface animateable
	private int animationStep = 1;
	private int animationDelay = 2; 
	
	public enum MOUVEMENT_SPRITE{
		Ferme,E,S,W,N;
	}
	
	MOUVEMENT_SPRITE sprite = MOUVEMENT_SPRITE.E;
	
	public Pacman(Case[][] cases){
		super(cases);
		this.cases = cases;
		this.setDimension(25,25);
		this.setPosition(14*FenetreJeu.TAILLE_CASE, 20*FenetreJeu.TAILLE_CASE);
		vitesse = 3;
		sprites = SpriteSheetLoader.loadSheet(Pacman.class.getClass().getResource("/images/pacman/" + "Mouvement_spriteMap.gif"));
	}

	public BufferedImage getImage() {
		
		return sprites[sprite.ordinal()];
		
	}
	
	public void manger(){
		Case caseCourante = cases[FenetreJeu.positionVersCase(this.getCenterPosition().x)][FenetreJeu.positionVersCase(this.getCenterPosition().y)];
		switch (caseCourante.getType()){
		case Point:
			caseCourante.setType(TYPE_CASE.Vide);
			points++;
			break;
		case GrosPoint:
			caseCourante.setType(TYPE_CASE.Vide);
			points++;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void mettreAJour() {
		manger();
		verifierCollision();

		if(bouge){
			bouger();
			animer();
		}
		else{
			sprite = MOUVEMENT_SPRITE.valueOf(direction.name());
		}
	}

	private void animer() {
		if(animationStep == animationDelay){
			animationStep = 1;
			if(sprite.equals(MOUVEMENT_SPRITE.Ferme)){
				sprite = MOUVEMENT_SPRITE.valueOf(direction.name());
			}
			else{
				sprite = MOUVEMENT_SPRITE.Ferme;
			}
		}else{
			animationStep++;
		}
	}


	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			if (direction.equals(DIRECTION.E) || !bouge){
				direction =  DIRECTION.W;
			}
			else{
				nouvelleDirection = DIRECTION.W;
			}
			bouge = true;
			break;
		case KeyEvent.VK_RIGHT:
			if (direction.equals(DIRECTION.W) || !bouge){
				direction =  DIRECTION.E;
			}
			else{
				nouvelleDirection= DIRECTION.E;
			}
			bouge = true;
			break;
		case KeyEvent.VK_UP:
			if (direction.equals(DIRECTION.S) || !bouge){
				direction =  DIRECTION.N;
			}
			else{
				nouvelleDirection= DIRECTION.N;
			}
			bouge = true;
			break;
		case KeyEvent.VK_DOWN:
			if (direction.equals(DIRECTION.N) || !bouge){
				direction =  DIRECTION.S;
			}
			else{
				nouvelleDirection= DIRECTION.S;
			}
			bouge = true;
			break;
		}



	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_DOWN:
			break;
		}

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}
