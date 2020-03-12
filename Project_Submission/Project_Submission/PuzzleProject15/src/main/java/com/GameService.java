package com;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService  extends HashSet<Node> implements NumberPuzzleInterface  {
	@Autowired
	GameDao gameDao;

	
	public String findOptimizedSolution(String inputSequence) {
		// TODO Auto-generated method stub
		int arr[][]=new int[4][4];
		String ss[]=inputSequence.split(" ");
		int x=0,y=0,u=0,v=0;
		for(int i=0;i<16;i++){
			if(i==0) {
				x=0;y=0;
			}
			else if(i==4){
				x=1;y=0;
			}
			else if(i==8){
				x=2;y=0;
			}
			else if(i==12){
				x=3;y=0;
			}
			int a1=Integer.parseInt(ss[i]);
			arr[x][y]=a1;
			if(a1==0){
				u=x;v=y;
			}
			y++;
		}
		
		Solve sol=new Solve();
		String ans=(sol.findans(arr,u,v)).toString();
		Input in= new Input(inputSequence,sol.time);
		gameDao.add(in);
		return ans+"&"+String.valueOf(sol.time);
		
	}

}
