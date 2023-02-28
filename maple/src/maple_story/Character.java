package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Character extends JLabel implements CharacterMove {

	MapleFrame mContext;
	// 상태
	private PlayerWay pWay;

	protected boolean left;
	protected boolean right;
	protected boolean jump;
	protected boolean fall; // 떨어지는거
	protected int state;
	// 좌표
	protected int x, y;
	// 캐릭터 이미지
	protected ImageIcon[] playerL = new ImageIcon[3];
	protected ImageIcon[] playerR = new ImageIcon[3];
	protected ImageIcon playerLevelUp;
	// 속도
	protected final int SPEED = 8;
	protected final int JUMP_SPEED = 2;
	// 캐릭터 스탯
	protected int maxHp;
	protected int hp;
	protected int maxMp;
	protected int mp;
	protected int lv;
	final int MAX_EXP = 100;
	protected int exp;
	// 배열 숫자용
	protected int arrN;
	// 아이템
	protected int hpPotion;
	protected int mpPotion;
	// 메이플 프레임

	public Character(MapleFrame mContext) {
		this.mContext = mContext;
		hpPotion = 999;
		mpPotion = 999;
		exp = 0;
		playerLevelUp = new ImageIcon("images/characters/levelup.gif");
	}

	public PlayerWay getpWay() {
		return pWay;
	}

	public void setpWay(PlayerWay pWay) {
		this.pWay = pWay;
	}

	public MapleFrame getmContext() {
		return mContext;
	}

	public void setmContext(MapleFrame mContext) {
		this.mContext = mContext;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon[] getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon[] playerL) {
		this.playerL = playerL;
	}

	public ImageIcon[] getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon[] playerR) {
		this.playerR = playerR;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getArrN() {
		return arrN;
	}

	public void setArrN(int arrN) {
		this.arrN = arrN;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMP_SPEED() {
		return JUMP_SPEED;
	}

	public boolean isFall() {
		return fall;
	}

	public void setFall(boolean fall) {
		this.fall = fall;
	}

	public int getHpPotion() {
		return hpPotion;
	}

	public void setHpPotion(int hpPotion) {
		this.hpPotion = hpPotion;
	}

	public int getMpPotion() {
		return mpPotion;
	}

	public void setMpPotion(int mpPotion) {
		this.mpPotion = mpPotion;
	}

	@Override
	public void left() {
		pWay = PlayerWay.LEFT;
		left = true;
		right = false;
		arrN = 1;
		setIcon(playerL[1]);
		// 한번 키보다 왼쪽 방향 키를 누르면 쓰레드 생성
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					setIcon(playerL[arrN]);
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (x < 16) {
						x = 12;
					} else {
						x -= SPEED;
					}
					setLocation(x, y);
					arrN += 1;
					if (arrN > 2) {
						arrN = 0;
					}
				} // end of while

			}
		}).start();
	}

	@Override
	public void right() {
		pWay = PlayerWay.RIGHT;
		right = true;
		arrN = 1;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					setIcon(playerR[arrN]);
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (x > 1266) {
						x = 1270;
					} else {
						x += SPEED;
					}
					setLocation(x, y);
					arrN += 1;
					if (arrN > 2) {
						arrN = 0;
					}
				}
			}
		}).start();
	}

	@Override
	public void jump() {
		jump = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 300 / JUMP_SPEED; i++) {
					if (y < 2) {
						y = 0;
					} else {
						y -= JUMP_SPEED;
					}
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				jump = false;
				fall();
			}
		}).start();
	}

	@Override
	public void fall() {
		fall = true;
		new Thread(new Runnable() {

			@Override
			public void run() {

				while (fall) {
					y += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				fall = false;
			}
		}).start();
	}

	public void beattackLeft(int damage) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				hp -= damage;
				DamagedSkin skin = new DamagedSkin(mContext, damage);
				mContext.add(skin);
				x -= 100;
				y -= 30;
				setLocation(x, y);
				mContext.getHpState().setText("HP:  " + hp + " / " + maxHp);
				mContext.getHealthBar1().setValue((int) (hp * 100 / maxHp));

				if (hp <= 0) {
					mContext.dispose();
					new Die();
				}
			}
		}).start();
	}

	public void beattackRight(int damage) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				hp -= damage;
				DamagedSkin skin = new DamagedSkin(mContext, damage);
				mContext.add(skin);
				if (x < 1200) {
					x += 100;
				} else {
					x = 1300;
				}
				y -= 30;
				setLocation(x, y);
				mContext.getHpState().setText("HP:  " + hp + " / " + maxHp);
				mContext.getHealthBar1().setValue((int) (hp * 100 / maxHp));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (hp <= 0) {
					mContext.dispose();
					new Die();

				}

			}
		}).start();
	}

	abstract void useSkill1();

	abstract void useSkill2();

	public void useHpPotion() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (hp == maxHp) {
					// 체력이 가득 차서 포션 못먹음
				} else {
					hpPotion--;
					mContext.getHpPotionCount().setText("" + hpPotion);
					hp += 100;
					if (hp > maxHp) {
						hp = maxHp;
						// 체력이 maxHp - hp 만큼 참
					}
				}
				mContext.getHpState().setText("HP:  " + hp + " / " + maxHp);
				mContext.getHealthBar1().setValue((int) (hp * 100 / maxHp));
			}
		}).start();
	}

	public void useMpPotion() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (mp == maxMp) {
					// 체력이 가득 차서 포션 못먹음
				} else {
					mpPotion--;
					mContext.getMpPotionCount().setText("" + mpPotion);
					mp += 100;
					if (mp > maxMp) {
						mp = maxMp;
						// 체력이 maxHp - hp 만큼 참
					}
				}
				mContext.getMpState().setText("MP:  " + mp + " / " + maxMp);
				mContext.getHealthBar2().setValue((int) (mp * 100 / maxMp));
			}
		}).start();
	}

	public void takeExp(int exp) {
		this.exp += exp;
		System.out.println(this.exp);
		if (this.exp > MAX_EXP) {
			levelUp();
		}
		mContext.getExpBar().setValue(this.exp);
		mContext.getExpState().setText("EXP: " + this.exp + " / " + MAX_EXP + " (Lv: " + lv + ")");
		mContext.getExpState().setText("EXP: " + this.exp + " / " + MAX_EXP + " (Lv: " + lv + ")");
	}

	public void levelUp() {
		lv++;
		maxHp += 50;
		hp = maxHp;
		maxMp += 50;
		mp = maxMp;
		exp -= 100;
		mContext.getHpState().setText("HP:  " + hp + " / " + maxHp);
		mContext.getMpState().setText("MP:  " + mp + " / " + maxMp);
		mContext.getHealthBar2().setValue((int) (mp * 100 / maxMp));
		mContext.getHealthBar1().setValue((int) (hp * 100 / maxHp));
	}
}
