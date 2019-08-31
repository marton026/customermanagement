package pl.sdacademy.customermanagement.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.w3c.dom.Document;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PdfService {

    public final SpringTemplateEngine engine;
    private final ViewPdfService viewPdfService;



    public void createPdf(long ivoiceId) {
    try {
        Map<String, Object> params = new HashMap<>();
        params.put("listPdf", viewPdfService.findById(ivoiceId));
        Context context = new Context(Locale.forLanguageTag("pl"), params);

        String template = readHtmlFile();
        String filledHtml = engine.process(template, context);

        final W3CDom w3cDom = new W3CDom();
        final Document w3cDoc = w3cDom.fromJsoup(Jsoup.parse(filledHtml));
        final OutputStream outStream = new FileOutputStream("invoice.pdf");
        final PdfRendererBuilder pdfBuilder = new PdfRendererBuilder();
        pdfBuilder.useFastMode();
        pdfBuilder.withW3cDocument(w3cDoc, "pdf/");
        pdfBuilder.useFont(new File(PdfService.class.getClassLoader().getResource("files/SourceSansPro-Regular.ttf").getFile()), "source-sans");
        pdfBuilder.toStream(outStream);
        pdfBuilder.run();
        outStream.close();
    } catch (Exception e) {
        System.out.println("PDF could not be created: " + e.getMessage());
    }

        /*OutputStream outputStream = new FileOutputStream("message.pdf");
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(String.valueOf(htmlInBytes));
        renderer.layout();
        renderer.createPDF(outputStream, false);
        renderer.finishPDF();
        outputStream.close();*/
    }

    public String readHtmlFile() {
        Path path = Paths.get("src/main/resources/templates/pdfView.html");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}


