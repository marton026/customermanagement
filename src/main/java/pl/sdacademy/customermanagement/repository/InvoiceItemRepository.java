package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.customermanagement.model.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {

}
