package randomorbit.test

class User {

    String username
    String password
    String email

    //int age

    Date dateCreated

    String ethnic
    String hair
    String build

    String headline
    String bio

    //String zipcode

    Location location

    //static hasMany = [ posts : Post, tags : Tag, following : User ]


    static constraints = {
        username(blank:false, unique: true)
        password(blank:false)
        email(email: true, nullable: true)
        headline(nullable: true, maxSize: 150)
        bio(nullable: true, maxSize: 1000)
        location(nullable: true)
        dateCreated()
    }

 static mapping = {
        location lazy: false
    }
}
