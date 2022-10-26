package kr.or.ddit.basic.homework;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Apt {

	public void parse() throws Exception {
		
		String serviceKey = "JTpWDYFZS7u8AmLXQMOhVuqZlifrhgH3cRVd3TFMS%2F5nbdB6vETWKc89Z2GaffqsdMfGRXULro%2F5tiq7SVWdzg%3D%3D";
		
//		URL url = new URL("http://apis.data.go.kr/6410000/GOA/GOA001?ServiceKey=서비스키&type=json&numOfRows=10&pageNo=1");
		URL url = new URL("http://apis.data.go.kr/6410000/GOA/GOA001?ServiceKey="+serviceKey+"&type=json&numOfRows=10&pageNo=1");

		System.out.println(url.toString());

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse(url.toString());
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명 : " + root.getTagName());
		System.out.println(root.toString());
		
		
		// 전체 레시피 수를 가져오기
//		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();
//		endIdx = totalCnt;
//
//		url = new URL("http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/" + endIdx
//				+ "?RECIPE_ID=" + recipeId);
//
//		document = builder.parse(url.toString());
//
//		root = document.getDocumentElement();
//
//		String code = root.getElementsByTagName("code").item(0).getTextContent();
//
//		if (code.equals("INFO-000")) { // 정상 상태인 경우...
//
//			NodeList rowNodeList = root.getElementsByTagName("row"); // row or itm
//
//			for (int i = 0; i < rowNodeList.getLength(); i++) {
//
//				Element element = (Element) rowNodeList.item(i);
//
//				String rowNum = element.getElementsByTagName("ROW_NUM").item(0).getTextContent();
//				String irdntNm = element.getElementsByTagName("IRDNT_NM").item(0).getTextContent();
//				String irdntCpcty = element.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent();
//				String irdntTyNm = element.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent();
//
//				System.out.printf("%3s\t%8s\t%10s\t%10s\t%8s\n", rowNum, recipeId, irdntTyNm, irdntNm, irdntCpcty);
//				System.out.println("-----------------------------------------------------------------------");
//			}
//		}
	}

	public static void main(String[] args) throws Exception {
		new Apt().parse();
	}
}
