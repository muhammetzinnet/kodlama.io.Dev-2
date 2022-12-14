package kodlama.io.kodlama.io.Dev.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {
    private String name;
    private String programingLanguageName;
    private int programingLanguageId;
}
