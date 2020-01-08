package test;

import static test.DoubleLinkedList.*;

/**
 * @author bertking
 * @date 2020/1/6
 */
public class ElementPool {
    /* 1K */
    private static final long MAX_SIZE = 1 * 1024L;

    private Element next;

    private long byteCount = 0L;

    private Element take() {
        synchronized (this) {
            if (next != null) {
                next = next.next;
                next.next = null;
                byteCount -= Element.SIZE;
                return next;
            } else {
                // Pool is empty.
                return new Element();
            }
        }
    }

    public void recycle(Element element) {
        if (element.next == null || element.prior == null) {
            throw new IllegalArgumentException("Failed requirement.");
        }

        synchronized (this) {
            if (byteCount + Element.SIZE > MAX_SIZE) return; // Pool is full.

            byteCount += Element.SIZE;
            element.next = next;
            next = element;
        }
    }

}
