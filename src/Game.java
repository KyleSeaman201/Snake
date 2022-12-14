import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Random;

public class Game implements KeyListener, ActionListener {
    public final int boardDimension = 20;
    public Snake snake;
    public Food food;

    public Frame frame;
    public Timer timer;
    boolean gameOver;
    boolean keyLocked = false;

    public Game(){
        this.frame = new Frame(this);
        this.gameOver = false;
        this.snake = new Snake(this);
        this.food = new Food(this);
        this.timer = new Timer(150, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyLocked = false;
        Map<String, Integer> lastBodyCoords = snake.getLastBody();

        if (snake.direction == Direction.East) {
            snake.moveRight();
        } else if (snake.direction == Direction.South) {
            snake.moveDown();
        } else if (snake.direction == Direction.West) {
            snake.moveLeft();
        } else if (snake.direction == Direction.North) {
            snake.moveUp();
        }

        if ((snake.head.x == food.x) && (snake.head.y == food.y)){
            snake.grow(lastBodyCoords);
            food.move();
        }

        if(snake.isCollide()){
            gameOver = true;
        }

        if (gameOver) {
            timer.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            return;
        }

        if (!keyLocked) { // key has already been pressed for this tick
            //Left Arrow
            if ((e.getKeyCode() == 37) & (snake.direction != Direction.East)) {
                snake.direction = Direction.West;
                //snake.moveLeft();
                keyLocked = true;
            }

            //Up Arrow
            else if ((e.getKeyCode() == 38) & (snake.direction != Direction.South)) {
                snake.direction = Direction.North;
                //snake.moveUp();
                keyLocked = true;
            }

            //Right Arrow
            else if ((e.getKeyCode() == 39) & (snake.direction != Direction.West)) {
                snake.direction = Direction.East;
                //snake.moveRight();
                keyLocked = true;
            }

            //Down Arrow
            else if ((e.getKeyCode() == 40) & (snake.direction != Direction.North)) {
                snake.direction = Direction.South;
                //snake.moveDown();
                keyLocked = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
