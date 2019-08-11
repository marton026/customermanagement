package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
