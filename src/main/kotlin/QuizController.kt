class QuizController {
    private var questions: List<Question> = mutableListOf()

    constructor(){
        createDummyList()
    }

    fun doQuiz(givenNumber : Int){
        randomizeQuestions()

        var selectQuestions: List<Question> = questions.take(givenNumber)


        var correctAnswers : Int = 0
        var inputStr : String
        selectQuestions.forEach {
            println(it.text)
            println(it.answers.shuffled())

            inputStr = readLine().toString()

            if(inputStr == it.correctAnswer){
                correctAnswers++
            }
        }

        println("Correct answers: $correctAnswers" +
                "/Total number of answers ${selectQuestions.size}")

    }

    private fun randomizeQuestions(){
        questions = questions.shuffled()
    }

    private fun createDummyList() {
        var question = Question(
            "Which collection search with most efficency?",
            listOf("Set", "List", "Map", "Same efficency for all"),
            "Map"
        )
        questions += question
        question = Question(
            "How can u refer for the parent class?",
            listOf("this", "->", "super", "parent class name"),
            "super"
        )
        questions += question
        question = Question(
            "Template question for further testing",
            listOf("a", "b", "c", "d"),
            "b"
        )
        questions += question
    }
}