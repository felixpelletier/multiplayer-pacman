package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import jeu.Case;
import jeu.Case.TYPE_CASE;
import jeu.Chose;
import jeu.Pacman;
import jeu.Personnage;

public class FenetreJeu extends JFrame{

	private Case[][] Cases;

	private int largeur = 560,hauteur = 720;
	private int tailleCase = largeur / Case.NB_CASES_X;

	ArrayList<Chose> choses = new ArrayList<Chose>();

	Pacman j = new Pacman();
	
	Graphics g;

	public FenetreJeu(Case[][] Cases){

		this.Cases = Cases;
		
		g = this.getGraphics();
		
		PointPanel pointPanel = new PointPanel(Cases,tailleCase);
		MurPanel murPanel = new MurPanel(Cases,tailleCase);
		ChosesPanel chosesPanel = new ChosesPanel(choses);
		
		addChose(j);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p =new JPanel();
		OverlayLayout l = new OverlayLayout(p);
		p.setLayout(l);
		p.setPreferredSize(new Dimension(largeur,hauteur));
		
		p.add(chosesPanel);
		p.add(pointPanel);
		p.add(murPanel);
		
		this.add(p, BorderLayout.CENTER);
		
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		pointPanel.repaint();
		
	}
	
	public int getTailleCase() {
		return tailleCase;
	}
	
	public void addChose(Chose chose){
		choses.add(chose);
	}
}
