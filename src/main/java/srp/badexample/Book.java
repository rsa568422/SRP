package srp.badexample;

import lombok.Getter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Book {

    public static final String BOOK_DIRECTORY_PATH = "/tmp";

    @Getter
    private String title;

    @Getter
    private String author;

    private List<Page> pages;

    @Getter
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

    public void save() throws IOException {
        String bookFilePath = String.format("%s/%s_%s", BOOK_DIRECTORY_PATH, this.title, new Date().getTime());
        BufferedWriter writer = new BufferedWriter(new FileWriter(bookFilePath));
        for (Page page : this.pages) {
            writer.write(String.format("--- Page %d ---", page.getNumber()));
            writer.newLine();
            writer.write(page.getContent());
            writer.newLine();
        }
        writer.close();
    }

}
