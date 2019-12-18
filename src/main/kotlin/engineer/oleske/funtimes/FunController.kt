package engineer.oleske.funtimes

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FunController {
    @GetMapping("/regularFun")
    fun regularFun(): String = "regular fun"

    @GetMapping("/superFun")
    fun superFun(): String = "🤪 super fun"
}