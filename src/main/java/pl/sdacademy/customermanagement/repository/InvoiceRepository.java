package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.Invoice;

import java.util.Date;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


//    @Query("select inv.invoiceNo from Invoice  where inv.invoiceDate = " +
//            "(select max(inv.invoiceDate) from Invoice inv)")
//    String findlastInvoiceDate();

    @Query("from Invoice  where invoiceDate = " +
            "(select max(invoiceDate) from Invoice)")
    Optional<Invoice> findlastInvoiceDate();


}
