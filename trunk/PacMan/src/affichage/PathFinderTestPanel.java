

package affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JPanel;

import pathFinder.Node;
import pathFinder.PathFinder;

import jeu.Case;
import jeu.Chose;
import jeu.Personnage;

public class PathFinderTestPanel extends JPanel{

	private Case[][] cases;
	private int tailleCase;
	private ArrayList<Chose> choses;
	
	public PathFinderTestPanel(Case[][] cases, int tailleCase, ArrayList<Chose> choses){
		this.cases = cases;
		this.tailleCase = tailleCase;
		this.choses = choses;
	}
	
	public void paintComponent(Graphics g) {
		
		g.translate(getInsets().left + getInsets().right, getInsets().top);
		
		Point[] path = PathFinder.getPath(cases, new Point(1,4), ((Personnage) (choses.get(0))).getCase());
				
		for(Point point : path){
			g.setColor(Color.white);

			g.drawRect(point.x * tailleCase, point.y * tailleCase, tailleCase, tailleCase);
		}
		//super.paintComponent(g);
		
     }
	
}

