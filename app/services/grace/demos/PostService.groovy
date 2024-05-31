package grace.demos

import grails.gorm.transactions.Transactional

class PostService {

    List<Post> findAll() {
        Post.list()
    }

    Post get(Long id) {
        Post post = Post.get(id)
        post
    }

    @Transactional
    void save(Post post) {
        post.save(flush: true)
    }

}
