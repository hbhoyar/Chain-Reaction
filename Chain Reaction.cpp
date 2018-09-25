#include<iostream>
#include<algorithm>
using namespace std;
int row=9, col=6;
	
main(){
	int board[row][col];
	int x,y,k=1;
	int r=row-1, c=col-1;
	
	for(int i=0; i<row; i++)  //array initialisation to 0
	    for(int j=0; j<col; j++)
	        board[i][j]=0;
	    
	

	
	for(cin>>x>>y; x!=-1; cin>>x>>y, k=(-1)*k){
		
		cout<<endl;
	    
	    if (board[x][y]==0) board[x][y]=k;
	    else{if (board[x][y]*k > 0) board[x][y]=k*(1+abs(board[x][y]));
	    else {cout<<"Incorrect move"<<endl<<endl; k=(-1)*k; continue;}}
	    
	    bool factor=1;  //watches for bang bang
	    
	    while(factor!=0){
	        
	        factor=0;
	        
	        int temp[row][col];     //temporary array
	        
	        for(int i=0; i<row; i++)  //array initialisation to 0
	            for(int j=0; j<col; j++)
	                temp[i][j]=0;
	                
	       {if(abs(board[0][0])==2){temp[0][0]=0; factor=1;
	                                 temp[0][1]=k*(1+abs(temp[0][1]));
	                                 temp[1][0]=k*(1+abs(temp[1][0]));}
	            else{if (temp[0][0]==0) temp[0][0]=board[0][0];
	            else temp[0][0]=k*(abs(temp[0][0])+abs(board[0][0]));}}
	            
	       {if(abs(board[r][0])==2){temp[r][0]=0; factor=1;
	                                 temp[r][1]=k*(1+abs(temp[r][1]));
	                                 temp[r-1][0]=k*(1+abs(temp[r-1][0]));}
	            else{if (temp[r][0]==0) temp[r][0]=board[r][0];
	            else temp[r][0]=k*(abs(temp[r][0])+abs(board[r][0]));}}
	            
	       {if(abs(board[0][c])==2){temp[0][c]=0; factor=1;
	                                 temp[0][c-1]=k*(1+abs(temp[0][c-1]));
	                                 temp[1][c]=k*(1+abs(temp[1][c]));}
	            else{if (temp[0][c]==0) temp[0][c]=board[0][c];
	            else temp[0][c]=k*(abs(temp[0][c])+abs(board[0][c]));}}
	            
	       {if(abs(board[r][c])==2){temp[r][c]=0; factor=1;
	                                 temp[r][c-1]=k*(1+abs(temp[r][c-1]));
	                                 temp[r-1][c]=k*(1+abs(temp[r-1][c]));}
	            else{if (temp[r][c]==0) temp[r][c]=board[r][c];
	            else temp[r][c]=k*(abs(temp[r][c])+abs(board[r][c]));}}
	            
	       for(int i=1; i<r; i++){
	           if (abs(board[i][0])==3) {temp[i][0]=0; factor=1;
	                                      temp[i+1][0]=k*abs(1+abs(temp[i+1][0]));
	                                       temp[i-1][0]=k*abs(1+abs(temp[i-1][0]));
	                                       temp[i][1]=k*abs(1+abs(temp[i][1]));}
	           else{if (temp[i][0]==0) temp[i][0]=board[i][0];
	           else temp[i][0]=k*(abs(temp[i][0])+abs(board[i][0]));}} 
	           
	       for(int i=1; i<r; i++){
	           if (abs(board[i][c])==3) {temp[i][c]=0; factor=1;
	                                      temp[i+1][c]=k*abs(1+abs(temp[i+1][c]));
	                                       temp[i-1][c]=k*abs(1+abs(temp[i-1][c]));
	                                       temp[i][c-1]=k*abs(1+abs(temp[i][c-1]));}
	           else{if (temp[i][c]==0) temp[i][c]=board[i][c];
	           else temp[i][c]=k*(abs(temp[i][c])+abs(board[i][c]));}}
	           
	       for(int i=1; i<c; i++){
	           if (abs(board[0][i])==3) {temp[0][i]=0; factor=1;
	                                      temp[0][i+1]=k*abs(1+abs(temp[0][i+1]));
	                                       temp[0][i-1]=k*abs(1+abs(temp[0][i-1]));
	                                       temp[1][i]=k*abs(1+abs(temp[1][i]));}
	           else{if (temp[0][i]==0) temp[0][i]=board[0][i];
	           else temp[0][i]=k*(abs(temp[0][i])+abs(board[0][i]));}}
	           
	       for(int i=1; i<c; i++){
	           if (abs(board[r][i])==3) {temp[r][i]=0; factor=1;
	                                      temp[r][i+1]=k*abs(1+abs(temp[r][i+1]));
	                                       temp[r][i-1]=k*abs(1+abs(temp[r][i-1]));
	                                       temp[r-1][i]=k*abs(1+abs(temp[r-1][i]));}
	           else{if (temp[r][i]==0) temp[r][i]=board[r][i];
	           else temp[r][i]=k*(abs(temp[r][i])+abs(board[r][i]));}}
	           
	       for(int i=1; i<r; i++){
	           for(int j=1; j<c; j++){
	               if (abs(board[i][j])==4) {temp[i][j]=0; factor=1;
	                                         temp[i+1][j]=k*abs(1+abs(temp[i+1][j]));
	                                         temp[i-1][j]=k*abs(1+abs(temp[i-1][j]));
	                                         temp[i][j+1]=k*abs(1+abs(temp[i][j+1]));
	                                         temp[i][j-1]=k*abs(1+abs(temp[i][j-1]));}
	               else{if (temp[i][j]==0) temp[i][j]=board[i][j];
	               else temp[i][j]=k*(abs(temp[i][j])+abs(board[i][j]));}}}
	               
	        for(int i=0; i<row; i++)  //array copying
	            for(int j=0; j<col; j++)
	                board[i][j]=temp[i][j];}
	        
	        for(int i=0; i<row; i++){        //displays board
	            for(int j=0; j<col; j++){
	              cout<<board[i][j]<<" "; }
	                 cout<<endl;}
	                 
	       cout<<endl;}
	
	
	
}
