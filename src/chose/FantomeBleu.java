package chose;

import java.awt.Point;
import java.awt.image.BufferedImage;

import jeu.Case;
import jeu.Serveur;

import affichage.outils.SpriteSheetLoader;

public class FantomeBleu extends Fantome {

	@Override
	public void mettreAJour() {
		if (Serveur.getPoints() < 30){
			resetTempsDebut();
		}
		super.mettreAJour();
	}

	private FantomeRouge rouge;
	
	public FantomeBleu(FantomeRouge rouge) {
			super();
			setCase(14,14);
			ajusterPosition();
			homeTile = new Point(26,33);
			targetTile = homeTile;
			sprites = SpriteSheetLoader.loadSheet(Pacman.class.getClass().getResource("/images/pacman/" + "Mouvement_spriteMap.gif"));
			this.rouge = rouge;
		}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		if(estSurCaseDecision()){
			return sprites[1];
		}
		
		return sprites[0];
	}

	@Override
	protected Point choisirTargetTile() {

		Point middleTarget = joueur.getProchainePositionAvecErreur(2);
		
		Point actualTarget = new Point(middleTarget.x + (middleTarget.x - rouge.getCase().x),middleTarget.y + (middleTarget.y - rouge.getCase().y));
		
		if(actualTarget.x < 0) actualTarget.x = 0;
		if(actualTarget.x >= Case.NB_CASES_X) actualTarget.x = Case.NB_CASES_X - 1;
		
		if(actualTarget.y < 0) actualTarget.y = 0;
		if(actualTarget.y >= Case.NB_CASES_Y) actualTarget.y = Case.NB_CASES_Y - 1;
		
		return actualTarget;
	}

}
