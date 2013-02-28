package affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

import jeu.Case;

public class FenetreJeu extends JFrame{

	private Case[][] Cases;

	private int largeur = 560,hauteur = 720;
	private int tailleCase = largeur / Case.NB_CASES_X;

	Graphics g;

	public FenetreJeu(Case[][] Cases){

		this.Cases = Cases;
		g = this.getGraphics();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(largeur,hauteur));
		getContentPane().setBackground(Color.BLACK);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		

	}
	
	public void paint(Graphics g)
	{
		
		super.paint(g);
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*2, HEIGHT*2);
		dessinerCases(g);
		
		
	}

	private void dessinerCases(Graphics g){
		
		for(int y = 0;y<Case.NB_CASES_Y;y++){
			for(int x = 0;x<Case.NB_CASES_X;x++){
				try{
					
					g.drawImage(Cases[x][y].getImage(), x*tailleCase, y*tailleCase, tailleCase, tailleCase, null);
				} catch(java.lang.NullPointerException e){
				}
			}
		}

	}
}
