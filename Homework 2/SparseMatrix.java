

public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;
    private ValueNode row;
   
    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        this.firstColumn = new MatrixColumn();
        MatrixColumn tempColumn = firstColumn;

        for(int i = 1; i < totalColumns; i++) {
            MatrixColumn secondTempColumn = new MatrixColumn();
            tempColumn.setNext(secondTempColumn);
            tempColumn = secondTempColumn;
            }

        this.firstRow = new MatrixRow();
        MatrixRow tempRow = firstRow; 

        for(int i = 1; i < totalRows; i++) {

            MatrixRow secondTempRow = new MatrixRow();
            tempRow.setNext(secondTempRow);
            tempRow = secondTempRow;
        }
    }

    //Insert isnt inserting into sparseMatrix
    public void insert(int row, int column, int value) {
        ValueNode x = new ValueNode(row, column, value);
        MatrixColumn mColumn = getColumn(column);
        mColumn.insert(x);
        MatrixRow mRow = getRow(row);
        mRow.insert(x);
        
    }
    
    public MatrixRow getRow(int position) {
        MatrixRow currentRow = firstRow;

        for(int i = 1; i < position; i++){
            currentRow = currentRow.getNext();
        }

        return currentRow;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn currentColumn = firstColumn;

        for(int i = 1; i < position; i++){
            currentColumn = currentColumn.getNext();
        }

        return currentColumn;
    }   

    public int getValue(int row, int column) {
        MatrixRow current = getRow(row);
        if (current == null){
            return 0;
        }
        else{
            return current.get(column);
        }
    }

    public void print() {
        for(int i = 1; i <= totalRows; i++){
            for(int j = 1; j <= totalColumns; j++){
                System.out.printf("%5d", getValue(i, j));
            }

           System.out.println();
        }
    }

    public SparseMatrix transpose() {
        SparseMatrix matrixTranspose = new SparseMatrix(totalColumns, totalRows);
        for(int i = 1; i < totalRows + 1; i++){
            
            for(int j = 1; j < totalColumns + 1; j++){
                if(getValue(i, j) != 0){
                    matrixTranspose.insert(j, i, getValue(i, j));
                }
            }
        }
        
        return matrixTranspose;
    }

    public SparseMatrix product(SparseMatrix other) {
        SparseMatrix matrixProduct = new SparseMatrix(totalRows, totalColumns); 
        
        for(int i = 1; i < totalRows + 1; i++) {
            for(int j = 1; j < other.totalColumns + 1; j++){
                int sum = 0;
                for(int k = 1; k < totalColumns + 1; k++) {
                    sum += (getValue(i, k)) * (other.getValue(k, j));
                    matrixProduct.insert(i, j, sum);
                }
            
            }            
        }
        
        return matrixProduct;
    }
}
