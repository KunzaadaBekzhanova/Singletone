package kg.tutorialapp.singletone

class SingleTone private constructor(){

    companion object{
        private var instance = SingleTone()

        fun getInstance() =  instance

        }
    }
