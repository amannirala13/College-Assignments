#include <stdio.h>
#include <stdlib.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include <GL/glut.h>

//glutDisplayFunc: Draws frames
void display(){
    glClearColor(0.0f,0.0f,0.0f,1.0f);  //Defining RGBA color buffers used by glColor while clearing color buffers
    glMatrixMode( GL_PROJECTION );      //Defining Projection matrix as the curring matrix  
    glLoadIdentity();             // Replacing the current matrix with identity matrix
    gluOrtho2D( 0, 500, 0, 500);        //Setting Orthogonal 2D projection matrix

    glClear(GL_COLOR_BUFFER_BIT);   //Clearing the color buffer
    /*---------------------------------------------------------------------
    Drawing graphics here. All the graphic points will be defined here
    ----------------------------------------------------------------------*/

    glLineWidth(1.0f);      //Defining line width
    glBegin(GL_LINES);      //Defining the beginning of vetices with inbuilt OpenGL interpretation i.e. line

    for(int n = 0;n<rand()%50;n++){     //Loop for creating random number of lines
        glColor3ub(rand()%255,rand()%255,rand()%255);   //Setting random rgb color profile to the graphics
        glVertex2i(rand()%500, rand()%500);    //Drawing fist vertex of the line with random values of x and y
        glVertex2i(rand()%500, rand()%500);     //Drawing second vertex of the line with random values of x and y
    }

    glEnd();    //End of vertice drawing
    glutSwapBuffers();      //Swaps background frame to foreground once its ready
}

//Animation callback: Calls itself after a particular period of time to tell OpenGl to re-draw the frame
void update(int){
    glutPostRedisplay();        //Calls glutDisplayFunction i.e. display() to re-draw the frame
    glutTimerFunc(16,update,0);     //Calls the update() function after 16ms for creating 60fps animation
}

// Program entry point: You application execution starts here
int main(int argc, char** args){
    glutInit(&argc, args);      //Init glut
    glutCreateWindow("OpenGL Renderer");    //Creating rendering window with Title
    glutInitDisplayMode(GL_DOUBLE | GLUT_RGBA);     //Defining display mode GL_DOUBLE for double buffer 
                                                    //and GLUT/RGBA for rgba color encoding
    glutInitWindowSize(500,500);    //Defining the renderer window size
    glutInitWindowPosition(100,100);    //Defining the position of the renderer window on the display
    glutDisplayFunc(display);   //Registering display callback handler for windows re-paint
    glutTimerFunc(0,update,0);     //Runs update function that updates the frames at 60fps.
    glutMainLoop();     //Enter event-processing loop
    return 0;   //Program exits
}
