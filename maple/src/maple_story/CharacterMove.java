package maple_story;

public interface CharacterMove {

	void left();

	void right();

	default public void jump() {
	};

	void fall();
}
