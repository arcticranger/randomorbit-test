package randomorbit.test

class User {

    String userId
    String password
    String email

    int age

    Date dateCreated

    String ethnic
    String hair
    String build

    String headline
    String bio


    //static hasMany = [ posts : Post, tags : Tag, following : User ]


    static constraints = {
        userId(blank:false, unique: true)
        password(blank:false)
        email(email: true, nullable: true)
        headline(nullable: true, maxSize: 150)
        bio(nullable: true, maxSize: 1000)
        dateCreated()
    }
}
