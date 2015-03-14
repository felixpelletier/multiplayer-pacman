package affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import chose.Chose;


import jeu.Case;
import jeu.Case.TYPE_CASE;

public class ChosesPanel extends JPanel{

	LinkedList<Chose> choses;
	
	public ChosesPanel(LinkedList<Chose> choses){
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