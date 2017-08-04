package mrigor.model;

import java.time.LocalDate;

/**
 * Created by Игорь on 18.07.2017.
 */
public class Interaction {
    int id;
    LocalDate dateOfEvent;
    String subject;
    String comment;

    public Interaction() {
    }

    public Interaction(LocalDate dateOfEvent, String subject, String comment) {

        this.dateOfEvent = dateOfEvent;
        this.subject = subject;
        this.comment = comment;
    }

    public Interaction(int id, LocalDate dateOfEvent, String subject, String comment) {

        this.id = id;
        this.dateOfEvent = dateOfEvent;
        this.subject = subject;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Interaction{");
        sb.append("id=").append(id);
        sb.append(", dateOfEvent=").append(dateOfEvent);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
