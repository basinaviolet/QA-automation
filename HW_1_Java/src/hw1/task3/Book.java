package main.task3;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

	private int id;
	private String name;
	private String author;
	private String year;
	private int pageCount;
	private int price;
	private String coverType;

	public Book(int id, String name, String author, String year, int pageCount, int price, String coverType) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.year = year;
		this.pageCount = pageCount;
		this.price = price;
		this.coverType = coverType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		if ((year.matches("[0-9]+"))
				&& (Integer.parseInt(year) >= 1517)
				&& (Integer.parseInt(year) <= LocalDate.now().getYear())) {
			this.year = year;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		if (pageCount >= 0) {
			this.pageCount = pageCount;
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}
	}

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getAuthor(), getYear(), getPageCount(), getPrice(), getCoverType());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (price != other.price)
			return false;
		if (coverType == null) {
			if (other.coverType != null)
				return false;
		} else if (!coverType.equals(other.coverType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{id: " + this.id
				+ "; name: " + this.name
				+ "; author: " + this.author
				+ "; year: " + this.year
				+ "; pages: " + this.pageCount
				+ "; price: " + this.price
				+ "; cover: " + this.coverType;
	}
}
