package CloneGraph;

import java.util.ArrayList;
import java.util.List;


class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {

	private ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
	private UndirectedGraphNode newOne;

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if(node==null)
			return null;

		newOne = new UndirectedGraphNode(node.label);

		help(node);

		return newOne;
	}

	public void help(UndirectedGraphNode node){

		for(int i=0;i<node.neighbors.size();i++){
			UndirectedGraphNode temp = new UndirectedGraphNode(node.neighbors.get(i).label);
			newOne.neighbors.add(temp);
			list.add(newOne);
			if(!list.contains(temp)){
				help(temp);
			}
		}
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		UndirectedGraphNode a = new UndirectedGraphNode(0);
		UndirectedGraphNode b = new UndirectedGraphNode(0);
		UndirectedGraphNode c = new UndirectedGraphNode(0);
		a.neighbors.add(b);
		a.neighbors.add(c);
		UndirectedGraphNode d = s.cloneGraph(a);
	}
}
