import static org.junit.Assert.*;
import org.junit.Test;

public class ImageCompareTest {

	@Test
	public void basicImageTest() {
		// Create a compare object specifying the 2 images for comparison.
		ImageCompare ic = new ImageCompare("src/images/diferencias1.jpg", "src/images/diferencias2.jpg");
		// Set the comparison parameters.
		// (num vertical regions, num horizontal regions, sensitivity, stabilizer)
		ic.setParameters(300, 300, 1, 1);
		// Display some indication of the differences in the image.
		ic.setDebugMode(2);
		// Compare.
		ic.compare();
		// Display if these images are considered a match according to our parameters.
		System.out.println("Match: " + ic.match());
		// If its not a match then write a file to show changed regions.
		if (!ic.match())
			ImageCompare.saveJPG(ic.getChangeIndicator(), "changes2.jpg");
		System.out.println("FINISHED");
	}

}
