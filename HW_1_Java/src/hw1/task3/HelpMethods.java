package main.task3;

import java.util.ArrayList;
import java.util.List;

public class HelpMethods {

    public List<Book> requestByAuthor (List<Book> baseList, String author) {
        List<Book> newListAuthor = new ArrayList<Book>();

        for (Book bookItem : baseList ) {
            if (bookItem.getAuthor().compareTo(author) == 0) {
                newListAuthor.add(bookItem);
            }
        }
        return newListAuthor;
    }

    public List<Book> requestByPattern (List<Book> baseList, String pattern) {
        List<Book> newListPattern = new ArrayList<Book>();

        for (Book bookItem : baseList ) {
            if (bookItem.getName().indexOf(pattern) >= 0) {
                newListPattern.add(bookItem);
            }
        }
        return newListPattern;
    }

    public List<Book> requestByYear (List<Book> baseList, String[] yearPeriod) {
        List<Book> newListYear = new ArrayList<Book>();

        int [] year = getSortYear(yearPeriod);

        for (Book bookItem : baseList ) {
            if ((!bookItem.getYear().isEmpty())
                    && (Integer.parseInt(bookItem.getYear()) >= year[0])
                    && (Integer.parseInt(bookItem.getYear()) <= year[1])) {
                newListYear.add(bookItem);
            }
        }
        return newListYear;
    }

    public int[] getSortYear (String[] year){
        int year1;
        int year2;
        year1 = (Integer.parseInt(year[0]) < Integer.parseInt(year[1])) ? Integer.parseInt(year[0]) :
                Integer.parseInt(year[1]);
        year2 = (Integer.parseInt(year[0]) == year1) ? Integer.parseInt(year[1]) : Integer.parseInt(year[0]);
        return new int[] {year1, year2};
    }

    public void toPrint(List<Book> toPrn, String str) {
        System.out.println(str);
        for (Book bookItem : toPrn) {
            System.out.println(bookItem);
        }
    }
}
