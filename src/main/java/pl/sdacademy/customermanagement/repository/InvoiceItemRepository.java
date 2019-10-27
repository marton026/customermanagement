package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.InvoiceItem;

import java.util.List;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {

    List<InvoiceItem> findByLinvoice_Id(Long invoiceId);
}
