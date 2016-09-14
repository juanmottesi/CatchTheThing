package com.catchthething.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.catchthething.CatchTheThingScreen;
import com.catchthething.GameComponent;
import com.catchthething.TextureManager;

import java.util.Random;

class Seed extends Sprite implements GameComponent {

    Vector2 initialAcceleration = new Vector2(0, -10); // gravity
    Vector2 initialVelocity = new Vector2(new Random().nextFloat() * 10, 0);
    CatchTheThingScreen screen;

    public Seed(CatchTheThingScreen screen){
        super(TextureManager.seed);
        this.setPosition(0,550);
        this.screen = screen;
    }

    @Override
    public void update(float delta) {
        this.translate(initialVelocity.x + initialAcceleration.x * delta , initialVelocity.y + initialAcceleration.y * delta);
        this.checkOverlaps();
        this.updateModel(delta);
    }

    private void checkOverlaps(){
        if(this.screen.getMainPlayer().getBoundingRectangle().overlaps(this.getBoundingRectangle())){
            this.screen.removeComponent(this);
            this.screen.getMainPlayer().onCaught();
        }
    }

    private void updateModel(float delta){
        initialVelocity = new Vector2(initialVelocity.x + initialAcceleration.x * delta , initialVelocity.y + initialAcceleration.y * delta);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        float angle = (new Vector2(this.initialVelocity.x, this.initialVelocity.y).angle()) + 90;
        spriteBatch.draw(new TextureRegion(this.getTexture()), this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(),this.getScaleX(), this.getScaleY(), angle);
    }
}
