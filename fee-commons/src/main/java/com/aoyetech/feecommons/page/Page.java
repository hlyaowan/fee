package com.aoyetech.feecommons.page;

/**
 * 这里用一句话描述这个类的作用
 * 
 * @author 蒋永亮
 * @version 1.00 2011-8-31
 */
public class Page {

    /**
     * 每页显示数量
     */
    private int     everyPage;
    /**
     * 总记录数
     */
    private long    totalCount;
    /**
     * 总页数
     */
    private int     totalPage;
    /**
     * 当前页
     */
    private int     currentPage;
    /**
     * 起始点
     */
    private int     beginIndex;
    /**
     * 是否有上一页
     */
    private boolean hasPrePage;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    private boolean isCountQuery;

    /**
     * 构造方法
     * 
     * @param everyPage2
     * @param totalCount2
     * @param totalPage2
     * @param currentPage2
     * @param beginIndex2
     * @param hasPrePage2
     * @param hasNextPage2
     */
    public Page(int everyPage2, long totalCount2, int totalPage2, int currentPage2, int beginIndex2,
                boolean hasPrePage2, boolean hasNextPage2){

        this.everyPage = everyPage2;
        this.totalCount = totalCount2;
        this.totalPage = totalPage2;
        this.currentPage = currentPage2;
        this.beginIndex = beginIndex2;
        this.hasPrePage = hasPrePage2;
        this.hasNextPage = hasNextPage2;
    }
    
    public static int GetPageCount(int pageSize, int count) {
        return count % pageSize != 0 ? count / pageSize + 1 : count / pageSize;
    }

    public Page(int everyPage, long totalCount, int totalPage, int currentPage, int beginIndex){

        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
    }
    /*
     * 相应的有参无参构造器，getters和setters方法
     */
    public Page(){

    }

    public Page(Boolean isCount){
        this.isCountQuery = isCount;
    }

    /**
     * 每页显示数量
     */
    public int getEveryPage() {
        return this.everyPage;
    }

    /**
     * 每页显示数量
     */
    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginIndex() {
        return this.beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public boolean isHasPrePage() {
        return this.hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isCountQuery() {
        return isCountQuery;
    }

    public void setCountQuery(boolean isCountQuery) {
        this.isCountQuery = isCountQuery;
    }

}
