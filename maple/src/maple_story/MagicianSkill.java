package maple_story;

import javax.swing.ImageIcon;



public class MagicianSkill extends Skill {

	private ImageIcon energyBall;
	private final int SKILL_SPEED = 5;


	public MagicianSkill(MapleFrame mContext) {
		super(mContext);
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
				}else {
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
	System.out.println(x+" "+y);
		 
		for  (int i = 0; i < 100; i++) {
			x -= SKILL_SPEED;
			setLocation(x, y);
			if (520 <= y && y <= 530) {
				if (Math.abs(mContext.getRedSnail().getX()-x) < 10 ) {
					setIcon(null);
					mContext.getRedSnail().damaged(damage);
					if(mContext.getRedSnail().getState() == 1) {
						remove(mContext.getRedSnail());
					}
				}
			}else if(250 <= y && y <= 260) {
				if (Math.abs(mContext.getBlueSnail().getX()-x) < 10 ) {
					setIcon(null);
					mContext.getBlueSnail().damaged(damage);
					if(mContext.getBlueSnail().getState() == 1) {
						remove(mContext.getBlueSnail());
					}
				}
			}else if (y <= 70) {
				if (Math.abs( mContext.getSnail().getX()-x) < 10) {
					setIcon(null);
					mContext.getSnail().damaged(damage);
					if(mContext.getSnail().getState() == 1) {
						remove(mContext.getSnail());
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
			if (520 <= y && y <= 530) {
				if (Math.abs(mContext.getRedSnail().getX()-x) < 10 ) {
					setIcon(null);
					mContext.getRedSnail().damaged(damage);
					if(mContext.getRedSnail().getState() == 1) {
						remove(mContext.getRedSnail());
					}
				}
			}else if(250 <= y && y <= 260) {
				if (Math.abs(mContext.getBlueSnail().getX()-x) < 10 ) {
					setIcon(null);
					mContext.getBlueSnail().damaged(damage);
					if(mContext.getBlueSnail().getState() == 1) {
						remove(mContext.getBlueSnail());
					}
				}
			}else if (y <= 70) {
				if (Math.abs( mContext.getSnail().getX()-x) < 10) {
					setIcon(null);
					mContext.getSnail().damaged(damage);
					if(mContext.getSnail().getState() == 1) {
						remove(mContext.getSnail());
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
