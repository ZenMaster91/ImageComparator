package com.guille.images.comparator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class ImageCompareTest {

	@Test
	public void basicImageTest() throws IOException {
		// Create a compare object specifying the 2 images for comparison.
		ImageCompare ic = new ImageCompare("diferencias4.jpg", "diferencias4false.jpg");
		// Set the comparison parameters.
		// (num vertical regions, num horizontal regions, sensitivity,
		// stabilizer)
		ic.setParameters(50, 50, 0, 250);
		// Compare.
		ic.setDebugMode(2);
		ic.compare();
		// Display if these images are considered a match according to our
		// parameters.
		System.out.println("Match: " + ic.match());
		// If its not a match then write a file to show changed regions.
		if (!ic.match()) {
			ImageCompare.saveJPG(ic.getChangeIndicator(),
					ImageCompare.PATH_TO_RESULTS + ic.getNameImg1() + "&" + ic.getNameImg2() + ".jpg");
			ic.displayResult();
		}

		System.out.println("FINISHED");
	}

	@Test @Ignore
	public void baseCaseTest() {
		ImageCompare ic = new ImageCompare("test1.jpg", "test2.jpg");
		ic.setParameters(8, 6, 5, 10);
		ic.setDebugMode(0);
		ic.compare();
		ic.displayResult();
		assertEquals(false, ic.match());
	}

}
