package fi.om.initiative.dto.search;

import fi.om.initiative.web.Urls;

public class InitiativeSearch {

    private SearchView searchView = SearchView.pub;

    private Integer offset;

    private Integer limit;

    private OrderBy orderBy = OrderBy.mostTimeLeft;

    private Show show = Show.running;

    private Integer minSupportCount = Urls.DEFAULT_INITIATIVE_MINSUPPORTCOUNT;

    public InitiativeSearch() {}

    public InitiativeSearch(SearchView searchView) {
        this.searchView = searchView;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        if (limit == null)
            return Urls.DEFAULT_INITIATIVE_SEARCH_LIMIT;
        else
            return Math.min(limit, Urls.MAX_INITIATIVE_SEARCH_LIMIT);
    }

    public InitiativeSearch setRestrict(int offsetIndex, int limit) {
        setOffset(offsetIndex);
        setLimit(limit);
        return this;
    }

    public InitiativeSearch setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public InitiativeSearch setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public InitiativeSearch setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public Show getShow() {
        return show;
    }

    public InitiativeSearch setShow(Show show) {
        this.show = show;
        return this;
    }


    public InitiativeSearch copy() {

        InitiativeSearch clone = new InitiativeSearch();
        clone.setShow(show);
        clone.setSearchView(searchView);
        clone.setLimit(limit);
        clone.setOffset(offset);
        clone.setOrderBy(orderBy);
        clone.setMinSupportCount(minSupportCount);
        return clone;
    }

    public SearchView getSearchView() {
        return searchView;
    }

    public InitiativeSearch setSearchView(SearchView searchView) {
        this.searchView = searchView;
        return this;
    }

    public Integer getMinSupportCount() {
        return minSupportCount;
    }

    public InitiativeSearch setMinSupportCount(Integer minSupportCount) {
        this.minSupportCount = minSupportCount;
        return this;
    }

    // These are only for freemarker

    public boolean isViewPublic() {
        return searchView == SearchView.pub;
    }

    public boolean isViewOwn() {
        return searchView == SearchView.own;
    }

    public boolean isViewOm() {
        return searchView == SearchView.om;
    }

    // For testing and mocking

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InitiativeSearch that = (InitiativeSearch) o;

        if (searchView != that.searchView) return false;
        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        if (limit != null ? !limit.equals(that.limit) : that.limit != null) return false;
        if (orderBy != that.orderBy) return false;
        if (show != that.show) return false;
        return minSupportCount != null ? minSupportCount.equals(that.minSupportCount) : that.minSupportCount == null;

    }

    @Override
    public int hashCode() {
        int result = searchView != null ? searchView.hashCode() : 0;
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        result = 31 * result + (limit != null ? limit.hashCode() : 0);
        result = 31 * result + (orderBy != null ? orderBy.hashCode() : 0);
        result = 31 * result + (show != null ? show.hashCode() : 0);
        result = 31 * result + (minSupportCount != null ? minSupportCount.hashCode() : 0);
        return result;
    }
}
