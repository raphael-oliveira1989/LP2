#include <stdio.h>
#include <math.h>

typedef struct {
  int r1x, r1y, r2x, r2y;
  int size;
  float rot;
} Elipse;
/*
typedef struct {
  int p1x,p1y;
  int p2x,p2y;
  float rot;
  float size;
} Linha;
*/
void print_elipse (Elipse* e) {
	if(e->r1x==e->r2x && e->r1y==e->r2y){
		printf("Circulo de tamanho %d, de raio na posicao (%d,%d) e rotacao %.1f graus.\n",
		e->size, e->r1x,e->r1y, e->rot);
	}else{
		printf("Elipse de tamanho %d, de raios nas posicoes (%d,%d) e (%d,%d) e rotacao %.1f graus.\n",
    	e->size, e->r1x,e->r1y,e->r2x,e->r2y, e->rot);
	}
}
/*
void print_ln (Linha* l) {
	if(l->p1x==l->p2x && l->p1y==l->p2y){
		printf("Ponto de coordenadas (%d,%d).\n",
	 	l->p1x,l->p1y);
	}else{
		l->size = sqrt(pow(l->p1x-l->p2x,2)+pow(l->p1y-l->p2y,2));
		printf("Linha de tamanho %.2f, que comeca na posicao (%d,%d) e termina na posicao (%d,%d) e rotacao %.1f graus.\n",
		l->size, l->p1x,l->p1y,l->p2x,l->p2y,l->rot);
	}
}
*/

int main (void) {
    Elipse e1 = {1,1,1,2,5,90};
    print_elipse(&e1);
    /*
    Linha l1 = {5,5,7,5,0};
    print_ln(&l1);*/
}
