package collegeboys.server.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "PassWord")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Message> messageSet;

    public User(String userName, String password, List<Message> messageSet) {
        this.userName = userName;
        this.password = password;
        this.messageSet = messageSet;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(List<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(messageSet, user.messageSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, messageSet);
    }

}

