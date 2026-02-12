# 🐾 adotaPet

Uma aplicação robusta via Linha de Comando (CLI) para o gerenciamento completo do cadastro de pets. O sistema permite o registro, busca avançada, edição e exclusão de animais, utilizando persistência de dados em arquivos de texto e seguindo regras de negócio estritas.

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