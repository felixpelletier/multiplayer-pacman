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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.RepaintManager;

import jeu.Case;
import jeu.Case.TYPE_CASE;
import jeu.Chose;

public class FenetreJeu extends JFrame{

	private Case[][] Cases;

	public static final int LARGEUR = 560, HAUTEUR = 720;

	public static final int TAILLE_CASE = LARGEUR / Case.NB_CASES_X;

	ArrayList<Chose> choses = new ArrayList<Chose>();
	
	Graphics g;
	
	private PointPanel pointPanel = null;
	private MurPanel murPanel = null;
	private ChosesPanel chosesPanel = null;

	public FenetreJeu(Case[][] Cases){

		this.Cases = Cases;
		
		g = this.getGraphics();
		
		pointPanel = new PointPanel(Cases,TAILLE_CASE);
		murPanel = new MurPanel(Cases,TAILLE_CASE);
		chosesPanel = new ChosesPanel(choses);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p =new JPanel();
		OverlayLayout l = new OverlayLayout(p);
		p.setLayout(l);
		p.setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
		
		p.add(chosesPanel);
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
}
