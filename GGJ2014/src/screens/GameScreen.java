package screens;

import java.util.ArrayList;

import Actors.Human;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.jam.MyGame;

public class GameScreen implements Screen {
	private OrthographicCamera camera = new OrthographicCamera();
	private SpriteBatch batch = new SpriteBatch();
	private double pastTime = 0.0;
	private MyGame game;
	private ArrayList<Human> humans = new ArrayList<Human>();
	
	public GameScreen(MyGame game) {
		this.game = game;
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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

		for(Object human : tempRemoveList) {
			humans.remove(human);
		}
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
