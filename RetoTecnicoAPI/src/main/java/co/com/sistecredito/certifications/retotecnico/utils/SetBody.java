package co.com.sistecredito.certifications.retotecnico.utils;

import co.com.sistecredito.certifications.retotecnico.models.ModelCreateUser;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class SetBody {

    public ModelCreateUser body(Map<String, String> data) {
        return ModelCreateUser.builder()
                .name(data.get("name"))
                .gender(data.get("gender"))
                .build();
    }
}
