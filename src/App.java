import java.security.Key;

import processing.core.*;

public class App extends PApplet{

    int paddleA = 100; //sets paddleA starting hight
    int paddleB = 100; //sets paddleB starting hight
    int score1 = 0; //sets player1 score at the beggining 
    int score2 = 0; //sets player2 score at the beggining 
    int ballR = 0;
    int ballG = 0;
    int ballB = 0;

    int scene = 2; //sets the the beggining scene that starts everything off
    int number = 3;

    PImage heart; //inserts the heart image


    float ballX, ballY; //variable for ball postion
    float ballXSpeed, ballYSpeed; //variable for ball speed


    boolean up, down, leftUp, leftDown; //sets the boolean in order for my paddles to move smoothly

    float startBoxX = 230;
    float startBoxY = 350;
    float startBoxWidth = 198;
    float startBoxHeight = 80;

    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        textSize(32); //sets the size of the text for the whole game
        up = false;  
        down = false; 
        leftUp = false;
        leftDown = false;

        ballX = width/2;
        ballY = height/2;
        
        ballXSpeed = random(1); //makes the ball go either left or right randomly 
        if (ballXSpeed > 0.5) {
        ballXSpeed = 5; //makes it go right at the speed of 3 pixels
        }else if (ballXSpeed < 0.5) {
        ballXSpeed = -5; //makes it go left at the speed of 3 pixels
        }
       
        ballYSpeed = 2; //decides how fast the ball goes up at the beggining

        heart = loadImage("heart.png"); //makes the variable heart store my image 
    }

    public void settings(){
        size(650,500); //sets the window size
    }

    public void draw(){ 
    if (scene == 1) { //the start page. This is how I start my game, like the home page. 
        background(200); // makes the background grey
        textSize(60); //sets the size of my text
        fill(0); //makes my text white
        text("Welcome to Pong!", 116,200); //puts in my text
        textSize(33); //sets the size of my text
        fill(0); // //makes my text white
        text("press the the box below to start your game",45,300); //puts in my text

        fill(80,30,200); //gives my box color
        rect(230,350,198,80); //add in box for continue button
        textSize(35);
        fill(0);
        text("START GAME",236,400);
    }

    if (scene == 2) { //my countdown. makes my game start
    background(0);
    textSize(300);
    text(number, 240,330);

    delay(1000);  //chatgpt
    number--; //chatgpt

    if (number < 0) {
    background(0);
    textSize(300);
    text("GO!", 85,350);
     //chatgpt

    delay(1000);


    scene = 3;
    }

}

    if (scene == 3) {
        background(230);
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        if (ballY <= 0 || ballY >= height) {
        ballYSpeed *= -1;
        }

        if (ballX + 20 >= width - 25 && ballY >= paddleA && ballY <= paddleA + 125) {   
            println("touched right");
            ballXSpeed *= -1;
            
            ballR = (int)random(255);
            ballG = (int)random(255);
            ballB = (int)random(255); 
        }

        if (ballX - 20 <= 25 && ballY >= paddleB && ballY <= paddleB + 125) {
            println("touched left");
            ballXSpeed *= -1;

            ballR = (int)random(255);
            ballG = (int)random(255);
            ballB = (int)random(255);
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

        fill(ballR, ballG, ballB);        
        ellipse(ballX, ballY, 40, 40);
        noStroke();
        
        fill(0); //paddleA
        rect(width - 25, paddleA, 25, 125);
        noStroke();
        
        fill(0); //paddleB
        rect(width - 650, paddleB, 25, 125);
        noStroke();
        image(heart, 100,100,100,100);

        if (ballX >= 650) {
            score2 += 1;
            resetGame();
            System.out.println(score2);
        }else if (ballX <= 0) {
            score1 += 1;
            resetGame();
            System.out.println(score1);
        
            text("Score 1: " + score1, 200,100);

            text("Score 2: " + score2, 100,100 );
        
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

    public void mousePressed(){
         if (scene == 1) {
            if (mouseX > 230 && mouseX < 428 && mouseY > 350 && mouseY < 430) {
                System.out.println("yep");
                scene = 3;
            }
        }
    }
    
    public void resetGame () {
        ballX = 350;
        ballY = 200; 
        float ballXSpeed, ballYSpeed;
        
    }
}
