#include<stdio.h>
#include<Windows.h>
#include<time.h>
#include<math.h>
 
#define L 44
#define WALL  0
#define ROUTE 1
static int Rank = 0;
 
void CreateMaze(int maze[100][100], int x, int y);
 
int main(void) {
	srand((unsigned)time(NULL));
	int Maze[100][100];
	for (int i = 0; i < L; i++){
		Maze[i][0] = ROUTE;
		Maze[0][i] = ROUTE;
		Maze[i][L - 1] = ROUTE;
		Maze[L - 1][i] = ROUTE;
	}
	CreateMaze(Maze, 2, 2);
	Maze[2][1] = ROUTE;
	for (int i = L - 3; i >= 0; i--) {
		if (Maze[i][L - 3] == ROUTE) {
			Maze[i][L - 2] = ROUTE;
			break;
		}
	}
	for (int i = 0; i < L; i++) {
		for (int j = 0; j < L; j++) {
			if (Maze[i][j] == ROUTE) {
				printf("  ");
			}
			else {
				printf("¿Ú");
			}
		}
		printf("\n");
	}
 
	for (int i = 0; i < L; i++) free(Maze[i]);
	free(Maze);
	system("pause");
	return 0;
}
 
void CreateMaze(int maze[100][100], int x, int y) {
	maze[x][y] = ROUTE;
	int direction[4][2] = { { 1,0 },{ -1,0 },{ 0,1 },{ 0,-1 } };
	for (int i = 0; i < 4; i++) {
		int r = rand() % 4;
		int temp = direction[0][0];
		direction[0][0] = direction[r][0];
		direction[r][0] = temp;
 
		temp = direction[0][1];
		direction[0][1] = direction[r][1];
		direction[r][1] = temp;
	}
	for (int i = 0; i < 4; i++) {
		int dx = x;
		int dy = y;
		int range = 1 + (Rank == 0 ? 0 : rand() % Rank);
		while (range>0) {
			dx += direction[i][0];
			dy += direction[i][1];
			if (maze[dx][dy] == ROUTE) {
				break;
			}
			int count = 0;
			for (int j = dx - 1; j < dx + 2; j++) {
				for (int k = dy - 1; k < dy + 2; k++) {
					if (abs(j - dx) + abs(k - dy) == 1 && maze[j][k] == ROUTE) {
						count++;
					}
				}
			}
			if (count > 1) {
				break;
			}
			--range;
			maze[dx][dy] = ROUTE;
		}
		if (range <= 0) {
			CreateMaze(maze, dx, dy);
		}
	}
}
