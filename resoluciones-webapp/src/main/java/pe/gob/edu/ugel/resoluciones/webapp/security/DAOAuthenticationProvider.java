package pe.gob.edu.ugel.resoluciones.webapp.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pe.gob.edu.ugel.resoluciones.core.security.User;
import pe.gob.edu.ugel.resoluciones.service.services.ResolucionServiceImpl;

/**
 * 
 * @author ocalsin
 *
 */

public class DAOAuthenticationProvider implements AuthenticationProvider {

	protected final Log logger = LogFactory.getLog(getClass());

	 @Autowired
	 private ResolucionServiceImpl resolucionService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		UsernamePasswordAuthenticationToken successToken = null;

		if (SessionDetail.getUserDetails() == null) {
			System.out.println(":: DAO authenticate ::");
			String username = null;
			String password = null;

			try {
				username = authentication.getPrincipal().toString();
				password = authentication.getCredentials().toString();
			} catch (Exception e) {
				logger.info(e.getMessage(), e);
				throw new BadCredentialsException("Username or Password is empty: " + username);
			}

			if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
				throw new BadCredentialsException("Username or Password is empty: " + username);
			}
			System.out.println("username: " + username);

			// User user = userService.getUserDAOAuthenticate(username,
			// password);
			User user = null;
//			if (username.equals("client01") && password.equals("client01")) {
//				user = new User();
//				String[] roles = { "ROLE_CLIENT" };
//				user.setRoles(roles);
//				user.setUserName("Cliente-01");
//				user.setUserId(2L);
//			}
//
//			if (username.equals("client02") && password.equals("client02")) {
//				user = new User();
//				String[] roles = { "ROLE_CLIENT" };
//				user.setRoles(roles);
//				user.setUserName("Cliente-02");
//				user.setUserId(3L);
//			}
//
//			if (username.equals("client03") && password.equals("client03")) {
//				user = new User();
//				String[] roles = { "ROLE_CLIENT" };
//				user.setRoles(roles);
//				user.setUserName("Cliente-03");
//				user.setUserId(4L);
//			}

			if (username.equals("admin") && password.equals("admin")) {
				user = new User();
				String[] roles = { "ROLE_ADMIN" };
				user.setRoles(roles);
				user.setUserName("Administrador");
				user.setUserId(1L);
			}

//			if (username.equals("user") && password.equals("user")) {
//				user = new User();
//				String[] roles = { "ROLE_USER" };
//				user.setRoles(roles);
//				user.setUserName("User");
//				user.setUserId(5L);
//				user.setInstitutionId(1L);
//			}

			System.out.println(resolucionService+"  :::::user::::: " + user);
			if (user == null) {
				throw new BadCredentialsException("DAO: User's Information need to be updated, user " + username);
			}


			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (String rol : user.getRoles()) {
				System.out.println("rol " + rol);
				authorities.add(new SimpleGrantedAuthority(rol));
			}
			System.out.println("authorities: " + authorities);
			// successToken = new
			// UsernamePasswordAuthenticationToken(authentication.getPrincipal().toString(),
			// authorities);
			successToken = new UsernamePasswordAuthenticationToken(authentication.getPrincipal().toString(),
					authentication.getCredentials().toString(), authorities);
			successToken.setDetails(user);
			System.out.println(
					"USER authenticated>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:" + username + ":<<<<<<<<<<<<<<<<<<<<<<<<");
		} else {
			successToken = (UsernamePasswordAuthenticationToken) SessionDetail.getAuthentication();
		}
		return successToken;
	}

	public boolean supports(Class<? extends Object> authentication) {
		return true;
	}
}
