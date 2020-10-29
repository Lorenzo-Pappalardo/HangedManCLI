// HangedMan Game Server

#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

#define MAXBUF 30

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Usage: %s <SERVER-IP-ADDRESS>", argv[0]);
    exit(1);
  }

  FILE* input;
  if ((input = fopen("words.txt", "r")) == NULL) {
    perror("Error opening source file\n");
    exit(EXIT_FAILURE);
  }

  char buffer[MAXBUF];
  while (fgets(buffer, MAXBUF, input)) {  //fgets insert the row content in "buffer", with \n in the end..->
    printf("%s", buffer); 
  }
  printf("\n"); //<-...except for the final string, because there's directly EOF that interrupts the string.
}
