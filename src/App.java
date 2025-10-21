import processing.core.*;

public class App extends PApplet{

    int paddleA = 100;
    int paddleB = 100;

    boolean up, down;

    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        up = false;
        down = false; 
    }

    public void settings(){
        size(400,400);
    }

    public void draw(){
        background(230);

        fill(0,0,30); //ball
        ellipse(100, 100, 50, 50);
        noStroke();
        
        fill(0); //paddleA
        rect(width - 30, paddleA, 30, 150);
        noStroke();
        
        fill(0); //paddleB
        rect(width - 400, paddleB, 30, 150);
        noStroke();

        if(up == true) {
            paddleA -= 5;  
        }else if(down == true) {
            paddleA += 5;  
        }

        if (paddleA < 0) {
        paddleA = 0;
        }else if (paddleA > height - 150) {  // 150 = paddle height
        paddleA = height - 150;
        }
    }

    public void keyPressed(){
        if (keyCode == UP) {
            up = true;
        }
        if (keyCode == DOWN) {
            down = true;
        }
    }

    public void keyReleased () {
        if (keyCode == UP) {
            up = false;
        }
        if (keyCode == DOWN) {
            down = false;
        }
    }
}
