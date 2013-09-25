package chose;

import java.awt.Point;
import java.awt.image.BufferedImage;

import affichage.outils.SpriteSheetLoader;

public class FantomeRose extends Fantome{
	
	public FantomeRose() {
			super();
			setCase(14,14);
			ajusterPosition();
			homeTile = new Point(2,4);
			targetTile = homeTile;
			sprites = SpriteSheetLoader.loadSheet(Pacman.class.getClass().getResource("/images/pacman/" + "Mouvement_spriteMap.gif"));
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
		
		return joueur.getProchainePositionAvecErreur(4);
	}

}
