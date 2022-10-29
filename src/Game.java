import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener, ActionListener {
    public final int boardDimension = 25;
    public Snake snake;

    public Frame frame;
    public Timer timer;
    boolean gameOver;

    public Game(){
        this.frame = new Frame(this);
        this.gameOver = false;
        this.snake = new Snake(this);
        this.timer = new Timer(250, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (snake.direction == Direction.East) {
            snake.moveRight();
        } else if (snake.direction == Direction.South) {
            snake.moveDown();
        } else if (snake.direction == Direction.West) {
            snake.moveLeft();
        } else if (snake.direction == Direction.North) {
            snake.moveUp();
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

        //Left Arrow
        if ((e.getKeyCode() == 37) & (snake.direction != Direction.East)){
            snake.direction = Direction.West;
        }

        //Up Arrow
        else if ((e.getKeyCode() == 38) & (snake.direction != Direction.South)) {
            snake.direction = Direction.North;
        }

        //Right Arrow
        else if ((e.getKeyCode() == 39) & (snake.direction != Direction.West)) {
            snake.direction = Direction.East;
        }

        //Down Arrow
        else if ((e.getKeyCode() == 40) & (snake.direction != Direction.North)) {
            snake.direction = Direction.South;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
