package com.mygdx.game;

public class Enemys extends Figure{

    private int speedX;
    private int speedY;

    public Enemys(String fileName, float x, float y, float size){
        super(fileName, x, y, size);
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
