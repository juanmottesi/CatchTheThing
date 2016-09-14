package com.catchthething.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.catchthething.CatchTheThingScreen;
import com.catchthething.GameComponent;

import java.util.Random;

public class SeedSpawner implements GameComponent {

    private float cooldown;
    private float timer;
    private CatchTheThingScreen screen;

    public SeedSpawner(CatchTheThingScreen screen){
        this.screen = screen;
        timer = 0.0f;
        cooldown = this.generateCooldown() * 2;
    }

    @Override
    public void update(float  delta) {
        if(timer >= cooldown) {
            this.spawnBall();
            timer = 0;
            cooldown = this.generateCooldown() * 2;
        } else {
            timer += delta;
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch){}

    private void spawnBall() {
        Seed seed = new Seed(this.screen);
        this.screen.addComponent(seed);
    }

    public float generateCooldown() {
        float newNumber = new Random().nextFloat();
        return ( newNumber* 0.5f) + 0.2f;
    }

}
