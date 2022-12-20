import com.bootcamp.DocumentPrinter;
import com.bootcamp.PdfBook;
import com.bootcamp.Report;
import com.bootcamp.Resume;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PdfBook pdfBook = new PdfBook("1984", "George Orwell", "Sci-Fi", 300);
        Report report = new Report("Some random text", "Pepe Lopez", "Laura Gonzalez", 275);
        Resume resume = new Resume("Jose", "Martinez", "30.123.123", LocalDate.of(1970, 3, 3));
        String abilityOne = "Running";
        String abilityTwo = "Swimming";
        resume.addAbility(abilityOne);
        resume.addAbility(abilityTwo);

        DocumentPrinter.printDocument(pdfBook);
        DocumentPrinter.printDocument(report);
        DocumentPrinter.printDocument(resume);
    }
}