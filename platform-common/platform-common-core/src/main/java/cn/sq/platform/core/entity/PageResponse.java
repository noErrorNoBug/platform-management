package cn.sq.platform.core.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页返回值
 *
 * @author sunqiang
 * @date 2020-10-24 20:33:23
 */
@Data
public class PageResponse<T> {

    /**
     * 当前页码
     */
    private Long pageNum;
    /**
     * 每页数量
     */
    private Long pageSize;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> records;

    public PageResponse() {
    }

    public PageResponse(Long pageNum, Long pageSize, Long totalPage, Long total, List<T> records) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.records = records;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "PageResponse{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", records=" + records +
                '}';
    }

    public static <T> PageResponse<T> success(Long pageNum,Long pageSize,Long totalPage,Long total,List<T> records) {
        return new PageResponse(pageNum, pageSize, totalPage, total, records);
    }
}
