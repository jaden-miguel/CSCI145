public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
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
            ValueNode next = current.getNextColumn();

            while(next != null && next.getColumn() < value.getColumn()) {
                current = next;
                next = next.getNextColumn();
            }

            current.setNextColumn(value);
            value.setNextColumn(next);
        }
    }

    public int get(int position) {
        ValueNode current = first;

        while(current != null && current.getColumn() < position) {
            current = current.getNextColumn();
        }

        if(current == null || current.getColumn() != position) {
            return 0;
        }
        
        return current.getValue();
    }

}
