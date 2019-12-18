package engineer.oleske.funtimes

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class FunControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun regularFun() {
        mockMvc.perform(get("/regularFun")).andExpect(status().isOk)
    }

    @Test
    fun superFun() {
        mockMvc.perform(get("/superFun")).andExpect(status().isOk)
    }
}