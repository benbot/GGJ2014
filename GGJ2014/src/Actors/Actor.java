package Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Actor extends Sprite {
	
	public Actor(String filename) {
		super();

		this.setTexture(new Texture(filename));
	}
	
	public abstract void move();
	
	
	public abstract void update();
	
}
