
public class ArrayList<T> implements List<T> {
	private int maxSize;
	private int size;
	private int cur;
	private T[] arr;

	public ArrayList(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.cur = -1;
		this.arr = (T[]) new Object[maxSize];
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return size == maxSize;
	}

	@Override
	public void findFirst() {
		cur = 0;
		// TODO Auto-generated method stub

	}

	@Override
	public void findNext() {
		cur++;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean last() {
		// TODO Auto-generated method stub
		return cur == size - 1;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return arr[cur];
	}

	@Override
	public void update(T e) {
		arr[cur] = e;
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(T e) {
		for (int i = size - 1; i > cur; --i) {
			arr[i + 1] = arr[i];
		}
		cur++;
		arr[cur] = e;
		size++;

	}

	@Override
	public void remove() {
		for (int i = cur + 1; cur < size; i++) {
			arr[i - 1] = arr[i];
		}
		size--;
		if (size == 0)
			cur = -1;
		else if (cur == size)
			cur = 0;

	}

	@Override
	public boolean findFirstEle(Cond<T> cnd) {
		if (empty() == true || cnd == null)
			return false;
		for (int i = 0; i < size; i++) {
			if (cnd.test(arr[i])) {
				arr[cur] = arr[i];
				return true;
			}
		}
		return false;
	}

	@Override
	public List<T> findAllEle(Cond<T> cnd) {
		List<T> tmp = new ArrayList<T>(maxSize);
		if (empty() == true || cnd == null)
			return tmp;
		for (int i = 0; i < size; i++) {
			if (cnd.test(arr[i]))
				tmp.insert(arr[i]);
		}
		return tmp;
	}

}
