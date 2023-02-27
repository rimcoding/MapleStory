package maple_story;

import javax.swing.ImageIcon;

public class Warrior extends Character {

	public Warrior(MapleFrame mContext) {
		super(mContext);
		initData();
		setInitLayout();
		lv = 10;
		maxHp = 500;
		maxMp = 300;
		hp = maxHp;
		mp = maxMp;
	}

	private void initData() {
		playerL[0] = new ImageIcon("images/characters/warior_walk01.png");
		playerL[1] = new ImageIcon("images/characters/warior_walk02.png");
		playerL[2] = new ImageIcon("images/characters/warior_walk03.png");
		playerR[0] = new ImageIcon("images/characters/warior_walk1R.png");
		playerR[1] = new ImageIcon("images/characters/warior_walk2R.png");
		playerR[2] = new ImageIcon("images/characters/warior_walk3R.png");
		playerSwingL[0] = new ImageIcon("images/characters/warior_swing00.png");
		playerSwingL[1] = new ImageIcon("images/characters/warior_swing01.png");
		playerSwingL[2] = new ImageIcon("images/characters/warior_swing2.png");
		playerSwingR[0] = new ImageIcon("images/characters/warior_swing00R.png");
		playerSwingR[1] = new ImageIcon("images/characters/warior_swing01R.png");
		playerSwingR[2] = new ImageIcon("images/characters/warior_swing2R.png");
		playerLadder[0] = new ImageIcon("images/characters/warior_ladder0.png");
		playerLadder[1] = new ImageIcon("images/characters/warior_ladder1.png");

	}

	private void setInitLayout() {
		setSize(200, 200);
		x = 50;
		y = 500;
		setLocation(x, y);
		setIcon(playerR[0]);
	}

	@Override
	void useSkill1() {

	}

	@Override
	void useSkill2() {

	}

}
