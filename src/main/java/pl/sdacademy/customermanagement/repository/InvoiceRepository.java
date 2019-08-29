package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.Invoice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findByLuser_Id(Long userId);

    @Query("from Invoice  where invoiceDate = " +
            "(select max(invoiceDate) from Invoice)")
    Optional<Invoice> findlastInvoiceDate();


}
