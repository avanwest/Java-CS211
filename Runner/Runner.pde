
// A 
Runner runner;


void setup() {
  size(1200, 400);
 runner = new Runner();

}

void draw() {
  background(0);
   textSize(25);
   text("Runner", 20, 30);
   textSize(15);
   text("Stop the runner from reaching the right margin.  Click on circle to stop the runner!", 150, 30);
  // Update the location
  runner.update();
  // Display the Mover
  runner.display(); 
}


void mousePressed() {
  if ( runner.hit() ) {
    println("Hit!");
    runner.bg = color(255, 0, 0);
    runner.done = true;
    runner.uWin = true;
   
  }
}


class Runner {

  int maxX = 1200;
  int maxY = 400;
  PVector location;
  PVector velocity;
  PVector acceleration;
  int radius = 20;
  boolean done = false;
  boolean uWin = false;
  color bg = color(127);
  

  float topspeed;

  Runner() {
    // Start in the center
    location = new PVector(0,random(maxY));
    velocity = new PVector(0,0);
    topspeed = 15;
    
  }

  void update() {
    
    if (done) { return; }
    // Compute a vector that points from location to mouse
    // PVector mouse = new PVector(mouseX,mouseY);
    float ranx = random(maxX);
    float rany = random(maxY);
    PVector next = new PVector(ranx, rany);
    PVector acceleration = PVector.sub(next,location);
    // Set magnitude of acceleration
    acceleration.setMag(0.15);
    
    // Velocity changes according to acceleration
    velocity.add(acceleration);
    // Limit the velocity by topspeed
    velocity.limit(topspeed);
    // Location changes by velocity
    location.add(velocity);
  }

  void display() {
    
    if ( location.x >= maxX ) {
      fill(0,255,0);
      ellipse(location.x,location.y, radius, radius);
      done = true;
      println("Runner wins!!");
      textSize(45);
      text("Runner wins!!", 80, 130);
      return;
    }
    if ( done && uWin ) {
      textSize(45);
      text("You win!!", 80, 130);
    }
    stroke(255);
    strokeWeight(2);
    fill(bg);
    ellipse(location.x,location.y, radius, radius);
  }
  
  boolean hit() {
    print(".");
    if ( mouseX < (location.x + radius) && mouseX > (location.x - radius) 
      && mouseY < (location.y + radius) && mouseY > (location.y - radius) ) {
      return true;
    }
    return false;
  }

}