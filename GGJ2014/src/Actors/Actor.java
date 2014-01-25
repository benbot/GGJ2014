package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.jam.MyGame;

public abstract class Actor extends Sprite {
	SpriteBatch batch;
	MyGame game;
	public boolean toRemove = false;
	
	public Actor(MyGame game, SpriteBatch batch, Texture tex) {
		super();
		this.batch = batch;
		this.game = game;
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
