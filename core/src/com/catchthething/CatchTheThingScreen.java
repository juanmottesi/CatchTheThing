package com.catchthething;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.catchthething.model.Pot;
import com.catchthething.model.SeedSpawner;
import com.catchthething.model.Sun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatchTheThingScreen extends ScreenAdapter {

    private CatchTheThingGame game;
    private OrthographicCamera camera;
    private List<GameComponent> components;
    private Pot mainPlayer;
    private Sun sun;

    public CatchTheThingScreen(CatchTheThingGame game){
        this.game = game;
        this.components = new ArrayList<>();
        this.initializeCamera();
        this.initializeComponents();
        sun = new Sun();
    }

    private void initializeCamera() {
        this.camera = new OrthographicCamera(800,600);
    }

    private void initializeComponents(){
        this.initializePot();
        this.initializeSpawner();
    }

    private void initializePot(){
        this.mainPlayer = new Pot();
    }

    private void initializeSpawner(){
        this.addComponent(new SeedSpawner(this));
    }

    public void addComponent(GameComponent gameComponent){
        this.components.add(gameComponent);
    }

    public void render(float delta) {
        this.renderBackground();
        this.update(delta);
        this.draw();
    }

    private void renderBackground(){
        TextureManager.backgroundSprite.draw(this.game.getBatch());
    }

    private void update(float delta) {
        this.camera.update();
        this.mainPlayer.update(delta);
        new ArrayList<>(this.components).forEach(component -> component.update(delta));
        this.sun.update(delta);
    }

    private void draw(){
        this.mainPlayer.shadowDraw(this.game.getBatch());
        new ArrayList<>(this.components).forEach(component -> component.draw(this.game.getBatch()));
        this.mainPlayer.draw(this.game.getBatch());
        this.sun.draw(this.game.getBatch());
    }

    public Pot getMainPlayer(){
        return  this.mainPlayer;
    }

    public void removeComponent(GameComponent gameComponent){
        this.components.remove(gameComponent);
    }

}