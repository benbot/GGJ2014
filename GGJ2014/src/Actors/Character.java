package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Character extends Sprite {
	SpriteBatch batch;
	
	public Character(SpriteBatch batch, Texture tex) {
		super();
		this.batch = batch;
		setTexture(tex);
		
	}

	public void act() {
		Gdx.app.log("thing", "THING");
	}
	
	public void draw()
	{
		act();
		batch.begin();
		batch.draw(getTexture(), getX(), getY());
		batch.end();
	}
	
}
