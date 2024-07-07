// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.testlogic.models;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import java.time.OffsetDateTime;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    private long id;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;

    private String gistsUrl;
    private String reposUrl;
    private String followingUrl;
    private String twitterUsername;
//    private OffsetDateTime createdAt;
    private String login;
    private String type;
    private String blog;
    private String subscriptionsUrl;
//    private OffsetDateTime updatedAt;
@Ignore
    private boolean siteAdmin;
    private String company;
    private long publicRepos;
    private String gravatarid;
    private String organizationsUrl;
    private String starredUrl;
    private String followersUrl;
    private long publicGists;
    private String url;
    private String receivedEventsUrl;
    private long followers;

    private String eventsUrl;

    private long following;
    private String name;
    private String location;
    private String nodeid;



    public User(long id, String login, String nodeid, String avatarUrl, String gravatarid, String Url, String htmlUrl, String followersUrl, String followingUrl, String gistsUrl, String reposUrl, String organizationsUrl, String starredUrl, String type, boolean siteAdmin, String receivedEventsUrl) {
        this.id = id;
        this.login = login;
        this.nodeid = nodeid;
        this.avatarUrl = avatarUrl;
        this.gravatarid = gravatarid;
        this.url = Url;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.gistsUrl = gistsUrl;
        this.reposUrl = reposUrl;
        this.organizationsUrl = organizationsUrl;
        this.starredUrl = starredUrl;
        this.type = type;
        this.siteAdmin = siteAdmin;
        this.receivedEventsUrl = receivedEventsUrl;
    }
    public User() {
    }

    public User(long id, String gistsUrl, String reposUrl, String followingUrl, String twitterUsername, String login, String type, String blog, String subscriptionsUrl, boolean siteAdmin, String company, long publicRepos, String gravatarid, String organizationsUrl, String starredUrl, String followersUrl, long publicGists, String Url, String receivedEventsUrl, long followers, String avatarUrl, String eventsUrl, String htmlUrl, long following, String name, String location, String nodeid) {
        this.id = id;
        this.gistsUrl = gistsUrl;
        this.reposUrl = reposUrl;
        this.followingUrl = followingUrl;
        this.twitterUsername = twitterUsername;
        this.login = login;
        this.type = type;
        this.blog = blog;
        this.subscriptionsUrl = subscriptionsUrl;
        this.siteAdmin = siteAdmin;
        this.company = company;
        this.publicRepos = publicRepos;
        this.gravatarid = gravatarid;
        this.organizationsUrl = organizationsUrl;
        this.starredUrl = starredUrl;
        this.followersUrl = followersUrl;
        this.publicGists = publicGists;
        this.url = Url;
        this.receivedEventsUrl = receivedEventsUrl;
        this.followers = followers;
        this.avatarUrl = avatarUrl;
        this.eventsUrl = eventsUrl;
        this.htmlUrl = htmlUrl;
        this.following = following;
        this.name = name;
        this.location = location;
        this.nodeid = nodeid;
    }

    public String getGistsUrl() { return gistsUrl; }
    public void setGistsUrl(String value) { this.gistsUrl = value; }

    public String getReposUrl() { return reposUrl; }
    public void setReposUrl(String value) { this.reposUrl = value; }

    public String getFollowingUrl() { return followingUrl; }
    public void setFollowingUrl(String value) { this.followingUrl = value; }

    public String getTwitterUsername() { return twitterUsername; }
    public void setTwitterUsername(String value) { this.twitterUsername = value; }

//    public OffsetDateTime getCreatedAt() { return createdAt; }
//    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    public String getLogin() { return login; }
    public void setLogin(String value) { this.login = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getBlog() { return blog; }
    public void setBlog(String value) { this.blog = value; }

    public String getSubscriptionsUrl() { return subscriptionsUrl; }
    public void setSubscriptionsUrl(String value) { this.subscriptionsUrl = value; }

//    public OffsetDateTime getUpdatedAt() { return updatedAt; }
//    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; }

    public boolean getSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(boolean value) { this.siteAdmin = value; }

    public String getCompany() { return company; }
    public void setCompany(String value) { this.company = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public long getPublicRepos() { return publicRepos; }
    public void setPublicRepos(long value) { this.publicRepos = value; }

    public String getGravatarid() { return gravatarid; }
    public void setGravatarid(String value) { this.gravatarid = value; }

    public String getOrganizationsUrl() { return organizationsUrl; }
    public void setOrganizationsUrl(String value) { this.organizationsUrl = value; }

    public String getStarredUrl() { return starredUrl; }
    public void setStarredUrl(String value) { this.starredUrl = value; }

    public String getFollowersUrl() { return followersUrl; }
    public void setFollowersUrl(String value) { this.followersUrl = value; }

    public long getPublicGists() { return publicGists; }
    public void setPublicGists(long value) { this.publicGists = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getReceivedEventsUrl() { return receivedEventsUrl; }
    public void setReceivedEventsUrl(String value) { this.receivedEventsUrl = value; }

    public long getFollowers() { return followers; }
    public void setFollowers(long value) { this.followers = value; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String value) { this.avatarUrl = value; }

    public String getEventsUrl() { return eventsUrl; }
    public void setEventsUrl(String value) { this.eventsUrl = value; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String value) { this.htmlUrl = value; }

    public long getFollowing() { return following; }
    public void setFollowing(long value) { this.following = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getLocation() { return location; }
    public void setLocation(String value) { this.location = value; }

    public String getNodeid() { return nodeid; }
    public void setNodeid(String value) { this.nodeid = value; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
