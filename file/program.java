  public class Gu{
 
   public static void main(String[]args){
   System.out.println("Hi");
     method8();method9(); method1(); method2();
     method6();m3ethod();myMethod();  m2ethod();
     method(); m1ethod(); method5();  m4ethod();
     method7();method3();
     }
      

     public static void method3(){
      String str="Guddan is a Student";
      int count=0;
      char ch[]=str.toCharArray();
      for(int i=0;i<str.length();i++){
      count=1;
      for(int j=i+1;j<str.length();j++){
      if(ch[i]==ch[j] && ch[i]!=' '){
      count++;
      ch[j]='@';
      }
      }
      if(count>1 && ch[i]!='@'){
      System.out.println(ch[i] +" "+"is repeted"+" "+count +"time");
      }
      }
      }       
     public static void method2(){
     int a=543;
     int b=0;
     int c=0;
     while(a!=0){
     b=a%10;
     a=a/10;
     c=c*10+b;
    }
    System.out.println(c);
    }
     
     public static void method1(){
     int []a={2,4,5,7,8,9,8};
     int sum=0;
     for(int i=0;i<a.length;i++){
     sum=a[i]+sum;
     }
    System.out.println(sum);
    }
     public static void method9(){
     int []a={2,4,5,7,8,9,8};
     int min=a[0];
     for(int i=0;i<a.length;i++){
     if(a[i]<min){
     min=a[i];
    }
    }
     System.out.println(min +"smallest element");
    }
   
      public static void method8(){
     int[]a={2,4,5,6,8};
     int max=a[0];
     for(int i=1;i<a.length;i++){
     if(max<a[i]){
     max=a[i];
     }
    }
    System.out.println("max element"+ max);
    }
     
     public static void method7(){
    for(char i='A';i<'Z';i++){
     System.out.print(i);
    }
    }
     public static void method6(){  
     String str="Sunita Love India";
     int count=0;
     for(int i=0;i<str.length()-1;i++){
     char ch= str.charAt(i);
     if(ch!=' '){
     count++;
     }
     }
     System.out.println("It is count Charecter"+" "+ count);
      }

     public static void method5(){   
     String str="Sunita Love India";
     int count=1;
     for(int i=0;i<str.length()-1;i++){
     char ch= str.charAt(i);
     if(ch==' '){
     count++;
     }
     }
     System.out.println("It is count Word"+" "+ count);
      }

     public static void m4ethod(){
    String str ="Madam";
    String temp=" ";
    for(int i=str.length()-1;i>=0;i--){
    temp=temp+str.charAt(i);
    }
    if(temp.equalsIgnoreCase(str)){
    System.out.println("It is palindrom");
    }else{
    System.out.println("It is not palindrom");
    }

   }
    public static void m2ethod(){
    String str ="Sunita love India";
    for(int i =str.length()-1;i>=0;i--){
    System.out.print(str.charAt(i));
     
     }
     }
      public static void m3ethod(){
      String str="Sunita";
      String rev="yadav";
      System.out.println(str+" "+rev);
      }

    public static void m1ethod(){
    String str ="Sunita love India";
    String []arr=str.split(" ");
    for(int i =arr.length-1;i>=0;i--){
    System.out.print(arr[i]+" ");
   
    }
    }

   public static void method(){
  System.out.println();
   int a=15;
   int temp=0;
   for(int i=2;i<a;i++){
   if(i%a==0){
   temp=temp++;
   }
   }if(temp>0){
   System.out.println("It is not prime");
   }else{
    System.out.println("It is prime");
   }
    
   }

   public static void myMethod(){
   int a=15;
   if(a%2==0){
   System.out.println("It is Even");
   }else{
   System.out.println("It is odd");
   }
   }
  
   }