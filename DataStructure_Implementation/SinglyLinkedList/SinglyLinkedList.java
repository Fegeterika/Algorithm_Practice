
public class SinglyLinkedList<T> {
		
	private class Node<T> {
		T value;
		Node<T> next;
		
		public Node (T data) {
			this.value = data;
		}
	}
	
	private Node<T> head = null;
	private Node<T> tail = null;
	
	public void insertNode(T data) {
		Node<T> newNode = new Node<T> (data);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
			System.out.println("First Node Added, Value: " + head.value);
		} else {
			tail.next = newNode;
			tail = newNode;
			System.out.println("Node Added, Value: " + tail.value);
		}
	}
	
	public void deleteAllNodesWithValue(T data) {
		Node<T> current = head;
		Node<T> prev = head;
		
		while(current == head) {
			if (current.value == data && current.next != null) {
				head = current.next;
				current = head;
				prev = head;
			}
			else if (current.value == data && current.next == null) {
				head = null;
				tail = null;
			}
			else {
				current = current.next;
			}
		}
		
		while(current != null) {
			if (current.value == data && current.next != null) {
				prev.next = current.next;
				current = current.next;
			}
			else if (current.value == data && current.next == null) {
				prev.next = null;
				tail = prev;
			}
			else {
				prev = current;
				current = current.next;
			}
		}
	}
	
	public void serializeList() {
		Node<T> current = head;
		System.out.print("Values in this list are: ");
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String args[]) {
		SinglyLinkedList<Integer> testList = new SinglyLinkedList<Integer> ();
		
		testList.insertNode(3);
		testList.insertNode(5);
		testList.insertNode(6);
		testList.insertNode(8);
		testList.insertNode(6);
		testList.insertNode(9);
		testList.insertNode(13);
		testList.insertNode(2);
		
		testList.serializeList();
		testList.deleteAllNodesWithValue(6);
		testList.serializeList();
	}
}
