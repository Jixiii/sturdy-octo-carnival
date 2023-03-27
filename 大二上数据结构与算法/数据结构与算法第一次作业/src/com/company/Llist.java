package com.company;
import java.io.*;
class Link{
	private Object element;
	private Link next;
	Link(Object it,Link nextval){
		element=it;
		next=nextval;
	}
	Link(Link nextval){
		next=nextval;
	}
	Link next() {return next;}
	void setNext(Link nextval) {
		next=nextval;
	}
	Object element() {return element;}
	Object setElement(Object it) {return element=it;}

	@Override
	public String toString() {
		return "element="+element;
	}
}
public class Llist implements List{

	private Link head;
	private Link tail;
	protected Link curr;

	public Llist() {
		tail=head=curr=new Link(null);
	}

	//	Llist(int sz){
//		setup();
//	}
//	Llist(){
//		setup();
//	}
//	private void setup() {
//		tail=head=curr=new Link(null);//����dummyNode
//	}

	@Override
	public void insert(Object newElement) {
		if(!isFull())
			curr.setNext(new Link(newElement,curr.next()));
		if(tail==curr)tail=curr.next();
	}

	public void remove() {
		if(isEmpty()||curr.next()==null){
			return;
		}
		if(tail==curr.next())tail=curr;
		curr.setNext(curr.next().next());
	}

//	public void replace(String element) {
//		if(isEmpty()||element==null)return;
//		curr.setNext(new Link(element,curr.next()));
//	}
	@Override
	public void replace(Object newElement) {
		if(isEmpty()||newElement==null)return;
		curr.setNext(new Link(newElement,curr.next()));
	}

	public boolean isEmpty() {
		return head.next()==null;
	}

	public boolean isFull() {
		return false;
	}

	public boolean gotoBeginning() {
		if (isEmpty()) {
			return false;
		}
		curr = head;
		return true;
	}

	public boolean gotoEnd() {
		if(isEmpty()){
			return false;
		}
		curr=tail;
		return true;
	}
	public boolean gotoNext() {
		if(isEmpty()||curr.next()==tail)return false;
		curr=curr.next();
		return true;
	}
	public boolean gotoPrev() {
		if(isEmpty()||curr==head)return false;
		Link a=head;
		while(a.next()!=null&&a.next()!=curr) {
			a = a.next();
		}
		curr=a;
	    return true;
	}
	public Object getCursor(){
		return curr.next().element();
	}
	public void showStructure() {
		if(isEmpty()){
			System.out.print("Empty list -1\n");
		} else {
			Link temp=head;
			int currValue=0;
			while(temp.next()!=null){
				System.out.print(temp.next().element()+" ");
				temp=temp.next();
			}
			while(temp!=null&&temp!=curr){
				temp=temp.next();
				currValue++;
			}
			System.out.println(currValue-1);
		}
	}

	public void clear() {
		head.setNext(null);
		tail=head=curr=new Link(null);
	}
	public static void main(String[] args) {
		Llist list=new Llist();
		InputStreamReader reader = null;
		try { 
		     String pathname = "D:\\Javaaaa\\数据结构与算法第一次作业\\src\\testcase.txt";
		     File filename = new File(pathname); 
		     reader = new InputStreamReader(new FileInputStream(filename)); 
		     StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(reader));
		     streamTokenizer.ordinaryChar('-');
		     streamTokenizer.eolIsSignificant(true);
		     streamTokenizer.whitespaceChars('\r', '\r');
		     streamTokenizer.whitespaceChars('\n', '\n');
		     while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
		    	 switch (streamTokenizer.ttype){
                 case StreamTokenizer.TT_EOL:
                     list.showStructure();
                     break;
                 case StreamTokenizer.TT_WORD:
                     break;
                 default:
                     switch (String.valueOf((char) streamTokenizer.ttype)){
                     case "+":
                         streamTokenizer.nextToken();
                         list.insert(streamTokenizer.sval);
                         break;
                     case "-":
                         list.remove();
                         break;
                     case "=":
                         streamTokenizer.nextToken();
                         list.replace(streamTokenizer.sval);
                         break;
                     case "#":
                         list.gotoBeginning();
                         break;
                     case "*":
                         list.gotoEnd();
                         break;
                     case ">":
                         list.gotoNext();
                         break;
                     case "<":
                         list.gotoPrev();
                         break;
                     case "~":
                         list.clear();
                         break;
                 }
		     }
		 }
		    }catch(Exception e) {
		    	 e.printStackTrace();
		     }finally {
		    	 if(reader!=null) {
		    		 try {
		    			 reader.close();
		    		 }catch(IOException e) {
		    			 e.printStackTrace();
		    		 }
		    	 }
		     }
		}
	
}
	
	

	


