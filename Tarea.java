package arrayunidimensionalesbidimensionales;

import java.util.Scanner;

public class Tarea {
    
    Scanner s = new Scanner(System.in);
    int filas1, columnas1, filas2, columnas2;
    int[] arreglo1, arreglo2;
    
    public Tarea() {
        
        System.out.println("Ingrese cuantas filas tiene la primera matriz");
        filas1 = s.nextInt();
        System.out.println("Ingrese cuantas columnas tiene la primera matriz");
        columnas1 = s.nextInt();
        arreglo1 = LlenarArreglo(filas1, columnas1);
        
        System.out.println("Ingrese cuantas filas tiene la segunda matriz");
        filas2 = s.nextInt();
        System.out.println("Ingrese cuantas columnas tiene la segunda matriz");
        columnas2 = s.nextInt();
        arreglo2 = LlenarArreglo(filas2, columnas2);
        
        if (columnas1 == filas2) {
            System.out.println("Matriz 1");
            ImprimirArreglo(filas1, columnas1, arreglo1);
            System.out.println();
            System.out.println("Matriz 2");
            ImprimirArreglo(filas2, columnas2, arreglo2);
            System.out.println();
            System.out.println("Matriz resultante");
            ImprimirArreglo(filas1, columnas2, MultiplicarArreglos());
        }
        else {
            System.out.println("No se pueden multiplicar las matrices");
            System.out.println("La primera matriz debe tener tantas filas como la segunda tiene columnas");
        }
        
    }
    
    public int[] MultiplicarArreglos() {
        int[] ArregloResultante = new int[filas1 * columnas2];
        int temporal;
        
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                temporal = 0;
                for (int k = 0; k < filas2; k++) {
                    temporal = temporal + (arreglo1[(i * columnas1) + k] * arreglo2[j+(k*columnas2)]);
                }
                ArregloResultante[(i * columnas2) + j] = temporal;
            }
        }
        
        return ArregloResultante;
    }

    
    //  Método para imprimir un arreglo que tiene la matriz
    //  Como el que hicimos en la clase
    public void ImprimirArreglo(int filas, int columnas, int[] arreglo) {
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("  ["+(i+1)+","+(j+1)+"] "+arreglo[(i * columnas) + j]);
            }
            System.out.println();
        }
        
    }
    
    //  Método para llenar una matriz en un arreglo
    //  Como el que hicimos en clase
    public int[] LlenarArreglo(int filas, int columnas) {
        int[] arreglo = new int[filas * columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                arreglo[(i * columnas) + j] = (int)(Math.random() * 19) + 1;
            }
        }
        
        return arreglo;
    }
    
}
