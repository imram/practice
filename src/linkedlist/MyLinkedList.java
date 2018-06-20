package linkedlist;

public class MyLinkedList {
    private Node head;
    private int size;

    public void append(int data) {
        this.size++;
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node curent = head;
        while (curent.next != null) {
            curent = curent.next;
        }
        curent.next = node;
    }

    public int getElementByPosition(int position) {
        if (position > size) {
            return -1;
        }
        Node current = head;
        int index = 1;

        while (index < position) {
            current = current.next;
            index++;
        }

        return current.data;
    }

    public int size() {
        return size;
    }

    public void prepend(int data) {
        size++;
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

    public boolean delete(int position) {
        if (position > size)
            return false;

        if (position == 1) {
            head = null;
            size--;
            return true;
        }

        Node current = head;
        int index = 1;
        while (index < position - 1) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public boolean contains(int data) {
        if (head == null) {
            return false;
        }

        Node current = this.head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;

        }
        return false;
    }

    public void reversePrint() {
        if (head == null) {
            return;
        }

        int count = 0;
        for (Node current = head; current != null; current = current.next) {
            count++;
        }

        for (int i = count; i > 0; i--) {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            System.out.println(current.data);
        }
    }

    public void reverse() {
        if (head == null)
            return;

        Node current = head;

        int index = 1;
        int middle = size / 2;

        for (int i = size; i > size / 2; i--) {
            Node tail = head;
            for (int j = 0; j < i - 1; j++) {
                tail = tail.next;
            }
            swap(current, tail);
            current = current.next;
        }

    }

    private void swap(Node current, Node tail) {
        int temp = current.data;
        current.data = tail.data;
        tail.data = temp;
    }

    public static boolean compare(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        if (myLinkedList1.size() == 0 || myLinkedList2.size() == 0) {
            return false;
        }
        if (myLinkedList1.size() != myLinkedList2.size()) {
            return false;
        }

        Node current1 = myLinkedList1.head;
        Node current2 = myLinkedList2.head;
        while (current1 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public static MyLinkedList merge(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        MyLinkedList mergedList = new MyLinkedList();

        if (myLinkedList1.size != 0) {
            int counter;
            if (myLinkedList1.size <= myLinkedList2.size) {
                counter = myLinkedList1.size;
            } else {
                counter = myLinkedList2.size;
            }
            int index = 0;
            while (index < counter) {

                int elementByPosition1 = myLinkedList1.getElementByPosition(index + 1);
                int elementByPosition2 = myLinkedList2.getElementByPosition(index + 1);
                int low;
                int high;
                if (elementByPosition1 <= elementByPosition2) {
                    low = elementByPosition1;
                    high = elementByPosition2;
                } else {
                    low = elementByPosition2;
                    high = elementByPosition1;
                }

                if (mergedList.size != 0) {
                    int lastAdded = mergedList.getElementByPosition(mergedList.size);
                    if (low < lastAdded) {
                        mergedList.delete(mergedList.size);
                        mergedList.append(low);
                        low = lastAdded;
                    }
                }
                mergedList.append(low);
                mergedList.append(high);
                index++;
            }

            if (counter == myLinkedList1.size) {
                for (int remaining = counter; remaining < myLinkedList2.size; remaining++)
                    mergedList.append(myLinkedList2.getElementByPosition(remaining + 1));
            } else {
                for (int remaining = counter; remaining < myLinkedList1.size; remaining++)
                    mergedList.append(myLinkedList1.getElementByPosition(remaining + 1));
            }
        }
        return mergedList;
    }

    public static MyLinkedList removeDuplicate(MyLinkedList myLinkedList) {
        if (myLinkedList == null || myLinkedList.size <= 1)
            return myLinkedList;
        if (myLinkedList.size > 1) {
            Node current = myLinkedList.head;
            while (current != null && current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

        }
        return myLinkedList;

    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
