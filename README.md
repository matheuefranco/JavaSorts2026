# Implementações de Ordenação - Estrutura de Dados II

Este projeto reúne implementações de algoritmos de ordenação desenvolvidas para a disciplina de **Estrutura de Dados II**.

As implementações foram escritas em Java e utilizam generics, `Comparable` e `Comparator` para permitir a ordenação de diferentes tipos de dados.

## Algoritmos implementados

- **Bubble Sort**: possui versões tradicional, detalhada e otimizada.
- **Insertion Sort**: ordenação por inserção.
- **Selection Sort**: ordenação por seleção do menor elemento.
- **Quick Sort**: ordenação baseada na divisão do vetor a partir de um pivô.

Os algoritmos contabilizam operações como comparações, trocas e deslocamentos, permitindo observar o custo de cada estratégia.

## Estrutura do projeto

- `src/App.java`: classe principal e exemplos de execução.
- `src/BubbleSort.java`: implementação do Bubble Sort.
- `src/InsertionSort.java`: implementação do Insertion Sort.
- `src/SelectionSort.java`: implementação do Selection Sort.
- `src/QuickSort.java`: implementação do Quick Sort.
- `src/Pessoa.java`: classe de exemplo que implementa `Comparable`.
- `src/ComparadorData.java`: comparador para ordenar pessoas pela data de nascimento.
- `lib/`: bibliotecas externas, caso sejam necessárias.
- `out/`: arquivos compilados gerados pelo projeto.

## Como executar

No terminal, a partir da pasta do projeto:

```powershell
javac -d out src\*.java
java -cp out App
```

O programa gera um vetor de números inteiros, executa os algoritmos de ordenação e exibe métricas de comparações, trocas, deslocamentos e tempo de execução.

## Objetivo acadêmico

O objetivo é estudar o funcionamento dos algoritmos de ordenação, praticar a implementação de estruturas e técnicas fundamentais e comparar o desempenho de diferentes métodos.
