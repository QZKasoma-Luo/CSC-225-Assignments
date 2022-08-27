// Name: QingZe Luo
// Student number: V00953873

public class MaxFrequencyHeap implements PriorityQueue {
	
	private static final int DEFAULT_CAPACITY = 10;
	private Entry[] data;
	private int size;
	
	public MaxFrequencyHeap() {
		data = new Entry[DEFAULT_CAPACITY];
		size = 0;
	}

	public int get_parent(int index){
		return (index-1)/2;
	}

	public int get_left_child(int index){
		return 2*index+1;
	}

	public int get_right_child(int index){
		return 2*index+2;
	}

	public MaxFrequencyHeap(int size) {
		data = new Entry[size];
		size = 0;
	}

	public void swap(int index, int parent){
        Entry tmp;
        tmp = data[index];
        data[index] = data[parent];
        data[parent] = tmp;
    }

	public boolean is_leaf(int index){

		if(index > (size/2) && index < size){
			return true;
		}
		return false;
	}
	
	public void insert(Entry element) {
		// TODO: Complete this methodS
		data[size] = element;
		int counter = size;
		while (data[counter].getFrequency() > data[get_parent(counter)].getFrequency()){
            swap(counter, get_parent(counter));
            counter = get_parent(counter);
        }
        size++;
	}


	public Entry[] extend_size(Entry[] data){

		Entry[] NewSizeData = new Entry[size * 2];
		for(int i = 1; i <= size; i++) {
			NewSizeData[i] = data[i];
		}
		return NewSizeData;

	}

	public void resort_after_remove_max(int index){
		if(is_leaf(index) == true){
			return;
		}
		if(data[index].getFrequency() < data[get_right_child(index)].getFrequency() ||data[index].getFrequency() < data[get_left_child(index)].getFrequency()){
			if(data[get_left_child(index)].getFrequency() > data[index].getFrequency()){
				swap(index, get_left_child(index));
				resort_after_remove_max(get_left_child(index));
			}
		}else{
			if(data[get_right_child(index)].getFrequency() > data[index].getFrequency()){
				swap(index, get_right_child(index));
				resort_after_remove_max(get_right_child(index));
			}

		}

	}

	public Entry removeMax() { 
		// TODO: Complete this method
		Entry max_freq = data[0];
		data[0] = data[--size];
		resort_after_remove_max(0);
		return max_freq; // so it compiles
	}
	
	public boolean isEmpty() {
		// TODO: Complete this method
		if(size == 0){
			return true;
		}
		return false; // so it compiles
	}
	
	public int size() {
		// TODO: Complete this method
		return size; // so it compiles
	}

}
 
