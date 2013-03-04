package jeu;

import java.awt.image.BufferedImage;

import jeu.Case.TYPE_CASE;

import affichage.outils.SpriteSheetLoader;

public class Pacman extends Personnage{

	BufferedImage[] sprites;
	
	public enum MOVEMENT_SPRITE{
		Ferme,E,S,W,N;
	}
	
	public Pacman(){
		this.setPosition(100, 100);
		sprites = SpriteSheetLoader.loadSheet(Pacman.class.getClass().getResource("/images/pacman/" + "Mouvement_spriteMap.gif"));
	}


	public BufferedImage getImage() {
		
		return sprites[1];
		
	}
	
}
