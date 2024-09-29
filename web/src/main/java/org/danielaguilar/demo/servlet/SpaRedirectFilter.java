package org.danielaguilar.demo.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpaRedirectFilter implements Filter {
	private static final Logger logger = LogManager.getLogger();
	private final String INDEX_PATH = "/";

	/**
	 * A "valid path" is one that must be handled by the servlet, as opposed to the
	 * client (i.e. Vue routes). Needless to say, don't make your Vue routes begin
	 * with any of these paths.
	 */
	private final List<String> RESERVED_VALID_PATHS = Arrays.asList("/spa", "/api");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws ServletException, IOException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		if (isValidPath(httpReq)) {
			chain.doFilter(request, response);
		} else { // Redirect to index
			logger.debug("{} - Invalid (unknown) path, redirecting to index... ", request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_PATH);
			dispatcher.forward(request, response);
		}
	}

	@Override
	public void destroy() {

	}

	private boolean isValidPath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());

		boolean isValid = RESERVED_VALID_PATHS.stream().anyMatch(p -> path.startsWith(p));
		boolean isIndex = path.equals(INDEX_PATH); // Prevent an infinite loop
		return isValid || isIndex;
	}
}
