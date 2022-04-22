
public class ShapeClass {

	    public static void main(String[] args) {
	        Shape rectangle = new Rectangle(5, 3);
	        Shape triangle = new Triangle(2, 5);
	        System.out.println("Area of rectangle: " +  rectangle.getArea());
	        System.out.println("Area of triangle:" + triangle.getArea());
	    }
	}

	abstract class Shape {
	    private final double width;
	    private final double height;

	    public Shape(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }

	    public double getWidth() {
	        return width;
	    }

	    public double getHeight() {
	        return height;
	    }

	    public abstract double getArea();
	}

	class Rectangle extends Shape {
	    public Rectangle(double width, double height) {
	        super(width, height);
	    }
	    //Finding Rectangle area method
	    @Override
	    public double getArea() {
	        return this.getWidth() * this.getHeight();
	    }
	}

	class Triangle extends Shape {
	    public Triangle(double width, double height) {
	        super(width, height);
	    }
	    //Finding Triangle area method
	    @Override
	    public double getArea() {
	        return 0.5 * (this.getWidth() * this.getHeight());
	    }
	}



