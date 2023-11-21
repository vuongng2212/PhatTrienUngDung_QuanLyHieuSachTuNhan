package interfaces;

public interface listInterface<T> {
	String getDS();
	boolean add(T obj);
	boolean xoa(int index);
	boolean update(T obj);
	int getCount();
}
