package ru.filters;

import org.springframework.stereotype.Component;
import ru.entities.Book;
import ru.enums.RestrictionAlready;
import ru.enums.RestrictionSearch;
import ru.enums.RestrictionYear;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruslan on 14.10.17.
 */
@Component
public class SearchFilter {
    private String searchString = "";
    private RestrictionYear restrictionYear = RestrictionYear.ALL;
    private RestrictionAlready restrictionAlready = RestrictionAlready.ALL;
    private String year = "";
    private RestrictionSearch restrictionSearch = RestrictionSearch.TITLE;
    private int bookOnPage = 10;
    private int first;
    private int last;
    private Map<RestrictionSearch, String> restrictionSearchMap;
    private Map<RestrictionYear, String> restrictionYearMap;
    private Map<RestrictionAlready, String> restrictionAlreadyMap;
    private Book editBook;
    private int totalBook;
    private boolean showPrew;
    private boolean showNext;

    public boolean isShowPrev() {
        return first >= bookOnPage;
    }

    public boolean isShowNext() {
        return first + bookOnPage < totalBook;
    }

    public Book getEditBook() {
        return editBook;
    }

    public void setEditBook(Book editBook) {
        this.editBook = editBook;
    }

    public Map<RestrictionAlready, String> getRestrictionAlreadyMap() {
        if (restrictionAlreadyMap == null) {
            restrictionAlreadyMap = new HashMap<>();
            restrictionAlreadyMap.put(RestrictionAlready.ALL, "Все");
            restrictionAlreadyMap.put(RestrictionAlready.IS_ALREADY, "Прочитанные");
            restrictionAlreadyMap.put(RestrictionAlready.NOT_ALREADY, "Не прочитанные");
        }
        return restrictionAlreadyMap;
    }

    public Map<RestrictionYear, String> getRestrictionYearMap() {
        if (restrictionYearMap == null) {
            restrictionYearMap = new HashMap<>();
            restrictionYearMap.put(RestrictionYear.ALL, "Все");
            restrictionYearMap.put(RestrictionYear.GE, "От");
            restrictionYearMap.put(RestrictionYear.LE, "До");
        }
        return restrictionYearMap;
    }

    public Map<RestrictionSearch, String> getRestrictionSearchMap() {
        if (restrictionSearchMap == null) {
            restrictionSearchMap = new HashMap<>();
            restrictionSearchMap.put(RestrictionSearch.TITLE, "Название");
            restrictionSearchMap.put(RestrictionSearch.AUTHOR, "Автор");
        }
        return restrictionSearchMap;
    }

    public RestrictionAlready getRestrictionAlready() {
        return restrictionAlready;
    }

    public void setRestrictionAlready(RestrictionAlready restrictionAlready) {
        this.restrictionAlready = restrictionAlready;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public RestrictionYear getRestrictionYear() {
        return restrictionYear;
    }

    public void setRestrictionYear(RestrictionYear restrictionYear) {
        this.restrictionYear = restrictionYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public RestrictionSearch getRestrictionSearch() {
        return restrictionSearch;
    }

    public void setRestrictionSearch(RestrictionSearch restrictionSearch) {
        this.restrictionSearch = restrictionSearch;
    }

    public int getBookOnPage() {
        return bookOnPage;
    }

    public void setBookOnPage(int bookOnPage) {
        this.bookOnPage = bookOnPage;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        last = first + bookOnPage;
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }
}
