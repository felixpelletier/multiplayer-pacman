package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import jeu.Case;
import jeu.Case.TYPE_CASE;

public class FenetreJeu extends JFrame{

	private Case[][] Cases;

	private int largeur = 560,hauteur = 720;
	private int tailleCase = largeur / Case.NB_CASES_X;

	

	Graphics g;

	public FenetreJeu(Case[][] Cases){

		this.Cases = Cases;
		
		g = this.getGraphics();
		
		PointPanel pointPanel = new PointPanel(Cases,tailleCase);
		MurPanel murPanel = new MurPanel(Cases,tailleCase);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p =new JPanel();
		OverlayLayout l = new OverlayLayout(p);
		p.setLayout(l);
		p.setPreferredSize(new Dimension(largeur,hauteur));
		
		p.add(pointPanel);
		p.add(murPanel);
		
		this.add(p, BorderLayout.CENTER);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cases[1][4] = new Case(TYPE_CASE.Vide);
		pointPanel.repaint();
		
	}
	
	public int getTailleCase() {
		return tailleCase;
	}
}
