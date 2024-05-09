import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Core;

public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        ReadImage obj=new ReadImage();
        //obj.getimage();
        //Now we will add command to change image from one form to another
        // Path to the image file

        String imagePath = "E:\\sample.jpg";
        String OutputPathJpg = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpgToAll\\sample";
        // Read the image
        Mat image = Imgcodecs.imread(imagePath);

        JpgToAll jpg = new JpgToAll();
        jpg.JpgToJpeg(image,OutputPathJpg);
        jpg.JpgToPng(image,OutputPathJpg);
        jpg.JpgToPdf(image,OutputPathJpg);

        imagePath = "E:\\sampleJpeg.jpeg";
        OutputPathJpg = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpegToAll\\sample";
        image = Imgcodecs.imread(imagePath);

        JpegToAll jpeg = new JpegToAll();
        jpeg.JpegToJpg(image,OutputPathJpg);
        jpeg.JpegToPng(image,OutputPathJpg);
        jpeg.JpegToPdf(imagePath,OutputPathJpg);

    }
}