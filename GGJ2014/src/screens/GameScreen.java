package screens;

import java.util.ArrayList;

import Actors.Human;
import Actors.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.game.jam.MyGame;

public class GameScreen implements Screen {
	private OrthographicCamera camera = new OrthographicCamera();
	private SpriteBatch batch = new SpriteBatch();
	private double pastTime = 0.0;
	private MyGame game;
	private ArrayList<Human> humans = new ArrayList<Human>();
	private Player player;
	public World world;
	
	public GameScreen(MyGame game) {
		this.game = game;
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		world = new World(new Vector2(0, 0), true);
		player = new Player(game, batch, game.textures.get("circle"), 100, 100);
		player.setUpPhysics(world);
	}
	
	public ArrayList<Human> getHumans() {
		return humans;
	}
	
	private void update() {
		pastTime += Gdx.graphics.getDeltaTime();
		
		if(humans.size() < 20 && pastTime >= 2.5)
		{
			Human tempHuman = new Human(game, batch, game.textures.get("circle"));
			Gdx.app.log("Human Coords", tempHuman.getX() + " : " + tempHuman.getY());
			humans.add(tempHuman);
			pastTime = 0;
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 0, 1, 0);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		
		update();
		ArrayList<Object> tempRemoveList = new ArrayList<Object>();
		for(Human human : humans ) {
			human.draw();
			
			if(human.toRemove) {
				tempRemoveList.add(human);
			}
		}
		
		player.draw();
		
		for(Object human : tempRemoveList) {
			humans.remove(human);
		}
		
		world.step(1f/60f, 6, 2);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
