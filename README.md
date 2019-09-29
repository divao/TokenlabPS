# TokenlabPS

App desenvolvido para o Desafio Mobile do Processo Seletivo para Estagiário da Tokenlab.

## Features

* App nativo Android utilizando a linguagem Kotlin
* Padrão de arquitetura de software: MVVM
* Biblioteca para as chamadas HTTP: Retrofit
* O app informa o usuário quando está baixando/processando dados através de uma Progress Bar
* O app trata erros, informando o usuário quando não conseguir baixar os dados (quando não há conexão com a internet ou o servidor não retornou os dados esperados nas chamadas HTTP, por exemplo)

## Descrição do Desafio

O pessoal da Tokenlab gosta muito de filmes e decidiu construir uma API REST que disponibiliza informações sobre 20 filmes que estão entre os mais bem avaliados pelos usuários do TMDB.
O desafio consiste em elaborar um aplicativo (Android ou iOS) que obtenha os dados desta API, apresentando-os de forma simples e acessível, seguindo os padrões de usabilidade da plataforma. Preze pela qualidade e não pela velocidade, utilize o tempo que lhe foi dado da melhor forma possível.

## Informações da API

* Para obter a listagem dos filmes, basta realizar uma requisição HTTP utilizando o método GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies
* Para obter informações detalhadas de um determinado filme, basta adicionar o ID do mesmo ao final do endpoint anterior. Então se quisermos, por exemplo, obter os detalhes do filme de ID 240, basta realizar um GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies/240

## Referências

1. "Modern Android app using Kotlin, MVVM, Dagger2, RxJava &more" - https://www.udemy.com/course/modernandroid/
2. "Recyclerview + Cardview with GridLayout | Android studio tutorial" - https://www.youtube.com/watch?v=SD2t75T5RdY


