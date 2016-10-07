/*
vivek kulaharia
14CS30039
even PC:38
*/

#include<stdlib.h>
#include<stdio.h>

struct node {
  int u,v;
  struct node *l,*m,*r;
} *node;

int search(struct node *t , int x){

 struct node * top;
    top=t;
  while(top!=NULL){
  if(top->u!=-1&&top->v!=-1)
   {
    if(top->u<x && top->v>x)
       top=top->m;
    else if(top->u>x && top->v>x)
          top=top->l;
         else if(top->u<x && top->v<x)
           top=top->r;
     
     if(top->u==x || top->v==x)
     return 1;       
    }         
    if(top->u!=-1&&top->v==-1){
      if(top->u==x)
       return 1;
    }
  
  }
  return 0;
  
  
  }  


  
struct node * insert(struct node *t,int x){
  int p;
  struct node *no;
     no=(struct node *)malloc(sizeof(struct node));
     no->u=x;
     no->v=-1;
     no->l=no->m=no->r=NULL;
     if(t==NULL){
        t=no;
        return t;
      }
      
      else{
       if(t->u!=-1&&t->v!=-1)
       {  if(t->u<x&&t->v>x)
          t->m=insert(t->m,x);
          
          if(t->u<x&&t->v<x)
          t->r=insert(t->r,x);
          
          if(t->u>x&&t->v>x)
          t->l=insert(t->l,x);
       }
      
       if(t->u!=-1&&t->v==-1){
          if(t->u<x)
             t->v=x;
             else if(t->u>x) {
                     p=t->u;
                     t->u=x;
                     t->v=p;
             }
             
       }
      
      return t;
      }  
}

void print2largest(struct node *t1){
  int x=0,y=0;
  struct node * top,*t=t1;
  while(t!=NULL){
       top=t;
       if(t->u!=-1&&t->v!=-1)
         {x=t->v;y=t->u;} 
       if(t->v==-1)
          x=t->u;
       else
          x=t->v;
        
       t=t->r;
      
  
  }
  
  if(y==-1)
     y=top->v; 
   //  printf("\nsecond largest element : %d",y);  
  while(top->m!=NULL&&y==-1){
        if(t->v==-1)
          y=t->u;
       else
          y=t->v;
          top=top->m;
   }   
  printf("\nlargest element : %d",x);
  printf("\nsecond largest element : %d",y);  
}  

int  printsmall(struct node *t , int a){
        if(t==NULL)
        { return 0 ;} 
        
        
        if(t->u!=-1)       
        if(t->u<=a){
         printsmall(t->l,a);
         printf("%d ",t->u);
        }
        
        
        if(t->u!=-1&&t->u!=-1)  
        if(t->u<a&&t->v>a){
         printsmall(t->m,a);
        }
        
        if(t->v!=-1)  
        if(t->v<=a){
        
         printf("%d ",t->v);
         printsmall(t->r,a);
         
        }
        
       
        
}
void inorder(struct node * tree)
{   if(tree!=NULL){ 
		inorder(tree->l);
 	    printf("%d ",tree->u);
      	inorder(tree->m);
      	printf("%d ",tree->v);
      	inorder(tree->r);
     }
}
void main(){
   int i,j,k,m=0;
	
	printf("\nnins=:");
	
	scanf("%d",&j);/* how many value you want to store*/
	printf(" \nInsert element \n ");
	for(i=0;i<j;i++){
	    scanf("%d",&k);
	    node=insert(node,k);
	   }
	printf("\ntraversal inorder :");
	inorder(node);
	printf("\nEnter number to search :");
	scanf("%d",&k);
	m=search(node,k);
	if(m==1)
	   printf("\n Search(%d):SUCCES",k);
    else
       printf("\n Search(%d):FAILURE",k);
	
	
	print2largest(node);
	printf("enter number to <= ");
	scanf("%d",&k);
	printsmall(node , k);
	
}

