package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.game.jam.MyGame;

public abstract class Actor extends Sprite {
	protected SpriteBatch batch;
	protected MyGame game;
	protected Body body;
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
	
	public abstract void setUpPhysics(World world);
	
	public void draw()
	{
		act();
		batch.begin();
		batch.draw(getTexture(), getX(), getY());
		batch.end();
	}
}
