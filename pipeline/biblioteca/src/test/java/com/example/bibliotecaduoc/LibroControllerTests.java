package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibroControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void total10_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros/total"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Integer resultado = objectMapper.readValue(json, Integer.class);

        assertNotNull(resultado);
        assertEquals(10, resultado);
    }

    @Test
    void consultaLibros_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros"))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Libro> libros = objectMapper.readValue(json, List.class);

        assertNotNull(libros);
        assertEquals(10, libros.size());
    }

    @Test
    void consultaPorIsbnNoExiste_retorna_404_isNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("isbn", "123"))
                .andExpect(status().isNotFound());
    }

    @Test
    void consultaPorIsbnExiste_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("isbn", "9780132350884"))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Libro[] libros = objectMapper.readValue(json, Libro[].class);

        assertNotNull(libros);
        assertEquals(1, libros.length);
        Libro libro = libros[0];
        assertNotNull(libro);
        assertEquals("Clean Code", libro.getTitulo());
    }

    @Test
    void consultaPorAutorNoExiste_retorna_404_isNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("autor", "Baradit"))
                .andExpect(status().isNotFound());
    }

    @Test
    void consultaPorAutorExiste_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("autor", "J.K.Rowling"))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Libro[] libros = objectMapper.readValue(json, Libro[].class);

        assertNotNull(libros);
        assertEquals(3, libros.length);
        Libro libro = libros[0];
        assertNotNull(libro);
        assertEquals("Harry Potter y la piedra filosofal", libro.getTitulo());
    }

    @Test
    void consultaPorFechaNoExiste_retorna_404_isNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("fechaPublicacion", "2999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void consultaPorFechaExiste_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("fechaPublicacion", "2000"))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Libro[] libros = objectMapper.readValue(json, Libro[].class);

        assertNotNull(libros);
        assertEquals(1, libros.length);
        Libro libro = libros[0];
        assertNotNull(libro);
        assertEquals("Harry Potter y el cáliz de fuego", libro.getTitulo());
    }

    @Test
    void consultaPorAutorYFechaExiste_retorna_200_isOk() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/libros")
                        .param("autor", "J.K.Rowling")
                        .param("fechaPublicacion", "2000"))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Libro[] libros = objectMapper.readValue(json, Libro[].class);

        assertNotNull(libros);
        assertEquals(1, libros.length);
        Libro libro = libros[0];
        assertNotNull(libro);
        assertEquals("Harry Potter y el cáliz de fuego", libro.getTitulo());
    }

}
