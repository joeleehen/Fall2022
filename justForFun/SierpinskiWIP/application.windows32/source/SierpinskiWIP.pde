BorderPoint[] borders = new BorderPoint[3];
int n;
float[] coords;
ArrayList<Float> xCoords = new ArrayList<Float>();
ArrayList<Float> yCoords = new ArrayList<Float>();
ArrayList<SimPoint> points = new ArrayList<SimPoint>();
float newX;
float newY;

void setup() {
  size(500, 500);

  // number of points to simulate
  n = 25000;

  borders[0] = new BorderPoint(250, 50, 1);
  borders[1] = new BorderPoint(50, 396.41, 2);
  borders[2] = new BorderPoint(450, 396.41, 3);

  // display border points
  for (BorderPoint i : borders) {
    i.display();
  }

  // place first 'random' point
  /* NOTE: placement isn't randomly generated, I'm too lazy to place a new
   random point each simulation */
  xCoords.add(250.0);
  yCoords.add(50.0);
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

void genTriangle(int i) {
  // randomly pick a border point
  BorderPoint ref;
  int randRef = int(random(0, 3));
  ref = borders[randRef];
  // plot a new simulation point halfway between prev and ref
  float newX = abs((xCoords.get(i - 1) + ref.x) / 2);
  float newY = abs((yCoords.get(i - 1) + ref.y) / 2);
  xCoords.add(newX);
  yCoords.add(newY);
}
