package Actors;

import screens.GameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.game.jam.MyGame;

public class Player extends Actor 
{
	
	
	public Player(MyGame game, SpriteBatch batch, Texture tex, int posX, int posY) 
	{
		super(game, batch, tex);
		
		setPosition(posX, posY);
	}

	
	public void move() 
	{
		body.applyForceToCenter(new Vector2(100, 0), true);
		
		setPosition(body.getPosition().x, body.getPosition().y);
	}

	@Override
	public void act() 
	{
		move();
	}


	@Override
	public void setUpPhysics(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(new Vector2(getX(), getY()));
		
		PolygonShape rect = new PolygonShape();
		rect.setAsBox(getWidth(), getHeight());
		
		FixtureDef fix = new FixtureDef();
		fix.shape = rect;
		fix.restitution = 0.3f;
	
		
		body = world.createBody(bodyDef);
		body.createFixture(fix);
	}


}
