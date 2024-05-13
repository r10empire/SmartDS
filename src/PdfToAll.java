import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.Loader;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToAll {
    public void PdfToImage(String inputPdfPath, String outputDirectory, String extension) {
        try {
            // Load PDF document
            PDDocument document = Loader.loadPDF(new File(inputPdfPath));
            // Create PDF renderer
            PDFRenderer renderer = new PDFRenderer(document);

            // Create output directory if it doesn't exist
            File outputDir = new File(outputDirectory);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Iterate through each page and convert to JPEG image
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                // Render PDF page as image
                BufferedImage image = renderer.renderImageWithDPI(i, 300); // 300 DPI

                // Construct output file path
                String outputFilePath = outputDirectory + extension + "_page_" + (i + 1) + "." + extension;

                // Save image as JPEG
                ImageIO.write(image, extension, new File(outputFilePath));
            }

            // Close PDF document
            document.close();

            //System.out.println("PDF converted to JPEG images successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PdfToJpeg(String inputPdfPath,String outputFilePath)
    {
        PdfToImage(inputPdfPath,outputFilePath,"jpeg");
    }
    public void PdfToPng(String inputPdfPath,String outputFilePath)
    {
        PdfToImage(inputPdfPath,outputFilePath,"png");
    }
    public void PdfToJpg(String inputPdfPath, String outputFilePath)
    {
        PdfToImage(inputPdfPath,outputFilePath,"jpg");
    }
}
