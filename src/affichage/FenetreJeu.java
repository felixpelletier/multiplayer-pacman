package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.RepaintManager;

import chose.Chose;


import jeu.Case;
import jeu.Case.TYPE_CASE;

public class FenetreJeu extends JFrame{

	private Case[][] Cases;

	public static final int LARGEUR = 560, HAUTEUR = 720;

	public static final int TAILLE_CASE = LARGEUR / Case.NB_CASES_X;

	LinkedList<Chose> choses = new LinkedList<Chose>();
	
	Graphics g;
	
	private PointPanel pointPanel = null;
	private MurPanel murPanel = null;
	private ChosesPanel chosesPanel = null;
	private PathFinderTestPanel pathFinderTestPanel = null;

	public FenetreJeu(Case[][] Cases, LinkedList<Chose> choses){

		this.Cases = Cases;
		
		g = this.getGraphics();
		
		this.choses = choses;
		
		pointPanel = new PointPanel(Cases,TAILLE_CASE);
		murPanel = new MurPanel(Cases,TAILLE_CASE);
		chosesPanel = new ChosesPanel(choses);
		pathFinderTestPanel = new PathFinderTestPanel(Cases,TAILLE_CASE,choses);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p =new JPanel();
		OverlayLayout l = new OverlayLayout(p);
		p.setLayout(l);
		p.setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
		
		p.add(chosesPanel);
		p.add(pathFinderTestPanel);
		p.add(pointPanel);
		p.add(murPanel);
		
		this.add(p, BorderLayout.CENTER);
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public int getTailleCase() {
		return TAILLE_CASE;
	}
	
	public void addChose(Chose chose){
		choses.add(chose);
	}

	public void repaintChoses() {
		chosesPanel.repaint();
	}
	
	public static int positionVersCase(double x){
		return (int) (x / TAILLE_CASE);
	}
	
	public static Point positionVersCase(double x,double y){
		return new Point(positionVersCase(x),positionVersCase(y));
	}
	
	public static Point positionVersCase(Point2D point){
		return new Point(positionVersCase(point.getX()),positionVersCase(point.getY()));
	}
	
	public static Point2D.Float caseVersPosition(Point point){
		return new Point2D.Float(point.x * TAILLE_CASE + TAILLE_CASE/2,point.y * TAILLE_CASE + TAILLE_CASE/2);
	}
}
