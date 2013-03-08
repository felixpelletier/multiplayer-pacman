package jeu;

import java.awt.Point;

public abstract class Fantome extends Personnage{
	
	protected static Case[][] cases;
	protected static Pacman joueur;

	public enum MODE{
		Disperser,Chasser;
	}
	
	private static final MODE[] listeMode = {	MODE.Disperser,MODE.Chasser,
												MODE.Disperser,MODE.Chasser,
												MODE.Disperser,MODE.Chasser,
												MODE.Disperser};
	
	private static final float[] tempsMode = {	7,20,
												7,20,
												5,20,
												5};
	
	private int etape = 0;
	
	public static void initialiser(Case[][] cases, Pacman joueur){
		Fantome.cases = cases;
		Fantome.joueur = joueur;
	}
	
	public MODE getMode(){
		return MODE.Chasser;
	}
	
	public Fantome() {
		super(cases);
	}
	
	String couleur;
	Point target;
	
}
