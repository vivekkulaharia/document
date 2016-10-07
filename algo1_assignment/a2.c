#include<stdio.h>
#include<stdlib.h>
int max=0,a[1000],h=1;
/* structure node having three pointer*/
struct node{
int data;
struct node* left;
struct node* right;
struct node* parent;
}*tree=NULL;
/* insertion function of tree*/
struct node* insert(struct node *tree, int data)
{
    /* z get new memory of size node and value*/
    struct node *z = (struct node*)malloc(sizeof(struct node));
    z->data = data;
    z->left = z->right = z->parent = NULL;
 	if (tree == NULL)
    {   tree = z;
    }
    else
    {
        struct node *y = NULL;
        struct node *x = tree;
 
       while (x != NULL)
        {
            y = x;
            if (z->data < x->data)
                x = x->left;
            else
                x = x->right;
        }
        z->parent = y;
        if (z->data > y->data)
            y->right = z;
        else
            y->left = z;
       
        
    }
    return tree;
}
void preorder(struct node * tree)
{   if(tree!=NULL){
		printf("%d ",tree->data);
     	preorder(tree->left);
     	preorder(tree->right);
     }
}
void inorder(struct node * tree)
{   if(tree!=NULL){ 
		inorder(tree->left);
 	    printf("%d ",tree->data);
      	inorder(tree->right);
     }
}

void height(struct node* tree){
            int g=h;
			if(tree!=NULL){
			    a[0]=1;
			    
			     
			       if(tree->left!=NULL){
			     
			       a[g]=a[g-1]+1;
			       h++;
			       height(tree->left);
			     }
			     
			    if(tree->right!=NULL){
			       int y=h;
			       a[y]=a[g-1]+1;
			       h++;
			       height(tree->right);
			     }
			    
			 }
	}	
struct node* leftrotate(struct node *tree,struct node *x)
{
   
    struct node *y = x->right;
    x->right = y->left;
 
    if (x->right != NULL)
        x->right->parent = x;
 
  
   y->parent = x->parent;
 
   if (x->parent == NULL)
        tree = y;
 
   else if (x == x->parent->left)
             x->parent->left = y;
         else    x->parent->right = y;
    
    y->left = x;
    x->parent = y;
    
    return tree;
}
 
 
/* rightrotate function */
struct node* rightrotate(struct node *tree,struct node *y)
{
    struct node *x = y->left;
    y->left = x->right;
    if (x->right != NULL)
        x->right->parent = y;
    x->parent =y->parent;
    if (x->parent == NULL)
        tree = x;
    else if (y == y->parent->left)
        y->parent->left = x;
    else y->parent->right = x;
    x->right = y;
    y->parent = x;
    
    return tree;
}
/*a function makeSkew () to convert the tree constructed in Part 1 to a linked list followed by the right links*/ 
struct node* makeskew(struct node* tree,struct node* t){
             struct node *s=tree;
             while(tree->left!=NULL){
                tree=rightrotate(s,tree);
                 s=tree;
                while(tree->left==NULL)
                tree=tree->right;
                while(tree->left!=NULL)
                s=rightrotate(s,tree);
                while(tree->right!=NULL &&tree->left!=NULL){
                    tree=tree->right;
                 }
             }
             
             return s;
         }
void main(){
	int i,j,k,m=0;
	
	printf("\nn=:");
	
	scanf("%d",&j);/* how many value you want to store*/
	
	for(i=0;i<j;i++){
	    scanf("%d",&k);
	    tree=insert(tree,k);
	   }
	   
	height(tree);  /* to get height of tree*/ 
	for(i=0;i<j;i++)	    
	    if(m<a[i])
	       m=a[i];
	printf("%d\n",m);     
	
	preorder(tree);
	printf("\n");
	tree=makeskew(tree,tree);
	preorder(tree); 
        
	
	}
