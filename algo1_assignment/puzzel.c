#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct node{
  int val,rk,flag;
  struct node * parent;
}***top;
// init board  of top pointer
struct node *** initboard(struct node ***top,int n){
    int i,j;
    top=(struct node ***)malloc(n*sizeof(struct node **));
     for(i=0;i<n;i++){
         top[i]=(struct node **)malloc(n*sizeof(struct node *));
         for(j=0;j<n;j++){
         top[i][j]=(struct node *)malloc(sizeof(struct node));
         top[i][j]->val=0;
         top[i][j]->rk=0;
         top[i][j]->parent=NULL;
         top[i][j]->flag=0;
         }}

    return top;
}
//calculating set of given element
int findset(struct node *** top ,int i,int j){
     if(top[i][j]->parent==NULL)
         { while(top[i][j]->parent==NULL) top[i][j]=top[i][j]->parent;
           return  top[i][j]->val;}
     else
         return top[i][j]->val;
         }
// making disjoin element into same  set 
struct node *** setunion( struct node *** top , int i,int j,int x ,int y){
    if(top[i][j]->rk!=top[x][y]->rk)

      if(top[i][j]->rk >= top[x][y]->rk){
        top[x][y]->parent=top[i][j];
        top[x][y]->rk= top[i][j]->rk+1;}

      else{
        top[i][j]->parent=top[x][y];
         top[i][j]->rk=top[x][y]->rk+1;}

    else{
        top[x][y]->parent=top[i][j];
        top[x][y]->rk+=1;
        }

     return top;
}
// checkpopsition check valid block fortr flow in the given square 
int * checkpos(struct node ***top,int i,int j,int n){
      int c,count=0,x=0,y=0,a[4]={0,0,0,0},p[]={-1,-1},b=n,t=1,v;
      struct node *f;                                          //i-1,j a[3],i,j-1 a[0],i+1,j a[2],i,j+1 a[1]
      f=top[i][j];
      while(f->parent!=NULL){
           f=f->parent;
           for(v=0;v<n*n;v++)
              if(top[v/n][v%n]==f)                 // checking condition whether index of square is in valid or not
                 {x=v/n;y=v%n;}

    
           if( i-1==x && j==y-1)
               a[3]=1;
           if( i+1==x && j==y-1)
               a[2]=1;
           if( i==x && j-1==y-1)
                a[0]=1;
           if( i==x && j+1==y-1)
                a[1]=1;
           if( i-1==x && j==y+1)
                a[3]=1;
           if( i+1==x && j==y+1)
                a[2]=1;
           if( i==x && j-1==y+1)
               a[0]=1;
           if( i==x && j+1==y+1)
               a[1]=1;
           if( i-1==x-1 && j==y)
               a[3]=1;
           if( i+1==x-1 && j==y)
               a[2]=1;
           if( i==x-1 && j-1==y)
                a[0]=1;
           if( i==x-1 && j+1==y)
               a[1]=1;
           if( i-1==x+1 && j==y)
               a[3]=1;
           if( i+1==x+1 && j==y)
               a[2]=1;
           if( i==x+1 && j-1==y)
                a[0]=1;
           if( i==x+1 && j+1==y)
               a[1]=1;
     }    if(i-1>=0)
          {if((top[i-1][j]->parent==NULL &&top[i-1][j]->flag==1)||top[i-1][j]->parent!=NULL)   // checking its left right ... position 
             a[3]=1;}
          else   a[3]=1;

          if(j-1>=0)
          {if((top[i][j-1]->parent==NULL && top[i][j-1]->flag==1)||top[i][j-1]->parent!=NULL)
             a[0]=1;}
          else  a[0]=1;

          if(i+1<n)
          {if((top[i+1][j]->parent==NULL &&top[i+1][j]->flag==1)||(top[i+1][j]->parent!=NULL))
             a[2]=1;}
          else   a[2]=1;

          if(j+1<n)
          {if((top[i][j+1]->parent==NULL &&top[i][j+1]->flag==1)||(top[i][j+1]->parent!=NULL))
             a[1]=1;}
          else    a[1]=1;

          for(c=0;c<4;c++){
               if(a[c]==0)
                 count++;}
          if(count==0)
            return p;
          else{ c=rand()%4;
          while(t)
            {   c=rand()%4;
                if(c==0)
                  if(a[0]==0)
                  {p[0]=i;p[1]=j-1;break;}
                  else
                   t=1;
                if(c==1)
                   if(a[1]==0)
                   {p[0]=i;p[1]=j+1;break;}
                    else
                   t=1;
                if(c==3)
                   if(a[3]==0)
                   {p[0]=i-1;p[1]=j;break;}
                   else
                   t=1;
                if(c==2)
                   if(a[2]==0)
                   {p[0]=i+1;p[1]=j;break;}
                   else
                   t=1;
                   }}
             return p;}



