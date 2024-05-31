package grace.demos

class Role {

    String name

    static constraints = {
        name(blank: false, nullable: false, maxSize: 60)
    }

    static mapping = {
        table "roles"
    }

    String toString() {
        name
    }

}
