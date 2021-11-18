package main.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

	public static void main(String[] args) {
			List<Book> listBook = new ArrayList<Book>();

			HelpMethods help = new HelpMethods();
			int id = 1000;

			listBook.add(new Book(id++, "Programming on Java", "MainAuthor", "2014", 300, 400, "softcover"));
			listBook.add(new Book(id++, "C++", "MainAuthor", "1978", 125, 200, "hardcover"));
			listBook.add(new Book(id++, "Python", "SecondAuthor", "2015", 129, 50, "softcover"));
			listBook.add(new Book(id++, "MS Office", "SecondAuthor", "1990", 234, 150, "hardcover"));
			listBook.add(new Book(id++, "Java", "SecondAuthor", "2020", 333, 500, "hardcover"));
			listBook.add(new Book(id++, "MS Office", "SecondAuthor", "1986", 50, 100, "softcover"));
			listBook.add(new Book(id++, "Head for Java", "MainAuthor", "2010", 432, 5000, "hardcover"));
			listBook.add(new Book(id++, "Java. Base course", "MainAuthor", "2009", 89, 250, "softcover"));
			listBook.add(new Book(id++, "Java code", "MainAuthor", "2017", 12, 5, "hardcover"));
			listBook.add(new Book(id++, "Java fundamentals", "SecondAuthor", "2020", 345, 0, "softcover"));
			listBook.add(new Book(id++, "Java Basics", "MainAuthor", "2019", 76, 20, "softcover"));
			listBook.add(new Book(id++, "Java", "ThirdAuthor", "2018", 84, 550, "hardcover"));
			listBook.add(new Book(id++, "PHP", "SecondAuthor", "2009", 23, 30, "softcover"));
			listBook.add(new Book(id++, "Java", "MainAuthor", "2005", 400, 500, "softcover"));
			listBook.add(new Book(id++, "Java", "SecondAuthor", "2020", 2, 1, "hardcover"));

			String author = "MainAuthor";
			List<Book> requestAuthor = new ArrayList<Book>();
			requestAuthor = help.requestByAuthor(listBook, author);
			help.toPrint(requestAuthor, "\nRequest by author{" + author + "}:");

			String pattern = "Java";
			List<Book> requestPattern = new ArrayList<Book>();
			requestPattern = help.requestByPattern(listBook, pattern);
			help.toPrint(requestPattern, "\nRequest by pattern {" + pattern  + "}:");

			String[] year = {"1980", "2000"};
			List<Book> requestYear = new ArrayList<Book>();
			requestYear = help.requestByYear(listBook, year);
			help.toPrint(requestYear, "\nRequest by year {" + year[0] + "-" + year[1] + "}:");
		}

	}

