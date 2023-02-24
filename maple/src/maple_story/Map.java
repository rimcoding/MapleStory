package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends JLabel{
	
	private int x, y;
	private ImageIcon map;
	private MapleFrame mContext;
	
	public Map(MapleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
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



	public ImageIcon getMap() {
		return map;
	}



	public void setMap(ImageIcon map) {
		this.map = map;
	}



	public MapleFrame getmContext() {
		return mContext;
	}



	public void setmContext(MapleFrame mContext) {
		this.mContext = mContext;
	}



	private void initData() {
		map = new ImageIcon("images/map/background1.png");
		setSize(1400, 850);
		x = 0;
		y = 0;
	}
	private void setInitLayout() {
		setLocation(x, y);
		setIcon(map);
	}

}
