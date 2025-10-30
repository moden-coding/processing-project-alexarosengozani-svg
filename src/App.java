import java.security.Key;

import processing.core.*;

public class App extends PApplet{

    int paddleA = 100; //sets paddleA starting hight
    int paddleB = 100; //sets paddleB starting hight
    int score1 = 0; //sets player1 score at the beggining 
    int score2 = 0; //sets player2 score at the beggining 
    int ballR = 0;//sets the primary colors as a varible so that the color of the ball will be randomized

    int ballG = 0;
    int ballB = 0;

    int scene = 1; //sets the the beggining scene that starts everything off

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
        ballXSpeed = 6; //makes it go right at the speed of 3 pixels
        }else if (ballXSpeed < 0.5) {
        ballXSpeed = -6; //makes it go left at the speed of 3 pixels
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
        text("press the tab button to view the rules",90,300); //puts in my text
        image(heart, 20,350,100,100);//inserts the heart image at diffrent points
        image(heart, 120,350,100,100); 
        image(heart, 230,350,100,100); 
        image(heart, 330,350,100,100); 
        image(heart, 440,350,100,100); 
        image(heart, 550,350,100,100);
        

        
    }

    if (scene == 2) { //
    background(230);
    textSize(20);
    text("The right paddle is Player1. Please use the arrow keys.", 100,100); //expalins the rules
    text("The left paddle is Player2. Please use the wasd keys.", 100,200); //expalins the rules
    text("The game starts quickly. Be Ready!", 180,280); //expalins the rules

    fill(80,30,200); //gives my box color
    rect(230,350,198,80); //add in box for continue button
    textSize(35); //makes the size of the text
    fill(0); //makes the text black
    text("START GAME",236,400); //labels the button
    }


    if (scene == 3) {
        background(230); //makes the new background grey
        ballX += ballXSpeed; //makes the ball move side to side
        ballY += ballYSpeed; //makes the ball move up and down

        if (ballY <= 0 || ballY >= height) { //when my ball hits the top or bottom, it makes my ball bounce off
        ballYSpeed *= -1; //makes it go the opposite direction to bounce off the ceilings
        }

        if (ballX + 20 >= width - 25 && ballY >= paddleA && ballY <= paddleA + 110) { //makes the ball bounce of the right paddle
            println("touched right"); //helps me test my game and make sure evrything is runnning well
            ballXSpeed *= -1; //makes the ball bounce off
            
            ballR = (int)random(255); //makes the ball change color randomly when touching the paddle
            ballG = (int)random(255);
            ballB = (int)random(255); 
        }

        if (ballX - 20 <= 25 && ballY >= paddleB && ballY <= paddleB + 110) { //makes the ball bounce of the left paddle
            println("touched left"); //helps me test my game and make sure evrything is runnning well
            ballXSpeed *= -1; //makes the ball bounce off

            ballR = (int)random(255); //makes the ball change color randomly when touching the paddle
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
        }else if (paddleA > height - 110) {  // 125 = paddle height
        paddleA = height - 110;

        }else if (paddleB < 0) {
        paddleB = 0;
        }else if (paddleB > height - 110) {  
        paddleB = height - 110;
        }

        fill(ballR, ballG, ballB); //makes it so that the ball can change colors     
        ellipse(ballX, ballY, 40, 40); //sets the ball size and coordinates
        noStroke(); //makes there be no border
        
        fill(0); //paddleA
        rect(width - 25, paddleA, 25, 110); //draws paddleA
        noStroke(); //makes there be no border
        
        fill(0); //paddleB
        rect(width - 650, paddleB, 25, 110); //draws paddleB
        noStroke(); //makes there be no border

        if (ballX >= 650) {
            score2 += 1;
            resetGame();
            System.out.println(score2);
        }else if (ballX <= 0) {
            score1 += 1;
            resetGame();
            System.out.println(score1); 
        } 
        
        if (score1 == 5 || score2 == 5) {
            scene = 4;
        }


        text("Player1 score: " + score1, 350,50);

        text("Player2 score: " + score2, 50,50);
    }  
    
    if (scene == 4) {
        background(0);
        fill(255);
        text("Game Over",250,100);
            
        if (score1 > score2) {
        text("Player 1 is the winner",200,200);
        }else if (score2 > score1) {
        text("Player 2 is the winner",200,200);
        }
            
        text("Press space bar to play again",155,300);
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
        if (key == TAB) {
            scene = 2;
        }
        if (scene == 4) {
            if(key == ' ') {
            score1 = 0;
            score2 = 0;
            scene = 1;
            }
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
         if (scene == 2) {
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
