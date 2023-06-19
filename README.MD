# Digytal - Solução de Currículo Vitae
*Este é um projeto desenvolvido na MJV School Java como proposta de projeto.*

Este é um projeto desenvolvido pela empresa Digytal no ano de 1950, uma época em que a tecnologia ainda era considerada futurista. Nesse período, linguagens de programação começaram a surgir no mercado, possibilitando a automação de processos por meio da computação. No entanto, bancos de dados relacionais ainda não eram tão comuns. Foi nesse contexto "limitado" que a Digytal recebeu sua primeira demanda como uma fábrica de software: desenvolver uma solução que permitisse às pessoas elaborar seus currículos vitae para serem enviados via e-mail e armazenados em um banco de dados centralizado da People Job, uma das maiores empresas de recrutamento e seleção de profissionais de TI.

## Escopo do Projeto

O escopo inicial do projeto consiste na criação de um programa simples, no qual os candidatos possam preencher seus dados pessoais, endereço, informações de contato, experiência profissional e pretensão salarial por meio do console. Esses registros devem ser coletados pelo sistema e gerar dois arquivos de saída com layouts delimitado e posicional, respectivamente, seguindo as especificações abaixo:

### Dados Pessoais:
- Nome
- CPF
- Data de Nascimento
- Sexo

### Dados de Endereço:
- Logradouro
- Número
- Complemento
- Bairro
- Cidade
- Estado

### Dados de Contato:
- E-mail
- Telefone
- Celular
- Se o celular for WhatsApp

### Dados Profissionais:
- Profissão
- Empresa
- Salário
- Emprego Atual

### Habilidades:
- Lista de habilidades

### Pretensão Salarial:
- Valor Mínimo
- Valor Máximo

## Considerações sobre leitura e escrita de arquivos

Ao lidar com a leitura e escrita de conteúdo em arquivos, devemos levar em consideração três aspectos importantes:

1. O diretório onde os arquivos serão armazenados.
2. O nome e a extensão dos arquivos.
3. O conteúdo do arquivo e sua representação estrutural.

Existem dois tipos comuns de representação de arquivos em aplicações convencionais:

- **Delimitado**: separado por um delimitador, que pode ser representado por símbolos como `;`, `,`, `|`, entre outros.
- **Posicional**: determina um comprimento máximo para cada campo ou coluna que representa uma informação ou registro.

De acordo com os requisitos do software desenvolvido, será necessário gerar dois arquivos de saída com as seguintes especificações:

### Arquivo 1: cadastro.csv
- Destino: `c:\jobby\files`
- Layout: delimitado por `;`
- Nome do arquivo: `cadastro.csv`

A ordem dos campos no arquivo deve seguir a imagem acima, considerando os ajustes a seguir:

- O campo "data" deve estar no formato `AAAA-MM-DD` (ano-mês-dia).
- Campos decimais (double) devem estar no formato `00.00` (exemplo: 1234.56).
- Campos lógicos (boolean) devem salvar o valor literal `true` ou `false`.
- Campos nulos (null) devem ser convertidos para vazio.
- Campos do tipo enum devem salvar o literal da opção

### Arquivo 2: cadastro.txt

- Destino: `c:\jobby\files`
- Layout: Posicional
- Nome do arquivo: `cadastro-{CPF}.txt` 

A empresa People Job espera receber dos candidatos o arquivo `cadastro-{CPF}.txt` para que ela possa processar e armazenar em seu banco de dados central.

Este aquivo deverá seguir a estrutura posicional conforme posição e comprimento dos campos mencionados na tabela abaixo:

| Ordem | Campo            | Tamanho | Valor Original - Inserido sem padrão    | Valor Formatado (People Job)     | Observação                                                                                                                      |
|-------|------------------|---------|-----------------------------------------|----------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| 01    | Nome             | 30      | Raimundo Nonato Loureiro Castelo Branco | RAIMUNDO NONATO LOUREIRO CASTE   | Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome, caso inferior completar com espaços à esquerda |
| 02    | CPF              | 11      | 135.217.791-18                          | 13521779118                      | Somente dígitos                                                                                                                 |
| 03    | Data             | 08      | 16/04/1986                              | 19860416                         |                                                                                                                                 |
| 04    | Sexo             | 1       | M=Masculino / F=Feminino                | M                                |                                                                                                                                 |
| 05    | Lougradouro      | 40      | Ruas das laranjeiras                    | RUAS DAS LARANJEIRAS             | Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome, caso inferior completar com espaços à esquerda |
| 06    | Numero           | 5       | 123 ou S/N                              | 00123                            | Caso não seja S/N, preencher formatado com 00000                                                                                |
| 07    | Complemento      | 20      | Bl 03 ap 113                            | BL 03 AP 113                     | Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome, caso inferior completar com espaços à esquerda |
| 08    | Bairro           | 30      | Vila Nazare                             | VILA NAZARE                      | Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome, caso inferior completar com espaços à esquerda |
| 09    | Cidade           | 40      | Teresina                                | TERESINA                         | Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome, caso inferior completar com espaços à esquerda |
| 10    | Estado           | 2       | Pi                                      | PI                               |                                                                                                                                 |
| 11    | E-mail           | 50      | raimundo.nonato@gmail.com               | Garantir caracteres em mínusculo | Se o valor for inferior, completar com espaços à esquerda                                                                       |
| 12    | Telefone         | 10      | (11) 3351-1010                          | 1133511010                       | Em caso de não ter telefone, preencher com 0000000000                                                                           |
| 13    | Celular          | 11      | (11) 94565-2353                         | 11945652353                      | Em caso de não ter celular, preencher com 0000000000                                                                            |
| 14    | Celular é Whats? | 1       | T=true / F=false                        | T                                | Em caso de não ter celular, preencher com 0                                                                                     |
| 15    | Profissão        | 30      | Analista de sistemas                    | ANALISTA DE SISTEMAS             | Aplicar regra do campo Nome e considerar                                                                                        |
