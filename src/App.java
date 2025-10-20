import processing.core.*;

public class App extends PApplet{

    int paddleA = 100;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
    }

    public void settings(){
        size(400,400);
    }

    public void draw(){
      background(230);
       fill(0,0,30);
       ellipse(100, 100, 60, 60);
       noStroke();
       fill(0);
       rect(width - 60, paddleA, 60, 200);
       noStroke();
       fill(0);
       rect(width - 400, 100, 60, 200);
       noStroke();
    }

    public void keyPressed () {
        if (keyCode == UP) {
            paddleA -= 10;
        }
    }
}
