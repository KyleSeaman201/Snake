import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Food {
    public int x;
    public int y;
    JLabel bodyLabel;
    Frame frame;
    Random random = new Random();
    Game game;

    public Food(Game game){
        this.game = game;
        newLocation(); // This sets x & y position

        this.bodyLabel = new JLabel();

        frame = Frame.getInstance();
        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
        this.bodyLabel.setBackground(Color.RED);
        this.bodyLabel.setOpaque(true);

        frame.add(this.bodyLabel);
    }

    public void move() {
        newLocation();

        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
        this.bodyLabel.setBackground(Color.RED);
        this.bodyLabel.setOpaque(true);
    }

    public void newLocation(){
        int tempX = randomX();
        int tempY = randomY();
        boolean snakeExists = true;

        while (snakeExists) {
            snakeExists = false;
            tempX = randomX();
            tempY = randomY();

            Body tempSnake = game.snake.head;
            while (tempSnake != null) {
                if ((tempSnake.x == tempX) && (tempSnake.y == tempY)) {
                    snakeExists = true;
                    break;
                }
                tempSnake = tempSnake.next;
            }
        }

        this.x = tempX;
        this.y = tempY;
    }

    public int randomX(){
        int x = random.nextInt(game.boardDimension);
        return x;
    }

    public int randomY(){
        int y = random.nextInt(game.boardDimension);
        return y;
    }

    public int xCoordinate() {
        int bodySize = frame.bodySize;
        return this.x * bodySize;
    }

    public int yCoordinate() {
        int bodySize = frame.bodySize;
        return this.y * bodySize;
    }
}
