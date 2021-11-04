
public interface collectionInterface<T> {
	//void add (String element);
	T get (String target);
	boolean contains(String target);
	//boolean remove(T target);
	boolean isFull();
	boolean isEmpty();
	int size();

}
