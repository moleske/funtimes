package engineer.oleske.funtimes

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FunController(val funRepository: FunRepository) {
    @GetMapping("/regularFun")
    fun regularFun(): String = "regular fun"

    @GetMapping("/superFun")
    fun superFun(): String = "🤪 super fun"

    @PostMapping("/postFun")
    fun postFun(@RequestBody body: String) = funRepository.save(Fun(id = null, funstring = body))

    @GetMapping("/repoFun")
    fun repoFun(): MutableIterable<Fun> = funRepository.findAll()
}