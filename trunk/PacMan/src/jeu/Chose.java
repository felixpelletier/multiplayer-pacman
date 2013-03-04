package jeu;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class Chose {
	
	private Point2D.Float position = new Point2D.Float();
	private int largeur,hauteur;
	
	public Point2D.Float getPosition() {
		return position;
	}

	public void setPosition(Point2D.Float position) {
		this.position = position;
	}
	
	public void setPosition(float x,float y) {
		this.position = new Point2D.Float(x, y);
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public abstract BufferedImage getImage();

}
