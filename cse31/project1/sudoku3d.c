#include <stdio.h>
#include <stdlib.h>

// Declare printSudoku function
void printSudoku(int***);
// Declare solveSudoku function
int solveSudoku(int***);

//Helper functions. You can define any functions that can help your solve the problem

int inColumn(int*** arr,int block, int row, int column,int num){
	
	int i;
	int j;
	int k;
	int count=1;
	
	if(block==0||block==3||block==6){
		for(i=0;i<9;i+=3){
			for(j=0;j<3;j++){
				

					
						if(num == *(*(*(arr+i)+j)+column)){
							
							
							return 1;
							
							
						}else{
							
							continue;
							
						}
					}
			
			}
		}
	
	if(block==1||block==4||block==7){
		for(i=1;i<9;i+=3){
			for(j=0;j<3;j++){
				

					
						if(num == *(*(*(arr+i)+j)+column)){
							
							
							return 1;
							
							
						}
						else{
							continue;
						}
					
				
			
		}
	}
	}
	if(block==2||block==5||block==8){
		for(i=2;i<9;i+=3){
			for(j=0;j<3;j++){
				

					
						if(num == *(*(*(arr+i)+j)+column)){
							
							
							return 1;
							
							
						}
						else{
							continue;
						}
			}
		}
	}
	
					return 0;
					
}
int inRow(int*** arr,int block, int row, int column,int num){
	
	int i;
	int j;
	int k;
	int count=0;
	
	if(block<3){
		for(i=0;i<3;i++){
			for(j=row;j<row+1;j++){
				for(k=0;k<3;k++){
					
						if(num == *(*(*(arr+i)+j)+k)){
							count++;
							break;
						}else{
							continue;
						}
					
				}
			}
		}
	}
	
	if(block>=3&&block<6){
		for(i=3;i<6;i++){
			for(j=row;j<row+1;j++){
				for(k=0;k<3;k++){
					
						if(num == *(*(*(arr+i)+j)+k)){
							count++;
							break;
						}else{
							continue;
						}
					
				}
			}
		}
	}
	
	if(block>=6){
		for(i=6;i<9;i++){
			for(j=row;j<row+1;j++){
				for(k=0;k<3;k++){
					
						if(num == *(*(*(arr+i)+j)+k)){
							count++;
							break;
						}else{
							continue;
						}
					
				}
			}
		}
	}		


						
	if(count<1){
		return 0;
	}else{
		return 1;
	}

}


	



int inBlock(int*** arr,int block, int row, int column,int num){
	
	int i;
	int j;
	int k;

	for(i=0;i<9;i++){
		for(j=0;j<3;j++)
		{
			for(k=0;k<3;k++)
			{
				if(num == *(*(*(arr+block)+j)+k))
				{
					return 1;
				}
			}
			
		}
	}
		return 0;
}


int possibleNum(int*** blocks,int block,int row,int column,int num){
		return !(inRow(blocks, block, row, column, num)||inColumn(blocks, block, row, column, num)||inBlock(blocks, block, row, column, num));
}			









