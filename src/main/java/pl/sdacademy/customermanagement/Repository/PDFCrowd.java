package pl.sdacademy.customermanagement.repository;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import com.itextpdf.html2pdf.ConverterProperties;
//import com.itextpdf.html2pdf.HtmlConverter;
//
//public class HtmlPDF {
//
//    public static void main() throws IOException {
//        // IO
//        File htmlSource = new File("input.html");
//        File pdfDest = new File("output.pdf");
//        // pdfHTML specific code
//        ConverterProperties converterProperties = new ConverterProperties();
//        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
//                new FileOutputStream(pdfDest), converterProperties);
//    }
//
//}

import com.pdfcrowd.Pdfcrowd;

import java.io.IOException;

//import com.itextpdf.html2pdf.ConverterProperties;
//import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
//import com.itextpdf.layout.font.FontProvider;
//
//
//import java.io.File;
//import java.io.IOException;
//
//public class HtmlPDF {
//
//    /** The path to a folder containing extra fonts. */
//    public static final String FONTS = "src/main/resources/";
//    /** The Base URI of the HTML page. */
//    public static final String BASEURI = "src/main/resources/templates";
//    /** The path to the source HTML file. */
//    public static final String SRC = String.format("%sindex.html", BASEURI);
//    /** The target folder for the result. */
//    public static final String TARGET = "src/main/resources/pdf";
//    /** The path to the resulting PDF file. */
//    public static final String DEST = String.format("%sindex.pdf", TARGET);
//
//    /**
//     * The main method of this example.
//     *
//     * @param args no arguments are needed to run this example.
//     * @throws IOException Signals that an I/O exception has occurred.
//     */
//    public static void main(String[] args) throws IOException {
//        File file = new File(TARGET);
//        file.mkdirs();
//        HtmlPDF app = new HtmlPDF();
//        app.createPdf(SRC, FONTS, DEST);
//    }
//
//    /**
//     * Creates the PDF file.
//     *
//     * @param src the path to the source HTML file
//     * @param fonts the path to a font folder with extra fonts
//     * @param dest the path to the resulting PDF
//     * @throws IOException Signals that an I/O exception has occurred.
//     */
//    public void createPdf(String src, String fonts, String dest) throws IOException {
//        ConverterProperties properties = new ConverterProperties();
//        FontProvider fontProvider = new DefaultFontProvider();
//        fontProvider.addDirectory(fonts);
//        properties.setFontProvider(fontProvider);
//        HtmlConverter.convertToPdf(new File(src), new File(dest), properties);
//    }
//}

public class PDFCrowd {
    public static void main(String[] args) throws IOException {
        //Metoda którą będziemy wywoływać do wygenerowania pliku pdf
        convertHtmlToPdf("https://www.iso.org.pl/uslugi-zarzadzania/wdrazanie-systemow/zarzadzanie-ryzykiem/iso-iec-27001/", "src/main/resources/pdf/example.pdf");
    }

    //Metoda która generuje plik pdf na podstawie ścieżki wejścia i wyjścia
    public static void convertHtmlToPdf(String inputFilePath, String outputFilePath) throws IOException, Pdfcrowd.Error {

        try {
// create the API client instance
            Pdfcrowd.HtmlToPdfClient client = new Pdfcrowd.HtmlToPdfClient("demo", "ce544b6ea52a5621fb9d55f8b542d14d");
            // uruchamia konwersje i zapisuje do pliku wyjsciowego
            client.convertUrlToFile(inputFilePath, outputFilePath);
        } catch (Pdfcrowd.Error why) {
            System.err.println("Pdfcrowd Error: " + why);
            throw why;
        } catch (IOException why) {
// Wyswietla raport o bledzie
            System.err.println("IO Error: " + why.getMessage());

// obsluguje wyjatek na wyzszym poziomie.
            throw why;
        }
    }
}