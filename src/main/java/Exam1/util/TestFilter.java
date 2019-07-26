package Exam1.util;

import Exam1.controller.IndexController;
import Exam1.dao.MusicDao;
import Exam1.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "testFilter")
public class TestFilter implements Filter {
    @Autowired
    MusicDao musicDao;
    public static int login_state=0;
    Logger logger =LoggerFactory.getLogger(IndexController.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name=servletRequest.getParameter("name");
        String password=servletRequest.getParameter("password");
        Customer customer=new Customer();
        customer.setFirstName(name);
        customer.setLastName(password);
        Object object=(Object)musicDao.login(customer);
        if(login_state==0) {
            logger.info("收到的数据" + name + " " + password);
            if (object != null) {
                login_state = 1;
            }
            logger.info("登陆验证");
            if (login_state == 1) {
                filterChain.doFilter(servletRequest, servletResponse);
                logger.info("登陆验证成功");
            } else {
                logger.info("登陆验证失败");
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void destroy() {

    }
}
