#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
int  maxiter=0;
// create hash table
typedef struct table{
  unsigned int s,t,n,a,b;
  char **data;
  }table;

table* t1;
table * insert( table *t1,char s1[]);
void showdata(table *t1);
int  search(table *t1,char s[]);
// initilise hash table ass given in assignment
table * init(table *t1){

      int i=0;
      t1->s=8;
      t1->t=3;
      t1->n=0;
      t1->a=1;
      t1->b=3;

      t1->data=(char **)malloc(8*sizeof(char *));
      for(i=0;i<8;i++)
         (t1->data)[i]=NULL;
      return t1;
}
// hash function pass hash or data arry index
int  hash(char str[],unsigned int b,int t){
     unsigned int m,a,i;
     m = 0;
     a = 65791;
     for(i=0;i<strlen(str);i++){
         m=(a*m+(int)(str[i]));
         }
         m=m*b;
         t = 32-t;
         m = m >> t;
     return  m;
}
/* rehash has two properties
   check load factor and do the following size hashing
   other wise change  a b  and then insert in new table*/ 
table * rehash(table *t1){
         int i;
         float t=(float)(t1->n)/(t1->s);
         printf("%f\n",t);
         table *t2=(table *)malloc(sizeof(table));
         if(t<=.5){
         	printf("change paramete hash1 function is called");
            t2->a=t1->a+2;
            t2->b=t1->b+2;
            t2->s=t1->s;
            t2->t=t1->t;
            t2->n=t1->n;
            t2->data=(char **)malloc((t1->s)*sizeof(char *));
            printf("%d\n",t2->s);
            for(i=0;i<t2->s;i++)
                (t2->data)[i]=NULL;
            }
         else {
         	 printf("Double size hash2 function is called");
             t2->s=(t1->s)*2;
             t2->a=t1->a;
             t2->b=t1->b;
             t2->t=t1->t+1;
             t2->n=0;
             t2->data=(char **)malloc(t2->s*sizeof(char *));
              printf("%d\n",t2->s);
             for(i=0;i<t2->s;i++)
                (t2->data)[i]=NULL;

         }
         for(i=0;i<t1->s;i++){
            if((t1->data)[i]!=NULL)
            t2=insert(t2,(t1->data)[i]); 
          } 
return t2;
}
/* insert function this function work on that 
   first it check wheither it already present in it or not if present the return original table without insertion 
   second check load factor is greter than .5 that rehash by size double of hash table
   if both the indices is occupied by some string then it call rehash by changing the parameters  a,b by new odd number and insert in hash table
   if all succecfull it return new t2 which store in t1
*/ 
table * insert( table *t1,char s1[]){
          int i,j,k=0;
          k=search(t1,s1);
          if(k==1){
             printf("\nalready present\n");
             return t1;}
          printf("\n insert");
          i=hash(s1,t1->a,t1->t);
          j=hash(s1,t1->b,t1->t);
          float f1=(float)(t1->n)/(t1->s);
          if(f1<=.5){ 
		     if(t1->data[i]==NULL){
               (t1->data)[i] =(char *)malloc(20*sizeof(char));
                strcpy((t1->data)[i],s1);
                printf("\n previous value of (before insertion) n=%d  s=%d  load=%f",t1->n,t1->s,f1); // give value n,s before current insertion 
                 t1->n++;
             }
             else if((t1->data)[j]==NULL){
                    (t1->data)[j]=(char *)malloc(20*sizeof(char));
                    strcpy((t1->data)[j],s1);
                     t1->n++;}
                  else{  
				        t1=rehash(t1);
                        t1=insert(t1,s1);}}
           else{
               t1=rehash(t1);
               t1=insert(t1,s1);
               }
           return t1;

           }

/* search first get i and j index by hash function then check wheither present or not if present then return 1 other cases return 0*/
int  search(table *t1,char s[]){
       int i=hash(s,t1->a,t1->t);
       int j=hash(s,t1->b,t1->t);
       if(t1->data[i]==NULL && t1->data[j]==NULL)
             return 0;
       else{
       	  if(t1->data[i]!=NULL)
          { if(strcmp((t1->data)[i],s)==0)
             return 1; }
          else if(strcmp((t1->data)[j],s)==0)
                 return 1;
               else
                 return 0; }
        return 0;
}

/* delete function that delete particular string if present in hash table if not present in hash table then print not deleted */
table * delet(table *t1,char s[]){

        int i=hash(s,t1->a,t1->t);
        int j=hash(s,t1->b,t1->t);
        if(t1->data[i]!=NULL)
        {if(strcmp((t1->data)[i],s)==0)
            {(t1->data)[i]=NULL;
               t1->n--;
               printf("\n ...%s is deleted",s);}}
        else if(t1->data[j]!=NULL)
		     { if(strcmp((t1->data)[j],s)==0)
              { (t1->data)[j]=NULL;
                 t1->n--;
                  printf("\n ...%s is deleted",s);}}
        else printf("\nString is not present  in hash table");
        return t1;
        }
/* show function that show present value of the hash table */
void showdata(table *t1){
     int i=0;
     float t=(float)(t1->n)/(t1->s);
     printf("\n load factor %f  n=%d s=%d",t,t1->n,t1->s);
     printf("\nALL string in hash table\n");
     for(i=0;i<t1->s;i++){
       printf("%s",(t1->data)[i]);
       printf("\n");}
}


int main(){
   t1 = (table *)malloc(sizeof(table));
   t1=init(t1);
   int i=8,seh=4;
   char s[8];
   printf("\n0 or negative value for exit  \n1 for insert \n2 for search \n3 for delete \n4 for show record in array\n:");
   scanf("%d",&i);
   while(i>0){
   if(i==1){
    scanf("%s",s);
    t1=insert(t1,s);}
   if(i==2){
    scanf("%s",s);
    seh=search(t1,s);}
   if(seh==0){
      printf("\n not present");
      seh=8;}
    else if(seh ==1){
      printf("yes present");
      seh=8;}
   if(i==4)
      showdata(t1);
   if(i==3){
    scanf("%s",s);
    delet(t1,s);}
   printf("\nenter value for i:");
   printf("\n0 or negative value for exit  \n1 for insert \n2 for search \n3 for delete \n4 show record in array\n:");
   scanf("%d",&i);
   }
   }
