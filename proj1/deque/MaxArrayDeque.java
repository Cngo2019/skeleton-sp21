package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T max() {
        if (this.isEmpty()) {
            return null;
        }

        T max = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (this.comparator.compare(max, this.get(i)) < 0) {
                max = this.get(i);
            }
        }
        return max;
    }
}
