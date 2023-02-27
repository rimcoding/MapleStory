package maple_story;

import javax.swing.ImageIcon;

public class MagicianSkill extends Skill {

	private ImageIcon energyBall;
	private final int SKILL_SPEED = 5;

	public MagicianSkill(MapleFrame mContext) {
		super(mContext);
		initData();
		setInitLayout();
		initThread();
	}

	@Override
	void initData() {
		energyBall = new ImageIcon("images/skills/Magician0.png");
		damage = 12345;
	}

	@Override
	void setInitLayout() {
		x = mContext.getCharacter().getX();
		y = mContext.getCharacter().getY() - 30;
		setIcon(energyBall);
		setSize(164, 164);
		setLocation(x, y);
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

	public void left() {
		left = true;

		for (int i = 0; i < 100; i++) {
			x -= SKILL_SPEED;
			setLocation(x, y);
			if (510 <= y && y <= 530) {
				if (Math.abs(mContext.getRedSnail().getX() - (x + 85)) < 10 && mContext.getRedSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getRedSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getRedSnail());
						break;
					}
				}
			} else if (240 <= y && y <= 260) {
				if (Math.abs(mContext.getBlueSnail().getX() - (x + 85)) < 10 && mContext.getBlueSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getBlueSnail().damaged(damage);
					if (mContext.getBlueSnail().getState() == mContext.DEAD) {
						remove(mContext.getBlueSnail());
						break;
					}
				}
			} else if (y >= 50 && y <= 70) {
				if (Math.abs(mContext.getSnail().getX() - (x + 85)) < 10 && mContext.getSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getSnail().damaged(damage);
					if (mContext.getSnail().getState() == mContext.DEAD) {
						remove(mContext.getSnail());
						break;
					}
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearenergyBall();
	}

	public void right() {
		left = true;
		for (int i = 0; i < 100; i++) {
			x += SKILL_SPEED;
			setLocation(x, y);
			if (510 <= y && y <= 530) {
				if (Math.abs(mContext.getRedSnail().getX() - (x + 85)) < 10 && mContext.getRedSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getRedSnail().damaged(damage);
					if (mContext.getRedSnail().getState() == mContext.DEAD) {
						remove(mContext.getRedSnail());
						break;
					}
				}
			} else if (240 <= y && y <= 260) {
				if (Math.abs(mContext.getBlueSnail().getX() - (x + 85)) < 10 && mContext.getBlueSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getBlueSnail().damaged(damage);
					if (mContext.getBlueSnail().getState() == mContext.DEAD) {
						remove(mContext.getBlueSnail());
						break;
					}
				}
			} else if (y >= 50 && y <= 70) {
				if (Math.abs(mContext.getSnail().getX() - (x + 85)) < 10 && mContext.getSnail().getState() == mContext.ALIVE) {
					setIcon(null);
					mContext.getSnail().damaged(damage);
					if (mContext.getSnail().getState() == mContext.DEAD) {
						remove(mContext.getSnail());
						break;
					}
				}
			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearenergyBall();
	}

	private void clearenergyBall() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setIcon(null);
	}

	public void crash() {

	}

}
