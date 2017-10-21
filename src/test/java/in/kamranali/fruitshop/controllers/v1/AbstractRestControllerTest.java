package in.kamranali.fruitshop.controllers.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bornshrewd on 21/10/17
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj){

        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
