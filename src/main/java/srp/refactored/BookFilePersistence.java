package srp.refactored;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static srp.refactored.Book.BOOK_DIRECTORY_PATH;

public class BookFilePersistence implements BookPersistence {

    @Override
    public void save(Book book) {
        String bookFilePath = String.format("%s/%s_%s", BOOK_DIRECTORY_PATH, book.getTitle(), new Date().getTime());
        List<Page> pages = book.getPages();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(bookFilePath));
            for (Page page : pages) {
                writer.write(String.format("--- Page %d ---", page.getNumber()));
                writer.newLine();
                writer.write(page.getContent());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new BookPersistenceException();
        }
    }

}
