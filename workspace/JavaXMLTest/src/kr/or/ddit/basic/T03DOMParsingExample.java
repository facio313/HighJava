package kr.or.ddit.basic;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML DOM을 이용한 XML문서 파싱 예제(레시피 정보 조회 API)
 * 
 * @author PC-08
 *
 */
public class T03DOMParsingExample {

	public void parse() throws Exception {
		
		String svcKey = "Grid_20150827000000000227_1";  // 레시피 재료 정보 조회 서비스
  		String apiKey = "1df7e8571e8df3f8cbc9b87691ca7d3e4d04f03c593d477e52bf67b03f0b6e1c"; // 개인별 발급.
  		String startIdx = "1";  	// 레시피 재료 시작 순번
  		String endIdx = "5";		// 레시피 재료 종료 순번
  		String recipeId = "149";	// 래시피가 궁금한 음식 ID

  		URL url = new URL("http://211.237.50.150:7080/openapi/"+ apiKey
  				+ "/xml/"+ svcKey + "/"+startIdx +"/" + endIdx
  				+"?RECIPE_ID=" +  recipeId);
  		
  		System.out.println(url.toString());
  		
  		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  		DocumentBuilder builder = dbf.newDocumentBuilder();
  		Document document = builder.parse(url.toString());
  		Element root = document.getDocumentElement();
  		System.out.println("루트엘리먼트 태그명 : " + root.getTagName());
  		
  		// 전체 레시피 수를 가져오기
  		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();
  		endIdx = totalCnt;
  		
  		url = new URL("http://211.237.50.150:7080/openapi/"+ apiKey
  				+ "/xml/"+ svcKey + "/"+startIdx +"/" + endIdx
  				+"?RECIPE_ID=" +  recipeId);
  		
  		document = builder.parse(url.toString());
  		
  		root = document.getDocumentElement();
  		
  		String code = root.getElementsByTagName("code").item(0).getTextContent();
  		
  		if (code.equals("INFO-000")) { // 정상 상태인 경우...
  			
  			NodeList rowNodeList = root.getElementsByTagName("row");
  			
  			for (int i = 0; i < rowNodeList.getLength(); i++) {
  				
  				Element element = (Element) rowNodeList.item(i);
  				
  				String rowNum = element.getElementsByTagName("ROW_NUM").item(0).getTextContent();
  				String irdntNm = element.getElementsByTagName("IRDNT_NM").item(0).getTextContent();
  				String irdntCpcty = element.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent();
  				String irdntTyNm = element.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent();
  				
  				System.out.printf("%3s\t%8s\t%10s\t%10s\t%8s\n", rowNum, recipeId, irdntTyNm, irdntNm, irdntCpcty);
  				System.out.println("-----------------------------------------------------------------------");
  			}
  		}
  	}

	public static void main(String[] args) throws Exception {
		new T03DOMParsingExample().parse();
	}
}
