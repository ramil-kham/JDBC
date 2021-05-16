package tech.itpark.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class WebappApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Записки юного врача\",\n" +
                        "    \"price\": 317,\n" +
                        "    \"quantity\": 20,\n" +
                        "    \"author\": \"Булгаков\",\n" +
                        "    \"weight\": 252\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Капитанская дочка\",\n" +
                        "    \"price\": 165,\n" +
                        "    \"quantity\": 30,\n" +
                        "    \"author\": \"Пушкин\",\n" +
                        "    \"weight\": 300\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"Подросток\",\n" +
                        "    \"price\": 201,\n" +
                        "    \"quantity\": 25,\n" +
                        "    \"author\": \"Достоевский\",\n" +
                        "    \"weight\": 450\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"name\": \"Дети капитана Гранта\",\n" +
                        "    \"price\": 245,\n" +
                        "    \"quantity\": 15,\n" +
                        "    \"author\": \"Верн\",\n" +
                        "    \"weight\": 250\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 5,\n" +
                        "    \"name\": \"Граф Монте-Кристо\",\n" +
                        "    \"price\": 464,\n" +
                        "    \"quantity\": 19,\n" +
                        "    \"author\": \"Дюма\",\n" +
                        "    \"weight\": 678\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 6,\n" +
                        "    \"name\": \"Вий\",\n" +
                        "    \"price\": 171,\n" +
                        "    \"quantity\": 27,\n" +
                        "    \"author\": \"Гоголь\",\n" +
                        "    \"weight\": 247\n" +
                        "  }\n" +
                        "]\n"));

        mockMvc.perform(get("/books/2"))
                .andExpect(content().json("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"name\": \"Капитанская дочка\",\n" +
                        "  \"price\": 165,\n" +
                        "  \"quantity\": 30,\n" +
                        "  \"author\": \"Пушкин\",\n" +
                        "  \"weight\": 300\n" +
                        "}"));
        mockMvc.perform(get("/books/search")
                .queryParam("name", "Подросток")
                .queryParam("author", "Достоевский"))
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"Подросток\",\n" +
                        "    \"price\": 201,\n" +
                        "    \"quantity\": 25,\n" +
                        "    \"author\": \"Достоевский\",\n" +
                        "    \"weight\": 450\n" +
                        "  }\n" +
                        "]"));
        mockMvc.perform(post("/books")
                .contentType("application/json")
                .content("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"name\": \"Бородино\",\n" +
                        "  \"price\": 180,\n" +
                        "  \"quantity\": 16,\n" +
                        "  \"author\": \"Лермонтов\",\n" +
                        "  \"weight\": 230\n" +
                        "}"))
                .andExpect(content().json("{\n" +
                        "  \"id\": 7,\n" +
                        "  \"name\": \"Бородино\",\n" +
                        "  \"price\": 180,\n" +
                        "  \"quantity\": 16,\n" +
                        "  \"author\": \"Лермонтов\",\n" +
                        "  \"weight\": 230\n" +
                        "}"));
        mockMvc.perform(post("/books")
                .contentType("application/json")
                .content("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"name\": \"Анна Каренина\",\n" +
                        "  \"price\": 500,\n" +
                        "  \"quantity\": 24,\n" +
                        "  \"author\": \"Толстой\",\n" +
                        "  \"weight\": 300\n" +
                        "}"))
                .andExpect(content().json("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"name\": \"Анна Каренина\",\n" +
                        "  \"price\": 500,\n" +
                        "  \"quantity\": 24,\n" +
                        "  \"author\": \"Толстой\",\n" +
                        "  \"weight\": 300\n" +
                        "}"));

    }


}
