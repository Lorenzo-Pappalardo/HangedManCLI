// HangedMan Game Server

#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

#define DIM 7776
#define WORD_LENGTH 30

void getWords(char array[DIM][WORD_LENGTH]) {
  FILE* words_fd;
  if ((words_fd = fopen("words.txt", "r")) == NULL) {
    perror("Error opening source file");
    exit(EXIT_FAILURE);
  }

  int i = 0;
  char tmpWord[WORD_LENGTH];
  while (fgets(tmpWord, WORD_LENGTH, words_fd) != NULL) {
    int length = strlen(tmpWord);
    char word[WORD_LENGTH] = "";
    strncpy(word, tmpWord, length - 2);
    strcpy(array[i++], word);
  }
}

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Usage: %s <SERVER-IP-ADDRESS>", argv[0]);
    exit(EXIT_FAILURE);
  }

  char words_array[DIM][WORD_LENGTH];
  getWords(words_array);

  for (int i = 0; i < DIM; i++) {
    printf("[%s]\n", words_array[i]);
  }
}
