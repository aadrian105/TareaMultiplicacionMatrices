package arrayunidimensionalesbidimensionales;

import java.util.Scanner;

public class Arreglo {
    private int[] array;
    private int ren, col, x, y;
    private int size;
    private double data;

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
    
    

    public Arreglo(int ren, int col) {
        this.ren = ren;
        this.col = col;
        array    = new int [ren * col];
    }
    
    public Arreglo() {
        this.ren = 3;
        this.col = 3;
        array    = new int[ren * col];
    }
    
    public double bigger(double[] array, double big, int index) {
        if (index >= array.length)
            return big;
        else{
            if (array[index] >= big) {
                big = array[index];
            }
            return bigger(array, big, index+1);
        }
    }
    
    public double sumatoria(int index) {
        if (index == array.length-1)
            return array[index];
        else
            return array[index] + sumatoria(++index);
    }
    
    //      busqueda secuencial
    private int searchY(int i, int j) {
        if (j >= col)
            return -1;
        if (array[(ren * i) + j] == data)
            return j;
        else
            return searchY(i, ++j);
    }
    
    public double[] search(int i) {
        if (i >= ren)
            return new double[] {-1, -1, -1};
        int j = searchY(i, 0);
        if (j != -1)
            return new double[] {i, j, data};
        else
            return search(++i);
    }
    
    //      busqueda binaria
    public double binarySearch() {
        return 0;
    }
    
    public void read() {
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                array[(i*j)+1] = leer.nextInt();
            }
        }
        
    }
    
    public void print() {
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + i + "," + j + "]" + array[(ren*i) + j]);
            }
            System.out.println();
        }
    }
    
    public void fill(int n, int m) {
        
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                array[(ren*i) + j] = (int)Math.abs(Math.floor(Math.random()*(n-m+1)+m));
            }
            
        }
        
    }
    
    
}
