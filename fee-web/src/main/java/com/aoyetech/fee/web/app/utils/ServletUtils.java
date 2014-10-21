package com.aoyetech.fee.web.app.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Http与Servlet工具类.
 */
public class ServletUtils {

	// -- Content Type 定义 --//
	public static final String TEXT_TYPE = "text/plain";
	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "text/xml";
	public static final String HTML_TYPE = "text/html";
	public static final String JS_TYPE = "text/javascript";
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";

	// -- Header 定义 --//
	public static final String AUTHENTICATION_HEADER = "Authorization";

	// -- 常用数值定义 --//
	public static final long ONE_YEAR_SECONDS = 60 * 60 * 24 * 365;

	public static final String HEADER_ENCODING = "encoding";
	public static final String HEADER_NOCACHE = "no-cache";
	public static final String DEFAULT_ENCODING = "GBK";
	public static final boolean DEFAULT_NOCACHE = true;

	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		// Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		// Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}

	/**
	 * 设置客户端缓存过期时间 Header.
	 */
	public static void setExpiresHeader(HttpServletResponse response,
			long expiresSeconds) {
		// Http 1.0 header
		response.setDateHeader("Expires", System.currentTimeMillis()
				+ expiresSeconds * 1000);
		// Http 1.1 header
		response.setHeader("Cache-Control", "private, max-age="
				+ expiresSeconds);
	}

	/**
	 * 设置客户端无缓存Header.
	 */
	public static void setNoCacheHeader(HttpServletResponse response) {
		// Http 1.0 header
		response.setDateHeader("Expires", 0);
		response.addHeader("Pragma", "no-cache");
		// Http 1.1 header
		response.setHeader("Cache-Control", "no-cache");
	}

	/**
	 * 分析并设置contentType与headers.
	 */
	public static void initResponseHeader(HttpServletResponse resp,
			String contentType, String... headers) {
		// 分析headers参数
		String encoding = DEFAULT_ENCODING;
		boolean noCache = DEFAULT_NOCACHE;
		for (String header : headers) {
			String headerName = StringUtils.substringBefore(header, ":");
			String headerValue = StringUtils.substringAfter(header, ":");

			if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
				encoding = headerValue;
			} else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
				noCache = Boolean.parseBoolean(headerValue);
			} else {
				throw new IllegalArgumentException(headerName
						+ "不是一个合法的header类型");
			}
		}
		// 设置headers参数
		String fullContentType = contentType + ";charset=" + encoding;
		resp.setContentType(fullContentType);
		if (noCache) {
			setNoCacheHeader(resp);
		}
	}

	/**
	 * 直接输出内容的简便函数
	 * <p>
	 * render("text/plain", "hello", "encoding:GBK");
	 * </p>
	 * <p>
	 * render("text/plain", "hello", "no-cache:false");
	 * </p>
	 * <p>
	 * render("text/plain","hello", "encoding:GBK", "no-cache:false");
	 * </p>
	 * 
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为GBK和true.
	 */
	public static void render(HttpServletResponse resp, String contentType,
			String content, String... headers) {
		initResponseHeader(resp, contentType, headers);
		try {
			resp.getWriter().write(content);
			resp.getWriter().flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 输出文本
	 * 
	 * @param resp
	 * @param text
	 * @param headers
	 */
	public static void renderText(HttpServletResponse resp, String text,
			String... headers) {
		render(resp, ServletUtils.TEXT_TYPE, text, headers);
	}

	/**
	 * 输出html
	 * 
	 * @param resp
	 * @param html
	 * @param headers
	 */
	public static void renderHtml(HttpServletResponse resp, String html,
			String... headers) {
		render(resp, ServletUtils.HTML_TYPE, html, headers);
	}

	/**
	 * 输出xml
	 * 
	 * @param resp
	 * @param xml
	 * @param headers
	 */
	public static void renderXml(HttpServletResponse resp, String xml,
			String... headers) {
		render(resp, ServletUtils.XML_TYPE, xml, headers);
	}

	/**
	 * 输出json
	 * 
	 * @param jsonString
	 *            json字符串.
	 * @param headers
	 */
	public static void renderJson(HttpServletResponse resp, String jsonString,
			String... headers) {
		render(resp, ServletUtils.JSON_TYPE, jsonString, headers);
	}
}
