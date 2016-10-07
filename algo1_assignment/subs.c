#include<stdio.h>
#include<stdlib.h>

struct node{
    int value;
    struct node *next;
    
};

// function divide arry into lists
struct node ** subdivide(struct node **top,int a[] ,int s,int n,int m,int l){
       int i,j;
       struct node *t,*h,*p=(struct node *)malloc(sizeof(struct node));;
       h=p;
       t=p->next=NULL;
       for(i=1;i<l;i++)
          {    h=p; for(j=0;j<n;j++)
                {   h=p;
                    if(a[j]<s*i && a[j]>=(m+s*(i-1))){
                       p->value=a[j];
                       t=p->next;
                       p=(struct node *)malloc(sizeof(struct node));
                       t=p;
                       p->value=-1;
                       p->next=NULL;}
                       
                 }
                 printf("\n");
                 
            top[i]=h;
         }
         
         
         return top;
         }
       
// sorting top pointer 
struct node *sort(struct node *top){
     int i=0,j,k,swap,a[200];
     struct node *p,*u,*h=(struct node *)malloc(sizeof(struct node));
     p=h;
     u=h->next;
     while(top!=NULL){
           a[i++]=top->value;
           top=top->next;
           }
         
 // bubble sort 
  for(j=0;i<(i-1);j++)
  {  for(k=0;k<i-j-1;k++)
    {
      if (a[k]>a[k+1]) /* For decreasing order use < */
      { swap       = a[k];
        a[k]   = a[k+1];
        a[k+1] = swap;} }}
  
  for(j=0;j<i;j++)
  {   h->value=a[j];
      h=(struct node *)malloc(sizeof(struct node));
      u->next=h;
      u=h->next;}
      
      u=NULL;
           
     return p;
     
     
}
           
     



struct node ** sortlist(struct node **top,int l ){
     int i,j;
      for(i=0;i<l;i++)
          top[i] = sort(top[i]);  // sort is function to sort top pointer 
        
     return top;

}

int * sublist(struct node **top,int a[],int l){

      int i,j=0;
      for(i=0;i<l;i++)
        while(top[i]!=NULL){
            *(a+j)=top[i]->value;
            j=j+1;
              top[i]=top[i]->next;
              }
              return a;
  }
       


void main(){
    int *a,n,i,k=10,l,m,M,j,s;
    printf("\nn:");
    scanf("%d",&n);
    a=(int *)malloc(n*sizeof(int));
    for(i=0;i<n;i++)
       scanf("%d",&a[i]);
    M=*a;
    m=*a;
    if(n%10==0)
       l=n/k;
    else
       l=n/k+1;
       
    struct node **list=(struct node **)malloc(l*sizeof(struct node *));
    
    for(i=1;i<n;i++)
    {
       if(*(a+i)<m)
             m=*(a+i);
       if(*(a+i)>M)
             M=*(a+i);
    }
    
	if((M-m+1)/l==0)
		s=(M-m+1)/l;
    else
    	s=(M-m+1)/l+1;  
    list =   subdivide( list,a,s,n,m,l);
    for(i=1;i<l;i++){
    printf("\nsublist:");
       while(list[i]!=NULL){
         printf("%d ",list[i]->value);
         list[i]=list[i]->next;
         }
         printf("\n");
         }
         
    list = sortlist(list,l );   // sortlist function calling  that sort the list  
    
    for(i=1;i<l;i++){
    printf("\nsublist:");
       while(list[i]!=NULL){
         printf("%d ",list[i]->value);
         list[i]=list[i]->next;
         }
         printf("\n");
         }
         
    
     a=sublist(list ,a,l);   // sublist function calling that convert sorted list back to given array
     
     for(i=1;i<n;i++)
       printf("%d ",a[i]);
       
  }     
      
    

    
    
