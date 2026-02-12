# 🐾 adotaPet - Sistema de Cadastro

O adotaPet é uma aplicação Java robusta via linha de comando (CLI) para o gerenciamento completo do cadastro de pets. O sistema permite o registro, busca avançada, edição e exclusão de animais, utilizando persistência de dados em arquivos de texto e seguindo regras de negócio estritas.

## Funcionalidades

- **Leitura Dinâmica:** As perguntas do cadastro são carregadas externamente via `formulario.txt`.
- **Cadastro Validado:** Inserção de pets com verificação rigorosa de dados (RegEx para nomes, limites de peso/idade).
- **Persistência de Dados:** Salvamento automático de cada registro em arquivos `.txt` individuais com timestamp.
- **Busca Avançada:**
   - Filtragem por Nome, Sexo, Idade, Peso, Raça ou Endereço.
   - Combinação de até 2 critérios (ex: *Tipo* + *Nome* + *Idade*).
   - Busca *Case Insensitive* e parcial (contém string).
- **Edição e Remoção:** Atualização de dados cadastrais e exclusão segura de registros.
- **Tratamento de Erros:** Sistema resiliente a inputs inválidos do usuário e exceções customizadas.


## Perguntas no Formulário

```text
Qual o nome e sobrenome do pet?
Qual o tipo do pet (Cachorro/Gato)?
Qual o sexo do animal?
Qual endereço e bairro que ele foi encontrado?
Qual a idade aproximada do pet?
Qual o peso aproximado do pet?
Qual a raça do pet?
```

## Regras de Negócio

O sistema implementa as seguintes regras estritas de validação:

| Campo             | Regra                                                                                                                                  |
|:------------------|:---------------------------------------------------------------------------------------------------------------------------------------|
| **Nome**          | Apenas letras de A-Z. Caracteres especiais e números lançam exceção. Obrigatório Nome e Sobrenome.                                     |
| **Tipo/Sexo**     | Uso estrito de `ENUM` (Cachorro/Gato, Macho/Fêmea).                                                                                    |
| **Idade**         | Máximo de 20 anos. Idades em meses (menor que 1 ano) são convertidas para decimais (0.x).                                              |
| **Peso**          | Mínimo 0.5kg, Máximo 60kg.                                                                                                             |
| **Endereço**      | Coleta estruturada em etapas: Número, Cidade, Rua.                                                                                     |
| **Campos Vazios** | Nome, Raça, Peso, Idade e Endereço (número) são preenchidos com "NÃO INFORMADO" se deixados em branco (salvo restrições obrigatórias). |

## Armazenamento

Os pets são salvos na pasta `petsCadastrados` seguindo o padrão de nomenclatura temporal:
`ANO-MES-DIA-T-HORA-MINUTO-NOMECOMPLETO.TXT`

**Exemplo de conteúdo do arquivo gerado:**

```text
1 - Florzinha da Silva 
2 - Gato 
3 - Femea 
4 - Rua 2, 456, Seilandia 
5 - 6 anos 
6 - 5kg 
7 - Siames
```