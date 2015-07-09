package MergeIntervals;

import java.util.ArrayList;
import java.util.List;



class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class Solution {

	private List<Interval> result = new ArrayList<Interval>();

	public void quickSort(List<Interval> in, int begin, int end){
		if(end<=begin)
			return;

		int pivot = (in.get(begin).start+in.get(end).start)/2;

		int i=begin;
		int j=end;

		while(i<j){

			if(in.get(i).start<=pivot)
				i++;
			else{
				Interval temp = new Interval(in.get(i).start,in.get(i).end); // new please
				in.set(i,in.get(j));
				in.set(j,temp);
				j--;
			}
		}

		if(in.get(i).start<pivot){
			quickSort(in, begin,i);
			quickSort(in, i+1, end);
		}
		else if(in.get(i).start==pivot){
			quickSort(in, begin,i-1);
			quickSort(in, i+1, end);
		}
		else{
			quickSort(in,begin,i-1);
			quickSort(in,i,end);
		}

	}

	public List<Interval> merge(List<Interval> intervals) {

		if(intervals==null||intervals.size()==0)
			return result;

		quickSort(intervals, 0 , intervals.size()-1);

		result.add(intervals.get(0));

		Interval last = result.get(0);   // change last also change result

		for(int i=1;i<intervals.size();i++){
			Interval temp = intervals.get(i);
			if(temp.start>last.end){
				result.add(temp);
				last = temp;     // change last
			}
			else if(temp.start<=last.end&&temp.end>last.end){
				last.end=temp.end;
			}
			else
				;
		}

		return result;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		List<Interval> ins = new ArrayList<Interval>();
		ins.add(new Interval(1,3));
		ins.add(new Interval(8,10));
		ins.add(new Interval(2,6));
		
		ins.add(new Interval(15,18));
		List<Interval> result = s.merge(ins);
		for(int i=0;i<result.size();i++){
			Interval a = result.get(i);
			System.out.print(a.start+" "+a.end+"\n");
		}
	}
}