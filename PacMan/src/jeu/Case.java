package jeu;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Case {
	
	public final static int NB_CASES_X = 28,NB_CASES_Y = 36;
	
	public enum TYPE_CASE{
		Vide,Point,GrosPoint,BlocH,BlocV,BlocNW,BlocNE,BlocSW,BlocSE;
	}
	
	private TYPE_CASE type = TYPE_CASE.Vide;
	
	private static BufferedImage[] images = loadImages();
			
	private static BufferedImage[] loadImages(){
		BufferedImage[] images = new BufferedImage[TYPE_CASE.values().length];
		for(int i = 0 ; i<TYPE_CASE.values().length;i++){
			try {
				images[i] = ImageIO.read(Case.class.getClass().getResource(("/images/" + TYPE_CASE.values()[i].toString() + ".gif")));
			} catch (IOException e) {
				System.out.println("Missing Image: " + TYPE_CASE.values()[i].toString() + ".gif");
			}
			catch (java.lang.IllegalArgumentException e) {
				System.out.println("Missing Image: " + TYPE_CASE.values()[i].toString() + ".gif");
			}
			
		}
		return images;
	}
	
	public BufferedImage getImage(){
		return images[type.ordinal()];
	}
	
	public Case(){
		
	}
	
	public Case(TYPE_CASE type){
		this();
		this.type = type;
	}
	
	public TYPE_CASE getType(){
		return type;
	}

	public void setType(TYPE_CASE type) {
		this.type = type;
	}
	
	public boolean estBloc(){
		return type.toString().contains("Bloc");
	}
}
