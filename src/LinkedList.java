
public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> cur;

	public LinkedList() {
		super();
		head = null;
		cur = null;
	}

	public LinkedList(Node head) {
		super();
		this.head = head;
		cur = null;
	}

	public LinkedList(Node<T> head, Node<T> cur) {
		super();
		this.head = null;
		this.cur = null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void findFirst() {
		cur = head;
		// TODO Auto-generated method stub

	}

	@Override
	public void findNext() {
		cur = cur.getNext();
		// TODO Auto-generated method stub

	}

	@Override
	public boolean last() {
		// TODO Auto-generated method stub
		return cur.getNext() == null;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return cur.getData();
	}

	@Override
	public void update(T e) {
		cur.setData(e);
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(T e) {
		if (head == null)
			cur = head = new Node<T>(e);
		else {
			Node<T> tmp = cur.getNext();
			cur.setNext(new Node<T>(e));
			cur = cur.getNext();
			cur.setNext(tmp);
		}

	}

	@Override
	public void remove() {
		if (cur == head)
			head = head.getNext();
		else {
			Node<T> tmp = head;
			while (tmp.getNext() != cur)
				tmp = tmp.getNext();
			tmp.setNext(cur.getNext());

		}
		if (cur.getNext() == null)
			cur = head;
		else
			cur = cur.getNext();
	}

	@Override
	public boolean findFirstEle(Cond<T> cnd) {
		if (empty() == true || cnd == null)
			return false;
		Node<T> tmp = head;
		while (tmp != null) {
			if (cnd.test(tmp.getData())) {
				cur = tmp;
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	@Override
	public List<T> findAllEle(Cond<T> cnd) {
		List<T> x = new LinkedList<T>();
		if (empty() == true || cnd==null)
			return x;
		Node<T> tmp = head;
		while (tmp != null) {
			if (cnd.test(tmp.getData())) {
				x.insert(tmp.getData());
			}
			tmp = tmp.getNext();
		}
		return x;
	}

}
