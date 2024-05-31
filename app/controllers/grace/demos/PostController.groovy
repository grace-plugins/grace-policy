package grace.demos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostController {

    def postService

    def index() {
        authorize()
        respond postService.findAll()
    }

    def show(Long id) {
        def post = postService.get(id)
        if (post == null) {
            flash.message = "Post#${id} not found"
            redirect action: "index", method: "GET"
            return
        }
        authorize(post)
        respond post
    }

    def edit(Long id) {
        def post = postService.get(id)
        if (post == null) {
            flash.message = "Post#${id} not found"
            redirect action: "index", method: "GET"
            return
        }
        authorize(post)
        respond post
    }

    def update(Long id) {
        def post = postService.get(id)
        if (post == null) {
            flash.message = "Post#${id} not found"
            redirect action: "index", method: "GET"
            return
        }

        authorize(post)

        post.title = params.title
        post.content = params.content
        postService.save(post)

        flash.message = 'Post updated'
        redirect post
    }

}
