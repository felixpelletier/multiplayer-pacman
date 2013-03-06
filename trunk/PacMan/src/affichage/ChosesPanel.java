package affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import jeu.Case;
import jeu.Case.TYPE_CASE;
import jeu.Chose;

public class ChosesPanel extends JPanel{

	ArrayList<Chose> choses;
	
	public ChosesPanel(ArrayList<Chose> choses){
		this.choses = choses;
	}
	
	public void paintComponent(Graphics g) {
		
		
		setOpaque(false);
		
		g.translate(getInsets().left + getInsets().right, getInsets().top);
		
		for(Chose chose : choses){
			g.drawImage(chose.getImage(),(int) chose.getPosition().x,(int) chose.getPosition().y,chose.getLargeur(),chose.getHauteur(),null);
		
		}
		
		//super.paintComponent(g);
		
     }
	
}