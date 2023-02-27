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
	private Item hpPotion;
	private Item mpPotion;
	private Keys keys;
	private JLabel hpPotionCount;
	private JLabel mpPotionCount;
	private JLabel hpState;
	private JLabel mpState;
	private JLabel expState;
	private Snail snail;
	private BlueSnail blueSnail;
	private RedSnail redSnail;
	private JProgressBar healthBar1 = new JProgressBar(0, 100);
	private JProgressBar healthBar2 = new JProgressBar(0, 100);
	private JProgressBar expBar = new JProgressBar(0, 100);
	private int stateSnail, stateBlueSnail, stateRedSnail = -1;
	final int ALIVE = 0;
	final int DEAD = 1;

	public int getStateSnail() {
		return stateSnail;
	}

	public void setStateSnail(int stateSnail) {
		this.stateSnail = stateSnail;
	}

	public int getStateBlueSnail() {
		return stateBlueSnail;
	}

	public void setStateBlueSnail(int stateBlueSnail) {
		this.stateBlueSnail = stateBlueSnail;
	}

	public int getStateRedSnail() {
		return stateRedSnail;
	}

	public void setStateRedSnail(int stateRedSnail) {
		this.stateRedSnail = stateRedSnail;
	}

	public Item getHpPotion() {
		return hpPotion;
	}

	public void setHpPotion(Item hpPotion) {
		this.hpPotion = hpPotion;
	}

	public Item getMpPotion() {
		return mpPotion;
	}

	public void setMpPotion(Item mpPotion) {
		this.mpPotion = mpPotion;
	}

	public JLabel getHpState() {
		return hpState;
	}

	public void setHpState(JLabel hpState) {
		this.hpState = hpState;
	}

	public JLabel getMpState() {
		return mpState;
	}

	public void setMpState(JLabel mpState) {
		this.mpState = mpState;
	}

	public JLabel getExpState() {
		return expState;
	}

	public void setExpState(JLabel expState) {
		this.expState = expState;
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

	public JProgressBar getExpBar() {
		return expBar;
	}

	public void setExpBar(JProgressBar expBar) {
		this.expBar = expBar;
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
		expBar.setMaximum(character.MAX_EXP);
	}

	private void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 850);
		character = new Magician(this);
		map = new Map(mContext);
		backgroundPlayerService = new BackgroundPlayerService(this);
		healthBar1.setValue((int) (character.getHp() * 100 / character.getMaxHp()));
		healthBar2.setValue((int) (character.getMp() * 100 / character.getMaxMp()));
		expBar.setValue(character.getExp());
		healthBar1.setForeground(Color.RED); // 체력바 색상 설정
		healthBar1.setBounds(50, 50, 200, 20); // 위치 및 크기 설정
		healthBar2.setForeground(Color.BLUE);
		healthBar2.setBounds(50, 100, 200, 20);
		expBar.setForeground(Color.GREEN);
		expBar.setBounds(50, 150, 200, 20);
		hpPotion = new Item(this);
		hpPotion.setIcon(hpPotion.getHpPotion());
		mpPotion = new Item(this);
		mpPotion.setIcon(mpPotion.getMpPotion());
		keys = new Keys(this);
		hpPotionCount = new JLabel();
		mpPotionCount = new JLabel();
		hpState = new JLabel();
		mpState = new JLabel();
		expState = new JLabel();
		snail = new Snail(mContext, maple_story.MonsterWay.LEFT);
		blueSnail = new BlueSnail(mContext, maple_story.MonsterWay.LEFT);
		redSnail = new RedSnail(mContext, maple_story.MonsterWay.LEFT);
		new Bgm();
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
		hpState.setSize(200, 20);
		mpState.setSize(200, 20);
		expState.setSize(200, 20);
		hpState.setLocation(60, 50);
		mpState.setLocation(60, 100);
		expState.setLocation(60, 150);
		hpPotion.setLocation(1300, 700);
		mpPotion.setLocation(1300, 750);
		keys.setLocation(100, 670);
		hpPotionCount.setText("" + character.getHpPotion());
		mpPotionCount.setText("" + character.getMpPotion());
		hpState.setText("HP:  " + character.getHp() + " / " + character.getMaxHp());
		mpState.setText("MP:  " + character.getMp() + " / " + character.getMaxMp());
		expState.setText("EXP: " + character.getExp() + " / " + character.MAX_EXP + " (Lv: " + character.getLv() + ")");
		setContentPane(map);
		add(hpPotionCount);
		add(mpPotionCount);
		add(hpState);
		add(mpState);
		add(expState);
		add(character);
		add(healthBar1);
		add(healthBar2);
		add(expBar);
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
				} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					character.useSkill1();
				} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					character.useSkill2();
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!character.isFall() && !character.isJump()) {
						character.jump();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_1) {
					character.useHpPotion();
				} else if (e.getKeyCode() == KeyEvent.VK_2) {
					character.useMpPotion();
				} else if (e.getKeyCode() == KeyEvent.VK_R) {
					if (stateSnail == DEAD) {
						snail = new Snail(mContext, maple_story.MonsterWay.LEFT);
						add(snail);
					}
					if (stateBlueSnail == DEAD) {
						blueSnail = new BlueSnail(mContext, maple_story.MonsterWay.LEFT);
						add(blueSnail);
					}
					if (stateRedSnail == DEAD) {
						redSnail = new RedSnail(mContext, maple_story.MonsterWay.LEFT);
						add(redSnail);
					}
				}

			}
		});
	}

	public static void main(String[] args) {
		new MapleFrame();
	}

}
