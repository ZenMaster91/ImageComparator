package com.guille.images.comparator;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ImageCompareTest {

	@Test
	public void basicImageTest() throws IOException {
		// Create a compare object specifying the 2 images for comparison.
		ImageCompare ic = new ImageCompare("changes2.jpg", "london.jpg");
		// Set the comparison parameters.
		// (num vertical regions, num horizontal regions, sensitivity,
		// stabilizer)
		ic.setParameters(40, 40, 1, 5);
		// Compare.
		ic.setDebugMode(1);
		ic.compare();
		// Display if these images are considered a match according to our
		// parameters.
		System.out.println("Match: " + ic.match());
		// If its not a match then write a file to show changed regions.
		if (!ic.match()) {
			ImageCompare.saveJPG(ic.getChangeIndicator(),
					ImageCompare.PATH_TO_RESULTS + ic.getNameImg1() + "&" + ic.getNameImg2() + ".jpg");
			File f = new File(ImageCompare.PATH_TO_RESULTS + ic.getNameImg1() + "&" + ic.getNameImg2() + ".jpg");
			Desktop dt = Desktop.getDesktop();
			dt.open(f);
		}
		
		System.out.println("FINISHED");
	}

}

