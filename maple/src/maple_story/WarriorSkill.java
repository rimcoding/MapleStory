package maple_story;

import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class WarriorSkill extends Skill implements MonsterMove {

	private ImageIcon[] bashLeft = new ImageIcon[3];
	private ImageIcon[] bashRight = new ImageIcon[3];

	public WarriorSkill(MapleFrame mContext) {
		super(mContext);
		initData();
		setInitLayout();
		initThread();
	}

	@Override
	void initData() {
		bashLeft[0] = new ImageIcon("images/skills/warriorskill0.png");
		bashLeft[1] = new ImageIcon("images/skills/warriorskill1.png");
		bashLeft[2] = new ImageIcon("images/skills/warriorskill2.png");
		bashRight[0] = new ImageIcon("images/skills/warriorskill3.png");
		bashRight[1] = new ImageIcon("images/skills/warriorskill4.png");
		bashRight[2] = new ImageIcon("images/skills/warriorskill5.png");
		state = 0;
		damage = 22222;
	}

	@Override
	void setInitLayout() {
		setSize(250, 250);
	}

	@Override
	void initThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (mContext.getCharacter().getpWay() == PlayerWay.LEFT) {
					left();
				} else {
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
		x = mContext.getCharacter().getX() - 150;
		y = mContext.getCharacter().getY() - 110;
		setLocation(x, y);
		for (int i = 0; i < bashRight.length; i++) {
			setIcon(bashLeft[i]);
			if (430 <= y && y <= 450) {
				if (Math.abs((x + 120) - mContext.getRedSnail().getX()) < 100
						&& mContext.getRedSnail().getState() == mContext.ALIVE) {
					mContext.getRedSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getRedSnail());
						break;
					}
				}
			} else if (170 <= y && y <= 190) {
				if (Math.abs((x + 120) - mContext.getBlueSnail().getX()) < 100
						&& mContext.getRedSnail().getState() == mContext.ALIVE) {
					mContext.getBlueSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getBlueSnail());
						break;
					}
				}
			} else if (y >= -50) {
				if (Math.abs((x + 120) - mContext.getSnail().getX()) < 100
						&& mContext.getRedSnail().getState() == mContext.ALIVE) {
					mContext.getSnail().damaged(damage);
					if (mContext.getSnail().getState() == mContext.DEAD) {
						remove(mContext.getSnail());
						break;
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearBash();
	}

	@Override
	public void right() {
		right = true;
		x = mContext.getCharacter().getX() - 30;
		y = mContext.getCharacter().getY() - 100;
		setLocation(x, y);
		for (int i = 0; i < bashRight.length; i++) {
			setIcon(bashRight[i]);
			if (440 <= y && y <= 470) {
				if (Math.abs(mContext.getRedSnail().getX() - (x + 120)) < 100
						&& mContext.getRedSnail().getState() == mContext.ALIVE) {
					mContext.getRedSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getRedSnail());
						break;
					}
				}
			} else if (170 <= y && y <= 190) {
				if (Math.abs(mContext.getBlueSnail().getX() - (x + 120)) < 100
						&& mContext.getBlueSnail().getState() == mContext.ALIVE) {
					mContext.getBlueSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getBlueSnail());
						break;
					}
				}
			} else if (0 > y && y >= -30) {
				if (Math.abs(mContext.getSnail().getX() - (x + 120)) < 100
						&& mContext.getSnail().getState() == mContext.ALIVE) {
					mContext.getSnail().damaged(damage);
					if (mContext.getSnail().getState() == mContext.DEAD) {
						remove(mContext.getSnail());
						break;
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearBash();
	}

	private void clearBash() {

		setIcon(null);
	}

	@Override
	public void die() {

	}

}
