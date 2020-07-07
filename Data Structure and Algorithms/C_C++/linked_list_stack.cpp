#include <iostream>
#include <string>

using namespace std;

// Information Struture for each element block
struct info{
      int PRN;
      string name;
   };

// Structure for each element of the linked list (stack)
struct block{
    info data;
    block* prev;
};

// Top pointer of the linked-list
block* top = NULL;

//Function that checks and returns of the list is empty of not
bool isEmpty(){
   if(top == NULL){
      return true;
   }
   return false;
}

//Push function for adding elements
void push(info arg){
   block* blockObj = new block();
   blockObj->data = arg;
   blockObj->prev = top;
   top = blockObj;
   cout<<"Pushed new element! "<<endl;
}

// Pop function for deleting elements
void pop(){
   block* temp = top->prev;
   delete top;
   top = temp;
   cout<<"Popped an element! "<<endl;
}

// Traverse for readign and printing elements of the linked-list
void traverse(){
   if(isEmpty()){
      cout<<"Empty list! "<<endl;
   }
   else{
      cout<<"Printing stack:"<<endl;
      block* temp = top;
      bool endFlag = false;
      while(!endFlag){
         cout<<temp->data.PRN<<endl;
         cout<<temp->data.name<<endl<<endl;
         if(temp->prev == NULL)
         endFlag = true;
         else
         temp = temp->prev;
      }
      cout<<endl<<endl<<endl;
   }
}

// Main function
int main(){
int num;
cout<<"Enter the number of elements to be pushed in the stack: ";
cin>>num;
for (int i=0;i<num;i++){
info infoObj=info();
cout<<"Enter PRN for "<<i+1<<" element: ";
cin>>infoObj.PRN;
cout<<"Enter Name for "<<i+1<<" element: ";
cin.ignore();
getline(cin,infoObj.name);
push(infoObj);
}

for(int i=0;i<=num;i++){
   traverse();
   pop();
}
}