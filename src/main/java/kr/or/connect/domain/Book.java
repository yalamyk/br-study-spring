package kr.or.connect.domain;
//book 테이블의 컬럼과 동일한 속성을 가지는 Book 클래스를 만든다.
public class Book {
	private Integer id;
	private String author;
	private String title;
	private Integer pages;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", pages=" + pages + "]";
	}
	public Book(){}
	public Book(String title, String author, Integer pages){
		this.title=title;
		this.author=author;
		this.pages=pages;
	}
}
