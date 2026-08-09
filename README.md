# 📍 Qual Meu CEP

Aplicativo Android desenvolvido em **Kotlin** para consultar informações de endereço a partir de um CEP utilizando a **API ViaCEP**.

O projeto foi desenvolvido com foco no aprendizado de consumo de APIs REST em aplicações Android, utilizando **Retrofit**, **Gson**, **ViewModel** e **StateFlow**.

## 🚀 Tecnologias utilizadas

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Retrofit** — consumo da API REST
* **Gson** — conversão de JSON para objetos Kotlin
* **ViewModel** — gerenciamento da lógica e estado da tela
* **StateFlow** — gerenciamento de estado de forma reativa
* **Coroutines** — execução de operações assíncronas

## 🌐 API utilizada

O projeto utiliza a **ViaCEP** para consultar informações de endereço.

API:

https://viacep.com.br/

Exemplo de consulta:

```text
https://viacep.com.br/ws/01001000/json/
```

A API retorna informações como:

* CEP
* Logradouro
* Complemento
* Bairro
* Cidade
* Estado

## 🏗️ Estrutura do projeto

```text
app/
└── src/
    └── main/
        └── java/
            └── com.example.qualmeucep/
                │
                ├── data/
                │   ├── model/
                │   │   └── Address.kt
                │   │
                │   └── repository/
                │       ├── ApiFactory.kt
                │       └── ApiService.kt
                │
                └── ui/
                    └── ...
```

## 🔄 Fluxo da aplicação

O funcionamento básico do aplicativo segue o seguinte fluxo:

```text
Usuário informa o CEP
        ↓
ViewModel
        ↓
ApiService
        ↓
Retrofit
        ↓
ViaCEP
        ↓
JSON
        ↓
Gson
        ↓
Address
        ↓
StateFlow
        ↓
Jetpack Compose
        ↓
Informações exibidas na tela
```

## 📦 Modelo de dados

A resposta da API é representada pela `data class Address`:

```kotlin
data class Address(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val erro: Boolean? = null
)
```

## 🔌 Configuração do Retrofit

O Retrofit é configurado através do `ApiFactory`:

```kotlin
object ApiFactory {

    val apiCep: ApiService = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()
        .create(ApiService::class.java)
}
```

O `GsonConverterFactory` é responsável por converter automaticamente a resposta JSON da API em um objeto `Address`.

## 📡 Serviço da API

A comunicação com a ViaCEP é definida através de uma interface:

```kotlin
interface ApiService {

    @GET("ws/{cep}/json/")
    suspend fun getAddress(
        @Path("cep") cep: String
    ): Address
}
```

O `@Path` permite inserir o CEP informado pelo usuário diretamente na URL da requisição.

## 🎯 Objetivos do projeto

Este projeto tem como objetivo praticar:

* Consumo de APIs REST no Android
* Requisições HTTP com Retrofit
* Conversão de JSON com Gson
* `data class` em Kotlin
* `interface` em Kotlin
* Coroutines e funções `suspend`
* ViewModel
* StateFlow
* Gerenciamento de estado no Jetpack Compose
* Organização de código utilizando uma estrutura de camadas

## 📚 Aprendizados

Durante o desenvolvimento foram praticados conceitos importantes do desenvolvimento Android moderno, principalmente a comunicação entre a interface, ViewModel e uma API externa.

O projeto também serve como base para estudos futuros envolvendo **Repository Pattern**, tratamento de erros, estados de carregamento e validação de dados.

## 👨‍💻 Autor

**Artur Eloi**

Projeto desenvolvido como parte dos estudos de **desenvolvimento Android nativo com Kotlin**.
