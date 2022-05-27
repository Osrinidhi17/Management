package in.hcl.user_management.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.hcl.user_management.service.UserService;
import in.hcl.user_management.web.UserController;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    
	@Test
	void test_createNewUser() throws Exception {
		BDDMockito.given(userService.registerUser(Mockito.anyString(),Mockito.anyString()))
		.willReturn((String))
		mockMvc.perform(MockMvcRequestBuilders.get("/user/register"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isMap());
		}

}
