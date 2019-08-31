package pl.sdacademy.customermanagement;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sdacademy.customermanagement.service.PdfService;

import java.io.*;

@SpringBootApplication
public class CustomermanagementApplication {
    public static void main(String[] args) throws IOException, DocumentException {
        SpringApplication.run(CustomermanagementApplication.class, args);
    }
}
