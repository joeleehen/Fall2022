import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiWIP extends PApplet {

BorderPoint[] borders = new BorderPoint[3];
int n;
float[] coords;
ArrayList<Float> xCoords = new ArrayList<Float>();
ArrayList<Float> yCoords = new ArrayList<Float>();
ArrayList<SimPoint> points = new ArrayList<SimPoint>();
float newX;
float newY;

public void setup() {
  

  // number of points to simulate
  n = 25000;

  borders[0] = new BorderPoint(250, 50, 1);
  borders[1] = new BorderPoint(50, 396.41f, 2);
  borders[2] = new BorderPoint(450, 396.41f, 3);

  // display border points
  for (BorderPoint i : borders) {
    i.display();
  }

  // place first 'random' point
  /* NOTE: placement isn't randomly generated, I'm too lazy to place a new
   random point each simulation */
  xCoords.add(250.0f);
  yCoords.add(50.0f);
  points.add(new SimPoint(xCoords.get(0), yCoords.get(0)));

  // generate Sierpinski Triangle
  for (int i = 1; i < n; i++) {
    genTriangle(i);
    points.add(new SimPoint(xCoords.get(i), yCoords.get(i)));
  }
  println(yCoords);
  
  for (SimPoint point : points) {
    point.display();
  }
}

public void genTriangle(int i) {
  // randomly pick a border point
  BorderPoint ref;
  int randRef = PApplet.parseInt(random(0, 3));
  ref = borders[randRef];
  // plot a new simulation point halfway between prev and ref
  float newX = abs((xCoords.get(i - 1) + ref.x) / 2);
  float newY = abs((yCoords.get(i - 1) + ref.y) / 2);
  xCoords.add(newX);
  yCoords.add(newY);
}
class BorderPoint extends Point {
  int name;
  
  BorderPoint(float x, float y, int name) {
   super(x, y);
   this.name = name;
  }
  
  public void display() {
    noStroke();
    fill(color(0, 0, 255));
    ellipse(x, y, 5, 5);
  }
}
class Point {
  float x, y;
  
  Point(float x, float y) {
   this.x = x;
   this.y = y;
  }
  
  public void display() {
    noStroke();
    fill(30);
    ellipse(x, y, 2, 2);
  }
}
class SimPoint extends Point {
  SimPoint(float x, float y) {
    super(x, y);
  }
  
  
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiWIP" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
