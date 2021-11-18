package main.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3Stream {

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

        String patternAuthor = "MainAuthor";
        List<Book> requestAuthor = listBook.stream()
                .filter(item -> item.getAuthor().equalsIgnoreCase(patternAuthor))
                .collect(Collectors.toList());
        help.toPrint(requestAuthor, "\nRequest by author{" + patternAuthor + "}:");

        String pattern = "Java";
        List<Book> requestPattern = listBook.stream()
                .filter(item -> item.getName().indexOf(pattern) >= 0)
                .collect(Collectors.toList());
        help.toPrint(requestPattern, "\nRequest by pattern {" + pattern + "}:");

        String[] patternYearPeriod = {"1980", "2000"};
        int[] year = help.getSortYear(patternYearPeriod);
        List<Book> requestYear = listBook.stream()
                .filter(item -> !item.getYear().isEmpty()
                        && (Integer.parseInt(item.getYear()) >= year[0])
                        && (Integer.parseInt(item.getYear()) <= year[1]))
                .collect(Collectors.toList());
        help.toPrint(requestYear, "\nRequest by year {" + year[0] + "-" + year[1] + "}:");
    }

}

