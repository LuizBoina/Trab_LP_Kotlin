package ufes

import java.text.SimpleDateFormat
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField.after



class OrientaPos(campos: List<String>, dis: Discente) : Orientacao(campos[0], campos[4], dis) {
    val dataIngresso = SimpleDateFormat("dd/MM/yyyy").parse(campos[2].trim())
    val programa = campos[3].trim()

    fun dataFormata(): String {
        val formato = SimpleDateFormat("dd/MM/yyyy")
        return formato.format(this.dataIngresso)
    }
}