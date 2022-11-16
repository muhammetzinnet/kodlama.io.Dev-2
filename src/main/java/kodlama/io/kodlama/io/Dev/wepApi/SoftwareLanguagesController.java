package kodlama.io.kodlama.io.Dev.wepApi;

import kodlama.io.kodlama.io.Dev.business.abstracts.SoftwareLanguageService;
import kodlama.io.kodlama.io.Dev.business.requests.CreateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.GetByIdSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateSoftwareLanguageRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllSoftwareLanguageResponse;
import kodlama.io.kodlama.io.Dev.entites.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/softwarelanguages")
public class SoftwareLanguagesController {
    private SoftwareLanguageService softwareLanguageService;

    @Autowired
    public SoftwareLanguagesController(SoftwareLanguageService softwareLanguageService) {
        this.softwareLanguageService = softwareLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllSoftwareLanguageResponse> getAll(){
        return softwareLanguageService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateSoftwareLanguageRequest createSoftwareLanguageRequest) throws Exception {
        softwareLanguageService.add(createSoftwareLanguageRequest);
    }
    @PostMapping("/update")
    public void update(UpdateSoftwareLanguageRequest updateSoftwareLanguageRequest) throws Exception {
        softwareLanguageService.update(updateSoftwareLanguageRequest);
    }
    @PostMapping("/delete")
    public void delete(DeleteSoftwareLanguageRequest deleteSoftwareLanguageRequest){
        softwareLanguageService.delete(deleteSoftwareLanguageRequest);
    }
    @PostMapping("/getbyid")
    public SoftwareLanguage getById(GetByIdSoftwareLanguageRequest getByIdSoftwareLanguageRequest) throws Exception {
        return softwareLanguageService.getById(getByIdSoftwareLanguageRequest.getId());
    }
}
