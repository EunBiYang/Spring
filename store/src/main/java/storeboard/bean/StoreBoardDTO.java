package storeboard.bean;

public class StoreBoardDTO {
	 private int seq;                 // 글번호
	 private String storeName;        // 가게명
	 private String storePlace;       // 가게위치
	 private int storeNum;            // 가게 전화번호
	 private String storeContent;     // 가게소개
	 private String storeCategory;     // 가게소개
	 private String image1;           // 이미지이름
	 private String logtime;          // 작성일
	 
	 //검색
	 private String searchGubun;
	 private String searchText;
	 
	 
	public String getSearchGubun() {
		return searchGubun;
	}
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePlace() {
		return storePlace;
	}
	public void setStorePlace(String storePlace) {
		this.storePlace = storePlace;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public String getStoreContent() {
		return storeContent;
	}
	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	 
}
