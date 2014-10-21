package com.aoyetech.feecommons.page;

/**
 * @author jyl
 * @version 创建时间：2012-4-12 下午10:39:06 类说明
 */
public class PaginationUtil {

    private static int numLimit = 6;

    /**
     * @author yxq
     * @param page
     * @param url
     * @param style
     * @return
     */
    public static String getPaginationStylePage(Page page, String url) {
        return getPaginationStylePage(page, url, "");
    }

    public static String getPaginationStylePage(Page page, String url, String style) {
        String pagination = "";
        if (page.getCurrentPage() > page.getTotalPage()) {
            page.setCurrentPage(1);
        }
        if (page.getTotalPage() == 0) {
            pagination = "暂无记录";
        } else if (page.getTotalPage() == 1) {
            pagination += "<a class=\"active\" href=\"javascript:;\"><b>1</b></a><span>&nbsp;共" + page.getTotalCount()
                          + "条数</span>";
        } else {
            if (url.indexOf("?") == -1) {
                // 首页
                if (page.getCurrentPage() == 1) {
                    pagination += "<a class=\"first pageprv z-dis\">首页</a>";
                    pagination += "<a class=\"first pageprv z-dis\"><span class=\"pagearr\">&lt;</span>上一页</a>";
                    pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>1</b></a>";
                } else {
                    pagination += "<a  href='" + url + "?page=1&page.totalCount=" + page.getTotalCount()
                                  + "'>首页</a>";
                    pagination += "<a  href='" + url + "?page=" + (page.getCurrentPage() - 1)
                                  + "&page.totalCount=" + page.getTotalCount()
                                  + "'><span class=\"pagearr\">&lt;</span>上一页</a>";
                    pagination += "<a href='" + url + "?page=1&total=" + page.getTotalCount()
                                  + "'><b>1</b></a>";
                }

                // 处理前面的部分
                int start = page.getCurrentPage() - numLimit / 2;
                if (start > 1) {
                    pagination += "<a  href='" + url + "?page=" + start + "&page.totalCount="
                                  + page.getTotalCount() + "'>...</a>";
                    start = start + 1;
                } else {
                    start = 2;
                }

                // 处理后面的分页部分
                int end = page.getCurrentPage() + numLimit / 2 - 1;
                if (end >= page.getTotalPage()) {
                    end = page.getTotalPage() - 1;
                }

                // 处理中间的分页部分
                for (int i = start; i <= end; i++) {
                    if (page.getCurrentPage() == i) {
                        pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>" + i + "</b></a>";
                    } else {
                        pagination += "<a href='" + url + "?page=" + i + "&page.totalCount="
                                      + page.getTotalCount() + "'><b>" + i + "</b></a>";
                    }
                }

                // 处理后面的分页部分
                if ((page.getCurrentPage() + numLimit / 2) < page.getTotalPage()) {
                    pagination += "<a  href='" + url + "?page=" + (page.getCurrentPage() + numLimit / 2)
                                  + "&page.totalCount=" + page.getTotalCount() + "'>...</a>";
                }

                // 末页
                if (page.getCurrentPage() == page.getTotalPage()) {
                    pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>" + page.getTotalPage() + "</b></a>";
                    pagination += "<a class=\"first pageprv z-dis\">下一页<span class=\"pagearr\">&gt;</span></a>";
                    pagination += "<a class=\"first pageprv z-dis\">末页</a>";
                } else {
                    pagination += "<a href='" + url + "?page=" + page.getTotalPage() + "&page.totalCount="
                                  + page.getTotalCount() + "'><b>" + page.getTotalPage() + "</b></a>";
                    pagination += "<a href='" + url + "?page=" + (page.getCurrentPage() + 1)
                                  + "&page.totalCount=" + page.getTotalCount()
                                  + "'>下一页<span class=\"pagearr\">&gt;</span></a>";
                    pagination += "<a href='" + url + "?page=" + (page.getTotalPage())
                                  + "&page.totalCount=" + page.getTotalCount() + "'>末页</a>";
                }

                pagination += "<span style='padding:11px 8px'>&nbsp;共" + page.getTotalCount() + "条数据</span>";
            } else {
                // 首页
                if (page.getCurrentPage() == 1) {
                    pagination = "<a class=\"first pageprv z-dis\"><span class=\"pagearr\">&lt;</span>上一页</a>";
                    pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>1</b></a>";
                } else {
                    pagination = "<a  href='" + url + "&page=" + (page.getCurrentPage() - 1)
                                 + "&page.totalCount=" + page.getTotalCount()
                                 + "'><span class=\"pagearr\">&lt;</span>上一页</a>";
                    pagination += "<a href='" + url + "&page=1&page.totalCount=" + page.getTotalCount()
                                  + "'><b>1</b></a>";
                }

                // 处理前面的部分
                int start = page.getCurrentPage() - numLimit / 2;
                if (start > 1) {
                    pagination += "<a  href='" + url + "&page=" + start + "&page.totalCount="
                                  + page.getTotalCount() + "'>...</a>";
                    start = start + 1;
                } else {
                    start = 2;
                }

                // 处理后面的分页部分
                int end = page.getCurrentPage() + numLimit / 2 - 1;
                if (end >= page.getTotalPage()) {
                    end = page.getTotalPage() - 1;
                }

                // 处理中间的分页部分
                for (int i = start; i <= end; i++) {
                    if (page.getCurrentPage() == i) {
                        pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>" + i + "</b></a>";
                    } else {
                        pagination += "<a href='" + url + "&page=" + i + "&page.totalCount="
                                      + page.getTotalCount() + "'><b>" + i + "</b></a>";
                    }
                }

                // 处理后面的分页部分
                if ((page.getCurrentPage() + numLimit / 2) < page.getTotalPage()) {
                    pagination += "<a  href='" + url + "&page=" + (page.getCurrentPage() + numLimit / 2)
                                  + "&page.totalCount=" + page.getTotalCount() + "'>...</a>";
                }

                // 末页
                if (page.getCurrentPage() == page.getTotalPage()) {
                    pagination += "<a class=\"z-crt\" href=\"javascript:;\"><b>" + page.getTotalPage() + "</b></a>";
                    pagination += "<a class=\"first pageprv z-dis\">下一页<span class=\"pagearr\">&gt;</span></a>";
                } else {
                    pagination += "<a href='" + url + "&page=" + page.getTotalPage() + "&page.totalCount="
                                  + page.getTotalCount() + "'><b>" + page.getTotalPage() + "</b></a>";
                    pagination += "<a  href='" + url + "&page=" + (page.getCurrentPage() + 1)
                                  + "&page.totalCount=" + page.getTotalCount()
                                  + "'>下一页<span class=\"pagearr\">&gt;</span></a>";
                }

                pagination += "<span>&nbsp;共" + page.getTotalCount() + "条数据";
            }
        }
        return pagination;
    }
}
