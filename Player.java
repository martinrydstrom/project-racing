package com.mygdx.game;

public class Player extends Figure {

    public Player(String fileName, float x, float y, float size){
        super(fileName, x, y, size);
    }


    //Metoder för att ändra riktningen som spelaren rör sig.
    public void goUp(){
        setSpeedX(0);
        setSpeedY(3);
    }

    public void goDown(){
        setSpeedX(0);
        setSpeedY(-3);
    }

    public void goLeft(){
        setSpeedX(-3);
        setSpeedY(0);
    }

    public void goRight(){
        setSpeedX(3);
        setSpeedY(0);
    }
}
