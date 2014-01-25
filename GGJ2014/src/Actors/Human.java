package Actors;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.jam.MyGame;


public class Human extends Character {
	Rectangle rect;
	Vector2 direction;
	Random rand = new Random();
	float speed;
	
	public Human(MyGame game, SpriteBatch batch, Texture tex) {
		super(game, batch, tex);
		double rads = rand.nextDouble() * Math.PI * 2;
		direction = new Vector2((float)Math.cos(rads), (float)Math.sin(rads));
		Gdx.app.log("Human Vel", direction.x + " : " + direction.y);
		speed = (rand.nextFloat() + 0.2f) * 50;
		setPosition(rand.nextInt(Gdx.graphics.getWidth() / 2) + Gdx.graphics.getWidth() / 4, rand.nextInt(Gdx.graphics.getHeight() / 2) + Gdx.graphics.getHeight() / 4);
		rect = new Rectangle(getX(), getY(), tex.getWidth(), tex.getHeight());
	}
	
	@Override
	public void act() {
		if(getX() > Gdx.graphics.getWidth() || getY() > Gdx.graphics.getHeight())
		{
			toRemove = true;
		}
		
		if(isPressed())
		{
			toRemove = true;
		}
		
		setPosition(getX() + direction.x * speed * Gdx.graphics.getDeltaTime(), getY() + direction.y * speed * Gdx.graphics.getDeltaTime());
		rect.x = getX();
		rect.y = getY();
	}

	public boolean isPressed() {
		if(Gdx.input.isTouched()) {
			if(rect.contains(Gdx.input.getX(), Gdx.input.getY())){
				Gdx.app.log("I am ", "touched.");
				return true;
			}
		}
		
		return false;
	}
}
