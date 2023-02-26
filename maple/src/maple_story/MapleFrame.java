package maple_story;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MapleFrame extends JFrame {

	private MapleFrame mContext = this;
	private Character character;
	private JLabel background;
	private BackgroundPlayerService backgroundPlayerService;
	private Map map;
	private item hpPotion;
	private item mpPotion;
	private Keys keys;
	private JLabel hpPotionCount;
	private JLabel mpPotionCount;
	private Snail snail;
	private BlueSnail blueSnail;
	private RedSnail redSnail;
	private JProgressBar healthBar1 = new JProgressBar(0,100);
	private JProgressBar healthBar2 = new JProgressBar(0,100);

	public item getHpPotion() {
		return hpPotion;
	}

	public void setHpPotion(item hpPotion) {
		this.hpPotion = hpPotion;
	}

	public item getMpPotion() {
		return mpPotion;
	}

	public void setMpPotion(item mpPotion) {
		this.mpPotion = mpPotion;
	}

	public Keys getKeys() {
		return keys;
	}

	public void setKeys(Keys keys) {
		this.keys = keys;
	}

	public JLabel getHpPotionCount() {
		return hpPotionCount;
	}

	public void setHpPotionCount(JLabel hpPotionCount) {
		this.hpPotionCount = hpPotionCount;
	}

	public JLabel getMpPotionCount() {
		return mpPotionCount;
	}

	public void setMpPotionCount(JLabel mpPotionCount) {
		this.mpPotionCount = mpPotionCount;
	}

	public Snail getSnail() {
		return snail;
	}

	public void setSnail(Snail snail) {
		this.snail = snail;
	}

	public BlueSnail getBlueSnail() {
		return blueSnail;
	}

	public void setBlueSnail(BlueSnail blueSnail) {
		this.blueSnail = blueSnail;
	}

	public RedSnail getRedSnail() {
		return redSnail;
	}

	public void setRedSnail(RedSnail redSnail) {
		this.redSnail = redSnail;
	}

	public JProgressBar getHealthBar1() {
		return healthBar1;
	}

	public void setHealthBar1(JProgressBar healthBar1) {
		this.healthBar1 = healthBar1;
	}

	public JProgressBar getHealthBar2() {
		return healthBar2;
	}

	public void setHealthBar2(JProgressBar healthBar2) {
		this.healthBar2 = healthBar2;
	}

	public MapleFrame getmContext() {
		return mContext;
	}

	public void setmContext(MapleFrame mContext) {
		this.mContext = mContext;
	}

	public BackgroundPlayerService getBackgroundPlayerService() {
		return backgroundPlayerService;
	}

	public void setBackgroundPlayerService(BackgroundPlayerService backgroundPlayerService) {
		this.backgroundPlayerService = backgroundPlayerService;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public MapleFrame() {
		initData();
		setInitLayout();
		addEventListener();
		new Thread(backgroundPlayerService).start();
	}
	
	public void updateHealthBar(int health) {
		healthBar1.setMaximum(500);
		healthBar2.setMaximum(500);
	}

	private void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 850);
		character = new Magician(this);
		map = new Map(mContext);
		backgroundPlayerService = new BackgroundPlayerService(this);
		healthBar1.setValue((int)(character.getHp()*100/character.getMaxHp()));
		healthBar1.setForeground(Color.RED); // 체력바 색상 설정
		healthBar1.setBounds(50,50,200,20); // 위치 및 크기 설정
		healthBar2.setValue((int)(character.getHp()*100/character.getMaxHp())); 
		healthBar2.setForeground(Color.BLUE); 
		healthBar2.setBounds(50,100,200,20); 
		hpPotion = new item(this);
		hpPotion.setIcon(hpPotion.getHpPotion());
		mpPotion = new item(this);
		mpPotion.setIcon(mpPotion.getMpPotion());
		keys = new Keys(this);
		hpPotionCount = new JLabel();
		mpPotionCount = new JLabel();
		snail = new Snail(mContext, maple_story.MonsterWay.LEFT);
		blueSnail = new BlueSnail(mContext, maple_story.MonsterWay.LEFT);
		redSnail = new RedSnail(mContext, maple_story.MonsterWay.LEFT);

	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(true);
		hpPotionCount.setSize(50, 30);
		hpPotionCount.setLocation(1305, 720);
		mpPotionCount.setSize(50, 30);
		mpPotionCount.setLocation(1305, 770);
		mpPotionCount.setSize(50, 30);
		hpPotion.setLocation(1300, 700);
		mpPotion.setLocation(1300, 750);
		keys.setLocation(100, 670);
		hpPotionCount.setText("" + character.getHpPotion());
		mpPotionCount.setText("" + character.getMpPotion());
		setContentPane(map);
		add(hpPotionCount);
		add(mpPotionCount);
		add(character);
		add(healthBar1); 
		add(healthBar2);
		add(snail);
		add(blueSnail);
		add(redSnail);
		add(hpPotion);
		add(mpPotion);
		add(keys);
		setVisible(true);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					character.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					character.setLeft(false);

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					character.setUp(false);

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					character.setDown(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!character.isRight()) {
						character.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!character.isLeft()) {
						character.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

				} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					character.useSkill1();
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!character.isFall() && !character.isJump()) {
						character.jump();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_1) {
					
				} else if (e.getKeyCode() == KeyEvent.VK_2) {
				} else if (e.getKeyCode() == KeyEvent.VK_3) {
				} else if (e.getKeyCode() == KeyEvent.VK_R) {
					snail = new Snail(mContext, maple_story.MonsterWay.LEFT);
					blueSnail = new BlueSnail(mContext, maple_story.MonsterWay.LEFT);
					redSnail = new RedSnail(mContext, maple_story.MonsterWay.LEFT);
					add(snail);
					add(blueSnail);
					add(redSnail);
				}

			}
		});
	}

	public static void main(String[] args) {
		new MapleFrame();
	}

}
