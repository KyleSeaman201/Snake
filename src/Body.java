import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Body {
    public Body next;
    public int x;
    public int y;
    JLabel bodyLabel;
    Frame frame;
    Map<String, Integer> oldCoords;
    int color;
    public Body(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.next = null;
        this.bodyLabel = new JLabel();

        if (color < 0) {
            this.color = 0;
        } else {
            this.color = color;
        }

        frame = Frame.getInstance();
        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
        this.bodyLabel.setBackground(new Color(this.color,this.color,this.color));
        this.bodyLabel.setOpaque(true);

        frame.add(this.bodyLabel);
    }

    public void addTail(int x, int y) {
        this.next = new Body(x, y, this.color-10);
    }

    public int xCoordinate() {
        int bodySize = frame.bodySize;
        return this.x * bodySize;
    }

    public int yCoordinate() {
        int bodySize = frame.bodySize;
        return this.y * bodySize;
    }

    public void updateCoords(int x, int y){
        int oldX = this.x;
        int oldY = this.y;
        this.x = x;
        this.y = y;
        this.updateLabel();

        if (this.next != null){
            this.next.updateCoords(oldX, oldY);
        }
    }

    public void updateLabel(){
        this.bodyLabel.setBounds(xCoordinate(),yCoordinate(),frame.bodySize,frame.bodySize);
    }
}
