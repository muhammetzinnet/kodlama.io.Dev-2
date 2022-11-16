package kodlama.io.kodlama.io.Dev.business.abstracts;

import kodlama.io.kodlama.io.Dev.business.requests.CreateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllSoftwareLanguageResponse;
import kodlama.io.kodlama.io.Dev.entites.concretes.SoftwareLanguage;

import java.util.List;
import java.util.Optional;

public interface SoftwareLanguageService {
    List<GetAllSoftwareLanguageResponse> getAll();
    void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception;
    void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) throws Exception;
    void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest);
    SoftwareLanguage getById(int id) throws Exception;
}
