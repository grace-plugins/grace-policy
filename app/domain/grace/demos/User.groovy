package grace.demos

class User {

    String username
    String password

    Set<Role> getRoles() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    boolean hasRole(String name) {
        Role role = Role.findByName(name)
        role ? UserRole.findByUserAndRole(this, role) : false
    }

    boolean isAdmin() {
        hasRole('ROLE_ADMIN')
    }

    static constraints = {
        username(blank: false, nullable: false, maxSize: 60)
        password(blank: false, nullable: false, maxSize: 30)
    }

    static mapping = {
        table "users"
    }

    String toString() {
        username
    }

}
