#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
}Color;

Color color_new(int r, int g, int b){
	Color cor;
	cor.r = r;
	cor.g = g;
	cor.b = b;
	return cor;
}

void color_print(Color cor){
	int r = cor.r;
	int g = cor.g;
	int b = cor.b;
	char paleta[8]="";
	if(r==0 && g==0 && b==0){
		strcpy(paleta, "preto");
	}else if(r==255 && g==255 && b==255){
		strcpy(paleta, "branco");
	}else if(r==255 && g==0 && b==0){
		strcpy(paleta, "vermelho");
	}else if(r==0 && g==255 && b==0){
		strcpy(paleta, "verde");
	}else if(r==0 && g==0 && b==255){
		strcpy(paleta, "azul");
	}else if(r>0 && g==0 && b>0){
		strcpy(paleta, "roxo");
	}else if(r>0 && g>0 && b==0){
		strcpy(paleta, "amarelo");
	}else if(r==0 && g>0 && b>0){
		strcpy(paleta, "ciano");
	}else{
		strcpy(paleta, "cinza");
	}
	printf("%s", paleta);
}

///////////////////////////////////////////////////////////////////////////////

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d), ", this->w, this->h, sup->x, sup->y);
	printf("cor de borda ");color_print(sup->fg);
	printf(" e cor de fundo ");color_print(sup->bg);
	printf("\n");
}

Rect* rect_new (int x, int y, int w, int h,int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h, arci, arcf, choice;
} Arco;

void Arco_print (Arco* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d), com inicio em %d graus e fim %d graus, ",
	this->w, this->h, sup->x, sup->y, this->arci, this->arcf);
	if(this->choice==1){
		printf("do tipo aberto ");
	}else if(this->choice==2){
		printf("do tipo torta ");	
	}else if(this->choice==3){
		printf("do tipo corda ");
	}
	printf("e cor de fundo ");color_print(sup->bg);
	printf("\n");
}

Arco* arco_new (int x, int y, int w, int h, int bgr, int bgg, int bgb, int arci, int arcf, int choice) {
    Arco* this = malloc(sizeof(Arco));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Arco_print;
    sup->x = x;
    sup->y = y;
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    this->arci = arci;
    this->arcf = arcf;
    this->choice = choice;
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d), ",this->w, this->h, sup->x, sup->y);
    printf("cor de borda ");color_print(sup->fg);
	printf(" e cor de fundo ");color_print(sup->bg);
	printf("\n");
}

Ellipse* ellipse_new (int x, int y, int w, int h, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    char stg[100];
    char font[20];
    int size;
} Texto;

void Texto_print (Texto* this) {
    Figure* sup = (Figure*) this;
    printf("Texto: '%s', com tamanho %d, fonte %s, na posicao (%d,%d) ",this->stg, this->size, this->font, sup->x, sup->y);
	printf(" e cor de fundo ");color_print(sup->bg);
	printf("\n");
}

Texto* texto_new (int x, int y, int size, int bgr, int bgg, int bgb, char* stg, char* font) {
    Texto* this = malloc(sizeof(Texto));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Texto_print;
    sup->x = x;
    sup->y = y;
    sup->bg = color_new(bgr,bgg,bgb);
    this->size = size;
    strcpy(this->stg, stg);
    strcpy(this->font, font);
    return this;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,20,20,0,0,0,255,255,255),
        (Figure*) ellipse_new(40,10,140,300,0,0,255,166,166,166),
        (Figure*) arco_new(30,30,100,100,0,255,0,0,180,3),
        (Figure*) texto_new(210,110,20,122,255,0,"Ola mundo!","Arial")
    };

    ///
	int i;
	
    for (i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
