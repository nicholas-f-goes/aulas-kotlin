package nicholas.goes.helloworldproject.model

class Boleto(var name: String, var valor: Double, var Data: String) {

    override fun toString(): String {
        return "Boletos(name='$name', valor=$valor, Data='$Data')"
    }
}
