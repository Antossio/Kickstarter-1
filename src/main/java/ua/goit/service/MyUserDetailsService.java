package ua.goit.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.dao.UserDao;
import ua.goit.model.UserRole;
import ua.goit.model.Users;

import javax.transaction.Transactional;
import java.util.*;

@Service("myUserDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
  private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);
  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
    Users users = userDao.getUserByLogin(userName);
    List<GrantedAuthority> authorities = buildUserAuthority(users.getUserRole());
    return buildUserForAuthentication(users, authorities);
  }

  private User buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
    return new User(user.getLogin(), user.getPassword(),
            user.isActive() != 0, true, true, true, authorities);
  }

  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
    Set<GrantedAuthority> setAuths = new HashSet<>();
    for (UserRole userRole : userRoles) {
      setAuths.add(new SimpleGrantedAuthority(userRole.getRole().toString()));
    }

    List<GrantedAuthority> result = new ArrayList<>(setAuths);
    return result;
  }

}
