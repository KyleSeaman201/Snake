import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame{
    public final int bodySize = 20;
    private static Frame frame;
    public Game game;

    public static Frame getInstance(){
        return frame;
    }

    public Frame(Game game){
        this.game = game;
        this.frame = this;

        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit button closes program
        int windowDimension = game.boardDimension * bodySize; //body is 20 pixels

        // TODO: I cannot figure out why the window doesn't match my dimensions
        this.setSize(windowDimension+35, windowDimension+58); //window size
        this.setLayout(null);
        this.setLocationRelativeTo(null); //window location is center of screen
        this.getContentPane().setBackground(new Color(0,0,50));
        this.addKeyListener(game);
        this.setResizable(false);

        this.setVisible(true);
    }
}
