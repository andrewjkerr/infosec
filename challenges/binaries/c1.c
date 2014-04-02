#include<stdio.h>
#include<stdbool.h>

int main(){
	char password[] = "1337-sh33p";
	char input[80];
	bool correct = false;
	printf("Please enter the password: \n");
	while(!correct){
		scanf("%s", input);
		if(strcmp(input, password) == 0){
			printf("Good job! Here's the key: SIT-ABAD1DEA\n");
			correct = true;
		}
		else{
			printf("Incorrect password. Please try again: \n");
		}
	}
}
