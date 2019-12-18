package engineer.oleske.funtimes

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class FunControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var funRepository: FunRepository

    @Test
    fun `regular fun returns status ok`() {
        mockMvc.perform(get("/regularFun"))
                .andExpect(status().isOk)
    }

    @Test
    fun `super fun returns status ok`() {
        mockMvc.perform(get("/superFun"))
                .andExpect(status().isOk)
    }

    @Test
    fun `post fun saves the fun`() {
        every { funRepository.save(Fun(null, "I'm saving fun 💽")) } returns Fun(null, "saved")

        mockMvc.perform(post("/postFun").content("I'm saving fun 💽"))
                .andExpect(status().isOk)

        verify { funRepository.save(Fun(null, "I'm saving fun 💽")) }
    }

    @Test
    fun `repo fun returns saved fun`() {
        every { funRepository.findAll() } returns mutableListOf(Fun(1,"I'm saving fun 💽"))

        mockMvc.perform(get("/repoFun"))
                .andExpect(status().isOk)
                .andExpect(content().string("[{\"id\":1,\"funstring\":\"I'm saving fun \\uD83D\\uDCBD\"}]"))
    }
}