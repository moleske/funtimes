package engineer.oleske.funtimes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FuntimesApplication

fun main(args: Array<String>) {
	runApplication<FuntimesApplication>(*args)
}
