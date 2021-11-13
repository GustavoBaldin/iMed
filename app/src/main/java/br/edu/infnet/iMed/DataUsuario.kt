package br.edu.infnet.iMed

// Criamos uma data class, que é uma classe de dados, sem ter que atribuir atributos ou métodos pra classe Paciente
// Definimos essa classe com os itens necessários para o registro

data class DataUsuario (val nome: String? = null, val email: String? = null, val senha: String? = null, val cpf: String? = null, val convenio: String? = null,
                        val telefone: String? = null) {
}