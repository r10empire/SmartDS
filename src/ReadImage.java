import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ReadImage {
    public void getimage(){
        // Path to the image file
        String imagePath = "E:\\sample.jpg";

        // Read the image
        Mat image = Imgcodecs.imread(imagePath);

        // Check if the image was successfully loaded
        if (image.empty()) {
            System.out.println("Error: Could not read the image");
        } else {
            System.out.println("Image read successfully");
            System.out.println(image);
            // Now you can perform further processing on the 'image' Mat object
        }

        // Iterate over each pixel and print its value
        for (int y = 0; y < image.rows(); y++) {
            for (int x = 0; x < image.cols(); x++) {
                double[] pixel = image.get(y, x);
                System.out.println("Pixel value at (" + x + ", " + y + "): " + pixel[0] + ", " + pixel[1] + ", " + pixel[2]);
            }
        }

//        HighGui.namedWindow("Image", HighGui.WINDOW_NORMAL);
//        HighGui.resizeWindow("Image", 800, 600);
//        // Display the image in a window
//        HighGui.imshow("Image", image);
//
//        // Wait for a key press to exit
//        HighGui.waitKey();
//
//        // Close the window
//        HighGui.destroyAllWindows();
    }

}
