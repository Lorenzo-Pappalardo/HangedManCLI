// HangedMan Game Server

#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Usage: %s <SERVER-IP-ADDRESS>", argv[0]);
    exit(1);
  }

  int words_fd;
  if ((words_fd = open("words.txt", O_RDONLY)) == -1) {
    perror("Failed to open words file");
    exit(2);
  }

  const short dim = 7776;
  char* words[dim];

  for (int i = 0; i < dim; i++) {
    char* word = "";
    while (1) {
      char tmpChar;
      if (read(words_fd, &tmpChar, sizeof(char)) == -1) {
        perror("Read failed");
        exit(3);
      }

      printf("%c", tmpChar);
    }
    words[i] = word;
  }

  for (int i = 0; i < dim; i++) {
    printf("%s\n", words[i]);
  }
}