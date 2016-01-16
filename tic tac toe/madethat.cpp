#include<stdio.h>
#include<conio.h>
#include<iostream.h>
#include<stdlib.h>
class tic
{
public:
void playertwo();
void playerone();
};
void tic::playertwo()//2 playes game starts
{
int i,j,k,p=0;
char a[4][4];
for(i=1;i<=4;i++)
{
for(j=1;j<=4;j++)
{
if(i==4||j==4)
{
a[i][j]='e';
}
else
{
a[i][j]='*';
}
}
}
cout<<"enter the co-ordinates as per the given sequence\n\n";
cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j]<<"("<<i<<","<<j<<")";
cout<<" ";
}
cout<<"\n\n\t";
}
for(k=1;k<=5;k++)
{
 cout<<"\nplayer-1 enter x and y co ordinates\n";
 cin>>i>>j;
 if(a[i][j]=='*')
 {
  a[i][j]='x';
 }
 else
 {
 cout<<"invalid entry,please re enter it";
 cout<<"\nplayer-1 enter x and y co ordinates\n";
 cin>>i>>j;
 if(a[i][j]=='*')
  {
   a[i][j]='x';
  }
 }
cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j];
cout<<" ";
}
cout<<"\n\n\t";
}
 if(a[1][1]=='x'&&a[1][2]=='x'&&a[1][3]=='x'||a[2][1]=='x'&&a[2][2]=='x'&&a[2][3]=='x'||a[3][1]=='x'&&a[3][2]=='x'&&a[3][3]=='x'||a[1][1]=='x'&&a[2][1]=='x'&&a[3][1]=='x'||a[1][2]=='x'&&a[2][2]=='x'&&a[3][2]=='x'||a[1][3]=='x'&&a[2][3]=='x'&&a[3][3]=='x'||a[1][1]=='x'&&a[2][2]=='x'&&a[3][3]=='x'||a[1][3]=='x'&&a[2][2]=='x'&&a[3][1]=='x')
 {
 cout<<"\t***player 1 wins***\n\n";
 break;
 }


if(p!=4)
{
  cout<<"\nplayer-2 enter x and y co ordinates\n";
  cin>>i>>j;
  if(a[i][j]=='*')
   {
    a[i][j]='o';
   }
  else
   {
    cout<<"invalid entry,please re enter it";
    cout<<"\nplayer-2 enter x and y co ordinates\n";
    cin>>i>>j;
    if(a[i][j]=='*')
    {
     a[i][j]='o';
    }
   }
cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j];
cout<<" ";
}
cout<<"\n\n\t";
}
  cout<<"\n";
  if(a[1][1]=='o'&&a[1][2]=='o'&&a[1][3]=='o'||a[2][1]=='o'&&a[2][2]=='o'&&a[2][3]=='o'||a[3][1]=='o'&&a[3][2]=='o'&&a[3][3]=='o'||a[1][1]=='o'&&a[2][1]=='o'&&a[3][1]=='o'||a[1][2]=='o'&&a[2][2]=='o'&&a[3][2]=='o'||a[1][3]=='o'&&a[2][3]=='o'&&a[3][3]=='o'||a[1][1]=='o'&&a[2][2]=='o'&&a[3][3]=='o'||a[1][3]=='o'&&a[2][2]=='o'&&a[3][1]=='o')
   {
    cout<<"\t***player 2 wins***\n\n";
    break;
   }
}
else
{
cout<<"\tgame draw\n";
}
p++;

}
}//2playes game ends


void tic::playerone()//1 playes game starts
{
int i,j,k,p=0,t=0;
char a[4][4];
for(i=1;i<=4;i++)
{
for(j=1;j<=4;j++)
{
if(i==4||j==4)
{
a[i][j]='e';
}
else
{
a[i][j]='*';
}
}
}
cout<<"enter the co-ordinates as per the given sequence\n\n";
cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j]<<"("<<i<<","<<j<<")";
cout<<" ";
}
cout<<"\n\n\t";
}
for(k=1;k<=5;k++)
{
 cout<<"\nplayer-1 enter x and y co ordinates\n";
 cin>>i>>j;
 if(a[i][j]=='*')
 {
  a[i][j]='x';
 }
 else
 {
 cout<<"invalid entry,please re enter it";
 cout<<"\nplayer-1 enter x and y co ordinates\n";
 cin>>i>>j;
 if(a[i][j]=='*')
  {
   a[i][j]='x';
  }
 }
 cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j];
