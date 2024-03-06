import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class MatrixReader {
    
    public SparseMatrix read(String file){
        File matrixFile = new File(file);
        try {
            Scanner scan = new Scanner(matrixFile);
            
            String line1 = scan.nextLine();
            int parseLineRows = Integer.parseInt(line1);
            
            String line2 = scan.nextLine();
            int parseLineColumns = Integer.parseInt(line2);

            SparseMatrix matrixSparse = new SparseMatrix(parseLineRows, parseLineColumns);
            int lineCount = 0;
          
            while (scan.hasNextLine()) {
                lineCount += 1;
                String lineRead = scan.nextLine();
                String [] lineSplitSpace = lineRead.split(" ");
                for (String linesNeedSplit: lineSplitSpace){
                    String [] linesSplitCommas = linesNeedSplit.split(",");
                    int lineColumns = Integer.parseInt(linesSplitCommas[0]);
                    int lineValueNode = Integer.parseInt(linesSplitCommas[1]);
                    matrixSparse.insert(lineCount, lineColumns, lineValueNode);
                        
                }
            }
            
            return matrixSparse;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
        return null; 

    }
}
        
