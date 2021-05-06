#include <stdio.h>
#include <stdlib.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL/glut.h>
#include <time.h>

using namespace std;

struct cord{
    int x,y;
};


struct Cell{
    bool alive = false;
    cord matrixCord = cord();
    cord renderCord = cord();
    cord adjacencyList[8];
    int adjacencyListCount = 0; 
    public:
        Cell(){}
        Cell(int x,int y, int height, int width){
            if(x>=width || y>=height || x<0 || y<0){
                printf("Invalid arguments, index out of bound!");
                return;
            }
            matrixCord.x = x;
            matrixCord.y = y;

            int talive =  rand()%100;
            if(talive>30){
                alive = true;
            }else alive = false;
    }

    
    // Prints the data of the Cell to the console
    void printToConsole(){
        printf("-------------------------\n");
        printf("Matrix coordinates:\n");
        printf("-------------------------\n");
        printf("x = %d\n", matrixCord.x);
        printf("y = %d\n", matrixCord.y);
        printf("Status = %d\n", alive);
        printf("-------------------------\n");
    }

};

int* displayWidth = (int*)malloc(sizeof(int));
int* displayHeight = (int*)malloc(sizeof(int));
float* pointSize = (float*)malloc(sizeof(float));
int isOnGoing = 0, isAlter = 0;
Cell* matrix;
Cell currentCell, tempCell;

Cell* getAddress(int i, int j, Cell* base, int width){
    return (base+i * width+j);
}

// Generates matrix index by using x and y coordinates.
int getIndex(int x, int y, int width){
    return (width*(y+1)) - (width - (x+1));
}

int getLifeStatus(int i, int j){
    int activeCells = 0;
    int iLower, jLower, iUpper, jUpper;
    if(j==0)
        jLower = j;
    else
        jLower = j-1;
    if(j == *displayWidth -1)
        jUpper = j;
    else
        jUpper = j + 1;

    if(i==0)
        iLower = i;
    else
        iLower = i-1;
    if(i == *displayHeight -1)
        iUpper = i;
    else
        iUpper = i + 1;

    for(int p = iLower; p<=iUpper;p++){
        for(int q = jLower; q<=jUpper;q++){
            if(p!=i && q!=j){
                tempCell = *getAddress(p,q,matrix,*displayWidth);
            if(tempCell.alive)
                activeCells++;
            }
        }
    }

    if(activeCells<=1 || activeCells>=4)
        return 0;
    else if(activeCells == 3)
        return 1;
    else{
        if(isAlter)
            return 1;
        else
            return currentCell.alive;
    }
}

void display(){
    glClearColor(0.0f,0.0f,0.0f,1.0f);  //Defining RGBA color buffers used by glColor while clearing color buffers
    glMatrixMode( GL_PROJECTION );      //Defining Projection matrix as the curring matrix  
    glLoadIdentity();             // Replacing the current matrix with identity matrix
    gluOrtho2D( 0, *displayWidth, 0, *displayHeight);        //Setting Orthogonal 2D projection matrix

    glClear(GL_COLOR_BUFFER_BIT);   //Clearing the color buffer

    /*
    LETS START DRAWING---------------------------
    */

   glPointSize(*pointSize);
   glBegin(GL_POINTS);

   for(int i=0; i<*displayHeight; i++){
       for(int j=0; j<*displayWidth; j++){
            currentCell = *getAddress(i,j,matrix,*displayWidth);
            if(isOnGoing){
                currentCell.alive = getLifeStatus(i,j);
                *getAddress(i,j,matrix,*displayWidth) = currentCell;
            }
            if(currentCell.alive)
                glColor3ub(0,255,0);
            else
                glColor3ub(0,0,0);
            glVertex2i(i,j);
       }
   }
    glEnd();    //End of vertice drawing
    glutSwapBuffers(); 
}

void update(int){
    glutPostRedisplay();        //Calls glutDisplayFunction i.e. display() to re-draw the frame
    glutTimerFunc(200,update,0);     //Calls the update() function after 16ms for creating 60fps animation
}

void onKeyPressed (unsigned char key, int x, int y) {  
    if(key == 's'){
        isAlter = 0;
        if(isOnGoing)
            isOnGoing = 0;
        else
            isOnGoing = 1;
    }
    else if(key == 'a'){
        isAlter = 1;
        if(isOnGoing)
            isOnGoing = 0;
        else
            isOnGoing = 1;
    }
} 

void prepareOpenGLWindow(int argc, char** argv, int height, int width){
    *displayWidth = width;
    *displayHeight = height;
    glutInit(&argc, argv);      //Init glut
    glutCreateWindow("Game of Live Simulation");    //Creating rendering window with Title
    glutInitDisplayMode(GL_DOUBLE | GLUT_RGBA);     //Defining display mode GL_DOUBLE for double buffer 
                                                    //and GLUT/RGBA for rgba color encoding
    glutInitWindowSize(width,height);    //Defining the renderer window size
    glutInitWindowPosition(100,100);    //Defining the position of the renderer window on the display
    glutDisplayFunc(display);   //Registering display callback handler for windows re-paint
    glutKeyboardFunc(onKeyPressed);
    glutTimerFunc(0,update,0);     //Runs update function that updates the frames at 60fps.
    glutMainLoop();     //Enter event-processing loop
}

void printHelp(){
    printf("---------------------------------------------------------------------\n");
    printf("---------------------------------------------------------------------\n");
    printf("Welcome to Convey's Game of Life Simulation\n");
    printf("---------------------------------------------------------------------\n");
    printf("---------------------------------------------------------------------\n");
    printf("- To start/stop simulation: Press 'S' on the keyboard\n");
    printf("- To start/stop simulation in altered mode: Press 'A' on the keyboard\n");
    printf("---------------------------------------------------------------------\n");
    printf("By amannirala13\n");
}


int main(int argc, char** argv)
{
    srand((unsigned) time(0));
    if(argc<=2)
        return -1;
    int width = atoi(argv[1]), height = atoi(argv[2]);
    if(argc==4)
        *pointSize = atof(argv[3]);
    else
        *pointSize = 1.0f; 

    matrix = new Cell[width * height];
    
    for(int i=0; i<height;i++){
        for(int j=0; j<width;j++){
            *getAddress(i,j,matrix,width) = Cell(j,i,height, width);
        }
    }
    printHelp();
    prepareOpenGLWindow(argc, argv, height, width);


    return 0;
}
