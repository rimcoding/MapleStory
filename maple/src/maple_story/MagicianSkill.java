package maple_story;

import javax.swing.ImageIcon;



public class MagicianSkill extends Skill implements MonsterMove {

	private ImageIcon energyBall;
	private final int SKILL_SPEED = 5;

	public MagicianSkill(MapleFrame mContext) {
		super(mContext);
	}

	@Override
	void initData() {
		energyBall = new ImageIcon("images/skills/Magician0.png");
		state = 0;
	}

	@Override
	void setInitLayout() {
		x = mContext.getCharacter().getX();
		y = mContext.getCharacter().getY();
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
		for (int i = 0; i < 100; i++) {
			x -= SKILL_SPEED;
			setLocation(x, y);
			System.out.println("" + x + "" + y);

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearenergyBall();
	}

	@Override
	public void right() {
		left = true;
		for (int i = 0; i < 100; i++) {
			x += SKILL_SPEED;
			setLocation(x, y);

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
			setIcon(energyBall);
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
