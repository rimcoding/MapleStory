package maple_story;

import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class WarriorSkill extends Skill implements MonsterMove {

	private ImageIcon Bash[] = new ImageIcon[3];
	private final int SKILL_SPEED = 5;
	
	public WarriorSkill(MapleFrame mContext) {
		super(mContext);
		
	}
	
	@Override
	void initData() {
		Bash[0] = new ImageIcon("images/sklls/warriorskill0");
		Bash[1] = new ImageIcon("images/sklls/warriorskill1");
		Bash[2] = new ImageIcon("images/sklls/warriorskill2");
		Bash[3] = new ImageIcon("images/sklls/warriorskill3");
		state = 0;
	}

	@Override
	void setInitLayout() {
		x = mContext.getCharacter().getX();
		x = mContext.getCharacter().getY();
		for (int i = 0; i < Bash.length; i++) {
				setIcon(Bash[i]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setIcon(null);
		}
		setSize(200,200);
		setLocation(x,y);
	}

	@Override
	void initThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if (mContext.getCharacter().getpWay() == PlayerWay.LEFT) {
					left();
				}else {
					right();
				}
			}
		}).start();
	}

	@Override
	void used() {
		
	}

	@Override
	public void left() {
		left = true;
		for(int i = 0; i < 100; i++) {
			x -= SKILL_SPEED;
			setLocation(x,y);
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void right() {
		right = true;
		for(int i = 0; i < 100; i++) {
			x++;
			setLocation(x,y);
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clearBash();
		}
	}
	private void clearBash() {
		try {
			Thread.sleep(500);
			setIcon(Bash[0]); 
			Thread.sleep(50);
			setIcon(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}


	
	
}
