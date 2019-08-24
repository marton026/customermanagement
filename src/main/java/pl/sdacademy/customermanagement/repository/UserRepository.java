package pl.sdacademy.customermanagement.repository;

import org.omg.CORBA.LongLongSeqHelper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.customermanagement.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
