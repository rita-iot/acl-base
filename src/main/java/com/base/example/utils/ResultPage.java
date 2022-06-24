package com.base.example.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --分页返回对象
 * @author：Bing
 * @date：2022/1/12 10:15
 * @version：1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultPage {
    private Boolean success;
    private Integer code;
    private String message;
    private Page page;

    /**
     * 成功方法
     * @param pageInfo
     * @return
     */
    //public static ResultPage ok(PageInfo pageInfo) {
    //    ResultPage resultPage = new ResultPage();
    //    resultPage.setSuccess(true);
    //    resultPage.setCode(200);
    //    resultPage.setMessage("成功");
    //    Page page = new Page();
    //    page.setCurrentPage(pageInfo.getPageNum());
    //    page.setPageSize(pageInfo.getPageSize());
    //    page.setTotalPage(pageInfo.getPages());
    //    page.setTotalCount(Integer.valueOf(Math.toIntExact(pageInfo.getTotal())));
    //    page.setList(pageInfo.getList());
    //    resultPage.setPage(page);
    //    return resultPage;
    //}
    /**
     * 成功方法
     * @param iPage
     * @return
     */
    public static ResultPage ok(IPage iPage) {
        ResultPage resultPage = new ResultPage();
        resultPage.setSuccess(true);
        resultPage.setCode(20000);
        resultPage.setMessage("成功");
        Page page = new Page();
        page.setCurrentPage(Math.toIntExact(iPage.getCurrent()));
        page.setPageSize(Math.toIntExact(iPage.getSize()));
        page.setTotalPage(Math.toIntExact(iPage.getPages()));
        page.setTotalCount(Math.toIntExact(iPage.getTotal()));
        page.setList(iPage.getRecords());
        resultPage.setPage(page);
        return resultPage;
    }

    /**
     * 失败方法
     * @return
     */
    public static ResultPage fail() {
        ResultPage resultPage = new ResultPage();
        resultPage.setSuccess(false);
        resultPage.setCode(501);
        resultPage.setMessage("分页查询失败");
        resultPage.setPage(null);
        return resultPage;
    }
}
