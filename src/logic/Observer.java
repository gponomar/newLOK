package logic;

public interface Observer<T> {
	public void update(T val);
}