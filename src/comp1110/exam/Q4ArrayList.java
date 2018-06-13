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
        if ((elements + 1) >= values.length) {
            T[] newValues = (T[]) new Object[(int) (values.length * GROWTH_FACTOR)];
            for (int i = 0; i < elements; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
        values[elements] = value;
        elements = elements + 1;
        /* Unimplemented.  Q4 i) [7 Marks] */
    }

    /**
     * Remove the value at the specified index from the list.
     *
     * @param index
     */
    public void remove(int index) {
        if (elements>=1 && index>=0 && index<=elements-1){
            if ( (elements - 1) < (int) (values.length / GROWTH_FACTOR)) {
                T[] newValues = (T[]) new Object[(int) (values.length )];

                int j = 0;
                for (int i = 0; i < elements; i++) {
                    if (i == index) continue;
                    newValues[j++] = values[i];
                }
                values = newValues;
            } else {
                for (int i = index; i < (elements - 1); i++) {
                    values[i] = values[i + 1];
                }
            }
            elements--;
        } else
           {
               throw new IndexOutOfBoundsException();
           }}
        /* Unimplemented. Q4 ii) [7 Marks] */


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
        for (int i = 0; i < elements / 2; i++) {
            T temp = values[i];
            values[i] = values[elements - i - 1];
            values[elements - i - 1] = temp;
        }
        /* Unimplemented. Q4 iii) [6 Marks] */
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
