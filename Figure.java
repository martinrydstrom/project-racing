package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Figure {

    private Sprite sprite;
    private int speedX, speedY;


    //Konstruktor för att skapa ett nytt objekt.
    public Figure(String fileName, float x, float y, float size){
        sprite = new Sprite(new Texture(fileName));
        sprite.setX(x);
        sprite.setY(y);
        sprite.setSize(size, size);
    }

    public float getX(){
       return sprite.getX();
    }

    public float getY(){
        return sprite.getY();
    }

    public void setX(float x){
        sprite.setX(x);
    }

    public void setY(float y){
        sprite.setY(y);
    }

    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Rectangle collisionArea() {
        Rectangle collision = new Rectangle(
                sprite.getX(),
                sprite.getY(),
                sprite.getWidth(),
                sprite.getHeight());
        return collision;
    }

    public void updateSpeed(){
        setX(getX()+getSpeedX());
        setY(getY()+getSpeedY());
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }


}
