package cl.duoc.clase.api.matematicas;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles
class MatematicasControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void suma0_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/suma/{num1}/{num2}", "0", "0"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(0, resultado);
    }

    @Test
    void suma12_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/suma/{num1}/{num2}", "10", "2"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(12, resultado);
    }

    @Test
    void resta0_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/resta/{num1}/{num2}", "10", "10"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(0, resultado);
    }

    @Test
    void resta6_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/resta/{num1}/{num2}", "12", "6"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(6, resultado);
    }

    @Test
    void multiplicacion0_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/multiplicacion/{num1}/{num2}", "999999", "0"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(0, resultado);
    }

    @Test
    void multiplicacion56_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/multiplicacion/{num1}/{num2}", "7", "8"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(56, resultado);
    }

    @Test
    void division1_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/division/{num1}/{num2}", "7", "7"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(1, resultado);
    }

    @Test
    void division3_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/division/{num1}/{num2}", "21", "7"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(3, resultado);
    }

}
