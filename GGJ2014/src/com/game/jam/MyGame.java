package com.game.jam;

import java.util.HashMap;

import screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class MyGame extends Game {
	public HashMap<String, Texture> textures = new HashMap<String, Texture>();
	
	@Override
	public void create() {
		textures.put("circle", new Texture(Gdx.files.internal("data/circle.png")));
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		getScreen().dispose();
	}

	@Override
	public void render() {		
		getScreen().render(0);
	}

	@Override
	public void resize(int width, int height) {
		getScreen().resize(width, height);
	}

	@Override
	public void pause() {
		getScreen().pause();
	}

	@Override
	public void resume() {
		getScreen().resume();
	}
}
