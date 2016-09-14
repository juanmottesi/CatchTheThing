package com.catchthething.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MovementEntry{

    List<Integer> entries = new ArrayList<>();

    default void addEntries(List<Integer> entries){
        this.entries.addAll(entries);
    }

    default void movement(){
        this.execMovement(entries.stream().filter(entry -> Gdx.input.isKeyPressed(entry) | Gdx.input.isKeyJustPressed(entry)).findFirst());
    }

    default void execMovement(Optional<Integer> movement){
        if(movement.isPresent()){
            String key = Input.Keys.toString(movement.get());
            try{
                this.getClass().getDeclaredMethod("movementTo"+ key).invoke(this);
            }catch (Exception e) {
               throw new RuntimeException(e.getMessage());
            }
        }
    }

}
