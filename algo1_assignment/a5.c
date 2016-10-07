#include<stdio.h>
#include<stdlib.h>
int a=-1; // declared to check minimun room for event in tree
// making node as having field maximun count to count equal node if entered d[2] is array of lower and upper interval 
struct node{

int d[2],count,max;
struct node* lchild;
struct node* rchild;

}*tree=NULL;

void preorder(struct node * tree)
{   if(tree!=NULL)
    {printf("\n(%d,%d) ",tree->d[0],tree->d[1]);
     preorder(tree->lchild);
     preorder(tree->rchild);
     }
     }
void inorder(struct node * tree)
{   if(tree!=NULL)
    { inorder(tree->lchild);
      printf("\n(%d,%d) ",tree->d[0],tree->d[1]);
      inorder(tree->rchild);
     }
     }
int  intervalcmp(int a[],int b[]){
  if(a[0]<b[0])
  return -1;
  else if(a[0]==b[0]&&a[1]<b[1])
       return -1;
       else if(a[0]==b[0]&&a[1]==b[1])
            return 0;
            else if(a[0]>b[0])
                 return 1;
                 else if(a[0]==b[0]&&a[1]>b[1])
                      return 1;
                      
}

// it is insertion function that take 2 values stored in a[2] and insert in bst tree
struct node * insert(struct node * tree,int a[2]){
     struct node *cur=(struct node*)malloc(sizeof(struct node));
     if(tree==NULL){
        tree=(struct node*)malloc(sizeof(struct node));
        tree->d[0]=a[0];
        tree->d[1]=a[1];
        tree->max=a[1];
        tree->count=1;
        tree->lchild=tree->rchild=NULL;}
    else {
       cur->d[0]=a[0];
       cur->d[1]=a[1];
       cur->max=a[1];
       cur->count=1;
       cur->lchild=cur->rchild=NULL;
       if(tree->max<cur->max)
            tree->max=cur->max;
       int i=intervalcmp(tree->d,cur->d);
       if(i<0)
         tree->rchild=insert(tree->rchild,cur->d);
       else if(i>0)
              tree->lchild=insert(tree->lchild,cur->d);
            else if(i==0)
              tree->count++; }

   return tree;
}
//function to check overlap
int overlapcnt(struct node * tree ,int a[2],int co){
    int i;
    if(tree==NULL)
      return co;
    else{ if(a[0]<tree->d[1] && a[0]>tree->d[0]){
                printf("\n[(%d,%d),%d]",tree->d[0],tree->d[1],tree->count);
                co++;
                co=overlapcnt(tree->rchild,a,co);
                co=overlapcnt(tree->lchild,a,co);
                return co;}
           else {co=overlapcnt(tree->rchild,a,co);
                 return co;}   
          if(a[1]<tree->d[1] && a[1]>tree->d[0]){
             printf("\n[(%d,%d),%d]",tree->d[0],tree->d[1],tree->count);
             co++;
             co=overlapcnt(tree->lchild,a,co+1);
             co=overlapcnt(tree->rchild,a,co);}
            else { co=overlapcnt(tree->lchild,a,co);
                   return co;}
            return co;}
       return co;
}
// function to find min room required to comp event 
int minclassroomcnt(struct node * tree){
     int b,c;
     if(tree->lchild=NULL){     
        b=overlapcnt(tree->lchild,tree->d,0);
        printf("%d ",b);
         if(b>a)
            a=b; } // calling above function to get count
        if(tree->lchild=NULL){     
        c=overlapcnt(tree->rchild,tree->d,0); //     ,,,,
        printf(" %d",c);
        if(c>a)
           a=c;
      }
      return a;
}

void  main(){
    int i,j,k[2],p=0,h;
    printf("\n how many interval want to enter"); 
    scanf("%d",&j);
    for(i=0;i<j;i++){
    printf("\n left:");
    scanf("%d",&k[0]);
    printf("\n rignt:");
    scanf("%d",&k[1]);
    tree=insert(tree,k);}
    printf("\n inorder:");
    inorder(tree);
    printf("\n preorder:");
    preorder(tree);
    printf("\n enter interval to check overlap in tree or not (a,b) :");
    scanf("%d",&k[0]);
    scanf("%d",&k[1]);
    h=overlapcnt(tree ,k,p);
    printf("\ncount = %d",h);
    printf(" \nminimum number of room required :%d",minclassroomcnt(tree));
}
     




