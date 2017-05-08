package Facebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;

// merge k sorted array using iterator

public class MergeKSortedIterators {
	public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iters){
        Queue<PeekingIterator> minHeap = new PriorityQueue<PeekingIterator>(iters.size(), new Comparator<PeekingIterator>(){
        	public int compare(PeekingIterator a, PeekingIterator b){ 
                return a.peek() - b.peek();
            }
        });
        List<Integer> result = new LinkedList<Integer>();
        for(int i = 0; i < iters.size(); ++i){
        	PeekingIterator intItr = new PeekingIterator(iters.get(i));
        	if (intItr.peek() != null) {
        		minHeap.add(intItr);
        	}
            
        }
        while(!minHeap.isEmpty()){
        	PeekingIterator curr = minHeap.poll();
            result.add(curr.peek());
            curr.next();
            if(curr.peek() != null) {
                minHeap.add(curr);
            }
        }
        return result;
    }

    public static class PeekingIterator {
        private Integer next = null;
        private Iterator<Integer> iter;
        public PeekingIterator(Iterator<Integer> iterator) {
            iter = iterator;
            next = iterator.hasNext() ? iterator.next() : null;
        }
        
        public boolean hasNext() {
        	return next != null;
        }
        
        public Integer next() {
        	Integer res = next;
        	next = iter.hasNext() ? iter.next() : null;
        	return res;
        }
        
        public Integer peek() {
        	return next;
        }
    }
    
    public static void main(String[] args) {
    	LinkedList<Integer> list1 = new LinkedList<Integer>();
    	list1.add(1);
    	list1.add(3);
    	list1.add(5);
    	Iterator<Integer> itr1 = list1.iterator();
    	LinkedList<Integer> list2 = new LinkedList<Integer>();
    	list2.add(2);
    	list2.add(3);
    	list2.add(6);
    	Iterator<Integer> itr2 = list2.iterator();
    	List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer>>();
    	iters.add(itr1);
    	iters.add(itr2);
    	
    	Iterable<Integer> list = mergeKSortedIterators(iters);
    	for (int i : list) {
    		System.out.print(i + " ");
    	}
	}
}
