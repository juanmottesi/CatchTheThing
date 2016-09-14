package com.catchthething;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureManager {
    public static Texture seed = new Texture("semilla.png");
    public static Texture pot = new Texture("maceta.png");
    public static Texture shodowPot = new Texture("maceta-shadow.png");
    public static Sprite backgroundSprite = new Sprite(new Texture("background.png"));
    public static Texture sun = new Texture("sun.png");
}
