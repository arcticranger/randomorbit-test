package randomorbit.test


import grails.converters.JSON
import groovy.sql.Sql


class UserController {

    def scaffold = true

    def index() { }

    def signin() {

        println "in signin action"

        def currentuser = User.findByUsername(params.username)

        if (currentuser) {
            println "found"

            println currentuser.username 
            println currentuser.location.city 
            println currentuser.location.zipcode 
        }
        else {
            println "not found"
        }
    }


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




    //------------------------------------
    // search by distance
    //------------------------------------
    def searchByRadius() {}

    def resultByRadius = {

        def currentuser = User.findByUsername(params.username)

        if (currentuser) {
            println "found " + currentuser.username + " at latitute " + currentuser.location.lat + " / longitude " + + currentuser.location.lon
        }
        else {
            println "not found"
        }

        def lat = currentuser.location.lat
        def lon = currentuser.location.lon
        def kmRange = params.kilometers

        //-----------------------------------------
        // define the connection
        //-----------------------------------------
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/random1', 'kurt', 'bartok12', 'com.mysql.jdbc.Driver')

        //-----------------------------------------
        // define radius query
        //-----------------------------------------
        def radiusQuery = "SELECT *, (3956 * 2 * ASIN(SQRT(POWER(SIN((" +     "${lat}"     + " - abs(`lat`)) * pi()/180 / 2),2) + COS(" +      "${lat}"    +    "* pi()/180 ) * COS(abs(`lat`) *  pi()/180) * POWER(SIN(("   +    "${lon}"     + "- `lon`) *  pi()/180 / 2), 2)))) as distance FROM `location` WHERE   MBRContains(LineString(Point(" +      "${lat}"     + "+" +     "${kmRange}" +     "/ 111.1," +     "${lon}"      + "+" +  "${kmRange}"    +   "/ (111.1 / COS(RADIANS("   +   "${lat}"    + ")))), Point("     +   "${lat}"    +    "-" +  "${kmRange}"    +  "/ 111.1," +   "${lon}"    +   "-" +  "${kmRange}"   +   "/ (111.1 / COS(RADIANS("   +    "${lat}"   +   "))))), `Location`)" + " order by city"; 


        //---------------------------------------------------------------
        // use radius query to create a list of zipcodes
        //---------------------------------------------------------------
        List ziplist = []
        List citylist = []

        sql.eachRow(radiusQuery) { row ->
            ziplist.add(row.zipcode)
            citylist.add(row.city)
        }

        println ziplist
        println citylist

        //----------------------------------------
        // find users whose zipcode was returned
        //----------------------------------------
        def c = User.createCriteria()

        def userlist = c.list {
            location {
                inList('zipcode', ziplist)
            }
        }

        //render currentuser as JSON
        [ users : userlist, cities: citylist, kmRange: kmRange ]
    }




   def convert() {

        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/random1', 'kurt', 'bartok12', 'com.mysql.jdbc.Driver')

        def convertQuery = "SELECT zip, lat, lon, city, state, type, county from zip_codes";

        def i = 1;

        sql.eachRow(convertQuery) { row ->
            println "insert into zip values(" + row.zip + ", 0 ," + "'" + row.city + "'" + "," + "'" + row.county + "'" + "," + "'2013-08-29 18:30:13'" + "," + row.lat + "," + row.lon + "," + "'" + row.state + "'" + ");" 
        }


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
