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



/*
    def selectResults = {

        def userProps = ["ethnic", "hair", "build", "bio"]


        def users = User.withCriteria {
                and {
                        params.each { field, value ->

                            println "param: " + field + " " + value

                            if (userProps.grep(field) && value) {
                                println "found " + field + " in " + userProps
                                ilike(field, value)
                            }
                        }

                }
        }

        [ users : users ]
    }
*/


    def selectSearch() {}

    def selectResults = {

        println "in new results"

        def query = User.where {
            (ethnic == params.ethnic && build == params.build && hair == params.hair)
        }

        def users = query.list(sort:"ethnic")


        [ users : users ]
    }




    def textSearch() {}

    def textResults = {

        println "term " + params.term


        def wildterm = "%" + params.term + "%"
        println wildterm

        def c = User.createCriteria()
        def users = c.list () {
             like("bio", wildterm)
        }


        [ users : users ]
    }




    def radioSearch() {}

    def radioResults = {

        def userProps = User.metaClass.properties*.name
        def users = User.withCriteria {
                and {
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
