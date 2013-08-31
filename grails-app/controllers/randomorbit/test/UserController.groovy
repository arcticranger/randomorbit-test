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

        println "kilometers " + params.kilometers
        println "username " + params.username

        def currentuser = User.findByUsername(params.username)

        if (currentuser) {
            println "\n\n\n\n\n"
            println "currentuser username"
            println "======================"
            println currentuser.username 

            println "currentuser.location.city"
            println "======================"
            println currentuser.location.city 

            println "currentuser.location.state"
            println "======================"
            println currentuser.location.state 

            println "currentuser.location.lat"
            println "========================"
            println currentuser.location.lat 

            println "currentuser.location.lon"
            println "========================"
            println currentuser.location.lon 

        }
        else {
            println "not found"
        }

        def lat = currentuser.location.lat
        def lon = currentuser.location.lon
        def kmRange = params.kilometers

        println "lat: " + lat
        println "lon: " + lon
        println "kmRange: " + kmRange

        println "${lat}"


        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/random1', 'kurt', 'bartok12', 'com.mysql.jdbc.Driver')

        def radiusQuery = "SELECT *, (3956 * 2 * ASIN(SQRT(POWER(SIN((" +     "${lat}"     + " - abs(`lat`)) * pi()/180 / 2),2) + COS(" +      "${lat}"    +    "* pi()/180 ) * COS(abs(`lat`) *  pi()/180) * POWER(SIN(("   +    "${lon}"     + "- `lon`) *  pi()/180 / 2), 2)))) as distance FROM    `zip_codes` WHERE   MBRContains(LineString(Point(" +      "${lat}"     + "+" +     "${kmRange}" +     "/ 111.1," +     "${lon}"      + "+" +  "${kmRange}"    +   "/ (111.1 / COS(RADIANS("   +   "${lat}"    + ")))), Point("     +   "${lat}"    +    "-" +  "${kmRange}"    +  "/ 111.1," +   "${lon}"    +   "-" +  "${kmRange}"   +   "/ (111.1 / COS(RADIANS("   +    "${lat}"   +   "))))), `Location`)" + " order by city"; 




println "\n\n\n\n"
println radiusQuery
println "\n\n\n\n"

        //def radiusQuery = "SELECT *, (3956 * 2 * ASIN(SQRT(POWER(SIN((41.92 - abs(`lat`)) * pi()/180 / 2),2) + COS(41.92 * pi()/180 ) * COS(abs(`lat`) *  pi()/180) * POWER(SIN((lon - `lon`) *  pi()/180 / 2), 2)))) as distance FROM    `zip_codes` WHERE   MBRContains(LineString(Point(41.92 + 10 / 111.1, -72.65 + 10 / (111.1 / COS(RADIANS(41.92)))), Point(41.92 - 10 / 111.1, -72.65 - 10 / (111.1 / COS(RADIANS(41.92))))), `Location`) Order By distance";


        sql.eachRow(radiusQuery) { row ->
            println row.city + " " + row.state + " " + row.zip
        }



        render currentuser as JSON
        //[ users : users ]
    }




   def convert() {

        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/random1', 'kurt', 'bartok12', 'com.mysql.jdbc.Driver')

        def convertQuery = "SELECT zip, lat, lon, city, state, type, county from zip_codes";

        def i = 1;

        sql.eachRow(convertQuery) { row ->
            println "insert into location values(" + i++ + ", 0 ," + "'" + row.city + "'" + "," + "'" + row.county + "'" + "," + "'2013-08-29 18:30:13'" + "," + row.lat + "," + row.lon + "," + "'" + row.state + "'" + "," + "'" + row.type + "'" + "," + "'" + row.zip + "'" + ");" 
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
