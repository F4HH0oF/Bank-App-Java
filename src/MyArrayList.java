import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private List<T> elements;

    public MyArrayList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T get(int index) {
        return elements.get(index);
    }

    public void remove(T element) {
        elements.remove(element);
    }

    public int size() {
        return elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex;

        public MyArrayListIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T element = elements.get(currentIndex);
            currentIndex++;
            return element;
        }
    }
}