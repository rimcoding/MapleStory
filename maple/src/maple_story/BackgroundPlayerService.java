package maple_story;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	MapleFrame mContext;

	public BackgroundPlayerService(MapleFrame mContext) {
		this.mContext = mContext;
		try {
			image = ImageIO.read(new File("images/map/backgroundmap.png"));
		} catch (IOException e) {
			System.out.println("이미지 경로를 찾을 수 없습니다.");
		}
	}

	@Override
	public void run() {
		while (true) {
			Color bottomColor = new Color(
					image.getRGB(mContext.getCharacter().getX() + 40, mContext.getCharacter().getY() + 95));
			Color bottomColorLeft = new Color(
					image.getRGB(mContext.getCharacter().getX(), mContext.getCharacter().getY() + 95));
			Color bottomColorRight = new Color(
					image.getRGB(mContext.getCharacter().getX() + 70, mContext.getCharacter().getY() + 95));
			if ((bottomColorLeft.getRed() == 255 && bottomColorLeft.getBlue() == 0 && bottomColorLeft.getGreen() == 0)
					|| (bottomColorRight.getRed() == 255 && bottomColorRight.getBlue() == 0
							&& bottomColorRight.getGreen() == 0)) {
				mContext.getCharacter().setFall(false);
			} else {
				if (mContext.getCharacter().isJump() == false && mContext.getCharacter().isFall() == false) {
					mContext.getCharacter().fall();
				}
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} // end of while

	}

}