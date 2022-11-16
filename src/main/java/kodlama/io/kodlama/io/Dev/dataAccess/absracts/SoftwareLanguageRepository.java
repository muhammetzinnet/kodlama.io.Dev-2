package kodlama.io.kodlama.io.Dev.dataAccess.absracts;

import kodlama.io.kodlama.io.Dev.entites.concretes.SoftwareLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareLanguageRepository extends JpaRepository<SoftwareLanguage,Integer> {
}
