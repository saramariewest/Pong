import java.awt.*;

public class Ball {

    static final int MAX_SPEED = 7;

    private int x, y, cx, cy, speed, size;
    private Color color;

    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics g){

        g.setColor(color);

        g.fillOval(x, y, size, size);

    }

    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void bounceOffEdges(int top, int bottom){

        if (y > bottom - size){
            reverseY();
        }
        else if(y < top){
            reverseY();
        }

    }

    public void bounceFromPaddle(int paddleY, int paddleHeight) {

        int paddleCenter = paddleY + paddleHeight / 2;
        int ballCenter = y + size / 2;

        double relativeIntersect = (ballCenter - paddleCenter);
        double normalized = relativeIntersect / (paddleHeight / 2.0);

        cy = (int)(normalized * speed);

        reverseX();
    }

    public void reverseX(){
        cx *= -1;
    }

    public void reverseY(){
        cy *= -1;
    }

    public void increaseSpeed(){
        if(speed < MAX_SPEED){
            speed++;

            if (cx != 0) {
                cx = (cx / Math.abs(cx)) * speed;
            }

            if (cy != 0) {
                cy = (cy / Math.abs(cy)) * speed;
            }

            if (cy == 0) {
                cy = -1;
            }
        }
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setCy(int cy){
        this.cy = cy;
    }

    public void setCx(int cx){
        this.cx = cx;
    }

    public int getSize(){
        return size;
    }
}