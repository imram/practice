package linkedlist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import linkedlist.MyLinkedList.Node;

public class MyLinkedListTest {

    @Test
    public void linkedListSizeIsReturned() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        assertThat(myLinkedList.size(), is(2));
    }

    @Test
    public void append_OneElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
    }

    @Test
    public void get_Element() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(5);

        assertThat(myLinkedList.getElementByPosition(1), is(5));
    }

    @Test
    public void append_TwoElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);

        assertThat(myLinkedList.getElementByPosition(1), is(1));
        assertThat(myLinkedList.getElementByPosition(2), is(2));

    }

    @Test
    public void append_ThreeElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);

        assertThat(myLinkedList.getElementByPosition(1), is(1));
        assertThat(myLinkedList.getElementByPosition(2), is(2));
        assertThat(myLinkedList.getElementByPosition(3), is(3));
    }

    @Test
    public void prepend_oneElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.prepend(1);
        assertThat(myLinkedList.getElementByPosition(1), is(1));
    }

    @Test
    public void prepend_TwoElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.prepend(1);
        myLinkedList.prepend(2);

        assertThat(myLinkedList.getElementByPosition(1), is(2));
        assertThat(myLinkedList.getElementByPosition(2), is(1));

    }

    @Test
    public void delete_emptyList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        assertThat(myLinkedList.delete(1), is(false));
    }

    @Test
    public void delete_firstElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        assertThat(myLinkedList.delete(1), is(true));
        assertThat(myLinkedList.size(), is(0));
        assertThat(myLinkedList.getElementByPosition(1), is(-1));

    }

    @Test
    public void delete_lastElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        assertThat(myLinkedList.delete(2), is(true));
        assertThat(myLinkedList.size(), is(1));
        assertThat(myLinkedList.getElementByPosition(1), is(1));
        assertThat(myLinkedList.getElementByPosition(2), is(-1));

    }

    @Test
    public void delete_middleElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        assertThat(myLinkedList.delete(2), is(true));
        assertThat(myLinkedList.size(), is(2));
        assertThat(myLinkedList.getElementByPosition(1), is(1));
        assertThat(myLinkedList.getElementByPosition(2), is(3));

    }

    @Test
    public void check_elementIsPresentInEmptyList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        assertThat(myLinkedList.contains(0), is(false));
    }

    @Test
    public void givenInputListWithOneElementWithSearchElementNotPresent() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        assertThat(myLinkedList.contains(0), is(false));
    }

    @Test
    public void givenInputListWithOneElementWithSearchElementPresent() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        assertThat(myLinkedList.contains(1), is(true));
    }

    @Test
    public void givenInputListWithTwoElementsWithSearchElementMissing() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        assertThat(myLinkedList.contains(1), is(true));
        assertThat(myLinkedList.contains(2), is(true));
    }

    @Test
    public void givenEmptyList_printNothing() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.reversePrint();

    }

    @Test
    public void givenList_reversePrint() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);
        myLinkedList.append(9);
        myLinkedList.reversePrint();

    }

    @Test
    public void givenEmptyList_ReturnEmptyList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.reverse();
        assertThat(myLinkedList.size(), is(0));
    }


    @Test
    public void givenTwoElementsList_ReturnReversedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.reverse();
        assertThat(myLinkedList.size(), is(2));
        assertThat(myLinkedList.getElementByPosition(1), is(6));
        assertThat(myLinkedList.getElementByPosition(2), is(5));
    }

    @Test
    public void givenThreeElementsList_ReturnReversedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);

        myLinkedList.reverse();
        assertThat(myLinkedList.size(), is(4));
        assertThat(myLinkedList.getElementByPosition(1), is(8));
        assertThat(myLinkedList.getElementByPosition(2), is(7));
        assertThat(myLinkedList.getElementByPosition(3), is(6));
        assertThat(myLinkedList.getElementByPosition(4), is(5));
    }

    @Test
    public void check_eitherEmptyListReturnsFalse() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();
        assertThat(MyLinkedList.compare(myLinkedList1, myLinkedList2), is(false));
    }

    @Test
    public void check_oneElementWithSameDataReturnsFalse() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(5);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(5);
        assertThat(MyLinkedList.compare(myLinkedList1, myLinkedList2), is(true));
    }

    @Test
    public void check_oneElementWithDiffDataReturnsFalse() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(5);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(6);
        assertThat(MyLinkedList.compare(myLinkedList1, myLinkedList2), is(false));
    }

    @Test
    public void check_twoElementsWithDiffDataReturnsFalse() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(5);
        myLinkedList1.append(6);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(5);
        myLinkedList2.append(7);
        assertThat(MyLinkedList.compare(myLinkedList1, myLinkedList2), is(false));
    }



    @Test
    public void mergeEmptyLists() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();

        assertThat(MyLinkedList.merge(myLinkedList1, myLinkedList2).size(), is(0));
    }

    @Test @Ignore
    public void mergeEmptyListInListWithOneElement() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(5);
        MyLinkedList myLinkedList2 = new MyLinkedList();

        MyLinkedList mergedList = MyLinkedList.merge(myLinkedList1, myLinkedList2);
        assertThat(mergedList.size(), is(1));
        assertThat(mergedList.getElementByPosition(1), is(5));

    }

    @Test @Ignore
    public void mergeOtherEmptyListInListWithOneElement() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(5);

        MyLinkedList mergedList = MyLinkedList.merge(myLinkedList1, myLinkedList2);
        assertThat(mergedList.size(), is(1));
        assertThat(mergedList.getElementByPosition(1), is(5));

    }

    @Test
    public void mergeOneElementLists() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(6);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(5);

        MyLinkedList mergedList = MyLinkedList.merge(myLinkedList1, myLinkedList2);
        assertThat(mergedList.size(), is(2));
        assertThat(mergedList.getElementByPosition(1), is(5));
        assertThat(mergedList.getElementByPosition(2), is(6));

    }

    @Test
    public void mergeElementsListsSameSize() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(2);
        myLinkedList1.append(3);
        myLinkedList1.append(5);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(1);
        myLinkedList2.append(2);
        myLinkedList2.append(4);

        MyLinkedList mergedList = MyLinkedList.merge(myLinkedList1, myLinkedList2);
        assertThat(mergedList.size(), is(6));
        assertThat(mergedList.getElementByPosition(1), is(1));
        assertThat(mergedList.getElementByPosition(2), is(2));
        assertThat(mergedList.getElementByPosition(3), is(2));
        assertThat(mergedList.getElementByPosition(4), is(3));
        assertThat(mergedList.getElementByPosition(5), is(4));
        assertThat(mergedList.getElementByPosition(6), is(5));

    }

    @Test
    public void mergeElementsListsDiffSize() {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.append(3);
        myLinkedList1.append(5);
        myLinkedList1.append(7);
        myLinkedList1.append(8);
        myLinkedList1.append(9);
        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.append(1);
        myLinkedList2.append(2);
        myLinkedList2.append(3);

        MyLinkedList mergedList = MyLinkedList.merge(myLinkedList1, myLinkedList2);
        assertThat(mergedList.size(), is(8));
        assertThat(mergedList.getElementByPosition(1), is(1));
        assertThat(mergedList.getElementByPosition(2), is(2));
        assertThat(mergedList.getElementByPosition(3), is(3));
        assertThat(mergedList.getElementByPosition(4), is(3));
        assertThat(mergedList.getElementByPosition(5), is(5));
        assertThat(mergedList.getElementByPosition(6), is(7));
        assertThat(mergedList.getElementByPosition(7), is(8));
        assertThat(mergedList.getElementByPosition(8), is(9));

    }

    @Test
    public void removeDuplFromEmptyList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).size(), is(0));
    }

    @Test
    public void removeDuplFromSingleItemList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).size(), is(1));
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(1), is(1));
    }

    @Test
    public void noremovalForNonDupList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).size(), is(2));
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(1), is(1));
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(2), is(2));
    }

    @Test
    public void removeDuplFromDupList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(1);
        myLinkedList.append(1);
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(1), is(1));
    }

    @Test
    public void removeDuplFromTripletList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(5);
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(1), is(3));
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(2), is(4));
        assertThat(MyLinkedList.removeDuplicate(myLinkedList).getElementByPosition(3), is(5));
    }

}
