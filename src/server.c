// HangedMan Game Server

#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

#define WORD_LENGTH 30

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Usage: %s <SERVER-IP-ADDRESS>", argv[0]);
    exit(EXIT_FAILURE);
  }

  FILE* words_fd;
  if ((words_fd = fopen("words.txt", "r")) == NULL) {
    perror("Error opening source file");
    exit(EXIT_FAILURE);
  }

  char word[WORD_LENGTH];
  while (fgets(word, WORD_LENGTH, words_fd)) {
    printf("%s", word);
  }
}
