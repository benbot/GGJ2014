package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Player extends Actor 
{
	private float _acceleration; 
	private float _maxSpeed;
	private float _deceleration;
	private float _dx;
	private float _dy;
	private float vec;
	
	
	public Player(String filename) 
	{
		super(filename);
		
		_maxSpeed = 300;
		_acceleration = 200;
		_deceleration = 10;
		
	}

	@Override
	public void move() 
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT)) _dx -= Gdx.graphics.getDeltaTime() * _acceleration;
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) _dx += Gdx.graphics.getDeltaTime() * _acceleration;
		if(Gdx.input.isKeyPressed(Keys.UP)) _dy -= Gdx.graphics.getDeltaTime() * _acceleration;
		if(Gdx.input.isKeyPressed(Keys.DOWN)) _dy += Gdx.graphics.getDeltaTime() * _acceleration;
		
		vec = (float) Math.sqrt(_dx * _dx + _dy * _dy);
		if(vec > 0)
		{
			_dx -= (_dx /vec) * _deceleration * Gdx.graphics.getDeltaTime();
			_dy -= (_dy / vec) * _deceleration * Gdx.graphics.getDeltaTime();
		}
		if(vec > _maxSpeed)
		{
			_dx = (_dx / vec) * _maxSpeed;
			_dy = (_dy / vec) * _maxSpeed;
		}
		
		setPosition(getX()+_dx, getY()+_dy);
	}

	@Override
	public void update() 
	{
		move();
	}

}