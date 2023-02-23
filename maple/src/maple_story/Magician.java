package maple_story;

import javax.swing.ImageIcon;

public class Magician extends Character {

	public Magician() {
		lv = 10;
		maxHp = 500;
		maxMp = 300;
		hp = maxHp;
		mp = maxMp;
		str = 30;
		wis = 5;
		initData();
		setInitLayout();
	}
	
	
	private void initData() {
		playerL[0] = new ImageIcon("images/magician_walk1L.png");
		playerL[1] = new ImageIcon("images/magician_walk2L.png");
		playerL[2] = new ImageIcon("images/magician_walk3L.png");
		playerR[0] = new ImageIcon("images/magician_walk1R.png");
		playerR[1] = new ImageIcon("images/magician_walk2R.png");
		playerR[2] = new ImageIcon("images/magician_walk3R.png");
		playerSwingL[0] = new ImageIcon("images/magician_swing0L.png");
		playerSwingL[1] = new ImageIcon("images/magician_swing1L.png");
		playerSwingL[2] = new ImageIcon("images/magician_swing2.png");
		playerSwingR[0] = new ImageIcon("images/magician_swing0R.png");
		playerSwingR[1] = new ImageIcon("images/magician_swing1R.png");
		playerSwingR[2] = new ImageIcon("images/magician_swing2R.png");
		playerLadder[0] = new ImageIcon("images/magician_ladder0.png");
		playerLadder[1] = new ImageIcon("images/magician_ladder1.png");
	}
	
	private void setInitLayout() {

	}
	
	@Override
	void useSkill1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void useSkill2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}

	
}
