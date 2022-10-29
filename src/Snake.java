import java.util.HashMap;
import java.util.Map;

public class Snake {
    Body head;
    Direction direction;
    Game game;
    Map<String, Integer> oldCoords;
    public Snake(Game game){
        this.game = game;
        head = new Body(3, 0);
        head.addTail(2, 0);
        head.next.addTail(1, 0);
        head.next.next.addTail(0, 0);
        this.direction = Direction.East;
    }

    public void grow(Map<String, Integer> coords){
        int x = coords.get("x");
        int y = coords.get("y");
        Body newbody = new Body(x, y);
        Body tempHead = head;
        while (tempHead.next != null){
            tempHead = tempHead.next;
        }
        tempHead.next = newbody;
    }

    public Map<String, Integer> getLastBody(){
        Map<String, Integer> coords = new HashMap<>();
        Body tempHead = head;
        while (tempHead.next != null){
            tempHead = tempHead.next;
        }
        coords.put("x", tempHead.x);
        coords.put("y", tempHead.y);
        return coords;
    }

    public boolean isCollide(){
        boolean collide = false;
        Body tempHead = head;
        tempHead = tempHead.next;
        int x = head.x;
        int y = head.y;
        while (tempHead.next != null) {
            if ((tempHead.x == x) && (tempHead.y == y)){
                collide = true;
            }
            tempHead = tempHead.next;
        }
        if ((tempHead.x == x) && (tempHead.y == y)){
            collide = true;
        }
        return collide;
    }

    public void moveLeft(){
        if (direction != Direction.East){
            direction = Direction.West;
            int oldX = head.x;
            int oldY = head.y;
            head.x -= 1;
            if (head.x < 0) {
                game.gameOver = true;
            }
            head.updateLabel();
            head.next.updateCoords(oldX, oldY);
        }
    }

    public void moveDown(){
        if (direction != Direction.North){
            direction = Direction.South;
            int oldX = head.x;
            int oldY = head.y;
            head.y += 1;
            if (head.y > game.boardDimension) {
                game.gameOver = true;
            }
            head.updateLabel();
            head.next.updateCoords(oldX, oldY);
        }
    }

    public void moveRight(){
        if (direction != Direction.West){
            direction = Direction.East;
            int oldX = head.x;
            int oldY = head.y;
            head.x += 1;
            if (head.x > game.boardDimension) {
                game.gameOver = true;
            }
            head.updateLabel();
            head.next.updateCoords(oldX, oldY);
        }
    }

    public void moveUp(){
        if (direction != Direction.South){
            direction = Direction.North;
            int oldX = head.x;
            int oldY = head.y;
            head.y -= 1;
            if (head.y < 0) {
                game.gameOver = true;
            }
            head.updateLabel();
            head.next.updateCoords(oldX, oldY);
        }
    }
}
