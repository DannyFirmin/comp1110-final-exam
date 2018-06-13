package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 4
 */
public class Q4ArrayList<T> {
    private static final int INITIAL_SIZE = 2;
    private static final double GROWTH_FACTOR = 1.5;

    T[] values = (T[]) new Object[INITIAL_SIZE];
    int elements = 0;

    /**
     * Add a value to the tail of the list.
     *
     * @param value The value to be added.
     */
    public void add(T value) {
        /* Unimplemented.  Q4 i) [7 Marks] */
        if(elements >= values.length){
            T[] newValues = (T[])new Object[(int)(values.length * GROWTH_FACTOR)];
            for (int i = 0; i < elements; i++){
                newValues[i]= values[i];
            }
            values = newValues;

        }
            values[elements] = value;
            elements++;

    }

    /**
     * Remove the value at the specified index from the list.
     *
     * @param index
     */
    public void remove(int index) {
        /* Unimplemented. Q4 ii) [7 Marks] */
        if(index >= elements || index < 0) throw  new IndexOutOfBoundsException();
        if(elements <= values.length/GROWTH_FACTOR){
            T[] newValues = (T[]) new Object[values.length/2];
            int j =0;
            for (int i = 0; i<elements;i++){
                if (i==index) continue;
                newValues[j++]=values[i];
            }
        }
            for (int i = index; i < elements - 1; i++) {
                values[i] = values[i + 1];
            }
         //   values[elements-1]=null;

        elements--;
    }

    /**
     * @param index
     * @return The value at the specified index.
     */
    public T get(int index) {
        if (index >= elements || index < 0)
            throw new IndexOutOfBoundsException();
        return values[index];
    }

    /**
     * @return the current size of the list.
     */
    public int size() {
        return elements;
    }

    /**
     * Reverse the order of the elements of the list.
     */
    public void reverse() {
        /* Unimplemented. Q4 iii) [6 Marks] */
        T[] tmp = (T[]) new Object[elements];
        System.arraycopy(values,0,tmp,0,elements);
        for(int i= 0; i<elements/2;i++){
         //   T tmp = values[i];
            values[i] = values[elements-i-1];
            values[elements-i-1]= tmp[i];
        }
    }

    /**
     * @return A string representation of the list.
     */
    public String toString() {
        String rtn = "";
        for (int i = 0; i < elements; i++) {
            rtn += ((i != 0) ? " " : "") + values[i];
        }
        return rtn;
    }
}
