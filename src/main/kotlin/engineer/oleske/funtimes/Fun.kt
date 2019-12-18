package engineer.oleske.funtimes

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Fun (
        @Id
        @GeneratedValue
        val id: Long?,
        val funstring: String
)