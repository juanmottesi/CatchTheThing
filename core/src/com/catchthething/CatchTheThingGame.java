package com.catchthething;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CatchTheThingGame extends Game {

	private SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new CatchTheThingScreen(this));
	}

	public SpriteBatch getBatch(){
	    return this.batch;
    }

    @Override
    public void render () {
        batch.begin();
        super.render();
        batch.end();
    }
}

