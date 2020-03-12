package com;

import java.util.Arrays;

public class Node {
	
	Node parent; //holds parents node address
	int puzzle[][]; //holds the matrix
	int cost; //number of value at incorrect position
	int level; //number of moves yet
	int zx,zy; //stores index position of the Blank tile
	String move="";

	public Node(Node p,int[][]puz,int c,int l,int x,int y,String prev)	{
		this.puzzle=puz;
		this.parent=p;
		this.cost=c;
		this.level=l;
		this.zx=x;
		this.zy=y;
		this.move=String.valueOf(prev);
	}

	@Override
	public int hashCode() {
		System.out.println(".");
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(this.puzzle);
		result = prime * result + this.zx;
		result = prime * result + this.zy;
		result = prime * result + Arrays.deepHashCode(Solve.goal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Node other = (Node) obj;
		if (!Arrays.deepEquals(this.puzzle, other.puzzle))
			return false;
		
		if (this.zx != other.zx)
			return false;

		if (this.zy != other.zy)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				s.append(String.format("%4d", puzzle[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	public void swap(int i,int j,int ii,int jj){
		int xx=this.puzzle[i][j];
		this.puzzle[i][j]=this.puzzle[ii][jj];
		this.puzzle[ii][jj]=xx;
		this.zx=ii;
		this.zy=jj;
	}

}
