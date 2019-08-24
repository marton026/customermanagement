package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {




   // Invoice findLastInvoiceNo(String lastNo);

    // List<Invoice> findTopByInvoiceNo(String lastNo);

   // Invoice findTopByOrderByInvoiceNoDesc();

    //Optional<String> findTopByInvoiceNoOrderByIdDesc();


}
