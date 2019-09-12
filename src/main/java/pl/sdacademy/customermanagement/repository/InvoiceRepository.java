package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.Invoice;
import pl.sdacademy.customermanagement.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findByLuser_Id(Long userId);

    @Query("from Invoice  where invoiceDate = " +
            "(select max(invoiceDate) from Invoice)")
    Optional<Invoice> findlastInvoiceDate();


    List<User> findDistinctByLuser(Long userId); //czy to jest
    // równoważne z zapytaniem:  "Select distinct user_id from invoices";?




    //todo zapytanie
//
//    SELECT i.id FROM invoices i
//    WHERE i.invoice_date =
//      ( SELECT MAX(invoice_date) FROM invoices WHERE user_id = i.user_id );
}
