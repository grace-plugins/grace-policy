package grace.demos

class AuthController {

    static allowedMethods = [index: "GET", login: "POST", logout: "GET"]

    def index() {
        if (session["current_user"]) {
            redirect(uri: '/')
        }
    }

    def login(LoginCommand cmd) {
        User user = User.findByUsernameAndPassword(cmd.username, cmd.password)
        if (user) {
            session["current_user"] = user
            redirect(uri: '/')
        } else {
            redirect(controller: 'auth', action: 'index', params: [fail: true])
        }
    }

    def logout() {
        log.info "User logout"
        session.invalidate()
        redirect(action: "index")
    }

}

class LoginCommand {
    String username
    String password
}