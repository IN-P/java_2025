//package com.company.java010_ex;
//
//class Sawon3{ 
//	int pay=10000; //인스턴스변수
//    static int su=10; //클래스변수
//     
//    static int basicpay=pay; //클래스변수
//    
//    static int basicpay2; //클래스변수    
//    
//    public static void showSu() {   System.out.println(su);  }          
//    public static void showPay() {   System.out.println(this.pay);  }    
//  
//    public  void  showAll001() {   
//       System.out.println(su);  
//       System.out.println(this.pay);  
//    } 
//    public static  void  showAll002() {   
//       showAll001();    
//       System.out.println(this.pay);
//    } 
//} 
//
//public class StaticEx003{
//  public static void main(String[] args) {
//   Sawon3   sola = new Sawon3();  
//   sola.showAll001();
//  }
//}
//static 은 파일이 실행과 동시에 메모리상으로 올라가기 때문에 
//나중에 생기는 인스턴스를 담을 수 가 없다.