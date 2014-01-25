package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MainMenu implements Screen {
	private SpriteBatch batch = new SpriteBatch ();
	private Sprite play = new Sprite ();
	private ImageButton playButton;
	private Game game;
	
	
	public MainMenu(Texture playTexture, Game game ) {
		this.game = game;
		play.setTexture(playTexture);
		playButton = new ImageButton(new SpriteDrawable(play));
		
	}
	

	@Override
	public void render(float delta) {
		if(playButton.isPressed())
		{
			game.setScreen(null);
		}
		batch.begin();
		playButton.draw(batch, 1);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
