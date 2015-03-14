package chose;

import java.awt.Point;
import java.awt.image.BufferedImage;

import pathFinder.PathFinder;

import chose.Fantome.MODE;

import affichage.outils.SpriteSheetLoader;

/**
 * Ce fant�me commence � l'ext�rieur de la "maison des fant�mes". Il se
 * dirige g�n�ralement directement vers Pacman. Il suit presque toujours directement
 * Pacman � moins que le "myope" l'am�ne vers la mauvaise direction. Dans 2 points d�finit de 
 * chaque niveau, qui est bas� sur le nombre de point restant, sa vitesse augmente de 5 % et son
 * comportement change en "mode �parpillement".
 * 
 * 
 * @author Jonathan Moreau-Collin
 *
 */
public class FantomeRouge extends Fantome
{
	
	
	public FantomeRouge(){
		setCase(14,14);
		ajusterPosition();
		homeTile = new Point(26,4);
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
		return joueur.getCase();
	}

}
