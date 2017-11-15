package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import javafx.scene.paint.Stop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OurGame extends ApplicationAdapter {
    ArrayList<Figure> figureList = new ArrayList<>();
    ArrayList<Wall> wallList = new ArrayList<>();
    SpriteBatch batch;
	Texture img;
	Player player;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        createPlayer();
        createEnemys();
        createWall();
    }

    public void createPlayer(){
	    player = new Player("Player.png",500,500,50);
	    figureList.add(player);
    }

    public void createEnemys(){
        Enemys newEnemy = new Enemys("Enemy1.png", 100,100,50);
        figureList.add(newEnemy);

        Enemys newEnemyTwo = new Enemys("Enemy1.png", 200, 100,50);
        figureList.add(newEnemyTwo);
    }

    public void createWall(){
        Wall topWall = new Wall("Wall.png", 183,650,1000,10);
        wallList.add(topWall);
    }

    public void checkCollision() {
        for(int i = 0; i < wallList.size(); i++){
            Rectangle wallArea = wallList.get(i).collisionArea();
            Rectangle playerArea = player.collisionArea();

            if(playerArea.overlaps(wallArea)){
                player.setSpeedY(0);
                player.setSpeedX(0);
            }
        }
    }

    public void checkCollisionEnemy(){
        for(int i = 0; i < figureList.size(); i++){
                if(figureList.get(i) instanceof Enemys){
                    Rectangle enemyArea = figureList.get(i).collisionArea();
                    Rectangle playerArea = player.collisionArea();

                    if(playerArea.overlaps(enemyArea)){
                        System.exit(0);
                    }
                }
        }
    }

    public void controlInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            player.goUp();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            player.goDown();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.goLeft();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.goRight();
        }
    }

    @Override
    public void render () {

        checkCollision();
        checkCollisionEnemy();
        controlInput();

        for(Figure figures : figureList){
            figures.updateSpeed();
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

            for(Figure figures : figureList){
                figures.draw(batch);
            }
            for(Wall wall : wallList){
                wall.draw(batch);
            }

        batch.end();
    }


    @Override
    public void dispose () {
        batch.dispose();
 //ANVÄNDS EJ       img.dispose();
    }

}
