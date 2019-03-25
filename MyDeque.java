public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    data.addFirst("hi");
    System.out.println(data.start);
    data.addFirst("there");
    System.out.println(data.start);
    data.addFirst("bob");
    System.out.println(data.start);
    data.addFirst("my");
    System.out.println(data.start);
    data.addFirst("name");
    System.out.println(data.start);
    data.addFirst("is");
    System.out.println(data.start);
    data.addFirst("steve");
    System.out.println(data.start);
    data.addFirst("whats");
    System.out.println(data.start);
    data.addFirst("up");
    System.out.println(data.start);
    data.addFirst("bobby");
    System.out.println(data.start);
    data.addFirst("this");
    System.out.println(data.start);
    data.addFirst("fantastic");
    System.out.println(data.start);
    System.out.println(data.getLast());
    System.out.println(data.getFirst());
    System.out.println(data.size());
    data.debug();
    System.out.println(data.start);
    System.out.println(data.end);
    System.out.println(data);
  }

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String ans = "{";
    int addedIndex = 0;
    int s = start;
    while (addedIndex != size && s != end) {
      if (s >= data.length) {
        s = 0;
      }
      ans += data[s] + " ";
      addedIndex++;
      s++;
    }
    ans += "}";
    return ans;
  }

  private void debug() {
    String ans = "";
    int index = 0;
    for (int i = 0; i < size; i++) {
      ans += data[index] + " ";
      index++;
    }
    System.out.println(ans);
  }
  public void addFirst(E element) {
    if (size == data.length) {
      resize();
      start = 0;
      end = size;
    }
    if (start < 0) {
      start = data.length - 1;
      data[start] = element;
      start--;
      size++;
    } else {
      size++;
      data[start] = element;
      start--;
    }
  }
  public void addLast(E element) {
    if (size == data.length) {
      resize();
      start = 0;
      end = size;
    }
    if (end == data.length) {
      end = 0;
      data[end] = element;
      end++;
      size++;
    } else {
      size++;
      data[end] = element;
      end++;
    }
    // have to make this a loop
  }
  public E removeFirst() {
    E removed = data[start];
    data[start] = null;
    start++;
    size--;
    if (start >= data.length) {
      start = 0;
    }
    return removed;
  }
  public E removeLast() {
    E removed = data[end];
    data[end] = null;
    end--;
    size--;
    if (end < 0) {
      end = data.length - 1;
    }
    return removed;
  }
  public E getFirst() {
    return data[start];
  }
  public E getLast() {
    return data[end - 1];
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[]) new Object[size * 2];
    int addedIndex = 0;
    int s = start;
    while (addedIndex != size && s != end) {
      if (s >= data.length) {
        s = 0;
      }
      newData[addedIndex] = data[s];
      addedIndex++;
      s++;
    }
    data = newData;
  }
}
