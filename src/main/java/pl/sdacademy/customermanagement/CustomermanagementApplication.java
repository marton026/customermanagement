package pl.sdacademy.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sdacademy.customermanagement.model.Invoice;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class CustomermanagementApplication {


    public static void main(String[] args) {



        SpringApplication.run(CustomermanagementApplication.class, args);

       /* Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy");
        String dateString = dateFormat.format(currentDate);


        int intValue = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("FV"+String.format("%04d", intValue++)+"/"+dateString);
        }

        System.out.println();
      *//* // System.out.println(getLastFromDb());
        String s= "FV0005/19".substring(2, 6);
        int i= Integer.parseInt(s);*//*
        System.out.println(Integer.parseInt("FV0005/19".substring(2, 6)));
*/
        // System.out.println(i);


    }





}
