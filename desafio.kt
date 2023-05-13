// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, var xp: Int = 0) {
    fun adicionarXp(quantidade: Int) {
        xp += quantidade
    }

    override fun toString() = "Usuario(nome='$nome', email='$email', xp=$xp)"
}

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario, xpMatricula: Int = 10) {
        usuarios.forEach {
            inscritos.add(it)
            it.adicionarXp(xpMatricula)
        }
    }

    fun removerInscrito(usuario: Usuario) = inscritos.remove(usuario)

    fun getInscritos(): List<Usuario> {
        return inscritos
    }

    override fun toString() = "Formacao(nome='$nome', conteudos=$conteudos)"
}

fun main() {
    val usuario = Usuario("Yuri Italo","yuriitalo@email.com")
    val usuario2 = Usuario("Carlos Maia","carlosmaia@email.com")
    val usuario3 = Usuario("Elias Santos","eliassantos@email.com")
    val usuario4 = Usuario("Mateus Lira", "mateuslira@email.com")
    val usuario5 = Usuario("Carla Volpato", "carlavolpato@email.com")
    println("Usuários criados:\n$usuario\n$usuario2\n$usuario3\n$usuario4\n$usuario5\n-----------------------")

    val conteudoEducacional = ConteudoEducacional("Aprendendo Kotlin do Zero ao Avançado",120)
    val conteudoEducacional2 = ConteudoEducacional("Desenvolva Web Services com Kotlin",360, Nivel.DIFICIL)
    val conteudoEducacional3 = ConteudoEducacional("Design Patterns mais usados no mercado", nivel = Nivel.INTERMEDIARIO)
    val conteudoEducacional4 = ConteudoEducacional("Aprendendo Java do Zero ao Avançado",120)
    val conteudoEducacional5 = ConteudoEducacional("Desenvolva Web Services com Java",360, Nivel.DIFICIL)
    val conteudoEducacional6 = ConteudoEducacional("Aprendendo PHP do Zero ao Avançado",120)
    val conteudoEducacional7 = ConteudoEducacional("Desenvolva Web Services com PHP",360, Nivel.DIFICIL)
    println("Conteúdos educacionais criados:" +
            "\n$conteudoEducacional" +
            "\n$conteudoEducacional2" +
            "\n$conteudoEducacional3" +
            "\n$conteudoEducacional4" +
            "\n$conteudoEducacional5" +
            "\n$conteudoEducacional6" +
            "\n$conteudoEducacional7\n-----------------------")

    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudoEducacional,conteudoEducacional2,conteudoEducacional3))
    val formacaoJava = Formacao("Formação Java", mutableListOf(conteudoEducacional4,conteudoEducacional5,conteudoEducacional3))
    val formacaoPHP = Formacao("Formação PHP", mutableListOf(conteudoEducacional6,conteudoEducacional7,conteudoEducacional3))
    println("Formações disponíveis:\n$formacaoJava\n$formacaoKotlin\n$formacaoPHP\n-----------------------")

    // matriculando alunos
    formacaoJava.matricular(usuario,usuario4, xpMatricula = 50)
    formacaoKotlin.matricular(usuario2,usuario3, xpMatricula = 25)
    formacaoPHP.matricular(usuario5, xpMatricula = 15)
    println("Alunos inscritos na Formação Java:\n" + formacaoJava.getInscritos())
    println("Alunos inscritos na Formação Kotlin:\n" + formacaoKotlin.getInscritos())
    println("Alunos inscritos na Formação PHP:\n" + formacaoPHP.getInscritos())
    println("-----------------------")

    // remover inscritos
    println("Remoção de inscritos: ")
    println("Alunos inscritos na Formação Java:\n" + formacaoJava.getInscritos())
    println("Aluno removido com sucesso? " + formacaoJava.removerInscrito(usuario4))
    println("Alunos inscritos na Formação Java:\n" + formacaoJava.getInscritos())
    println("Aluno removido com sucesso? " + formacaoJava.removerInscrito(usuario5))
    println("Alunos inscritos na Formação Java:\n" + formacaoJava.getInscritos())
}
