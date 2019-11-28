package kr.or.ddit.basic;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class T18_PagingController implements Initializable{

	@FXML
	private TableColumn<T18_MemberVO, String> id;
	@FXML
	private TableColumn<T18_MemberVO, String> name;
	@FXML
	private TableColumn<T18_MemberVO, String> address;
	@FXML
	private Pagination pagination;
	@FXML
	private TableView<T18_MemberVO> tableView;
	
	private int from, to, itemsForPage;
	// itemsForPage: 한 페이지에 몇개까지 출력을 할지
	private ObservableList<T18_MemberVO> allTableData, currentPageData;
	
	/* Initializable로 인터페이스를 받아서 해도 되고 이렇게 해도 된다.
	@FXML
	public void initialize() {	
		
	}
	*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 필요한 객체가 다 주입이 됐으니 아래에서 로직을 짜주면 된다.
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		// 전체 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList();
		
		allTableData.add(new T18_MemberVO("1", "홍길동1", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("2", "홍길동2", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("3", "홍길동3", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("4", "홍길동4", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("5", "홍길동5", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("6", "홍길동6", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("7", "홍길동7", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("8", "홍길동8", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("9", "홍길동9", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("10", "홍길동10", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("11", "홍길동11", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("12", "홍길동12", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("13", "홍길동13", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("14", "홍길동14", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("15", "홍길동15", "대전시 중구 대흥동"));
		allTableData.add(new T18_MemberVO("16", "홍길동16", "대전시 중구 대흥동"));
		
//		tableView.setItems(allTableData);
		
		itemsForPage = 5;	// 한 페이지에 보여줄 항목수 설정
		
		int totPageCount
		= allTableData.size() % itemsForPage == 0 ? allTableData.size() / itemsForPage : allTableData.size() / itemsForPage + 1;
			// 몇 페이지 필요한지 계산
			// 몇 개씩 보여줄 건지?(이게 0이 맞나?) / 0이 맞으면 페이지는 그대로 / 0이 아니면 짜투리가 필요하니까 다음 페이지로 넘어가게끔 + 1을 해준다. 
		
		pagination.setPageCount(totPageCount);
			// 페이징이 몇 장으로 넘어갈건지 세팅해주는 부분
		
		// 방법1(Callback타입의 익명객체 생성)
		pagination.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * itemsForPage;
				to = from + itemsForPage - 1;
				tableView.setItems(getTableViewData(from, to));
				
				return tableView;
			}
		});
		
	}
	
	/**
	 * TableView에 채워줄 데이터를 가져오는 메서드
	 * @param from
	 * @param to
	 * @return
	 */
	private ObservableList<T18_MemberVO> getTableViewData(int from, int to){
			// from과 to 사이는 5씩 차이. 1부터 5까지, 6부터 10까지.
		
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i = from; i <= to && i < totSize; i++) {		// totSize: 끝이 5가 아닐 때, 전체 사이즈만큼만 돌고 끝날 수 있도록
			currentPageData.add(allTableData.get(i));
		}
		
		return currentPageData;
		
	}
	
	
	

}


























