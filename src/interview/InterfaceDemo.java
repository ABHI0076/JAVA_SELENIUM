package interview;

interface ShapeArea {

	// Variables are by default public and static and final.
	int length = 20;
	int width = 10;
	int radius = 10;

	// Abstract methods are allowed.
	// Abstract methods are by default public and abstract.
	void circle();

	// Default methods are allowed
	default void square() {
		System.out.println("Area of Square is : " + length * length);

	}

	// Static methods are allowed
	static void rectangle() {
		System.out.println("Area of Rectangle is : " + length * width);
	}

}

public class InterfaceDemo implements ShapeArea {

	@Override
	public void circle() {
		System.out.println("Area of Circle is : " + 3.14 * radius * radius);

	}

	public static void main(String[] args) {

		// Scenario 1
		ShapeArea shape = new InterfaceDemo();
		shape.circle();
		shape.square();
		ShapeArea.rectangle();

		// Scenario 2
		InterfaceDemo interf = new InterfaceDemo();
		interf.circle();
		interf.square();
		ShapeArea.rectangle();

		// Scenario 3(NOT VALID)
		// We can't create object/Instantiate of interface

//		Shape shape2 = new Shape();
	}

}
