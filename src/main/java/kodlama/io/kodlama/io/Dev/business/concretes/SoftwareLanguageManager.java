package kodlama.io.kodlama.io.Dev.business.concretes;

import kodlama.io.kodlama.io.Dev.business.abstracts.SoftwareLanguageService;
import kodlama.io.kodlama.io.Dev.business.requests.CreateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllSoftwareLanguageResponse;
import kodlama.io.kodlama.io.Dev.dataAccess.absracts.SoftwareLanguageRepository;
import kodlama.io.kodlama.io.Dev.entites.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SoftwareLanguageManager implements SoftwareLanguageService {
     private SoftwareLanguageRepository softwareLanguageRepository;

    @Autowired
    public SoftwareLanguageManager(SoftwareLanguageRepository softwareLanguageRepository) {
        this.softwareLanguageRepository = softwareLanguageRepository;
    }

    @Override
    public List<GetAllSoftwareLanguageResponse> getAll() {
        List<SoftwareLanguage> softwareLanguages = softwareLanguageRepository.findAll();
        List<GetAllSoftwareLanguageResponse> getAllSoftwareLanguageResponses = new ArrayList<GetAllSoftwareLanguageResponse>();
        for (SoftwareLanguage language : softwareLanguages){
            GetAllSoftwareLanguageResponse languageResponse = new GetAllSoftwareLanguageResponse();
            languageResponse.setId(language.getId());
            languageResponse.setName(language.getName());
            getAllSoftwareLanguageResponses.add(languageResponse);
        }
        return getAllSoftwareLanguageResponses;
    }

    @Override
    public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
        if (createSoftwareLanguageRequest.getName().equals(null) || createSoftwareLanguageRequest.getName() == ""){
            throw new Exception("Program dilini giriniz..");
        }
        SoftwareLanguage softwareLanguage = new SoftwareLanguage();
        softwareLanguage.setName(createSoftwareLanguageRequest.getName());
        this.softwareLanguageRepository.save(softwareLanguage);
    }

    @Override
    public void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) throws Exception {
        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(updateSoftwareLanguageRequest.getId()).get();
        if (softwareLanguage.getName().isEmpty() || softwareLanguage.getName().isBlank()){
            throw new Exception("Güncelleme başarılı.");
        }else {
            throw new Exception("Güncellme başarız.");
        }

    }

    @Override
    public void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest) {
        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(deleteSoftwareLanguageRequest.getId()).get();
        softwareLanguageRepository.save(softwareLanguage);
    }

    @Override
    public SoftwareLanguage getById(int id) throws Exception {
        List<SoftwareLanguage> softwareLanguages = softwareLanguageRepository.findAll();
        for (SoftwareLanguage language : softwareLanguages){
            if (language.getName().equals(softwareLanguages)){
                return language;
            }
        }
        return softwareLanguageRepository.findById(id).get();
    }
}
