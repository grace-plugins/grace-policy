package grace.demos

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                loadSampleData()
            }
        }
    }

    def destroy = {
    }

    @Transactional
    protected void loadSampleData() {
        def ROLE_ADMIN = new Role(name: "ROLE_ADMIN").save()
        def ROLE_USER = new Role(name: "ROLE_USER").save()
        def admin = new User(username: "admin", password: "admin").save()
        def user = new User(username: "user", password: "user").save()
        UserRole.create(admin, ROLE_ADMIN)
        UserRole.create(user, ROLE_USER)
        new Post(title: "The first post", content: "This is a content", status: "DRAFT", author: user).save()
        new Post(title: "The second post", content: "This is a post by admin", status: "DRAFT", author: admin).save()
        new Post(title: "This is another post", content: "This is also a content", status: "PUBLISHED").save()
    }

}
