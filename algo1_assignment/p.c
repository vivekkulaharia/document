#include<stdio.h>
#include<stdlib.h>
struct node{
int key;
struct node* lchild;
struct node* rchild;
}*tree=NULL;
struct node *current=NULL,*crrent=NULL;
struct node* insert(struct node* tree,int i)
{  if(tree==NULL){
     tree=(struct node*)malloc(sizeof(struct node));
     tree->key=i;
     tree->lchild=tree->rchild=NULL;}
   else{ if(tree->key>i){
   tree->lchild=insert(tree->lchild,i);}
   else if(tree->key<i){
   tree->rchild=insert(tree->rchild,i);}
   else 
   { exit(0);
     return tree;}
   }
   return tree;
}
void preorder(struct node * tree)
{   if(tree!=NULL)
    {printf("%d ",tree->key);
     preorder(tree->lchild);
     preorder(tree->rchild);
     }
     }
void inorder(struct node * tree)
{   if(tree!=NULL)
    { inorder(tree->lchild);
      printf("%d ",tree->key);
      inorder(tree->rchild);
     }
     }
 
struct node* search1(struct node *tree,int k)
{   
	if(tree->key>k && tree->lchild!=NULL) {
		tree=search1(tree->lchild,k);
	}
    else if(tree->key<k && tree->rchild!=NULL)
	{
		tree=search1(tree->rchild,k);
	}
    else if(tree->key==k)
		return tree; 
	return tree;     
}
struct node* search2(struct node *tree,int k)
{    if(tree->key>k)
       {
         crrent=tree->lchild;
       }
     else
        crrent=tree->rchild;    
 	if(crrent->key>k && crrent->lchild!=NULL) {
		tree=search2(crrent->lchild,k);
	}
    else if(crrent->key<k && crrent->rchild!=NULL)
	{
		tree=search2(crrent->rchild,k);
	}
    else if(tree->key==k)
		return tree; 
	return tree;     
}
                    
void main(){
int i,j,k,y;
printf("n:");
scanf("%d",&i);
for(j=0;j<i;j++)
{  printf("\n enter the number :");
   scanf("%d",&k);
   tree=insert(tree,k);
}  printf("\n pre order:");
   preorder(tree);
   printf("\n");
   printf("\n in order:");
   inorder(tree);
   printf("\n x :");
   scanf("%d",&i);
   printf("\n y :");
   
   scanf("%d",&y);
   crrent=search1(tree,i);
   printf("\n +++ search1(%d) : %d",i,crrent->key);
   //crrent=search2(tree,i);
   printf("\n +++ search(%d) : %d",y,crrent->key);
   
   printf("%d\n",crrent->key);
}
