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

public class BackgroundPlayerService extends JPanel implements Runnable {

	private BufferedImage image;
	private Character character;
	MapleFrame mContext;

	public BackgroundPlayerService(Character character, MapleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		this.character = character;
		try {
			image = ImageIO.read(new File("images/backgroundmap.png"));
		} catch (IOException e) {
			System.out.println("이미지 경로를 찾을 수 없습니다.");
		}
	}

	private void setInitLayout() {
		setLocation(mContext.getBgX(), mContext.getBgY());

	}

	private void initData() {

	}

	@Override
	public void run() {
		while (true) {
			// 왼쪽
			Color leftColor = new Color(image.getRGB(character.getX(), character.getY()));
			// 오른쪾
			Color rightColor = new Color(image.getRGB(character.getX(), character.getY()));

			int bottomColorLeft = image.getRGB(character.getX(), character.getY());
			int bottomColorRight = image.getRGB(character.getX(), character.getY());

			System.out.println(bottomColorLeft);
			if (bottomColorLeft != -1) {
				character.setDown(false);
			} else {
				if (character.isUp() == false && character.isDown() == false) {
					character.down();
				}
			}

			if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				character.setFall(false);
			} else if (leftColor.getRed() == 0 && leftColor.getGreen() == 255 && leftColor.getBlue() == 0) {
				character.setUp(true);
				character.setDown(true);
			}
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end of while

	}

//	
//	private JLabel label;
//	private JLabel background;
//	private Player player;
//	private MapleFrame mapleFrame;
//	
//	public BackgroundPlayerService(Player player) {
//		this.player = player;
//		background = new JLabel(new ImageIcon("images/맵1/backgroundmap.png"));
//		background.setSize(1000,800);
//		background.setLocation(mapleFrame.getBgX(),mapleFrame.getBgY());
//		//setLocation(mapleFrame.getx, mapleFrame.gety)
//	}
//
//	@Override
//	public void run() {
//	
//		background.setLocation(mapleFrame.getBgX(), mapleFrame.getBgY());
//		repaint();
//			//setlo(mapleFrame.getBgX(), mapleFrame.getBgX());
//			 //repaint
//		
//		
//	}
//
//		
//	
//}

}