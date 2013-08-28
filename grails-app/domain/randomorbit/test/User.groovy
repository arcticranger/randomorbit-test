package randomorbit.test

class User {

    String userId
    String password
    String email

    int age

    Date dateCreated

    //EthnicEnum ethnic
    //HairEnum hair
    //BuildEnum build
    String ethnic
    String hair
    String build


    //static hasMany = [ posts : Post, tags : Tag, following : User ]


    static constraints = {
        userId(blank:false, unique: true)
        password(blank:false)
        email(email: true, nullable: true)
        dateCreated()
    }
}
