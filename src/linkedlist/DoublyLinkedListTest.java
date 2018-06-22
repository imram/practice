package linkedlist;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Created by ramgupta on 6/20/18.
 */
public class DoublyLinkedListTest {

    @Test
    public void createdDoublyLinkedList() {
        assertThat(new DoublyLinkedList(), Is.isA(DoublyLinkedList.class));
    }

    @Test
    public void sizeOfDoublyLinkedList() {
        assertThat(new DoublyLinkedList().size(), is(0));
    }

    @Test
    public void addHeadElement() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        assertThat(doublyLinkedList.size(), is(1));
    }

    @Test
    public void addHeadNode() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.add(new DoublyLinkedList.DoublyLinkedListNode(1));
        assertThat(doublyLinkedList.size(), is(1));
    }

    @Test
    public void addTwoElementsAtEnd() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);

        assertThat(doublyLinkedList.size(), is(2));
    }

    @Test
    public void addThreeElements() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);

        assertThat(doublyLinkedList.size(), is(3));
    }

    @Test
    public void getElementFromEmptyList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        assertThat(doublyLinkedList.getByPosition(0), is(-1));
    }

    @Test
    public void givenPositionIndexZeroReturnsFirstElement() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);

        assertThat(doublyLinkedList.getByPosition(0), is(1));
    }

    @Test
    public void givenTwoElementsReturnElementsAtIndexOne() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);

        assertThat(doublyLinkedList.getByPosition(0), is(1));
        assertThat(doublyLinkedList.getByPosition(1), is(2));
    }

    @Test
    public void integrationForGetByPosition() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);

        assertThat(doublyLinkedList.getByPosition(0), is(1));
        assertThat(doublyLinkedList.getByPosition(1), is(2));
        assertThat(doublyLinkedList.getByPosition(2), is(3));
        assertThat(doublyLinkedList.getByPosition(3), is(4));
    }

    @Test
    public void toArrayForEmptyList() {
        assertThat(new DoublyLinkedList().toArray(), is(new int[] {}));
    }

    @Test
    public void givenOneElementReturnsAnElement() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        assertThat(doublyLinkedList.toArray(), is(new int[] {1}));
    }

    @Test
    public void givenTwoElementReturnsAnElement() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        assertThat(doublyLinkedList.toArray(), is(new int[] {1, 2}));
    }

    @Test
    public void givenSomeElementReturnsAllElementsInArray() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        assertThat(doublyLinkedList.toArray(), is(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void reverseToArrayEmptyList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertThat(doublyLinkedList.reverseToArray(), is(new int[] {}));
    }

    @Test
    public void givenOneElementListReturnsArraywithElement() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        assertThat(doublyLinkedList.reverseToArray(), is(new int[] {1}));
    }

    @Test
    public void givenTwoElementListReturnsElementsInReverseOrder() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        assertThat(doublyLinkedList.reverseToArray(), is(new int[] {2, 1}));
    }

    @Test
    public void givenThreeElementsListReturnsElementsInReverseOrder() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        assertThat(doublyLinkedList.reverseToArray(), is(new int[] {3, 2, 1}));
    }

    @Test
    public void reverseList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.add(6);
        assertThat(doublyLinkedList.reverse().toArray(), is(new int[] {6, 5, 4, 3, 2, 1}));
    }

    private static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        private int size() {
            if (head == null)
                return 0;
            int count = 0;
            DoublyLinkedListNode current = head;

            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        public void add(int data) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(data);
            add(node);
        }

        public void add(DoublyLinkedListNode node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }

            DoublyLinkedListNode current = head;
            for (; current.next != null; current = current.next)
                ;
            node.prev = current;
            current.next = node;
            tail = node;
        }

        public int getByPosition(int position) {
            if (head == null) {
                return -1;
            }
            if (head == tail)
                return position == 0 ? head.data : -1;

            DoublyLinkedListNode current = head;

            for (int index = 0; index < position && current != null; index++)
                current = current.next;
            return current == null ? -1 : current.data;
        }

        public int[] toArray() {
            if (head == null)
                return new int[0];
            if (head == tail)
                return new int[] {head.data};

            int[] ints = new int[size()];
            int index = 0;
            for (DoublyLinkedListNode current = head; current != null; current = current.next)
                ints[index++] = current.data;

            return ints;
        }

        public int[] reverseToArray() {
            if (head == null)
                return new int[] {};

            if (head == tail)
                return new int[] {head.data};

            int[] result = new int[size()];
            DoublyLinkedListNode current = tail;

            for (int index = 0; current != null; current = current.prev)
                result[index++] = current.data;
            return result;
        }

        public DoublyLinkedList reverse() {
            if (head == null)
                return this;
            if (head == tail)
                return this;

            DoublyLinkedListNode start = head;
            DoublyLinkedListNode end = tail;

            while (start != end && start.prev != end) {
                int tmp = start.data;
                start.data = end.data;
                end.data = tmp;

                start = start.next;
                end = end.prev;
            }

            return this;

        }

        private static class DoublyLinkedListNode {
            private int data;
            public DoublyLinkedListNode next;
            public DoublyLinkedListNode prev;

            public DoublyLinkedListNode(int data) {
                this.data = data;
            }
        }
    }
}
