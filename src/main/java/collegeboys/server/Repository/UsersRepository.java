package collegeboys.server.Repository;
import collegeboys.server.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Person,Long> {
}
