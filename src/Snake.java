public class Snake {
    Body head;
    Direction direction;
    Game game;
    public Snake(Game game){
        this.game = game;
        head = new Body(3, 0);
        head.addTail(2, 0);
        head.next.addTail(1, 0);
        head.next.next.addTail(0, 0);
        this.direction = Direction.East;
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
