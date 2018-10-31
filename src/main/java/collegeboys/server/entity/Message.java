package collegeboys.server.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "Text")
    private String text;

    @Column(name = "time")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Message(String text, Date date, User user) {
        this.text = text;
        this.date = date;
        this.user = user;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(text, message.text) &&
                Objects.equals(date, message.date) &&
                Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, date, user);
    }

}