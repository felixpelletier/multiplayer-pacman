

package affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import chose.Chose;
import chose.Personnage;


import pathFinder.Node;
import pathFinder.PathFinder;

import jeu.Case;

public class PathFinderTestPanel extends JPanel{

	private Case[][] cases;
	private int tailleCase;
	private LinkedList<Chose> choses;
	
	public PathFinderTestPanel(Case[][] cases, int tailleCase, LinkedList<Chose> choses){
		this.cases = cases;
		this.tailleCase = tailleCase;
		this.choses = choses;
	}
	
	public void paintComponent(Graphics g) {
		
		g.translate(getInsets().left + getInsets().right, getInsets().top);
		
		Point[] path = PathFinder.getPathExcluding(cases, new Point(1,4), ((Personnage) (choses.get(0))).getCase(), new Point(2,4));
				
		for(Point point : path){
			g.setColor(Color.white);

			g.drawRect(point.x * tailleCase, point.y * tailleCase, tailleCase, tailleCase);
		}
		//super.paintComponent(g);
		
     }
	
}

