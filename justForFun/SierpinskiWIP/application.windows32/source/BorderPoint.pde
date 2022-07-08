class BorderPoint extends Point {
  int name;
  
  BorderPoint(float x, float y, int name) {
   super(x, y);
   this.name = name;
  }
  
  void display() {
    noStroke();
    fill(color(0, 0, 255));
    ellipse(x, y, 5, 5);
  }
}
