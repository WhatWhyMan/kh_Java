package kh.lclass.openapi.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kh.lclass.openapi.model.vo.EvInfoVo;

public class EvInfoService extends Thread {
	List<EvInfoVo> evInfoList = new ArrayList<EvInfoVo>();

	@Override
	public void run() {
		int failCnt = 3; // 3회 재시도시에도 실패되면 더이상 data 읽어오지 않도록위함.
		for (int i = 0; i < 1; i++) {
			BufferedReader rd = null;
			HttpURLConnection conn = null;
			StringBuilder sb = null;
			try {
				String serviceKey = "aWAbcz0ZPb4TlCJSDJLTWVk9ENcyhCElbIEdKNK%2FrWSvwL1zDLb48IqBScpwx9mqPyxgsSq%2BN6YlaEmskpuRPA%3D%3D";
				StringBuilder urlBuilder = new StringBuilder(
						"http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /* URL */
				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
						+ URLEncoder.encode(String.valueOf(i + 1))); /* 페이지번호 */
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
						+ URLEncoder.encode("5", "UTF-8")); /* 한 페이지 결과 수 */
				// urlBuilder.append("&" + URLEncoder.encode("addr", "UTF-8") + "=" +
				// URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /* 검색대상 충전소주소 */
				// System.out.println(urlBuilder);
				URL url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				System.out.println("Response code: " + conn.getResponseCode());

				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				
				// TODO sb 안에 100개의 데이터가 들어있음. xml형태로 들어있음. ---> EvInfoVo 형태로 바꿔서 evInfoList.add..
			Document doc = parseXML(conn.getInputStream());
			// a. item 태그객체 목록으로 가져온다.
			NodeList descNodes = doc.getElementsByTagName("item");
			// c. 각 item 태그의 자식태그에서 정보 가져오기
			for(int J=0; J<descNodes.getLength(); J++) {
				EvInfoVo vo = new EvInfoVo();

				// item
				Node item = descNodes.item(J);
				// item 자식태그에 순차적으로 접근
				for(Node node=item.getFirstChild(); // 초기식
						node!=null;					// 조건식 T/F
						node=node.getNextSibling() 	// 증감식 
						// 첫번째 자식을 시작으로 마지막까지 다음 형제를 실행
					) {
					System.out.println(node.getNodeName() + ":" + node.getTextContent());
					switch(node.getNodeName()) {
					case "chargeTP" :
						try {
						vo.setChargeTp(Integer.parseInt(node.getTextContent()));
						} catch (NumberFormatException e) {
						}
						break;
					case "cpId":
						vo.setCpId(node.getTextContent());
					case "cpNm":
						vo.setCpId(node.getTextContent());
					case "csNm":
						vo.setCpId(node.getTextContent());
						break;
					// TODO
					}
				}	// item 자식 node을 for
				evInfoList.add(vo);
			}		// item 개수만큼 for
			// TODO: File에 저장.
			System.out.println(evInfoList);
			
			} catch (IOException e) {
				// 오류발생
				if (failCnt == 0) {
					break;
				}
				failCnt--;
				i--;
				e.printStackTrace();
			} finally {
				try {
					if (rd != null)
						rd.close();
					if (conn != null)
						conn.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// System.out.println(sb.toString());

		} // for
	} // thread method run()

	private Document parseXML(InputStream stream) {
		// Factory Pattern
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;

		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
} // class
