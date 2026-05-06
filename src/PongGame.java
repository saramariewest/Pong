import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userScore, pcScore;

    private int userMouseY;
    private int bounceCount;

    private int lives = 3;

    public PongGame() {

        gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);

        userMouseY = 0;
        userScore = 0; pcScore = 0;
        bounceCount = 0;

        addMouseMotionListener(this);

    }

    public void reset(){

        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;

    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);

        userPaddle.paint(g);
        pcPaddle.paint(g);

        g.setColor(Color.WHITE);
        g.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
        g.drawString("Lives: " + lives, 20, 20);
    }

    public void gameLogic() {

        gameBall.moveBall();

        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        userPaddle.moveTowards(userMouseY);

        pcPaddle.moveTowards(gameBall.getY());

        if(userPaddle.checkCollision(gameBall)){
            gameBall.bounceFromPaddle(userPaddle.getY(), userPaddle.getHeight());
            bounceCount++;
        }

        if(pcPaddle.checkCollision(gameBall)){
            gameBall.bounceFromPaddle(pcPaddle.getY(), pcPaddle.getHeight());
            bounceCount++;
        }

        if (bounceCount == 5){
            bounceCount = 0;
            gameBall.increaseSpeed();
        }

        if(gameBall.getX() < 0){
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            userScore++;
            reset();
        }

        if(gameBall.getX() < 0){
            pcScore++;
            lives--;

            if(lives <= 0){
                System.out.println("Game Over!");
                System.exit(0);
            }

            reset();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();

    }
}