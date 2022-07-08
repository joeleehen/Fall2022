class Point {
  float x, y;
  
  Point(float x, float y) {
   this.x = x;
   this.y = y;
  }
  
  void display() {
    noStroke();
    fill(30);
    ellipse(x, y, 2, 2);
  }
}
