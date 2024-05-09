import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import org.opencv.core.MatOfByte;

public class JpegToAll {

    public void JpegToJpg(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath+".jpg", image);
    }
    public void JpegToPng(Mat image,String outputFilePath)
    {
        Imgcodecs.imwrite(outputFilePath+".png", image);
    }
    public void JpegToPdf(String inputImagePath, String outputPdfPath)
    {
        try {
            BufferedImage image = ImageIO.read(new File(inputImagePath));

            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDImageXObject pdImage = PDImageXObject.createFromFile(inputImagePath, document);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 0, image.getWidth(), image.getHeight());
            contentStream.close();

            document.save(outputPdfPath+".pdf");
            document.close();

            System.out.println("PDF created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
