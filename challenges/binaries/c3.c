#include<stdio.h>

void shiftChars(char string[]){
	int size = strlen(string);
	int ascii[size];
	int i;
	for(i = 0; i < size; i++){
		ascii[i] = string[i] + 10;
	}
	for(i = 0; i < size; i++){
		string[i] = ascii[i];
	}
	printf("%s\n", string);
}

int main(){
	char password[] = "31337haxsh33p666";
	shiftChars(password);
}
