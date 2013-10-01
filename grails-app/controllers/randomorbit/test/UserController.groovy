package randomorbit.test

import grails.converters.JSON
import groovy.sql.Sql
import org.codehaus.groovy.grails.web.json.JSONObject 


class UserController {


    //------------------------------------
    // search by distance
    //------------------------------------
    def searchByRadius() {}

    def resultByRadius = {

        //def currentuser = User.findByUsername(params.username)
        def currentuser = User.findByUsername("jackdoe")
       

        if (currentuser) {
            println "found " + currentuser.username + " at latitute " + currentuser.location.lat + " / longitude " + + currentuser.location.lon
        }
        else {
            println "not found"
        }

        def lat = currentuser.location.lat
        def lon = currentuser.location.lon
        //def kmRange = params.kilometers
        def kmRange = 50

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

        //[ users : userlist, cities: citylist, kmRange: kmRange ]


/*
        String resp = userlist as grails.converters.deep.JSON
        resp = params.callback + "(" + resp + ")"
        render (contentType: "application/json", text: resp)
*/




        //String deepPeopleList = userlist as grails.converters.deep.JSON
        //String jo = new JSONObject()
        //jo.putOpt("people", deepPeopleList)
        //jo.putOpt("people", userlist as grails.converters.deep.JSON)
   

        //render jo.toString()


        //String resp = params.callback + "(" + jo + ")"
        //render (contentType: "application/json", text: resp)


        //println jo.toString()

        String deepPeopleList = userlist as grails.converters.deep.JSON 

        render deepPeopleList 

    }

}
