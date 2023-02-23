package maple_story;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapleFrame extends JFrame implements Moveable {

	private MapleFrame mContext = this;
	private Character character;
	private JLabel background;
	private int playerX;
	private int playerY;
	private int bgX;
	private int bgY;

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getBgX() {
		return bgX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}
	
	public MapleFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		background = new JLabel(new ImageIcon("images/map/background1.png"));
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background.setSize(1530, 1350);
		character = new Magician(this);
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		add(character);
		add(background);
		bgX = 0;
		bgY = -500;
		background.setLocation(bgX, bgY);
		setVisible(true);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					left();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down();
				} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {

				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					jump();
				} else if (e.getKeyCode() == KeyEvent.VK_1) {
					item1();
				} else if (e.getKeyCode() == KeyEvent.VK_2) {
					item2();
				} else if (e.getKeyCode() == KeyEvent.VK_3) {
					item3();
				} else if (e.getKeyCode() == KeyEvent.VK_4) {
					item4();
				}

			}
		});
	}

	@Override
	public void left() {
		bgX += 10;
		int x = character.getX() - 10;
		int y = playerY;
		if (x < 0) {
			x = 0;
			playerX = 0;
		}
		if (playerX < 100) {
			bgX = 0;
		}

		character.setLocation(x, y);
		background.setLocation(bgX, bgY);
	}

	@Override
	public void right() {
		bgX -= 10;
		int x = playerX += 10;
		int y = playerY;

		if (playerX > 500) {
			bgX = -500;
		}

		character.setLocation(x, y);
		background.setLocation(bgX, bgY);
	}

	@Override
	public void up() {
		bgY += 10;
		int x = playerX;
		int y = playerY -= 10;
		if (y < 0) {
			y = 0;
			playerY = 0;
		}
		if (playerY < 150) {
			bgY = 0;
		}

		character.setLocation(x, y);
		background.setLocation(bgX, bgY);
	}

	@Override
	public void down() {
		bgY -= 10;
		int x = playerX;
		int y = playerY += 10;
		if (playerY > 100) {
			bgY = -500;
		}
		background.setLocation(bgX, bgY);
		character.setLocation(x, y);
	}

	@Override
	public void jump() {

		background.setLocation(bgX, bgY);
		character.setLocation(playerX, playerY);
	}

	@Override
	public void item1() {

	}

	@Override
	public void item2() {

	}

	@Override
	public void item3() {

	}

	@Override
	public void item4() {

	}

	public static void main(String[] args) {
		new MapleFrame();
	}

}
