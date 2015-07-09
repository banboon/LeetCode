package InsertInterval;

import java.util.ArrayList;
import java.util.List;





class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class Solution {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();
		
		if(intervals==null||intervals.size()==0){
			result.add(newInterval);
			return result;
		}
		
		if(newInterval.end<intervals.get(0).start){
			intervals.add(0,newInterval);
			
			return intervals;
		}

		int added=0;

		for(int i=0;i<intervals.size();i++){
			Interval temp = intervals.get(i);
			if(newInterval.start>temp.end){
				result.add(temp);
				continue;
			}
			if(newInterval.end<temp.start){
				if(added==0){
					result.add(newInterval);
					added=1;
				}
				result.add(temp);
				continue;
			}
			if(newInterval.start<temp.start){
				Interval val = new Interval(newInterval.start, 0);
				if(newInterval.end>temp.end){
					val.end = newInterval.end;
				}
				else{
					val.end = temp.end;
				}
				int j=0;
				for(j=i;j<intervals.size();j++){
					Interval temp2 = intervals.get(j);
					if(temp2.start>val.end)
						break;
					if(temp2.end>val.end){
						val.end = temp2.end;
					}
				}
				i=j-1;
				result.add(val);
				added=1;
			}
			else{
				Interval val = new Interval(temp.start, 0);
				if(newInterval.end>temp.end){
					val.end = newInterval.end;
				}
				else{
					val.end = temp.end;
				}
				int j =0;
				for(j=i;j<intervals.size();j++){
					Interval temp2 = intervals.get(j);
					if(temp2.start>val.end)
						break;
					if(temp2.end>val.end){
						val.end = temp2.end;
					}
				}
				i=j-1;
				result.add(val);
				added=1;
			}

		}

		if(added == 0)
			result.add(newInterval);

		return result;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		List<Interval> ins = new ArrayList<Interval>();
		ins.add(new Interval(3,5));
		ins.add(new Interval(12,15));
//		ins.add(new Interval(10,11));
		Interval insert = new Interval(6,6);
		List<Interval> result = s.insert(ins,insert);
		for(int i=0;i<result.size();i++){
			Interval a = result.get(i);
			System.out.print(a.start+" "+a.end+"\n");
		}
	}
}
