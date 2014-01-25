package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.jam.MyGame;

public class Player extends Actor 
{
	private float _acceleration; 
	private float _maxSpeed;
	private float _deceleration;
	private float _dx;
	private float _dy;
	private float _threshold;
	private float _vec;
	private boolean _move;
	
	
	public Player(MyGame game, SpriteBatch batch, Texture tex) 
	{
		super(game, batch, tex);
		
		_threshold = 0f;
		_maxSpeed = 8;
		_acceleration = 60;
		_deceleration = 35;
		
	}

	
	public void move() 
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			_dx -= Gdx.graphics.getDeltaTime() * _acceleration;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) 
		{
			_dx += Gdx.graphics.getDeltaTime() * _acceleration;
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) 
		{
			_dy -= Gdx.graphics.getDeltaTime() * _acceleration;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			_dy += Gdx.graphics.getDeltaTime() * _acceleration;
		}
		
		System.out.println("value of vec: " + _vec);
		_vec = (float) Math.sqrt(_dx * _dx + _dy * _dy);
		
		if(_vec > _threshold)
		{
			_dx -= (_dx / _vec) * _deceleration * Gdx.graphics.getDeltaTime();
			_dy -= (_dy / _vec) * _deceleration * Gdx.graphics.getDeltaTime();
		}
		if(_vec > _maxSpeed)
		{
			_dx = (_dx / _vec) * _maxSpeed;
			_dy = (_dy / _vec) * _maxSpeed;
		}
		
		setPosition(getX()+_dx, getY()+_dy);
	}

	@Override
	public void act() 
	{
		move();
	}

}
