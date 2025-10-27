import java.security.Key;

import processing.core.*;

public class App extends PApplet{

    int paddleA = 100;
    int paddleB = 100;
    int score1 = 0;
    int score2 = 0;


    float ballX, ballY;
    float ballXSpeed, ballYSpeed;


    boolean up, down, leftUp, leftDown;

    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        textSize(32);
        up = false;
        down = false; 
        leftUp = false;

        ballX = width/2;
        ballY = height/2;
        
        ballXSpeed = random(1);
        if (ballXSpeed > 0.5) {
        ballXSpeed = 3;
        }else if (ballXSpeed < 0.5) {
        ballXSpeed = -3;
        }
       
        ballYSpeed = 2;
    }

    public void settings(){
        size(400,400);
    }

    public void draw(){
        background(230);
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        if (ballY <= 0 || ballY >= height) {
        ballYSpeed *= -1;
        }

        if (ballX + 20 >= width - 25 && ballY >= paddleA && ballY <= paddleA + 125) {   
            println("touched right");
            ballXSpeed *= -1;
        }

        if (ballX - 20 <= 25 && ballY >= paddleB && ballY <= paddleB + 125) {
            println("touched left");
            ballXSpeed *= -1;
        }


        if(up == true) {
            paddleA -= 5;  
        }else if(down == true) {
            paddleA += 5;  
        }
        
        if(leftUp == true) {
            paddleB -= 5;  
        }else if(leftDown == true) {
            paddleB += 5;  
        }

        if (paddleA < 0) {
        paddleA = 0;
        }else if (paddleA > height - 125) {  // 125 = paddle height
        paddleA = height - 125;

        }else if (paddleB < 0) {
        paddleB = 0;
        }else if (paddleB > height - 125) {  
        paddleB = height - 125;
        }

        fill(0,0,30); //ball
        ellipse(ballX, ballY, 40, 40);
        noStroke();
        
        fill(0); //paddleA
        rect(width - 25, paddleA, 25, 125);
        noStroke();
        
        fill(0); //paddleB
        rect(width - 400, paddleB, 25, 125);
        noStroke();

        if (ballX >= 400) {
            score2 += 1;
            resetGame();
            System.out.println(score2);
        }else if (ballX <= 0) {
            score1 += 1;
            resetGame();
            System.out.println(score1);
        } 
        if (score1 == 1 || score2 == 1) {
            background(0);
            fill(255);
            text("Game Over",120,100);
            
            if (score1 > score2) {
               text("Player 1 is the winner",80,200);
            }else if (score2 > score1) {
               text("Player 2 is the winner",80,200);
            }

            text("Press space bar to play again",60,300);
            
        }
    }

    public void keyPressed(){
        if (keyCode == UP) {
            up = true;
        }
        else if (keyCode == DOWN) {
            down = true;
        }
        else if (key == 'w') {
            leftUp = true;
        }
        else if (key == 's') {
            leftDown = true;
        }

    }

    public void keyReleased () {
        if (keyCode == UP) {
            up = false;
        }else if (keyCode == DOWN) {
            down = false;
        }else if (key == 'w') {
            leftUp = false;
        }else if (key == 's'){
            leftDown = false;
        }
    }
    
    public void resetGame () {
        ballX = 200;
        ballY = 200; 
        float ballXSpeed, ballYSpeed;
        
    }
}
