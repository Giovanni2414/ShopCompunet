package com.icesi.edu.Shop.Integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icesi.edu.Shop.dto.*;
import com.icesi.edu.Shop.model.Computer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasProperty;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
public class ShopIntegrationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;

    private final UUID USER_UUID = UUID.fromString("33414782-71a7-11ed-a1eb-0242ac120002");
    private final UUID ORDER_UUID = UUID.fromString("06b8dc30-71ec-11ed-a1eb-0242ac120002");

    @BeforeEach
    private void init() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void getComputersSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/computers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<ComputerDTO> userResult = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ComputerDTO>>(){});
        assertThat(userResult.get(0), hasProperty("name", is("Lenovo SP-1")));
        assertThat(userResult.get(1), hasProperty("name", is("GameWar Pad V1")));
    }

    @Test
    @SneakyThrows
    public void createComputerSuccessfully() {
        ComputerDTO baseComputer = baseComputer();
        String body = objectMapper.writeValueAsString(baseComputer);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/computers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        ComputerDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), ComputerDTO.class);
        //   UserError userError = objectMapper.readValue(result.getResponse().getContentAsString(), UserError.class);
        assertThat(userResult, hasProperty("name", is("Lenovo")));
    }

    @Test
    @SneakyThrows
    public void getUserSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + USER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        UserDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserDTO.class);
        assertThat(userResult, hasProperty("email", is("Giovanni2414g@gmail.com")));
    }

    @Test
    @SneakyThrows
    public void getUsersSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<UserDTO> userResult = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<UserDTO>>(){});
        assertThat(userResult.get(0), hasProperty("email", is("Giovanni2414g@gmail.com")));
        assertThat(userResult.get(0).getUserOrders().get(0), hasProperty("orderId", is(UUID.fromString("06b8dc30-71ec-11ed-a1eb-0242ac120002"))));
    }

    @Test
    @SneakyThrows
    public void createUserSuccessfully() {
        UserRegisterDTO baseUser = baseUser();
        String body = objectMapper.writeValueAsString(baseUser);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        UserDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), UserDTO.class);
        //   UserError userError = objectMapper.readValue(result.getResponse().getContentAsString(), UserError.class);
        assertThat(userResult, hasProperty("email", is("Juseros@hotmail.com")));
    }

    @SneakyThrows
    public void createOrderSuccessfully() {
        List<OrderItemToCreateDTO> baseOrder = baseOrder();
        String body = objectMapper.writeValueAsString(baseOrder);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();
        OrderDTO userResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);
        //   UserError userError = objectMapper.readValue(result.getResponse().getContentAsString(), UserError.class);
        assertThat(userResult, hasProperty("total", is(9.55)));
    }

    @Test
    @SneakyThrows
    public void deleteOrderSuccessfully() {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @SneakyThrows
    private UserRegisterDTO baseUser(){
        String body = parseResourceToString("createUser.json");
        return objectMapper.readValue(body, UserRegisterDTO.class);
    }
    @SneakyThrows
    private ComputerDTO baseComputer(){
        String body = parseResourceToString("createComputer.json");
        return objectMapper.readValue(body, ComputerDTO.class);
    }
    @SneakyThrows
    private List<OrderItemToCreateDTO> baseOrder(){
        String body = parseResourceToString("createOrder.json");
        return objectMapper.readValue(body, new TypeReference<List<OrderItemToCreateDTO>>(){});
    }
    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

}
