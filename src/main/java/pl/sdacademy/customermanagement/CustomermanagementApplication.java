package pl.sdacademy.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class CustomermanagementApplication {


    public static void main(String[] args){

        SpringApplication.run(CustomermanagementApplication.class, args);


       /* ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        String html = "index";

        String xHtml = convertToXhtml(html);


        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont("Code39.ttf", IDENTITY_H, EMBEDDED);

        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "test", "resources")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();

        OutputStream outputStream = new FileOutputStream("message.pdf");

        renderer.createPDF(outputStream);
        outputStream.close();



    }
    private static String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
*/
    }




}
