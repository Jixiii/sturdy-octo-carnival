package 贺晓珉;
public interface list<T> {
	void insert(T element);//����Ԫ����cursorλ��
	void remove();//ɾ��cursorλ��Ԫ��
	void replace(T element);//�滻cursorԪ��
	void clear();//�������
	boolean isEmpty();//���Ƿ�Ϊ��
	boolean isFull();//���Ƿ�����
	boolean gotoBeginning();//ʹcursorָ��head
	boolean gotoEnd();//ʹcursorָ��tail
	boolean gotoNext();//cursorָ����һ��
	boolean gotoPrev();//cursorָ��ǰһ��
	T getCursor();//��ȡcursorλ��Ԫ��ֵ
	void showStructure();//���cursorλ�õ�Ԫ��ֵ�Լ�cursor��ָindex
}