/*
The main program reads a text file containing the block values of the Sudoku grid.
It then saves each 3x3 block into a 2D array. The Sudoku grid is composed of 9 3x3 blocks.
DO NOT MODIFY THE MAIN FUNTION!!!
*/
int main(int argc, char **argv) {
	if (argc != 2) {
		fprintf(stderr, "Usage: %s <file name>\n", argv[0]);
		return 2;
	}
    int i, j;
    FILE *fptr;
    int ***blocks = (int***)malloc(9 * sizeof(int**));

    // Open file for reading
    fptr = fopen(argv[1], "r");
    if (fptr == NULL) {
        printf("Cannot Open File!\n");
        return 0;
    }

	// Read 9x9 blocks into 2D arrays
    for(i=0; i<9; i++)
    {
        *(blocks+i) = (int**)malloc(3 * sizeof(int*));
        printf("Reading numbers in block %d... \n", i+1);
        for(j=0; j<3; j++)
        {
            *(*(blocks+i)+j) = (int*)malloc(3 * sizeof(int));

                fscanf(fptr, "%d %d %d", *(*(blocks+i)+j), *(*(blocks+i)+j)+1, *(*(blocks+i)+j)+2);
                printf("%d %d %d\n", *(*(*(blocks+i)+j)), *(*(*(blocks+i)+j)+1), *(*(*(blocks+i)+j)+2));
        }
    }
	
	// Print out original Sudoku grid
    printf("Printing Sudoku before being solved:\n");
    printSudoku(blocks);

	// Call solveSudoku and print out result
    printf("\nSolving Sudoku...\n\n");
    if(solveSudoku(blocks)){
        printf("Sudoku solved!\n");
        printSudoku(blocks);
    }
    else
        printf("This Sudoku cannot be solved!\n");

    return 0;
}


void printSudoku(int*** arr){
	// This function will print out the complete Sudoku grid (arr). It must produce the output in the SAME format as the samples in the instructions. 	
	
	// Your implementation here
	
	int i;
	int j=0;
	int newLine=1;
	int newStart=0;
	int count =-1;

	for(i=0;i<=sizeof(arr);i++){
		count++;
		
			if (i==3){
				printf("\n");

			}else if(i==6){
				printf("\n");
			}
			
			
			if(count==9){
				printf("---------------------\n");
			}else if(count==18){
				printf("---------------------\n");
			}
		
		
			if(i<3){
				newLine==1;
			}else if(i==3&&newStart==0&&count<4){
				i=0;
				newStart=1;
				newLine+=1;
			}else if(i==3&&newStart==1){
				i=0;
				newStart=2;
				newLine+=1;
			}else if(i==3&&newStart==2){
				newStart=0;
				newLine=1;
				i=3;
			}else if(i==6&&newStart==0){
				i=3;
				newStart=1;
				newLine+=1;
			}else if(i==6&&newStart==1){
				i=3;
				newStart=2;
				newLine+=1;
			}else if(i==6&&newStart==2){
				newStart=0;
				newLine=1;
				i=6;
			}
				
			
		for(j=newStart;j<newLine;j++){
			if(i==8){
				printf("%d %d %d |\n", *(*(*(arr+i)+j)), *(*(*(arr+i)+j)+1), *(*(*(arr+i)+j)+2));
			}else{
			printf("%d %d %d |", *(*(*(arr+i)+j)), *(*(*(arr+i)+j)+1), *(*(*(arr+i)+j)+2));
			}

			if(i==8&&newStart==0){
				i=6;
				newStart=1;
				newLine+=1;
			}else if(i==8&&newStart==1){
				i=6;
				newStart=2;
				newLine+=1;
			}else if(i==8&&newStart==2){
				i=8;
				newStart=0;
			}
				
		}
	}
	
	


	

	
}



int solveSudoku(int*** blocks){
	// This is the function to solve the Sudoku (blocks). Feel free to use any helper functions.
	// YOU MUST NOT USE ANY ARRAY NOTATION ([])!
	
	//Your implementation here
	int row;
	int column;
	int block;
	int num;
	


	for(block=0; block <=sizeof(blocks);block++){
		for(row=0;row<3;row++){
			for(column=0;column<3;column++){
				if(*(*(*(blocks+block)+row)+column)==0){
					for(num=9;num>=1;num--){
						
						
						if(possibleNum(blocks, block, row, column, num)){
							*(*(*(blocks+block)+row)+column)=num;
						}else{
							continue;
						}
							
							
							if(solveSudoku(blocks)){
								return 1;
							}else{
								*(*(*(blocks+block)+row)+column)=0;
							}
							
							

					
						
						
					}
					return 0;
				}
			
			}
		
		}
		

	}

	return 1;
}
