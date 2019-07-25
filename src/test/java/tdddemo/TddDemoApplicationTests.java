package tdddemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TddDemoApplicationTests {

    private static final String CHARACTER1_NAME = "C1";

    private static final String CHARACTER1_JSON = "{\"name\":\"" + CHARACTER1_NAME + "\", \"leadership\":1, \"endurance\":4}";
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveCharacterWithName() throws Exception {
        // Given I set body to {"name":"C1", "leadership":1, "endurance":4}
        // When I POST to /characters
        MockHttpServletRequestBuilder request = post("http://localhost/characters").contentType(MediaType.APPLICATION_JSON)
                .content(CHARACTER1_JSON);

        // Then response code should be 201
        mockMvc.perform(request).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void shouldFailOnSaveCharacterWithoutName() throws Exception {
        // Given I set body to {"leadership":3, "endurance":2}
        // When I POST to /characters
        MockHttpServletRequestBuilder request = post("http://localhost/characters").contentType(MediaType.APPLICATION_JSON)
                .content("{\"leadership\":3, \"endurance\":2}");

        // Then response code should be 400
        mockMvc.perform(request).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldRetrieveSavedCharacterByName() throws Exception {
        // Given I saved character
        shouldSaveCharacterWithName();
        
        // When I GET /characters/C1
        MockHttpServletRequestBuilder request = get("http://localhost/characters/{name}", CHARACTER1_NAME);
        
        // Then response code should be 200
        mockMvc.perform(request).andDo(print())
            .andExpect(status().isOk())
        // And response body path $ should be {"name":"<name>", "leadership":<leadership>, "endurance":<endurance>}
            .andExpect(content().json(CHARACTER1_JSON));
    }

    @Test
    public void shouldListSavedCharacters() throws Exception {
        // Given I saved character
        shouldSaveCharacterWithName();
        
        // When I GET /characters
        MockHttpServletRequestBuilder request = get("http://localhost/characters");
        
        // Then response code should be 200
        mockMvc.perform(request).andDo(print())
            .andExpect(status().isOk())
        // And response body path $ should be [{"name":"<name>", "leadership":<leadership>, "endurance":<endurance>}]
            .andExpect(content().json("[" + CHARACTER1_JSON + "]"));
    }
}
