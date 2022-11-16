package kodlama.io.kodlama.io.Dev.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
    private int id;
    private String name;
    private String programingLanguage;
}
