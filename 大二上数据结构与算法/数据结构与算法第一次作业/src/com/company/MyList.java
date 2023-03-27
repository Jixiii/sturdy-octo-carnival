package com.company;


public class MyList implements List {

    private Node first;         //头（第一个）节点
    private Node end;           //尾（最后一个）节点
    private Node cursor;        //当前节点
    private int cursorValue;    //当前节点的下标
    private int lenghth;        //链表长度

    @Override
    public void insert(Object newElement) {
        if (lenghth == 0) {                                                     //如果表空
            Node temp = new Node(newElement, null, null);          //设置一个临时节点储存该元素
            setCursor(temp);                                                    //设置当前节点为该元素
            cursorValue = 0;                                                    //设置当前节点下标为0
            setFirst(temp);                                                     //设置头节点为该元素
            setEnd(temp);                                                       //设置尾节点为该元素
        } else if (cursor == end) {                                             //如果当前位置为表尾
            cursor.setNext(new Node(newElement, null, cursor));            //设置当前节点的后继为插入元素，插入元素的前驱为当前节点
            cursor = cursor.getNext();                                          //后移当前节点
            cursorValue++;
            end = cursor;                                                       //设置当前节点为尾节点
        } else {
            cursor.setNext(new Node(newElement, cursor.getNext(), cursor));     //设置当前节点的后继为插入元素，插入元素的后继为当前节点的后继，插入元素的前驱为当前节点
            cursor = cursor.getNext();                                          //后移当前节点
            cursorValue++;
            cursor.getNext().setPrevious(cursor);                               //设置当前节点的后继的前驱为当前节点
        }
        lenghth++;                                                              //长度增加
    }

    @Override
    public void remove() {
        if (lenghth != 0) {                                                 //表不为空
            if (lenghth == 1) {                                             //如果表中只有一个元素
                this.clear();                                               //置空表
            } else {                                                        //表中有多个元素
                if (cursor == end) {                                        //如果当前节点为尾节点
                    end = end.getPrevious();                                //设置尾节点为其前驱
                    end.setNext(null);                                      //设置尾节点的后继为null
//                    cursor = first;                                         //设置当前节点为头节点
//                    cursorValue = 0;
                    this.gotoBeginning();
                } else if (cursor == first) {                               //如果当前节点为头节点
                    cursor = cursor.getNext();                              //设置当前节点为其后继
                    first = cursor;                                         //设置头节点为当前节点
                    cursor.setPrevious(null);                               //设置当前节点的前驱为null
                } else {
                    cursor.getPrevious().setNext(cursor.getNext());         //设置当前节点的前驱的后继为当前节点的后继
                    cursor.getNext().setPrevious(cursor.getPrevious());     //设置当前节点的后继的前驱为当前节点的前驱
                    cursor = cursor.getNext();                              //设置当前节点为其后继
                }
                lenghth--;                                                  //表长减少
            }
        }
    }

    @Override
    public void replace(Object newElement) {
        if (cursor != null) {
            cursor.setElement(newElement);              //设置当前节点的元素为新元素
        }
    }

    @Override
    public void clear() {
        first = cursor = end = null;        //设置头节点、尾节点、当前节点为null
        lenghth = 0;                        //表长为0
        cursorValue = -1;                   //当前节点下标为-1
    }

    @Override
    public boolean isEmpty() {
        return lenghth == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean gotoBeginning() {
        if (lenghth != 0) {
            setCursor(first);
            cursorValue = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean gotoEnd() {
        if (lenghth != 0) {
            setCursor(end);
            cursorValue = lenghth - 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean gotoNext() {
        if (cursor != end) {
            setCursor(cursor.getNext());        //设置当前为其后继
            cursorValue++;                      //当前节点下标加一
            return true;
        }
        return false;
    }

    @Override
    public boolean gotoPrev() {
        if (cursor != first) {
            setCursor(cursor.getPrevious());        //设置当前节点为其前驱
            cursorValue--;                          //当前节点下标减一
            return true;
        }
        return false;
    }

    @Override
    public Object getCursor() {
        return cursor.getElement();
    }

    @Override
    public void showStructure() {
        if (lenghth == 0) {
            System.out.println("Empty list -1 ");
        } else {
            Node test = first;                              //设置测试节点为头节点
            while (test != null) {                          //当测试节点不为空
                System.out.print(test.getElement() + " ");  //输出测试节点的元素
                test = test.getNext();                      //后移测试节点
            }
            System.out.println(cursorValue);
        }

    }

    public MyList() {
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public void setCursor(Node cursor) {
        this.cursor = cursor;
    }

    public int getLenghth() {
        return lenghth;
    }

    public void setLenghth(int lenghth) {
        this.lenghth = lenghth;
    }

    public int getCursorValue() {
        return cursorValue;
    }

    public void setCursorValue(int cursorValue) {
        this.cursorValue = cursorValue;
    }
}
