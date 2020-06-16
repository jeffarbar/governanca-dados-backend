/*
 * package br.com.claro.catalogo.dados.intercept;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.web.authentication.
 * WebAuthenticationDetailsSource; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import br.com.claro.catalogo.dados.util.JwtTokenUtil; import
 * br.com.claro.catalogo.dados.vo.TokenDataVo; import
 * io.jsonwebtoken.ExpiredJwtException;
 * 
 *//**
	 *
	 * @author Jefferson Farias
	 *//*
		 * @Component public class JwtFilter extends OncePerRequestFilter {
		 * 
		 * @Autowired private JwtTokenUtil jwtTokenUtil;
		 * 
		 * @Override protected void doFilterInternal(HttpServletRequest request,
		 * HttpServletResponse response, FilterChain chain) throws ServletException,
		 * IOException {
		 * 
		 * final String requestTokenHeader = request.getHeader("Authorization");
		 * 
		 * TokenDataVo data = null; String jwtToken = null;
		 * 
		 * if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
		 * jwtToken = requestTokenHeader.substring(7);
		 * 
		 * try { data = jwtTokenUtil.getTokenInformation(jwtToken); } catch
		 * (IllegalArgumentException e) {
		 * //Logger.getLogger(JwtFilter.class.getName()).log(Level.SEVERE,
		 * "Unable to get JWT Token"); } catch (ExpiredJwtException e) {
		 * //Logger.getLogger(JwtFilter.class.getName()).log(Level.SEVERE,
		 * "JWT Token has expired"); } } else {
		 * //Logger.getLogger(JwtFilter.class.getName()).log(Level.SEVERE,
		 * "JWT Token does not begin with Bearer String"); }
		 * 
		 * if (data != null && SecurityContextHolder.getContext().getAuthentication() ==
		 * null) { UserDetails userDetails = new User(data.getLdap(), " ",
		 * data.getRoles());
		 * 
		 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
		 * UsernamePasswordAuthenticationToken( userDetails, null,
		 * userDetails.getAuthorities());
		 * usernamePasswordAuthenticationToken.setDetails(new
		 * WebAuthenticationDetailsSource().buildDetails(request));
		 * 
		 * SecurityContextHolder.getContext().setAuthentication(
		 * usernamePasswordAuthenticationToken);
		 * 
		 * } chain.doFilter(request, response); } }
		 */