package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MainMenu implements Screen {
	private Stage stage = new Stage();
	private ImageButton playButton;
	private Game game;
	
	
	public MainMenu(Texture playTexture, Game game ) {
		this.game = game;
		Gdx.input.setInputProcessor(stage);
		playButton = new ImageButton(new SpriteDrawable(new Sprite(playTexture)));
		stage.addActor(playButton);
		
	}
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(playButton.isPressed())
		{
			game.setScreen(new GameScreen(game));
		}
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		//stage.setViewport(width, height, false);
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
