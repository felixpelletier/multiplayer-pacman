package chose;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import affichage.FenetreJeu;

public abstract class Chose {
	
	protected Point2D.Float position = new Point2D.Float();
	protected int largeur;
	protected int hauteur;
	
	public Point2D.Float getPosition() {
		return position;
	}
	
	public Point2D.Float getCenterPosition() {
		return new Point2D.Float(position.x + largeur/2.0f, position.y + hauteur/2.0f);
	}
	
	public Point getCase() {
		return new Point((int)getCenterPosition().x/FenetreJeu.TAILLE_CASE,(int)getCenterPosition().y/FenetreJeu.TAILLE_CASE);
	}
	
	public void setCenterPosition(float x,float y) {
		setPosition(x - largeur/2.0f, y - hauteur/2.0f);
	}
	
	public void setCase(int x,int y) {
		setCenterPosition(x*FenetreJeu.TAILLE_CASE + FenetreJeu.TAILLE_CASE/2, y*FenetreJeu.TAILLE_CASE + FenetreJeu.TAILLE_CASE/2);
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
	
	public void setDimension(int largeur, int hauteur) {
		setLargeur(largeur);
		setHauteur(hauteur);
		
	}


	public abstract void mettreAJour();
	public abstract BufferedImage getImage();

}
