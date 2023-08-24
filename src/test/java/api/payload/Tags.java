package api.payload;

import java.util.List;

public class Tags {
    List<Category> tags;

    public List<Category> getTags() {
        return tags;
    }

    public void setTags(List<Category> tags) {
        this.tags = tags;
    }
}
