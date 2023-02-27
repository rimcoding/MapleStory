package maple_story;

public interface Move {
	
	void left();
	void right();
	default public void jump() {};
	void fall();
}
