package nbody;

import edu.princeton.cs.StdDraw;

/******************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 ******************************************************************************/

public class Body {

    private static String picture;
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass
//    private double newVector[100][0];
    public Body(Vector r, Vector v, double mass, String picture) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.picture = picture;
    } // Body( Vector, Vector, double )

    public void move(Vector f, double dt) {
        Vector a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )
 
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public void draw() {
        StdDraw.setPenRadius(0.015);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        StdDraw.picture(r.cartesian(0), r.cartesian(1), Body.picture);
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )

} // Body
