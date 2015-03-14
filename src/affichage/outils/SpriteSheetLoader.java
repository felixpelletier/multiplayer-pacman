package affichage.outils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public final class SpriteSheetLoader {

	public static BufferedImage[] loadSheet(URL input){
		URL infoURL = null;
		
		try {
			infoURL = new URL(input.toString().substring(0, input.toString().length()-4) + ".info");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int imageCount = 0;
		BufferedImage spriteSheet = null;
		
		try {
			imageCount = infoURL.openStream().read() - '0';
			spriteSheet = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage[] output = new BufferedImage[imageCount];
		
		int imageWidth = spriteSheet.getWidth() / imageCount;
		
		System.out.println(imageCount);
		
		for(int i = 0;i<imageCount;i++){
			output[i] = spriteSheet.getSubimage(i*imageWidth, 0, imageWidth, spriteSheet.getHeight());
		}
		
		return output;
		
	}
	
	
}
