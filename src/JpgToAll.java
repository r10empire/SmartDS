import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Core;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import org.opencv.core.MatOfByte;

public class JpgToAll {

    public void JpgToJpeg(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath, image);
    }
    public void JpgToPng(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath, image);
    }
    public void JpgToPdf(Mat image,String outputFilePath)
    {
        try {
            // Convert Mat to byte array
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, matOfByte);
            byte[] byteArray = matOfByte.toArray();

            // Create Document instance
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
            document.open();

            // Add image to PDF
            Image pdfImage = Image.getInstance(byteArray);
            document.add(pdfImage);

            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
