package maple_story;

import javax.swing.ImageIcon;

public class Warrior extends Character{

	
	
	public Warrior() {
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
		playerL[0] = new ImageIcon("images/warior_walk01.png");
		playerL[1] = new ImageIcon("images/warior_walk02.png");
		playerL[2] = new ImageIcon("images/warior_walk03.png");
		playerR[0] = new ImageIcon("images/warior_walk1R.png");
		playerR[1] = new ImageIcon("images/warior_walk2R.png");
		playerR[2] = new ImageIcon("images/warior_walk3R.png");
		playerSwingL[0] = new ImageIcon("images/warior_swing00.png");
		playerSwingL[1] = new ImageIcon("images/warior_swing01.png");
		playerSwingL[2] = new ImageIcon("images/warior_swing2.png");
		playerSwingR[0] = new ImageIcon("images/warior_swing00R.png");
		playerSwingR[1] = new ImageIcon("images/warior_swing01R.png");
		playerSwingR[2] = new ImageIcon("images/warior_swing2R.png");
		playerLadder[0] = new ImageIcon("images/warior_ladder0.png");
		playerLadder[1] = new ImageIcon("images/warior_ladder1.png");
	}
	
	private void setInitLayout() {

	}
	
	@Override
	void useSkill1() {
		
		
	}

	@Override
	void useSkill2() {
		
		
	}

	@Override
	public void fall() {
		
		
	}


}
