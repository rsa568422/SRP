package srp.refactored;

import lombok.Getter;

import java.util.List;

@Getter
public class Book {

    public static final String BOOK_DIRECTORY_PATH = "/tmp";

    private String title;

    private String author;

    private List<Page> pages;

    private Page currentPage;

    public Book(String title, String author, List<Page> pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.currentPage = pages.get(0);
    }

    public void turnPage() {
        Integer nextPageIndex = this.currentPage.getNumber();
        if (nextPageIndex <= pages.size()) {
            this.currentPage = this.pages.get(nextPageIndex);
        }
    }

    public void turnPageBack() {
        Integer previousPageIndex = this.currentPage.getNumber() - 2;
        if (previousPageIndex >= 0) {
            this.currentPage = this.pages.get(previousPageIndex);
        }
    }

}
