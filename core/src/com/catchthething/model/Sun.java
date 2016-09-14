package com.catchthething.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.catchthething.GameComponent;
import com.catchthething.TextureManager;

public class Sun extends Sprite implements GameComponent {

    private float currentRotation;
    private float rotationSpeed;

    public Sun(){
        super(TextureManager.sun);
        this.translate(-150,-150);
        this.currentRotation = 0.0f;
        this.rotationSpeed = (float)(Math.PI) / 1000f;
    }

    public void update(float deltaTime){
        currentRotation += rotationSpeed * deltaTime;
    }

    public void draw(SpriteBatch spriteBatch){
        this.rotate(currentRotation);
        super.draw(spriteBatch);
    }
}
