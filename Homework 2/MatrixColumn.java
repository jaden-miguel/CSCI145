public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        if(first == null) {
           first = value;
        }

        //sorting
        else{
            //creating a point to the head
            ValueNode current = first;
            ValueNode next = current.getNextRow();

            while(next != null && next.getRow() < value.getRow()) {
                current = next;
                next = next.getNextRow();
            }

            current.setNextRow(value);
            value.setNextRow(next);
        }
    }

    public int get(int position) {
        ValueNode current = first;

        while(current != null && current.getRow() < position) {
            current = current.getNextRow();
        }

        if(current == null || current.getRow() != position) {
            return 0;
        }
        
        return current.getValue();
    }

}
