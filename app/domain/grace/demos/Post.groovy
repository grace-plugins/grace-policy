package grace.demos

class Post {

    String title
    String content
    String status
    User author

    static constraints = {
        title(blank: false, nullable: false, maxSize: 255)
        content(blank: true, nullable: true, maxSize: 255)
        status(blank: false, nullable: false, maxSize: 10)
        author(nullable: true)
    }

}
