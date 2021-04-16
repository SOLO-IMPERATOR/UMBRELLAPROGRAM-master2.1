package com.example.First.Security;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USR")
public class USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = ROLE.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<ROLE> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ROLE> getRoles() {
        return roles;
    }

    public void setRoles(Set<ROLE> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
