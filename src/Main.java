import org.apache.pdfbox.tools.PDFToImage;
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
        String OutputPath = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpgToAll\\sample";
        // Read the image
        Mat image = Imgcodecs.imread(imagePath);

        JpgToAll jpg = new JpgToAll();
        jpg.JpgToJpeg(image,OutputPath);
        jpg.JpgToPng(image,OutputPath);
        jpg.JpgToPdf(imagePath,OutputPath);

        imagePath = "E:\\high_resolution.jpg";
        OutputPath = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\JpegToAll\\sample";
        image = Imgcodecs.imread(imagePath);

        JpegToAll jpeg = new JpegToAll();
        jpeg.JpegToJpg(image,OutputPath);
        jpeg.JpegToPng(image,OutputPath);
        jpeg.JpegToPdf(imagePath,OutputPath);

        imagePath = "E:\\high_resolution.jpg";
        OutputPath = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\PngToAll\\sample";
        image = Imgcodecs.imread(imagePath);

        JpegToAll png = new JpegToAll();
        png.JpegToJpg(image,OutputPath);
        png.JpegToPng(image,OutputPath);
        png.JpegToPdf(imagePath,OutputPath);

        imagePath = "E:\\sample.pdf";
        OutputPath = "C:\\Users\\Rahul\\IdeaProjects\\SmartDS\\TestImage\\PdfToAll\\";

        PdfToAll pdf = new PdfToAll();
        pdf.PdfToJpg(imagePath,OutputPath);
        pdf.PdfToPng(imagePath,OutputPath);
        pdf.PdfToJpeg(imagePath,OutputPath);

    }
}