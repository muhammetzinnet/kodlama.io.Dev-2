package kodlama.io.kodlama.io.Dev.dataAccess.absracts;

import kodlama.io.kodlama.io.Dev.entites.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
