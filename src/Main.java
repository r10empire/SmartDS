import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Core;

public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        ReadImage obj=new ReadImage();

        String imagePath = "E:\\high_resolution.jpg";
        String OutputPathJpg = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpgToAll\\sample";
        // Read the image
        Mat image = Imgcodecs.imread(imagePath);

        JpgToAll jpg = new JpgToAll();
        jpg.JpgToJpeg(image,OutputPathJpg);
        jpg.JpgToPng(image,OutputPathJpg);
        jpg.JpgToPdf(imagePath,OutputPathJpg);

        imagePath = "E:\\high_resolution.jpg";
        OutputPathJpg = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpegToAll\\sample";
        image = Imgcodecs.imread(imagePath);

        JpegToAll jpeg = new JpegToAll();
        jpeg.JpegToJpg(image,OutputPathJpg);
        jpeg.JpegToPng(image,OutputPathJpg);
        jpeg.JpegToPdf(imagePath,OutputPathJpg);

        imagePath = "E:\\high_resolution.jpg";
        OutputPathJpg = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\PngToAll\\sample";
        image = Imgcodecs.imread(imagePath);

        JpegToAll png = new JpegToAll();
        png.JpegToJpg(image,OutputPathJpg);
        png.JpegToPng(image,OutputPathJpg);
        png.JpegToPdf(imagePath,OutputPathJpg);

    }
}