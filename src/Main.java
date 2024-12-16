import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shedule shedule = new Shedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        // Use formatter to parse LocalDateTime
        shedule.addEvent(new Event("Новий рік", LocalDateTime.parse("01.01.2025 12:00", formatter), "Дім"));
        shedule.addEvent(new Event("Рздво Христове", LocalDateTime.parse("07.01.2025 07:00", formatter), "Церква"));
        shedule.addEvent(new Event("Міжнародний жіночий день", LocalDateTime.parse("08.03.2025 12:45", formatter), "Кавярня"));

        System.out.println("Усі заходи: ");
        shedule.printAllEvents();

        System.out.println("\nЗаходи на 01.01.2025:");
        List<Event> eventsOnDate = shedule.getEventBydDate(LocalDate.of(2025, 1, 1));
        eventsOnDate.forEach(System.out::println);

        System.out.println("\nВидаляємо минулі заходи.");
        shedule.removePastEvents();

        System.out.println("\nОновлений список заходів: ");
        shedule.printAllEvents();
    }
}