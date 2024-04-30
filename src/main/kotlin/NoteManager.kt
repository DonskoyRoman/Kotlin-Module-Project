import java.util.*

class NoteManager(val scanner: Scanner) {
    fun createNote(): Note {
        var title = ""
        while (title.isBlank()) {
            print("Введите название заметки: ")
            title = scanner.nextLine()
            if (title.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }

        var content = ""
        while (content.isBlank()) {
            print("Введите содержание заметки: ")
            content = scanner.nextLine()
            if (content.isBlank()) {
                println("Поле пустое, попробуйте еще раз.")
            }
        }

        return Note(title, content)
    }
}