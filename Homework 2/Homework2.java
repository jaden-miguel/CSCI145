import java.io.File;
import java.io.FileNotFoundException;

public class Homework2{    
    public void run() {
        
        MatrixReader readMatrix1 = new MatrixReader();
        System.out.println("Matrix A: ");
        SparseMatrix fileRead1 = readMatrix1.read("matrixA.txt");
        fileRead1.print();
            
        System.out.println("Matrix B: ");

        MatrixReader readMatrix2 = new MatrixReader();
        SparseMatrix fileRead2 = readMatrix2.read("matrixB.txt");
        fileRead2.print();

        System.out.println("Transpose MatrixA: ");
        fileRead1.transpose().print();

        System.out.println("Transpose MatrixB: ");
        fileRead2.transpose().print();

        System.out.println("Product of Matrix A x Matrix B: ");
        fileRead1.product(fileRead2).print();
        
        System.out.println("Thank you for observing our SparseMatrix :)");
    }
}