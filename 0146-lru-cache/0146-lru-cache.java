class LRUCache {
    // dll
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
  
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Move the accessed node to the head (Most Recently Used)
        remove(node);
        insertToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // remove old position, update value, move to head
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToHead(node);
        } else {
            // if size==cap, remove LRU
            if (map.size() == capacity) {
                Node lruNode = tail.prev;
                map.remove(lruNode.key);
                remove(lruNode);
            }
            
            // and then insert the new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToHead(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void insertToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}