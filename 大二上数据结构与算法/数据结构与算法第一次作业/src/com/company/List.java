package com.company;

public interface List<T> {
    void insert(T newElement);
    /*
    * Precondition: List is not full and newElement is not full.
    * PostCondition:
    * Inserts newElement into a list after the cursor. If the list is empty, newElement is inserted as the
  first(and only)element in the list.
  In either case(empty or not empty),moves the cursor to newElement.
    */
    void remove();
    /*
    * Precondition:
    * List is not empty.
    * PostCondition:
    * Removes the element marked by the cursor from a list. If the resulting list is not empty, then moves the
  cursor to the element that followed the deleted element. If the deleted element was at the end of the list, then
  moves the cursor to the element at the beginning of the list.
    */
    void replace(T newElement);
    /*
     * Precondition:
     * List is not empty and newElement is not null.
     * PostCondition:
     * Replaces the element marked by the cursor with newElement. The cursor remains at newElement.
     */
    void clear();
    /*
     * Precondition:
     * None
     * PostCondition:
     * Removes all the elements in a list.
     */
    boolean isEmpty();
    /*
     * Precondition:
     * None
     * PostCondition:
     * Returns true if a list is empty. Otherwise, returns false.
     */
    boolean isFull();
    /*
    * Precondition:
    * None
    * PostCondition:
    * Returns true if a list is full. Otherwise, returns false.
    */
    boolean gotoBeginning();
    /*
    * Precondition:
    * None
    * PostCondition:
    * If a list is not empty, then moves the cursor to the beginning of the list and returns true. Otherwise,
  returns false.
    */
    boolean gotoEnd();
    /*
    * Precondition:
    * None
    * PostCondition:
    * If a list is not empty, then moves the cursor to the end of the list and returns true. Otherwise, returns
  false.
    */
    boolean gotoNext();
    /*
    * Precondition:
    * List is not empty.
    * PostCondition:
    * If the cursor is not at the end of a list, then moves the cursor to the next element in the list and return
  true. Otherwise, returns false.
    */
    boolean gotoPrev();
    /*
    * Precondition:
    * List is not empty.
    * PostCondition:
    * If the cursor is not at the beginning of a list, then moves the cursor to the preceding element in the list
  and returns true. Otherwise, returns false.
    */
    T getCursor();
    /*
     * Precondition:
     * List is not empty.
     * PostCondition:
     * Returns a copy of the element marked by the cursor.
     */
    void showStructure();
    /*
    * Precondition:
    * None
    * PostCondition:
    * Outputs the elements in a list and the value of cursor. If the list is empty, outputs "Empty list". Note that
this operation is intended for testing/debugging purpose only.
    */
}