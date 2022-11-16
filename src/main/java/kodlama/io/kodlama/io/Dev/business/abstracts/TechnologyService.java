package kodlama.io.kodlama.io.Dev.business.abstracts;

import kodlama.io.kodlama.io.Dev.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.DeleteTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama.io.Dev.business.responses.GetAllTechnologyResponse;
import kodlama.io.kodlama.io.Dev.entites.concretes.Technology;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
    void update(UpdateTechnologyRequest updateTechnologyRequest);
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
    Technology getById(int id);
}
