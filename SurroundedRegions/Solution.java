package SurroundedRegions;

import java.util.ArrayList;
import java.util.Stack;


public class Solution {
	
    class Node{
        int x;
        int y;
        public Node(int x, int y){this.x=x; this.y=y;}
    }
    
    public void solve(char[][] board) {
        
        if(board==null||board.length<3)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int j =0;j<cols;j++){
            if(board[0][j]=='0'){
                setNext(board,0,j);
            }
        }
        for(int j =0;j<cols;j++){
            if(board[rows-1][j]=='0'){
                setNext(board,rows-1,j);
            }
        }
        for(int i =0;i<rows;i++){
            if(board[i][0]=='0'){
                setNext(board,i,0);
            }
        }
        for(int i =0;i<rows;i++){
            if(board[i][cols-1]=='0'){
                setNext(board,i,cols-1);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='1')
                    board[i][j]='0';
                else
                    board[i][j]='X';
            }
        }
        
    }
    
    public void setNext(char[][] board, int x, int y){
        int rows = board.length;
        int cols = board[0].length;
        
        if(x<0||y<0||x>=rows||y>=cols)
            return;
        
        Stack<Node> stack1 = new Stack<Node>();
        
        if(board[x][y]!='0')
            return;
        else{
            board[x][y]='1';
            stack1.push(new Node(x,y));
            while(!stack1.empty()){
            	
                ArrayList<Node> list = new ArrayList<Node>();
                Stack<Node> stack2 = new Stack<Node>();
                
                while(!stack1.empty()){
                	list.add(stack1.pop());
                }
                for(int i=0;i<list.size();i++){
                	Node temp = list.get(i);
                	if(temp.x+1>=0&&temp.x+1<rows){
                		if(board[temp.x+1][temp.y]=='0'){
                			board[temp.x+1][temp.y]='1';
                			stack2.push(new Node(temp.x+1,temp.y));
                		}
                	}
                	if(temp.x-1>=0&&temp.x-1<rows){
                		if(board[temp.x-1][temp.y]=='0'){
                			board[temp.x-1][temp.y]='1';
                			stack2.push(new Node(temp.x-1,temp.y));
                		}
                	}
                	if(temp.y+1>=0&&temp.y+1<cols){
                		if(board[temp.x][temp.y+1]=='0'){
                			board[temp.x][temp.y+1]='1';
                			stack2.push(new Node(temp.x,temp.y+1));
                		}
                	}
                	if(temp.y-1>=0&&temp.y-1<cols){
                		if(board[temp.x][temp.y-1]=='0'){
                			board[temp.x][temp.y-1]='1';
                			stack2.push(new Node(temp.x,temp.y-1));
                		}
                	}
                }
                while(!stack2.empty()){
                	stack1.push(stack2.pop());
                }
            }
        }
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	char[][] board={{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','X','X'}};
    	s.solve(board);
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board.length;j++){
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    }
}
