package com.test.team;
import java.util.Enumeration;
import java.util.Properties;
 
/**
* FileName : ShowSystemInfo.java
* Comment  : static Properties getProperties(), static String getProperty(String key) 
*          : 현재 시스템 정보를 알아낼 때 사용
*/
public class ShowSystemInfo {
    public static void main(String arr[]){
 
        /*
         * java.runtime.name     : 자바 실행환경(JRE)의 이름
         * java.runtime.version  : 자바 실행환경의 버전
         * java.vm.version       : 자바 VM의 버전
         * os.name               : 운영체제의 이름
         * java.class.path       : 환경변수 CLASSPATH에 지정된 경로명
         * user.language         : 사용 언어
         * sun.cpu.isalist       : CPU 종류 
        */       
        String attr = "java.runtime.version";
        System.out.println(attr + "=" + System.getProperty(attr));
         
        // 시스템의 추출 가능한 모든 속성 정보를 출력
        Properties prop = System.getProperties();
        Enumeration enums = prop.propertyNames();
        String key;
        while(enums.hasMoreElements()){
            key = (String)enums.nextElement();
            System.out.println(key + "=" + System.getProperty(key));
        }
    }
}
