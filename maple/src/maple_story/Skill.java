package maple_story;

import javax.swing.JFrame;
import javax.swing.JLabel;


public abstract class Skill extends JLabel {
	
	// 좌표
	protected int x, y;
	// 데미지 mp소모량
	protected int damage;
	// 방향
	protected boolean left; 
	protected boolean right;
	// mContext
	protected MapleFrame mContext;
	//적을 맞춘 상태 0 안맞 1 맞
	protected int state;
	
	public Skill(MapleFrame mContext) {
		this.mContext = mContext;
		
	}
	
	abstract void initData();
	abstract void setInitLayout();
	abstract void initThread(); 
	abstract void used();
}
