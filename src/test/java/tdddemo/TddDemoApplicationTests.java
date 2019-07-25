package tdddemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveCharacterWithName() throws Exception {
        // Given I set body to {"name":"C1", "leadership":1, "endurance":4}
        // When I POST to /characters
        MockHttpServletRequestBuilder request = post("http://localhost/characters").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"C1\", \"leadership\":1, \"endurance\":4}");

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
    public void shouldRetrieveSavedCharacterByName() {
        // TODO implement
    }

}
