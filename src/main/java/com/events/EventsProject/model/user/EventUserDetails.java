package com.events.EventsProject.model.user;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class EventUserDetails extends User {
    private final Long id;

    public EventUserDetails(
            long id,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        super(username, password, authorities);
        this.id = id;
    }
}
