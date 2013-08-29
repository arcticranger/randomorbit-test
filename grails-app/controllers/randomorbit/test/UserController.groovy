package randomorbit.test


import grails.converters.JSON


class UserController {

    def scaffold = true

    def index() { }


    //------------------------------------
    // search on username
    //------------------------------------
    def searchByUsername = {}

    def resultByUsername = {
         def users = User.findAllByUsernameLike("%${params.username}%")
         return [ users: users, term : params.username ]
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





    //------------------------------------
    // search on physical feature
    //------------------------------------
    def searchByPhysicalFeature() {}

    def resultByPhysicalFeature = {

        println "in new results"

        def query = User.where {
            (ethnic == params.ethnic && build == params.build && hair == params.hair)
        }

        def users = query.list(sort:"ethnic")


        [ users : users ]
    }



    //------------------------------------
    // search on a word in user bio
    //------------------------------------
    def searchByBioTerm() {}

    def resultByBioTerm = {

        println "term " + params.term


        def wildterm = "%" + params.term + "%"
        println wildterm

        def c = User.createCriteria()
        def users = c.list () {
             like("bio", wildterm)
        }


        //render users as JSON
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
