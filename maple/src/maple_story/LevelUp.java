package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LevelUp extends JLabel{
	
	private ImageIcon levelUp;
	private MapleFrame mContext;
	
	public LevelUp(MapleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		initThread();
	}
	
	private void initData() {
		levelUp = new ImageIcon("images/characters/levelup.gif");
		
	}
	
	private void setInitLayout() {
		setSize(302, 363);
		
	}
	
	private void initThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				setLocation(mContext.getCharacter().getX() - 116, mContext.getCharacter().getY() - 290);
				setIcon(levelUp);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(null);
				
			}
		}).start();
	}
	
}
