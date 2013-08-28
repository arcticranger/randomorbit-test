package randomorbit.test

class UserController {

    def scaffold = true

    def index() { }

    def search = {}
        

    def results = {
         def users = User.findAllByUserIdLike("%${params.userId}%")
         return [ users: users, term : params.userId ]
    }

    def advSearch = {}

/*
    def advResults = {

        def u = User.createCriteria()

        def users = u.list {
            like("hair".valueOf(), "RED")
        }

        return [ users: users, term : params.userId ]

    }
*/

    def advResults = {

        def userProps = User.metaClass.properties*.name
        def users = User.withCriteria {
                "${params.queryType}" {

                        params.each { field, value ->

                            if (userProps.grep(field) && value) {
                                ilike(field, value)
                            }
                        }

                }

        }
        [ users : users ]

    }


}
