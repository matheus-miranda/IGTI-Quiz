package com.matheusmiranda.igti.igtiquiz

object Constants {

    /**
     * Create questions and return as an ArrayList
     */
    fun getQuestions(): ArrayList<Question> {
      val questionList = ArrayList<Question>()

        val q1 = Question(
                1,
                "A linguagem oficial para desenvolvimento Android Nativo pela " +
                        "Google é a Kotlin",
                true)
        questionList.add(q1)

        val q2 = Question(
                2,
                "O processo de publicação do aplicativo na Google Play é gratuito",
                false)
        questionList.add(q2)

        val q3 = Question(
                3,
                "O Brasil possui uma população de quase 210 milhões",
                true)
        questionList.add(q3)

        val q4 = Question(
                4,
                "Flutter é uma dos frameworks de desenvolvimento mobile",
                true)
        questionList.add(q4)

        val q5 = Question(
                5,
                "A linguagem de programação do Flutter é o Dart",
                true)
        questionList.add(q5)

        val q6 = Question(
                6,
                "O Flutter possui interoperabilidade e pode ter projetos em Java e Dart",
                false)
        questionList.add(q6)

        val q7 = Question(
                7,
                "React-Native é uma plataforma para desenvolvimento de aplicativos móveis",
                true)
        questionList.add(q7)

        val q8 = Question(
                8,
                "O Kotlin possui interoperabilidade oque possibilita implementar " +
                        "projetos em Java e Kotlin",
                true)
        questionList.add(q8)

        return questionList
    }
}