package program;

import org.testng.annotations.Test;

public class Fibonacci_Series {

	@Test(enabled = true, groups = { "JavaTests" })
	public void stringProgram() {

		int n1 = 0, n2 = 1;
		for (int i = 1; i <= 10; i++) {
			int n3 = n1 + n2;
			System.out.print(n1 + " ");
			n1 = n2;
			n2 = n3;
		}

	}

}
