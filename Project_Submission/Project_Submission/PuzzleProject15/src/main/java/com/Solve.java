package com;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Solve{

	StringBuilder FinalOp;
	long time;
	final int N=4;
	static int goal[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	int i,j;
	// bottom , left, top, right 
	int row[] = { 1, 0, -1, 0 }; 
	int col[] = { 0, -1, 0, 1 }; 
	String dir[]= {"U","R","D","L"};
	GameService hs=new GameService();



	//method to check if the configuration is solvable or not
	public boolean issolvable(int mat[][]){
		return true;
	}

	//method to get the number of values at the wrong position
//	public int geterror(int [][] exp){
//		int e=0;
//		for(i=0;i<N;i++){
//			for(j=0;j<N;j++){
//				if(exp[i][j]!=goal[i][j] ){
//					e++;
//				}
//			}
//		}
//		return e;
//	}

	//method to check if the move does not goes out of bound 
	public boolean ispossible(int ii,int jj){
		if(ii>=0 && ii<4 && jj>=0 && jj<4)
			return true;
		else
			return false;
	}

	void printpath(Node n){
		FinalOp=new StringBuilder("");
		if(n!=null){
			printpath(n.parent);
			if(!n.move.equalsIgnoreCase("null"))
				FinalOp.append(n.move);
			System.out.println("Step :"+n.level+" Move :"+n.move);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.printf("%4d", n.puzzle[i][j]);
				}
				System.out.print("\n");
			}
		}
	}
	
	StringBuilder findans(int ini[][],int x, int y)
	{
		long t=System.currentTimeMillis();
		sol(ini,x,y);
		long tt=System.currentTimeMillis();
		time=tt-t;
		return FinalOp;
	}

	//solves the given puzzle
	void sol(int ini[][],int x, int y){
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(comparator);
		Node root=new Node(null,ini,0,0,x,y,null);
		root.cost=manhattan(root);
		priorityQueue.add(root);
		hs.add(root);
		int f=0;
		while(priorityQueue.size()!=0 && f!=1) {
			f=0;
			Node min=priorityQueue.poll();
			if(min.cost==0) {
				printpath(min);
				if(FinalOp.length() > 0)
					FinalOp.deleteCharAt(FinalOp.length()-1);
				System.out.println(FinalOp);
				f=1;
				return;
			}
			for(int k=0;k<4;k++){
				if(ispossible(min.zx+row[k],min.zy+col[k]) ) {
					Node child = newNode(min,  row[k], 
							col[k]); 
					child.cost = manhattan(child); 
					if(child.cost==0){
						printpath(child);
						if(FinalOp.length() > 0)
							FinalOp.deleteCharAt(FinalOp.length()-1);
						System.out.println(FinalOp);
						f=1;
						return;
					}
					if(!child.parent.move.equals(dir[k]) && !hs.contains(child) && (manhattan(child) < 1000)){
						priorityQueue.add(child); 
						hs.add(child);
					}
				}
			}
		}
	}

	//calculate manhattan Distance
	public int manhattan(Node child) {
		int count = 0;
		int expected = 0;
		for (int row = 0; row < child.puzzle.length; row++) {
			for (int col = 0; col < child.puzzle[row].length; col++) {
				int value = child.puzzle[row][col];
				expected++;
				if (value != 0 && value != expected) {
					count += Math.abs(row
							- getRow(goal, value))
							+ Math.abs(col
									- getCol(goal, value));
				}
			}
		}
		return count;
	}

	// helper to get the column of a value.
	public int getCol(int[][] a, int value) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				if (a[row][col] == value) {
					return col;
				}
			}
		}
		return -1;
	}

	// helper to get the row of a value.
	public int getRow(int[][] a, int value) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				if (a[row][col] == value) {
					return row;
				}
			}
		}
		return -1;
	}   


	public Node newNode(Node nn,int newm,int newn){
		String s;
		int p[][]=new int[4][4];
		int u,v;
		for(u=0;u<4;u++){
			for(v=0;v<4;v++)
			{
				p[u][v]=nn.puzzle[u][v];
			}
		}
		if(newm==1 && newn==0){
			s="D,";
		}
		else if(newm==0 && newn==-1){
			s="L,";
		}
		else if(newm==-1 && newn==0){
			s="U,";
		}
		else if(newm==0 && newn==1){
			s="R,";
		}
		else{
			s="null";
		}
		Node n=new Node(nn,p,0,nn.level+1,nn.zx,nn.zy,s);
		n.swap(nn.zx,nn.zy,nn.zx+newm,nn.zy+newn);
		return n;
	}

	Comparator<Node> comparator = new Comparator<Node>() {
		public int compare(Node node1, Node node2) {
			return(node1.cost - node2.cost);
		}
	};
}
