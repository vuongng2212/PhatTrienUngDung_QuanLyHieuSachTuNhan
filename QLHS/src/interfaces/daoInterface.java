package interfaces;

import java.sql.PreparedStatement;

public interface daoInterface<T,U> {
	U getAll();
	boolean add(T obj);
	boolean update(T obj);
	boolean delete(String ma);
	void close(PreparedStatement stm);
}
