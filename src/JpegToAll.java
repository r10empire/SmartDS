import java.io.FileOutputStream;
import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;


public class JpegToAll {

    public void JpegToJpg(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath+".jpg", image);
    }
    public void JpegToPng(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath+".png", image);
    }
    public void JpegToPdf(String inputImagePath, String outputFilePath)
    {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputFilePath + ".pdf")); //  Change pdf's name.

            document.open();

            Image image = Image.getInstance(inputImagePath);  // Change image's name and extension.

            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / image.getWidth()) * 100; // 0 means you have no indentation. If you have any, change it.
            image.scalePercent(scaler);
            image.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);

            document.add(image);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
