package kodlama.io.kodlama.io.Dev.wepApi;

import kodlama.io.kodlama.io.Dev.business.abstracts.TechnologyService;
import kodlama.io.kodlama.io.Dev.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.GetByIdTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllTechnologyResponse;
import kodlama.io.kodlama.io.Dev.business.responses.GetByIdTechnologyResponse;
import kodlama.io.kodlama.io.Dev.entites.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
    @PostMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest){
        technologyService.add(createTechnologyRequest);
    }
    @PostMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest){
        technologyService.update(updateTechnologyRequest);
    }
    @PostMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest){
        technologyService.delete(deleteTechnologyRequest);
    }
    @PostMapping("/getbyid")
    public Technology getById(GetByIdTechnologyRequest getByIdTechnologyRequest){
        return technologyService.getById(getByIdTechnologyRequest.getId());
    }
}
