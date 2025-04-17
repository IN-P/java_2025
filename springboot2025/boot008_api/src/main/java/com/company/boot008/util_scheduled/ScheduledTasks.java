//package com.company.boot008.util_scheduled;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ScheduledTasks {
//	@Scheduled(fixedRate = 5000) //5초마다실행
//	public void runTask1() {
//		System.out.println("스케쥴러 실행중 : "+System.currentTimeMillis());
//	}
//	@Scheduled(cron="0 0 10 * * ?") //매일자정
//	public void runTset2() {
//		System.out.println("스케쥴러 실행중 : --"+System.currentTimeMillis());
//	}
//	
//}
/*
1. @Scheduled
   fixedRate = 5000 5초마다 실행
   fixedDelay       어떤 작업이 끝난 후 지정된 시간에 실행
   cron          크론 표현식
      cron = "0 0 0 * * ?" 초 분 시 날짜 월 요일
      cron = "0 0 12 * * ?" 매일 정오
      cron = "0 30 18 * * ?" 매일 오후 6시 30분
      cron = "0 0 0 1 * ?" 매월 1일 자정    
      cron = "0 0 0 ? * MON" 매주 월요일 자정
      
      * 제한없는 모든값
      ? 특정값 없음(대신 다른필드를 기준으로 실행)
      
      @SpringBootApplication 구동시키기
	@EnableScheduling
	public class Boot008Application {
*/