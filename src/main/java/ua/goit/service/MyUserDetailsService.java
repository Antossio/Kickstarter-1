package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyUserDetailsService implements UserDetailsService {

 @Autowired
  private UserDao userDao;

  @Transactional(readOnly=true)
  @Override
  public UserDetails loadUserByUsername(final String userName)
          throws UsernameNotFoundException {
    ua.goit.model.User user = userDao.getUserByLogin(userName);
    List<GrantedAuthority> authorities =
            buildUserAuthority(user.getUserRoles());

    return buildUserForAuthentication(user, authorities);

  }

  // Converts com.mkyong.users.model.User user to
  // org.springframework.security.core.userdetails.User
  private org.springframework.security.core.userdetails.User buildUserForAuthentication(ua.goit.model.User user,
                                          List<GrantedAuthority> authorities) {
    return new ua.goit.model.User(user.getUsername(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
  }

  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

    // Build user's authorities
    for (UserRole userRole : userRoles) {
      setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }

    List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

    return result;
  }

}
