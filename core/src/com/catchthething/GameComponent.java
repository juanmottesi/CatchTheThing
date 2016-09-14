package com.catchthething;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameComponent {

    void update(float delta);
    void draw(SpriteBatch spriteBatch);

}
