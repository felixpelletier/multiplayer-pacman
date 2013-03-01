package affichage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import jeu.Case;

public class MurPanel extends JPanel{

	private Case[][] Cases;
	private int tailleCase;
	
	public MurPanel(Case[][] Cases, int tailleCase){
		this.Cases = Cases;
		this.tailleCase = tailleCase;
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);

		g.translate(getInsets().left + getInsets().right, getInsets().top);
		
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(int y = 0;y<Case.NB_CASES_Y;y++){
			for(int x = 0;x<Case.NB_CASES_X;x++){
				try{
					if(Cases[x][y].getType().name().contains("Bloc")){
						g.drawImage(Cases[x][y].getImage(), x*tailleCase, y*tailleCase, tailleCase, tailleCase, null);
					}
				} catch(java.lang.NullPointerException e){
				}
			}
		}
		
     }
	
}
