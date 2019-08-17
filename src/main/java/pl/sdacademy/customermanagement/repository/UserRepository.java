package pl.sdacademy.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
