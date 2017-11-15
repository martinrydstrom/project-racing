package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Wall {

    private Sprite sprite;

    public Wall(String fileName, float x, float y, float sizeX, float sizeY){
        sprite = new Sprite(new Texture(fileName));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(sizeX, sizeY);
    }

    public float getX(){
        return sprite.getX();
    }

    public float getY(){
        return sprite.getY();
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public Rectangle collisionArea(){
        Rectangle collision = new Rectangle(
                sprite.getX(),
                sprite.getY(),
                sprite.getWidth(),
                sprite.getHeight());
        return collision;
    }

}
