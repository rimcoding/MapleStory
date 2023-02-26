package maple_story;

import javax.swing.ImageIcon;

public class Magician extends Character {
	
	private MagicianSkill magicianSkill;
	

	public MagicianSkill getMagicianSkill() {
		return magicianSkill;
	}

	public void setMagicianSkill(MagicianSkill magicianSkill) {
		this.magicianSkill = magicianSkill;
	}

	public Magician(MapleFrame mContext) {
		super(mContext);
		lv = 10;
		maxHp = 300;
		maxMp = 500;
		hp = maxHp;
		mp = maxMp;
		str = 5;
		wis = 30;
		initData();
		setInitLayout();
	}

	private void initData() {
		playerL[0] = new ImageIcon("images/characters/magician_walk1L.png");
		playerL[1] = new ImageIcon("images/characters/magician_walk2L.png");
		playerL[2] = new ImageIcon("images/characters/magician_walk3L.png");
		playerR[0] = new ImageIcon("images/characters/magician_walk1R.png");
		playerR[1] = new ImageIcon("images/characters/magician_walk2R.png");
		playerR[2] = new ImageIcon("images/characters/magician_walk3R.png");
		playerSwingL[0] = new ImageIcon("images/characters/magician_swing0L.png");
		playerSwingL[1] = new ImageIcon("images/characters/magician_swing1L.png");
		playerSwingL[2] = new ImageIcon("images/characters/magician_swing2.png");
		playerSwingR[0] = new ImageIcon("images/characters/magician_swing0R.png");
		playerSwingR[1] = new ImageIcon("images/characters/magician_swing1R.png");
		playerSwingR[2] = new ImageIcon("images/characters/magician_swing2R.png");
		playerLadder[0] = new ImageIcon("images/characters/magician_ladder0.png");
		playerLadder[1] = new ImageIcon("images/characters/magician_ladder1.png");
	}

	private void setInitLayout() {
		setSize(70, 70);
		x = 250;
		y = 300;
		setLocation(x, y);
		setIcon(playerR[0]);
	}

	@Override
	void useSkill1() {
		
		magicianSkill = new MagicianSkill(mContext);
		mContext.add(magicianSkill);

	}

	@Override
	void useSkill2() {
		// TODO Auto-generated method stub

	}

}
