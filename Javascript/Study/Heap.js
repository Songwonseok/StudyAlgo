class Heap {
  constructor() {
    this.tree = new Array(100001);
    this.heapsize = 0;
  }

  offer(item) {
    this.tree[++this.heapsize] = item;

    for (let i = this.heapsize; i > 1; i = Math.floor(i / 2)) {
      const parent = Math.floor(i / 2);
      if (this.tree[i] < this.tree[parent]) {
        this.swap(parent, i);
      } else {
        break;
      }
    }
  }

  poll() {
    if (this.isEmpty()) return null;

    const pollData = this.tree[1];

    this.tree[1] = this.tree[this.heapsize--];

    for (let i = 1; i * 2 <= this.heapsize;) {
      if (this.tree[i * 2] < this.tree[i]) {
        if (i * 2 + 1 > this.heapsize || this.tree[i * 2] < this.tree[i * 2 + 1]) {
          this.swap(i, i * 2);
          i *= 2;
        } else {
          this.swap(i, i * 2 + 1);
          i = i * 2 + 1;
        }
      } else if (i * 2 + 1 <= this.heapsize && this.tree[i * 2 + 1] < this.tree[i]) {
        this.swap(i, i * 2 + 1);
        i = i * 2 + 1;
      } else {
        break;
      }
    }

    return pollData;
  }

  swap(a, b) {
    const temp = this.tree[a];
    this.tree[a] = this.tree[b];
    this.tree[b] = temp;
  }

  isEmpty() {
    if (this.heapsize === 0)
      return true;
    return false;
  }
}



const heap = new Heap();

heap.add(1)
heap.add(3)
heap.add(10)
heap.add(9)
heap.add(4)
heap.add(2)

console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.isEmpty());