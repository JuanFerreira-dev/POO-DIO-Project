# **SisHop - Sistema Hospitalar** 🏥  

**Projeto desenvolvido para o Bootcamp da DIO (Digital Innovation One)**  

Um sistema de cadastro e gerenciamento de pessoas em um ambiente hospitalar, desenvolvido em **Java** como parte do desafio de projeto do Bootcamp.  

---

## **📌 Visão Geral**  

O **SisHop** é um sistema de cadastro que permite:  
✅ **Cadastrar** pacientes, médicos e enfermeiros  
✅ **Consultar** registros completos  
✅ **Editar** informações  
✅ **Excluir** cadastros  

---

## **🔧 Funcionalidades**  

### **1. Menu Principal**  
- Interface simples com opções numéricas  
- Validação de entrada  

### **2. Cadastro de Pessoas**  
- **Pacientes**:  
  - Nome, CPF, telefone, endereço  
  - ID do paciente, plano de saúde, problema de saúde  
  - Associação opcional com médico responsável  

- **Médicos**:  
  - Nome, CPF, telefone, endereço  
  - CRM e especialidade  

- **Enfermeiros**:  
  - Nome, CPF, telefone, endereço  
  - COREN e turno de trabalho  

### **3. Consulta**  
- Lista todos os nomes e CPFs cadastrados  
- Busca detalhada por CPF  

### **4. Edição e Exclusão**  
- Atualização de dados  
- Remoção de cadastros  

---

## **🛠️ Tecnologias e Conceitos Utilizados**  

- **Java (JDK 17+)**  
- **POO (Programação Orientada a Objetos)**  
  - Herança (`Person` → `Patient`, `Doctor`, `Nurse`)  
  - Encapsulamento (getters e setters)  
  - Associação (`Patient` ↔ `Doctor`)  
- **Estruturas de Dados** (`LinkedHashSet` para armazenamento)  
- **Tratamento de Entrada** (`Scanner` para interação com o usuário)  

---

## **🚀 Como Executar**  

1. **Pré-requisitos**:  
   - JDK 17+ instalado  
   - Git (opcional, para clonar o repositório)  

2. **Compilação e Execução**:  
   ```bash
   git clone https://github.com/seu-usuario/sishop.git
   cd sishop/src
   javac org/caioferreira/controller/Showtxt.java
   java org.caioferreira.controller.Showtxt
   ```

---

## **📂 Estrutura do Projeto**  

```
src/
└── org/
    └── caioferreira/
        ├── controller/
        │   └── Showtxt.java       # Classe principal (menu e lógica)
        └── entities/
            ├── Person.java        # Classe base
            ├── Patient.java       # Paciente (herda Person)
            ├── Doctor.java       # Médico (herda Person)
            └── Nurse.java        # Enfermeiro (herda Person)
```

---

## **📝 Melhorias Futuras**  

- [ ] **Persistência de Dados** (salvar em arquivo/banco de dados)  
- [ ] **Interface Gráfica** (JavaFX/Swing)  
- [ ] **Validação de CPF/CRM/COREN**  
- [ ] **Sistema de Login**  

---

## **📜 Licença**  

Este projeto está sob a licença **MIT**.  

---

## **👨‍💻 Autor**  

**Caio Ferreira**  
- GitHub: [@caioferreira](https://github.com/FerreiraxDev)  
- LinkedIn: [Caio Ferreira](https://www.linkedin.com/in/jferreirax)  

---

### **💡 Observação**  
Este projeto foi desenvolvido como parte do **Bootcamp da DIO**, com o objetivo de aplicar conceitos de **Java e POO**.  

**🔗 Link do Repositório:** [github.com/seu-usuario/sishop](https://github.com/seu-usuario/sishop)  

--- 

**⭐ Se gostou, deixe uma estrela no repositório!** ⭐
