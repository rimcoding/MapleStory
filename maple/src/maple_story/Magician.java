package maple_story;

import javax.swing.ImageIcon;

public class Magician extends Character {

	private MagicianSkill magicianSkill;
	private MagicianSkill2 magicianSkill2;
	private final int SKILL1_MP = 80;
	private final int SKILL2_MP = 50;
	private LevelUp levelUp;

	public MagicianSkill getMagicianSkill() {
		return magicianSkill;
	}

	public void setMagicianSkill(MagicianSkill magicianSkill) {
		this.magicianSkill = magicianSkill;
	}

	public Magician(MapleFrame mContext) {
		super(mContext);
		lv = 1;
		maxHp = 300;
		maxMp = 500;
		hp = maxHp;
		mp = maxMp;
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
	}

	private void setInitLayout() {
		setSize(70, 70);
		x = 50;
		y = 300;
		setLocation(x, y);
		setIcon(playerR[0]);
	}

	@Override
	void useSkill1() {
		if (mp > SKILL1_MP) {
			mp -= SKILL1_MP;
			magicianSkill = new MagicianSkill(mContext);
			mContext.add(magicianSkill);
			mContext.getHealthBar2().setValue((int) (mp * 100 / maxMp));
			mContext.getMpState().setText("MP:  " + mp + " / " + maxMp);
			mContext.getExpState().setText("EXP: " + this.exp + " / " + MAX_EXP + " (Lv: " + lv + ")");
			repaint();
		}

	}

	@Override
	void useSkill2() {
		if (mp > SKILL2_MP) {
			mp -= SKILL2_MP;
			magicianSkill2 = new MagicianSkill2(mContext);
			mContext.add(magicianSkill2);
			mContext.getHealthBar2().setValue((int) (mp * 100 / maxMp));
			mContext.getMpState().setText("MP:  " + mp + " / " + maxMp);
			mContext.getExpState().setText("EXP: " + this.exp + " / " + MAX_EXP + " (Lv: " + lv + ")");
		}
	}

	@Override
	public void useHpPotion() {
		super.useHpPotion();

	}

	@Override
	public void useMpPotion() {
		super.useMpPotion();
	}

	@Override
	public void levelUp() {
		super.levelUp();
		levelUp = new LevelUp(mContext);
		mContext.add(levelUp);

	}

}
