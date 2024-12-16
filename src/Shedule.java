import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Shedule {
    private List<Event> events;

    public Shedule(){
        events = new ArrayList<>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public List<Event> getEventBydDate(LocalDate date){
        List<Event> result = new ArrayList<>();
        for (Event event : events){
            if(event.getDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public List<Event> removePastEvents(){
        LocalDateTime now = LocalDateTime.now();
        List<Event> toRemove = new ArrayList<>();
        for (Event event : events){
            if(event.getDateTime().isBefore(now)){
                toRemove.add(event);
            }
        }
        events.removeAll(toRemove);
        return events;
    }

    public void printAllEvents(){
        if(events.isEmpty()){
            System.out.println("Розклад порожній.");
        }else {
            for(Event event : events){
                System.out.println(event);
            }
        }
    }
}