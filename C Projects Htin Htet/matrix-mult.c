// Compile with gcc -pthread -lm <source.c> -o <executable>

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
//Htin Htet
//ACO350
//Project 2b - Matrix Multiplication
typedef struct {
   // TO DO: What arguments do you need to send to each thread?
   int r, c;
} instruction;

void *cell_multiply(void *);
void read_matrix(FILE *f, int[10][10], int *, int *);
void print_matrix(char *, int[10][10], int, int);
instruction instruct1;
int matrix_a[10][10];
int matrix_b[10][10];
int matrix_c[10][10];

int main(int argc, char *argv[]) {
   FILE *f = NULL;
   int row_a, col_a;
   int row_b, col_b;

   if (argc != 2) {
      fprintf(stderr,"usage: %s <file>\n", argv[0]);
      return 1;
   }

   f = fopen(argv[1], "r");
   if (f == NULL) {
      fprintf(stderr, "Can't open file %s\n", argv[1]);
      return -1;
   }
	printf("\n****ACO350 Htin Htet**** \n Project 2b - Matrix Multiplication \n\n");

   read_matrix(f, matrix_a, &row_a, &col_a);
   read_matrix(f, matrix_b, &row_b, &col_b);

   print_matrix("A", matrix_a, row_a, col_a);
   print_matrix("B", matrix_b, row_b, col_b);

   if (col_a != row_b) {
      fprintf(stderr, "Error: Columns in A (%d) must equal rows in B (%d)\n", col_a, row_b);
      return 2;
   }
   int num_threads = (col_b*row_a); // TO DO: How many threads will there be?

   pthread_t tids[num_threads];
   pthread_attr_t attr;
	int S_index = 0;
	int F_index = 0;
   pthread_attr_init(&attr);
   	

  	
	for(int x = 0; x <row_a ; x++){
		for(int y = 0; y < col_b; y++)
		{
			instruction *sample = (instruction *)(malloc(sizeof(instruction)));
			sample->r = x;
			sample->c = y;
			
			 pthread_create(&tids[S_index], &attr, cell_multiply,sample);
				S_index++;
	

		}
}
		for(int x = 0; x <row_a ; x++){
		for(int y = 0; y < col_b; y++)
	{
		pthread_join(tids[F_index], NULL);
		F_index++;
	}
}

   print_matrix("A x B = C", matrix_c, row_a, col_b);
}

void *cell_multiply(void *param) {
	//printf("Test thread #%d; ", stamp);
	//stamp++;

	
	instruction* p = (instruction *) param;
	int sum = 0;
	for(int i = 0; i < 10; i++)
	{
		sum += matrix_a[p->r][i] * matrix_b[i][p->c];
	}
	matrix_c[p->r][p->c] = sum;
	sum = 0;


			pthread_exit(0);
			
}

void print_matrix(char *title, int m[10][10], int row_cnt, int col_cnt) {
   printf("%s [%dx%d]:\n", title, row_cnt, col_cnt);
	int max = 0;
   for(int r = 0; r < row_cnt; r++) {
      for (int c = 0; c < col_cnt; c++) {
        max = max < m[r][c] ? m[r][c] : max; 
      };
   }

   int size = (int)(log10((double)max)+1);
   char format[10];
   sprintf(format, "%%%dd ", size);

   for(int r = 0; r < row_cnt; r++) {
      printf("   ");
      for (int c = 0; c < col_cnt; c++) {
         printf(format, m[r][c]);
      };
      printf("\n");
   }
   printf("\n");
}

void read_matrix(FILE *f, int m[10][10], int *row_cnt, int *col_cnt) {
   fscanf(f, "%d %d", row_cnt, col_cnt);
   for (int r = 0; r < *row_cnt; r++) {
      for (int c = 0; c < *col_cnt; c++) {
         fscanf(f, "%d", &(m[r][c]));
      }
   }
}
