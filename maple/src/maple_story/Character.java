package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Character extends JLabel implements Move {

	MapleFrame mContext;
	// 상태
	private PlayerWay pWay;
	
	protected boolean left;
	protected boolean right;
	protected boolean up; // 사다리 올라가기
	protected boolean down; // 사다리 내려가기
	protected boolean jump;
	protected boolean attack; // 공격 모션중 (공격이나 스킬사용중 움직이지 못하게)
	protected boolean fall; // 떨어지는거
	protected boolean leftWallCrash;
	protected boolean rightWallCrash;
	protected boolean ladder; // 사다리에 있는 상태
	// 좌표
	protected int x, y;
	// 캐릭터 이미지
	protected ImageIcon[] playerL = new ImageIcon[3];
	protected ImageIcon[] playerR = new ImageIcon[3];
	protected ImageIcon[] playerLadder = new ImageIcon[2];
	protected ImageIcon[] playerSwingL = new ImageIcon[3];
	protected ImageIcon[] playerSwingR = new ImageIcon[3];
	// 속도
	protected final int SPEED = 8;
	protected final int JUMP_SPEED = 2;
	// 캐릭터 스탯
	protected int maxHp;
	protected int hp;
	protected int maxMp;
	protected int mp;
	protected int str;
	protected int wis;
	protected int lv;
	// 배열 숫자용
	protected int arrN;
	// 아이템
	protected int hpPotion;
	protected int mpPotion;
	// 메이플 프레임

	
	
	public Character(MapleFrame mContext) {
		this.mContext = mContext;
		hpPotion = 10;
		mpPotion = 10;
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


	public boolean isLadder() {
		return ladder;
	}


	public void setLadder(boolean ladder) {
		this.ladder = ladder;
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

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
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

	public ImageIcon[] getPlayerLadder() {
		return playerLadder;
	}

	public void setPlayerLadder(ImageIcon[] playerLadder) {
		this.playerLadder = playerLadder;
	}

	public ImageIcon[] getPlayerSwingL() {
		return playerSwingL;
	}

	public void setPlayerSwingL(ImageIcon[] playerSwingL) {
		this.playerSwingL = playerSwingL;
	}

	public ImageIcon[] getPlayerSwingR() {
		return playerSwingR;
	}

	public void setPlayerSwingR(ImageIcon[] playerSwingR) {
		this.playerSwingR = playerSwingR;
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

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
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

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
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
	public void up() {
		
		ladder = true;
		arrN = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {
					setIcon(playerLadder[arrN]);
					repaint();
					y -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					arrN += 1;
					if (arrN > 1) {
						arrN = 0;
					}
				}
				up = false;
			}
		}).start();
	}

	@Override
	public void down() {
		left = false;
		right = false;
		ladder = true;
		arrN = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					setIcon(playerLadder[arrN]);
					repaint();
					y += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					arrN += 1;
					if (arrN > 1) {
						arrN = 0;
					}
					
				}
				down = false;
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

	@Override
	public void attackLeft() {
		attack = true;
		for (int i = 0; i < playerSwingL.length; i++) {
			setIcon(playerSwingL[i]);
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void attackRight() {
		attack = false;
		for (int i = 0; i < playerSwingR.length; i++) {
			setIcon(playerSwingR[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	abstract void useSkill1();

	abstract void useSkill2();

	public void useHpPotion() {
		if (hp == maxHp) {
			// 체력이 가득 차서 포션 못먹음
		} else {
			hp += 100;
			if (hp > maxHp) {
				hp = 100;
				// 체력이 maxHp - hp 만큼 참
			}
		}

	}

	public void useMpPotion() {
		if (mp == maxMp) {
			// 체력이 가득 차서 포션 못먹음
		} else {
			mp += 100;
			if (mp > maxMp) {
				mp = 100;
				// 체력이 maxHp - hp 만큼 참
			}
		}
	}

}
