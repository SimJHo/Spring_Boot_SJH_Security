package edu.global.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.global.ex.security.CustomUserDetailsService;

//시큐리티 설정 클래스
@Configuration //이 클래스가 설정파일인 것을 알려줌, @Component(부모)+설정
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록됨(12개의 필터)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired //개발자가 커스터마이징
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		http.csrf().disable(); //CSRF 설정을 해제(초기 개발시에만 하는게 좋다)
		
//		http.httpBasic(); //디폴트 로그인 화면을 띄움(팝업)
		
//		로그인 폼을 커스터마이징
		http.formLogin()
			.loginPage("/login")
//			로그인폼 파라미터 변경
//			.usernameParameter("userId")
//			.passwordParameter("passwd")
			.defaultSuccessUrl("/")
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout");
		
		http.authorizeHttpRequests()
			.antMatchers("/user/**").hasAnyRole("USER", "ADMIN") //user/**로 접근할 때는 USER 또는 ADMIN 권한이 있어야 한다
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/**").permitAll(); //그 외 경로는 모두 허용
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
//		noop은 Spring Security에서 텍스트 그대로 비밀번호로 인식하게 해준다. {noop} 또는 비밀번호 암호화 둘중 하나는 해줘야함
//		이유 : PasswordEncoder를 설정하지 않아서다. Spring boot는 PasswordEncoder를 설정해 주지않으며, 이부분은 개발자가 직접 등록 해야한다
	
		auth.userDetailsService(customUserDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