cout<<" ";
}
cout<<"\n\n\t";
}
 if(a[1][1]=='x'&&a[1][2]=='x'&&a[1][3]=='x'||a[2][1]=='x'&&a[2][2]=='x'&&a[2][3]=='x'||a[3][1]=='x'&&a[3][2]=='x'&&a[3][3]=='x'||a[1][1]=='x'&&a[2][1]=='x'&&a[3][1]=='x'||a[1][2]=='x'&&a[2][2]=='x'&&a[3][2]=='x'||a[1][3]=='x'&&a[2][3]=='x'&&a[3][3]=='x'||a[1][1]=='x'&&a[2][2]=='x'&&a[3][3]=='x'||a[1][3]=='x'&&a[2][2]=='x'&&a[3][1]=='x')
 {
 cout<<"\t***player 1 wins***\n\n";
 break;
 }


if(p!=4)
{
 t=2;
 for(i=1;i<=3;i++)
 {
 if(a[i][1]=='o'&&a[i][2]=='o')
 {
 if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
 {
 }
 else
 {
  t=0;
  a[i][3]='o';
 }
 }
 if(a[i][2]=='o'&&a[i][3]=='o')
 {
 if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
 {
 }
 else
 {
  t=0;
  a[i][1]='o';
 }
 }
 if(a[i][1]=='o'&&a[i][3]=='o')
 {
 if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
 {
 }
 else
 {
  t=0;
  a[i][2]='o';
 }
 }
 }
 if(t!=0)
 {
 for(j=1;i<=3;i++)
 {
  if(a[1][j]=='o'&&a[2][j]=='o')
  {
  if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
  {
  }
 else
 {
   t=0;
   a[3][j]='o';
  }
  }
  if(a[2][j]=='o'&&a[3][j]=='o')
  {
  if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
  {
  }
 else
 {
   t=0;
   a[1][j]='o';
   }
  }
  if(a[1][j]=='o'&&a[3][j]=='o')
  {
  if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
  {
  }
 else
 {
   t=0;
   a[2][j]='o';
  }
  }
  }
  }
if(t!=0)
{

  if(a[1][1]=='o'&&a[2][2]=='o')
  {
  if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
  {
  }
 else
 {
   t=0;
   a[3][3]='o';
   }
  }
  if(a[2][2]=='o'&&a[3][3]=='o')
  {
  if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
  {
  }
 else
 {
   t=0;
   a[1][1]='o';
   }
  }
  if(a[1][1]=='o'&&a[3][3]=='o')
  {
  if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
  {
  }
 else
 {
   t=0;
   a[2][2]='o';
   }
  }
  if(a[1][3]=='o'&&a[2][2]=='o')
  {
  if(a[1][3]!='*'&&a[2][2]!='*'&&a[3][1]!='*')
  {
  }
 else
 {
   t=0;
   a[3][1]='o';
   }
  }
  if(a[2][2]=='o'&&a[3][1]=='o')
  {
  if(a[1][3]!='*'&&a[2][2]!='*'&&a[3][1]!='*')
  {
  }
 else
 {
   t=0;
   a[1][3]='o';
   }
  }
  if(a[1][3]=='o'&&a[3][1]=='o')
  {
  if(a[1][3]!='*'&&a[2][2]!='*'&&a[3][1]!='*')
  {
  }
 else
 {
   t=0;
   a[2][2]='o';
   }
  }
}



if(t!=0)
{
 for(i=1;i<=3;i++)
 {
  if(a[i][1]=='x'&&a[i][2]=='x')
  {
  if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
  {
  }
  else
  {
   t=0;
   a[i][3]='o';
  }
  }
  if(a[i][2]=='x'&&a[i][3]=='x')
  {
  if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
  {
  }
 else
 {
   t=0;
   a[i][1]='o';
  }
  }
  if(a[i][1]=='x'&&a[i][3]=='x')
  {
   if(a[i][1]!='*'&&a[i][2]!='*'&&a[i][3]!='*')
   {
   }
   else
   {
   t=0;
   a[i][2]='o';
  }
  }
 }
}
 if(t!=0)
 {            
 for(j=1;j<=3;j++)
 {
  if(a[1][j]=='x'&&a[2][j]=='x')
  {
   if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
   {
   }
   else
   {
   t=0;
   a[3][j]='o';
   }
  }
  if(a[2][j]=='x'&&a[3][j]=='x')
  {
   if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
   {
   }
   else
   {
   t=0;
   a[1][j]='o';
   }
  }
  if(a[1][j]=='x'&&a[3][j]=='x')
  {                          
   if(a[1][j]!='*'&&a[2][j]!='*'&&a[3][j]!='*')
   {
   }
   else
   {
   t=0;
   a[2][j]='o';
   }
  }
 }
 }
 if(t!=0)
 {

  if(a[1][1]=='x'&&a[2][2]=='x')
  {
   if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
   {
   }
 else
 {
   t=0;
   a[3][3]='o';
   }
  }
  if(a[2][2]=='x'&&a[3][3]=='x')
  {
   if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
   {
   }
 else
 {
   t=0;
   a[1][1]='o';
   }
  }
  if(a[1][1]=='x'&&a[3][3]=='x')
  {
   if(a[1][1]!='*'&&a[2][2]!='*'&&a[3][3]!='*')
   {
   }
 else
 {
   t=0;
   a[2][2]='o';
   }
  }
  if(a[1][3]=='x'&&a[2][2]=='x')
  {
   if(a[3][1]!='*'&&a[2][2]!='*'&&a[1][3]!='*')
   {
   }
 else
 {
   t=0;
   a[3][1]='o';
   }
  }
  if(a[2][2]=='x'&&a[3][1]=='x')
  {
  if(a[3][1]!='*'&&a[2][2]!='*'&&a[1][3]!='*')
  {
  }
 else
 {
   t=0;
   a[1][3]='o';
   }
  }
  if(a[1][3]=='x'&&a[3][1]=='x')
  {
  if(a[3][1]!='*'&&a[2][2]!='*'&&a[1][3]!='*')
  {
  }
 else
 {
   t=0;
   a[2][2]='o';
  }
  }
 }



 if(t!=0)
 {
  if(a[2][2]=='*')
  {
  t=1;
  a[2][2]='o';
  }
  else if(a[3][3]=='*')
   {
   t=1;
   a[3][3]='o';
   }

  else if(a[3][1]=='*')
   {
   t=1;
   a[3][1]='o';
   }

  else if(a[1][1]=='*')
   {
   t=1;
   a[1][1]='o';
   }

  else if(a[1][3]=='*')
   {
   t=1;
   a[1][3]='o';
   }

  else if(a[1][2]=='*')
   {
   t=1;
   a[1][2]='o';
   }

  else if(a[2][1]=='*')
   {
   t=1;
   a[2][1]='o';
   }

  else if(a[2][3]=='*')
   {
   t=1;
   a[2][3]='o';
   }

  else if(a[3][2]=='*')
   {
   t=1;
   a[3][2]='o';
   }

 }


  cout<<"\nafter computer entry\n\n";

  cout<<"\t";
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
cout<<a[i][j];
cout<<" ";
}
cout<<"\n\n\t";
}
  cout<<"\n";
  if(a[1][1]=='o'&&a[1][2]=='o'&&a[1][3]=='o'||a[2][1]=='o'&&a[2][2]=='o'&&a[2][3]=='o'||a[3][1]=='o'&&a[3][2]=='o'&&a[3][3]=='o'||a[1][1]=='o'&&a[2][1]=='o'&&a[3][1]=='o'||a[1][2]=='o'&&a[2][2]=='o'&&a[3][2]=='o'||a[1][3]=='o'&&a[2][3]=='o'&&a[3][3]=='o'||a[1][1]=='o'&&a[2][2]=='o'&&a[3][3]=='o'||a[1][3]=='o'&&a[2][2]=='o'&&a[3][1]=='o')
   {
    cout<<"\t***computer wins***\n\n";
    break;
   }
}
else
{
cout<<"game draw\n";
}
p++;

}//for loop
 }//1playes game ends


main()
{
int ch,q=1;
tic k;
while(1)
{
if(q==1)
{
cout<<"select your choice: 1-player vs com\n\t            2-player vs player\n\t            3-exit\n";
cin>>ch;
q++;
}
else
{
cout<<"\n\nwant to play another game??\nselect your choice: 1-player vs com\n\t            2-player vs player\n\t            3-exit\n";
cin>>ch;
}
switch(ch)
{
case 1:k.playerone();
       break;
case 2:k.playertwo();
       break;
case 3:exit(0);
}
}
}

