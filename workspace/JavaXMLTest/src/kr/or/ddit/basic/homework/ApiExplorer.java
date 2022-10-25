package kr.or.ddit.basic.homework;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

http://openapi.epost.go.kr/postal/retrieveLotNumberAdressAreaCdService/retrieveLotNumberAdressAreaCdService/getComplexListAreaCd
	?serviceKey=JTpWDYFZS7u8AmLXQMOhVuqZlifrhgH3cRVd3TFMS%2F5nbdB6vETWKc89Z2GaffqsdMfGRXULro%2F5tiq7SVWdzg%3D%3D
	&currentPage=1&areaNm=%EB%B9%9B%EA%B0%80%EB%9E%8C%EB%8F%99&searchSe=and&srchwrd=%EC%98%81%EB%AC%B4&countPerPage=10



public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.epost.go.kr/postal/retrieveLotNumberAdressAreaCdService/retrieveLotNumberAdressAreaCdService/getDetailListAreaCd"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "JTpWDYFZS7u8AmLXQMOhVuqZlifrhgH3cRVd3TFMS%2F5nbdB6vETWKc89Z2GaffqsdMfGRXULro%2F5tiq7SVWdzg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("searchSe","UTF-8") + "=" + URLEncoder.encode("dong", "UTF-8")); /*dong : 동(읍/면)명/아파트/건물명post : 우편번호sido : 시/군/구*/
        urlBuilder.append("&" + URLEncoder.encode("srchwrd","UTF-8") + "=" + URLEncoder.encode("빛가람동", "UTF-8")); /*검색어*/
        urlBuilder.append("&" + URLEncoder.encode("countPerPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지당 출력될 개수를 지정*/
        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*출력될 페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}