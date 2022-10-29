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
        this.x = randomX();
        this.y = randomY();

        this.bodyLabel = new JLabel();

        frame = Frame.getInstance();
        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
        this.bodyLabel.setBackground(Color.RED);
        this.bodyLabel.setOpaque(true);

        frame.add(this.bodyLabel);
    }

    public void move() {
        this.x = randomX();
        this.y = randomY();

        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
        this.bodyLabel.setBackground(Color.RED);
        this.bodyLabel.setOpaque(true);
    }

    public int randomX(){
        int x;
        x = random.nextInt(game.boardDimension);
        return x;
//        while(true) {
//            x = random.nextInt(game.boardDimension);
//            Body body = game.snake.head;
//            while(body != null){
//                if (body.x == x){
//                    break;
//                }
//            }
//            return x;
//        }
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
