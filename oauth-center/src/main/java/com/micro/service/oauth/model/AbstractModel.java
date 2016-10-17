package com.micro.service.oauth.model;

import com.micro.service.oauth.utils.DateUtils;
import com.micro.service.oauth.utils.GuidGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-10-14 1:04 PM
 */

public class AbstractModel implements Serializable {

    private static final long serialVersionUID = 6569365774429340632L;
    /**
     * Database id
     */
    protected int id;

    /**
     * 用于实现逻辑删除
     */
    protected boolean archived;
    /**
     * Domain business guid.
     * 业务Id
     */
    protected String guid = GuidGenerator.generate();

    /**
     * The domain create time.
     */
    private LocalDateTime created;

    /**
     * updated time
     */
    private LocalDateTime updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }


    public AbstractModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractModel)) {
            return false;
        }
        AbstractModel that = (AbstractModel) o;
        return guid.equals(that.guid);
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{id=").append(id);
        sb.append(", archived=").append(archived);
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }

}
