package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.customermanagement.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {

    List<InvoiceItem> findByLinvoice_Id(Long invoiceId);
}
