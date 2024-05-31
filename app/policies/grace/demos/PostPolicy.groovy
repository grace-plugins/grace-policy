package grace.demos

class PostPolicy {

    def index() {
        true
    }

    def show() {
        record.status == 'PUBLISHED' || record?.author?.id == user?.id || user?.isAdmin()
    }

    def edit() {
        update()
    }

    def update() {
        record?.author?.id == user?.id
    }

}