// function to add path in square  how much is possible
struct node *** addpath(struct node ***top,int n)
{
       int q[2],i,*a,j,k,m=1,p[2];
         k=rand()%(n*n); // code for initialised 2 element in subsets
         i=k/n;
         j=k%n;
         top[i][j]->flag=1;
         printf("\nAttempting to add new paths...\n");
         printf("\n New path: "); 
         while(i>=0&&j>=0)
             { 
             a=checkpos(top,i,j,n);
             p[0]=a[0];p[1]=a[1];
             if(p[0]<0||p[0]>n ||p[1]<0||p[1]>n)
               {top[i][j]->flag=1;}
             if(p[0]>=0&&p[1]>=0&&p[0]<n&&p[1]<n)
                { top=setunion(top,i,j,p[0],p[1]);i=p[0];j=p[1]; 
                  printf("(%d,%d) ",i,j); }                                    // calculating   new path  path 
             else {printf("\n New path: "); 
             break;}
             } 
      for(q[0]=0;q[0]<n;q[0]++)
       for(q[1]=0;q[1]<n;q[1]++)
         { // code for initialised rest  element in subsets
          i=q[0];
          j=q[1];
          if(top[i][j]->parent==NULL && top[i][j]->flag==0)
           {
             top[i][j]->flag=1;
             while(i>=0&&j>=0)
             {
                 a=checkpos(top,i,j,n);
                 p[0]=a[0];p[1]=a[1];
                 if(p[0]<0||p[0]>n ||p[1]<0||p[1]>n)
                    {top[i][j]->flag=1;}
                 if(p[0]>=0&&p[1]>=0&&p[0]<n&&p[1]<n)
                    { top=setunion(top,i,j,p[0],p[1]); i=p[0];j=p[1]; 
                     printf("(%d,%d) ",i,j);  }
                 else {printf("\n New path: "); 
                  break;}
             }
           }
         }
         return top;
}


struct node *** addpathnum(struct node *** top,int n){
       int i,j,k,no=1;          // k store value of non empty squarei, j indices
       struct node *next;
       for(i=0;i<n;i++)          // loop to traverse top node pointer
          for(j=0;j<n;j++)
        {  if(top[i][j]->flag==1)          // check wheither it is endpoint to flow or not
             if(top[i][j]->parent!=NULL){
                 top[i][j]->val=no;              // assign no to it if true
                 next=top[i][j];
                while(next->parent!=NULL){        // assign no to allof it flow square
                   next->parent->val=no;
                   next=next->parent;
                 }
                                                

                 no+=1;}
                    }

return top;
}
void printboard(struct node ***top,int n){
    int i,j,k,m;
    struct node *a;
    printf("\nThe puzzle : ");                                     // printing squares 
    printf("\n");
    for(m=0;m<n;m++)
         printf("----");
    printf("\n");
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++){
            if(top[i][j]->flag==1){
               printf("%d  |",top[i][j]->val);  }
            else 
               printf("   |"); }
               printf("\n");
               for(m=0;m<n;m++)
               printf("----");
               printf("\n");
             }
   printf("\n  Solution of puzzle : ");  
   printf("\n");
    for(m=0;m<n;m++)
         printf("----");
    printf("\n");        
     for(i=0;i<n;i++) {
         printf("\n");    
         for(j=0;j<n;j++){{
              printf("%d  |",top[i][j]->val);  }
           }
              printf("\n");
               for(m=0;m<n;m++)
               printf("----");
               printf("\n");
             
             
             }}



void main(){
     int n,i;
     srand((unsigned int)time(NULL));
     printf("\n please enter dimension of square n:"); 
     scanf("%d",&n);
     printf("\n 0 is stand for solid block");
     top=initboard(top,n);                         // calling function
     top=addpath(top,n);
     top=addpathnum(top,n);
     printboard(top,n);
     }

