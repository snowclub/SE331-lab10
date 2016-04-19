package camt.se331.shoppingcart.config.security;

import camt.se331.shoppingcart.entity.Role;
import camt.se331.shoppingcart.entity.User;
import org.hibernate.mapping.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by TOPCOM on 19/4/2559.
 */
public class SecurityUser extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    public SecurityUser(User user){
        if (user != null){
            this.setId(user.getId());
            this.setName(user.getName());
            this.setEmail(user.getEmail());
            this.setDob(user.getDob());
            this.setRoles(user.Roles());
            this.setPassword(user.getPassword());
            this.setUsername(user.getUsername());
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> userRole = this.getRoleName();

        if (userRole !=null)
        {
            for (Role role: userRoles){
                SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }
    @Override
    public String getUsername(){
        return super.getUsername();
    }

    @Override
    public String getPassword(){
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

}
