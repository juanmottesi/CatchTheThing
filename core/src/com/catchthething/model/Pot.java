package com.catchthething.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.catchthething.GameComponent;
import com.catchthething.helpers.MovementEntry;
import com.catchthething.TextureManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Pot extends Sprite implements GameComponent, MovementEntry {

    private Sprite shadow;
    private float powerUp = 4f;
    private float cooldownPowerUp = 10f;
    private Boolean caught;
    private Animation animation;
    private Animation animationShadow;
    private float animationTime = 0;

    public Pot(){
        super(new TextureRegion(TextureManager.pot), 0,0, 200,200);
        this.setPosition(0,15);
        this.addEntries(Arrays.asList(Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.SPACE));
        shadow = new Sprite(new TextureRegion(TextureManager.shodowPot), 0,0, 200,200);
        shadow.setPosition(0,15);
        //Animation
        caught = false;
        TextureRegion[][] regionsPot = TextureRegion.split(TextureManager.pot, 200,200);
        Array<TextureRegion> regionsUtils = new Array<>();
        for(int i = 0; i < regionsPot[0].length; i++){
            regionsUtils.add(regionsPot[0][i]);
        }
        animation = new Animation(1/9f, regionsUtils);
    }

    @Override
    public void update(float delta) {
        this.movement();
        powerUp += delta;
        if(powerUp > 0) cooldownPowerUp -= delta;
    }

    @Override
    public void draw(SpriteBatch spriteBatch){
        /*if(this.isCaught()){
            animationTime += Gdx.graphics.getDeltaTime();
            if(animationTime > 1f){
                animationTime = 0;
                caught = false;
            }
        }
        spriteBatch.draw(animation.getKeyFrame(animationTime, true), this.getX(), this.getY());*/
        super.draw(spriteBatch);
    }

    public void shadowDraw(SpriteBatch spriteBatch){
        shadow.draw(spriteBatch);
    }

    public void movementToLeft() {
        if(powerUp < 3f) {
            this.translate(-10,0);
            this.shadow.translate(-10, 0);
        }else{
            this.translate(-5, 0);
            this.shadow.translate(-5, 0);
        }
    }

    public void movementToRight() {
        if(powerUp < 3f) {
            this.translate(10,0);
            this.shadow.translate(10,0);
        }else{
            this.translate(5, 0);
            this.shadow.translate(5, 0);
        }
    }

    public void movementToSpace(){
        if(cooldownPowerUp < 0) {
            this.powerUp = 0;
            this.cooldownPowerUp = 10f;
        }
    }

    public void onCaught(){
        caught = true;
    }
    public boolean isCaught(){
        return caught;
    }

}



