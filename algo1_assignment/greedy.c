#include<stdlib.h>
#include<stdio.h>
//  data type for chain
struct cod{
int data[2];
struct cod * next;
};

struct cod **chain;
void merge(int arr[],int c[], int l, int m, int r)
{   int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m;
    int L[n1],L1[n1], R[n2],R1[n2];
    for(i = 0; i < n1; i++){
        L[i] = arr[l + i];
        L1[i]= c[l + i];}
    for(j = 0; j < n2; j++){
        R[j] = arr[m + 1+ j];
        R1[j] = c[m + 1+ j];}
    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            arr[k] = L[i];
            c[k] = L1[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            c[k] = R1[j];
            j++;
        }
        k++;
    }
    while (i < n1)
    {
        arr[k] = L[i];
        c[k] = L1[i];
        i++;
        k++;
    }
    while (j < n2)
    {
        arr[k] = R[j];
        c[k] = R1[j];
        j++;
        k++;
    }
}
void mergesort(int arr[],int c[],int l, int r)
{
    if (l < r)
    {  // printf("rt");
        int m = l+(r-l)/2; 
        mergesort(arr,c, l, m);
        mergesort(arr,c, m+1, r);
        merge(arr,c, l, m, r);
    }
}

void optnocons(int **a,int n)
{  int i,p[n],c[n];
   for(i=0;i<n;i++){
   p[i]=a[i][1];
   c[i]=a[i][0];}
   mergesort(p,c, 0,n-1);
  // printf("task sequenes :");
   for(i=0;i<n;i++)
   printf("task sequenes:%d (%d %d) \n",i,c[i],p[i]);
 }
// insertion in chain  
struct cod ** insert( int **a,int p,int c,int m ,struct cod **chain){
    int i;
    struct cod *v,*t,*pre,*start;
    v=(struct cod *)malloc(sizeof(struct cod ));
    v->data[1]=a[p][1];
    v->data[0]=a[p][0];
    v->next=NULL;
    chain[c]=start;
    if(chain[c]==NULL){
             chain[c]=v;
             return chain;}
    while(start!=NULL){                                 // problem is there 
             pre=start;
             start=start->next;
             }
          start=pre;
          start->next=v;
    return chain;      
    }      
 // function which complete insertion chain              
struct cod ** buildchains(int **a,int m,int c[] ,struct cod **chain,int n){
   int i;
   for(i=0;i<n;i++)
    chain=insert(a,i,c[i],m,chain);
    return chain;
}
// show data in chain 
void showdata(struct cod **chain,int m){
   int i;
   for(i=0;i<m;i++){
      while(chain[i]!=NULL){
         printf("chain %d:(%d %d)\n",i,chain[i]->data[0],chain[i]->data[1]);
         chain[i]=chain[i]->next;}
         }
}         

  
int main()
{
    int **a,n,i,m,*c;
    printf("Size: \n");
    scanf("%d",&n);
    a=(int **)malloc(n*sizeof(int *));
    c=(int *)malloc(n*sizeof(int ));
     for(i=0;i<n;i++)
    a[i]=(int *)malloc(2*sizeof(int ));
    for(i=0;i<n;i++)
       scanf("%d%d",&a[i][0],&a[i][1]);   // a[i][0] =p a[i][1]=t
     optnocons( a, n); 
     printf("\n m =");                 // m= value
     scanf("%d",&m);
    chain=(struct cod **)malloc(m*sizeof(struct cod *));         // pointer assign to **pointer
    for(i=0;i<n;i++)
        chain[i]=NULL; 
    for(i=0;i<n;i++)
    scanf("%d",&c[i]);        // taking ith value  of chain to be inserted 
    chain=buildchains(a,m, c,chain,n );
    showdata(chain,m); 
    
    
    
    
    
 
}
