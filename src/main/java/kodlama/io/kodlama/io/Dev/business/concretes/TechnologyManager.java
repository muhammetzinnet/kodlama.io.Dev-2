package kodlama.io.kodlama.io.Dev.business.concretes;

import kodlama.io.kodlama.io.Dev.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Dev.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllTechnologyResponse;
import kodlama.io.kodlama.io.Dev.dataAccess.absracts.SoftwareLanguageRepository;
import kodlama.io.kodlama.io.Dev.dataAccess.absracts.TechnologyRepository;
import kodlama.io.kodlama.io.Dev.entites.concretes.SoftwareLanguage;
import kodlama.io.kodlama.io.Dev.entites.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private SoftwareLanguageRepository softwareLanguageRepository;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, SoftwareLanguageRepository softwareLanguageRepository) {
        this.technologyRepository = technologyRepository;
        this.softwareLanguageRepository = softwareLanguageRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<>();
        List<Technology> technologies = technologyRepository.findAll();

        for (Technology technology : technologies){
            GetAllTechnologyResponse allTechnologyResponse = new GetAllTechnologyResponse();
            allTechnologyResponse.setId(technology.getId());
            allTechnologyResponse.setName(technology.getName());
            allTechnologyResponse.setProgramingLanguage(technology.getSoftwareLanguage().getName());
            getAllTechnologyResponses.add(allTechnologyResponse);
        }

        return getAllTechnologyResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(createTechnologyRequest.getProgramingLanguageId())
                .orElseThrow(() -> new RuntimeException("Programlama mevcut değil."));

        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());
        technology.setSoftwareLanguage(softwareLanguage);

        technologyRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        if (updateTechnologyRequest.getName().isEmpty() && updateTechnologyRequest.getName().isBlank()){
            Technology technology = technologyRepository.findById(updateTechnologyRequest.getId()).get();
            technology.setName(updateTechnologyRequest.getName());
            technologyRepository.save(technology);
        }
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(deleteTechnologyRequest.getId()).get();
        softwareLanguageRepository.delete(softwareLanguage);
    }

    @Override
    public Technology getById(int id) {
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies){
            if(technology.getName().equals(technologies)){
                return technology;
            }
        }
        return technologyRepository.findById(id).get();
    }
}
