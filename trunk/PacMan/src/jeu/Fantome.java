package jeu;

import java.awt.Point;

public abstract class Fantome extends Personnage{

	public Fantome(Case[][] cases) {
		super(cases);
	}
	
	String couleur;
	Point target;
	
}
