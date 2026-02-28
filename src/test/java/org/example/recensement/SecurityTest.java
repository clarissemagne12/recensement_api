package org.example.recensement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void accessDeniedWithoutLogin() throws Exception {
        mockMvc.perform((RequestBuilder) get("/api/admin/test"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void accessDeniedForAdmin() throws Exception {
        mockMvc.perform((RequestBuilder) get("/api/admin/test"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void accessAllowedForAdmin() throws Exception {
        mockMvc.perform((RequestBuilder) get("/api/admin/test"))
                .andExpect(status().isOk());
    }
}
