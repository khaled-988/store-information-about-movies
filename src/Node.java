
public class Node<T> {

	private Node<T> next;
	private Node<T> til;
	private T data;

	public Node(T v) {
		super();
		this.next = null;
		this.til = null;
		this.data = v;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public Node<T> getTil() {
		return til;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setTil(Node<T> til) {
		this.til = til;
	}

}
