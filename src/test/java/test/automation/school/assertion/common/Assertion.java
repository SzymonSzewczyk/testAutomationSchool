package test.automation.school.assertion.common;


import test.automation.school.page.common.Page;

/**
 * Abstract assertions class
 * @param <T> Page or component class which assertions should be testing
 */
public abstract class Assertion<T extends Page> {

    protected T page;

    public void setPage(T page) {
        this.page = page;
    }

    public T endCheck() {
        return page;
    }
}