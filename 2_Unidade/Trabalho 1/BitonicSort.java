// Pseudocódigo Bitonic Sort:

FUNCTION BitonicSort(A, low, count, direction)
    // A: vetor de elementos
    // low: índice inicial
    // count: número de elementos
    // direction: 1 para crescente, 0 para decrescente

    IF count > 1 THEN
        k = count / 2

        // Ordena a primeira metade em ordem crescente
        BitonicSort(A, low, k, 1)

        // Ordena a segunda metade em ordem decrescente
        BitonicSort(A, low + k, k, 0)

        // Mescla as duas metades
        BitonicMerge(A, low, count, direction)
    END IF
END FUNCTION


FUNCTION BitonicMerge(A, low, count, direction)
    IF count > 1 THEN
        k = count / 2
        FOR i = low TO (low + k - 1) DO
            IF (direction = 1 AND A[i] > A[i + k]) OR (direction = 0 AND A[i] < A[i + k]) THEN
                swap A[i], A[i + k]
            END IF
        END FOR

        BitonicMerge(A, low, k, direction)
        BitonicMerge(A, low + k, k, direction)
    END IF
END FUNCTION


// Função principal
FUNCTION Main()
    A = [3, 7, 4, 8, 6, 2, 1, 5]
    n = tamanho(A)

    BitonicSort(A, 0, n, 1)     // 1 indica ordenação crescente

    PRINT "Vetor ordenado:", A
END FUNCTION



// Passo a passo Bitonic Sort:

Dados iniciais:
 A = [3, 7, 4, 8, 6, 2, 1, 5]
 Tamanho = 8 (potência de 2 → ideal para Bitonic Sort)
 Objetivo: ordenar em ordem crescente


Etapa 1: Divisão Recursiva
 O vetor é dividido até formar pares (tamanho 1) e começa a ser combinado em sequências bitônicas.
 [3,7,4,8,6,2,1,5]
  → Divide em duas metades:
     [3,7,4,8] (ordem crescente)
     [6,2,1,5] (ordem decrescente)


Etapa 2: Criação das Sequências Bitônicas

 Subvetor [3,7,4,8] (direção crescente):
  Divide: [3,7] e [4,8]
  BitonicMerge([3,7,4,8], crescente)
  Comparar (3,4), (7,8)
  Nenhuma troca → [3,4,7,8]

 Subvetor [6,2,1,5] (direção decrescente):
  Divide: [6,2] e [1,5]
  BitonicMerge([6,2,1,5], decrescente)
  Comparar (6,1), (2,5)
  Trocas → [1,6,5,2]
  BitonicMerge novamente → [6,5,2,1]
  Resultado: [6,5,2,1]

 Agora temos:
  Parte crescente: [3,4,7,8]
  Parte decrescente: [6,5,2,1]
  Sequência bitônica formada.


Etapa 3: Mesclagem (BitonicMerge)
 BitonicMerge([3,4,7,8,6,5,2,1], crescente)

 Comparar pares:
   (3,6), (4,5), (7,2), (8,1)
  Trocas em (7↔2) e (8↔1)
  Resultado parcial: [3,4,2,1,6,5,7,8]

 BitonicMerge([3,4,2,1], crescente)
  Comparar (3,2), (4,1)
  Trocas → [2,1,3,4]
  BitonicMerge([2,1]) → troca → [1,2]
  BitonicMerge([3,4]) → sem troca
  Resultado: [1,2,3,4]

 BitonicMerge([6,5,7,8], crescente)
  Comparar (6,7), (5,8)
  Nenhuma troca
  Resultado: [5,6,7,8]

 Concatenando:
  [1,2,3,4,5,6,7,8]


Resultado final:
 [1, 2, 3, 4, 5, 6, 7, 8]
