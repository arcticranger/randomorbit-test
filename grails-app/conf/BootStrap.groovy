class BootStrap {

    def init = { servletContext ->


           def sampleuser

           sampleuser = new randomorbit.test.User(userId:"jackdoe", password:"password", email:"jdoe@x.com", ethnic:"Latino", build: "Skinny", hair: "Black", age:38)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"jeffery", password:"password", email:"jeffrey@x.com", ethnic:"Latino", build: "Skinny", hair: "Black", age:28)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"magenta", password:"password", email:"magenta@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:58)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"griffin", password:"password", email:"griffin@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"minotaur", password:"password", email:"minotaur@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"adder23", password:"password", email:"adder23@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"wholesome", password:"password", email:"wholesome@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"blakish", password:"password", email:"blakish@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"goaterd", password:"password", email:"goaterd@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()

           sampleuser = new randomorbit.test.User(userId:"wanderer", password:"password", email:"wanderer@x.com", ethnic:"BLACK", build: "FAT", hair: "BLACK", age:33)
           sampleuser.save()




    }
    def destroy = {
    }
}
